import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class Sessio {
	private String nomSessio;
	private Calendar data;
	private  Sala sala;
	private Seient[][] seients;
	private BigDecimal preu;
	private boolean assignadaPeli;


	//*********************************************************
	//Constructor 1
	public Sessio(String nomSessio, Calendar data, Sala sala, BigDecimal preu) {

		this.nomSessio = nomSessio;
		this.data = data;
		this.sala = sala;
		this.preu = preu;
		this.seients = new Seient[sala.getFiles()][sala.getTamanyFila()];
		for (int i=0; i < sala.getTamanyFila(); i++){
			for (int j=0; j < sala.getFiles(); j++){
				this.seients[i][j] = new Seient(i,j);
			}
		}
		this.assignadaPeli=false;
	}

	//*********************************************************
	//Constructor 2
	public Sessio(String nomSessio, int dia,int mes, int any, int hora, int minuts, Sala sala, BigDecimal preu) {

		this.nomSessio = nomSessio;
		this.data = Calendar.getInstance();
		this.data.set(any, mes, dia, hora, minuts);
		this.sala = sala;
		this.preu = preu;
		this.seients = new Seient[sala.getFiles()][sala.getTamanyFila()];
		for (int i=0; i < sala.getTamanyFila(); i++){
			for (int j=0; j < sala.getFiles(); j++){
				this.seients[i][j] = new Seient(i,j);
			}
		}
		this.assignadaPeli=false;
	}

	//*********************************************************
	//Constructor INTERACTIU
	public Sessio() {
		Scanner s = new Scanner(System.in);
		boolean validatIdSessio = false;
		System.out.println(">>>>>>>>>>>>>>>>>>>");
		System.out.println("Creació de la SESSIO\n>>>>>>>>>>>>>>>>>>> ");

		do{
			this.nomSessio = Validacio.validaCadena("\tIndentificador de la sessió? ");
			validatIdSessio = Sessions.validaIdSessio(this.nomSessio);
			if (!validatIdSessio)
				System.out.println("\tERROR: Numero de SESSIO existent");
		} while (!validatIdSessio);

		this.data = Validacio.validaData("\n\tData de la sessió? (dd/mm/aaaa) ");
		this.mostraDataFormatada();

		System.out.print("\n\tIndentificador de la sala? (0 per nova Sala)");
		//Llista TOTES les SALES DISPONIBLES
		Sales.llistarSales();
		System.out.println("");

		String nsala = s.next();
		//Si es vol afegir una nova SALA...
		if (nsala.equalsIgnoreCase("0")) {
			this.sala = new Sala();
			Sales.afegirSala(this.sala);
		}else 
			this.sala = Sales.retornaSala(Integer.parseInt(nsala));

		this.preu = Validacio.validaMoneda("\tPreu de la sessió? ");

		this.seients = new Seient[sala.getFiles()][sala.getTamanyFila()]; 		

		//Creacio SEIENTS
		for (int i=0; i < sala.getTamanyFila(); i++){
			for (int j=0; j < sala.getFiles(); j++){
				this.seients[i][j] = new Seient(i,j);
			}
		}

		this.assignadaPeli=false;

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	//*********************************************************
	//Modifica la SESSIO
	public void modificaSessio() {
		Scanner s = new Scanner(System.in);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		System.out.println("\tModificació de la SESSIO\n>>>>>>>>>>>>>>>>>>>>>");
		System.err.println("\tPrem tecla INTRO per matenir informació anterior ");

		this.nomSessio = Validacio.validaCadenaDefecte("\tIndentificador de la sessió? ",this.getNomSessio());

		this.data = Validacio.validaDataDefecte("\n\tData de la sessió? (dd/mm/aaaa) ["
				+ data.get(Calendar.DAY_OF_MONTH) + "/"
				+ data.get(Calendar.MONTH) + "/"
				+ data.get(Calendar.YEAR) + "]",data);
		this.mostraDataFormatada();

		System.out.print("\n\tIndentificador de la sala? ["+ this.sala.getNumeroSala()+" ] (0 per nova Sala)");
		//Llista TOTES les SALES
		Sales.llistarSales();
		System.out.println("");

		String nsala = s.nextLine();

		if (nsala.equalsIgnoreCase("0")) { //Nova SALA
			this.sala = new Sala();
			Sales.afegirSala(this.sala);
		} else { //SALA de la llista o antiga SALA 
			if (nsala.compareToIgnoreCase("")!=0) { //SALA de la llista 
				this.sala = Sales.retornaSala(Integer.parseInt(nsala));
			}else{ //SALA antiga 
			} 
		}

		this.preu = Validacio.validaMonedaDefecte("\tPreu de la sessió? ",this.getPreu());

		boolean reinicia = Validacio.validaBoolea("\tReiniciar assignació seients? (S/N) ");

		if(reinicia) {
			//Creacio SEIENTS
			for (int i=0; i < this.sala.getTamanyFila(); i++){
				for (int j=0; j < this.sala.getFiles(); j++){
					if(this.seients[i][j]!=null) //Si seient ja existeix, l'allibera	
						this.seients[i][j].alliberaSeient();
					else	//si NO existeix, es crea 
						this.seients[i][j] = new Seient(i,j);
				}
			}
		}else{//resposta = N. Deixa coses com estan
		}

		System.out.println("\t=======================");
		System.out.println(this);

		this.assignadaPeli= Validacio.validaBooleaDefecte("\tTé PELICULA associada? (S/N) ", this.assignadaPeli);
	}

	//*********************************************************
	//Esborra la SESSIO
	public void esborraSessio() {
		System.out.println("Sessió esborrada!");
	}

	//*********************************************************
	//Mostra la distribució de SEIENTS a la SALA
	public void mapaSessio(){
		System.out.println("\n\t --------  MAPA SESSIO  -----------");
		//CAPÇALERA de la SALA
		System.out.print("\t Seient-> ");
		for (int x=1; x <= this.sala.getTamanyFila(); x++)
			System.out.print(x +"  ");

		//COS de la SALA
		System.out.println();
		for (int i=0; i < this.sala.getTamanyFila(); i++){
			System.out.print("\t Fila "+(i+1)+": ");
			for (int j=0; j < this.sala.getFiles(); j++){
				System.out.print(" "+this.seients[i][j].iconaSeient()+" ");
			}//endfor	
			System.out.println();
		}//endfor
		System.out.println("\n\t SIMBOLOGIA: X=ocupat; O=lliure; ?=reservant\n\n");
	}

	//*********************************************************
	//Mostra DATA en format espanyol
	public void mostraDataFormatada(){
		int day = this.data.get(Calendar.DAY_OF_MONTH);
		int month = this.data.get(Calendar.MONTH);
		int year = this.data.get(Calendar.YEAR);
		int hour = this.data.get(Calendar.HOUR_OF_DAY);
		int minute = this.data.get(Calendar.MINUTE);

		System.out.print(day+"/"+month+"/"+year+" "+hour+":"+minute);
	}


	//*********************************************************
	//Mostra TICKET de compra de la PELICULA
	public void imprimirTicket(Seient s, Sessio se, Sala sa, Pelicula p){
		System.out.println("Imprimint el seu Ticket...");
		System.out.println("***************************");
		System.out.println("* ***TICKET ENTRADA *******");
		System.out.println("* PELICULA: "+ p.getNomPeli() +" *");
		System.out.print("* HORARI: ");
		se.mostraDataFormatada();
		System.out.println("*\n* Seient FILA:"+(s.getFilaSeient()+1)+ " SEIENT:"+(s.getNumeroSeient()+1)+"*");
		System.out.println("* Preu: "+ se.getPreu()+" €");
		System.out.println("****************************");


	}


	//*********************************************************
	//Metode ToString
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
		return "Sessio [nomSessio=" + nomSessio + "\n\t data=" + sdf.format(data.getTime()) + 
				"\n\t sala="+ sala + "\n\t preu=" + preu + "\n\t assignadaPeli="+ assignadaPeli + "]";
	}


	//GETTERS & SETTERS
	//*********************************************************
	public  String getNomSessio() {
		return nomSessio;
	}


	public  void setNomSessio(String nomSessio) {
		this.nomSessio = nomSessio;
	}


	public  Calendar getData() {
		return data;
	}


	public  void setData(Calendar data) {
		this.data = data;
	}


	public  Sala getSala() {
		return sala;
	}


	public  void setSala(Sala sala) {
		this.sala = sala;
	}


	public  BigDecimal getPreu() {
		return preu;
	}


	public  void setPreu(BigDecimal preu) {
		this.preu = preu;
	}

	public  Seient[][] getSeients() {
		return seients;
	}

	public  void setSeients(Seient[][] seients) {
		this.seients = seients;
	}

	public boolean isAssignadaPeli() {
		return assignadaPeli;
	}

	public void setAssignadaPeli(boolean assignadaPeli) {
		this.assignadaPeli = assignadaPeli;
	}

}
