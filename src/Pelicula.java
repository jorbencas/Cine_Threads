import java.util.ArrayList;
import java.util.Scanner;

public class Pelicula {

	private String nomPeli;
	private String nacionalitat;
	private int duracio;
	private String director;
	private String interprets;
	private String argument;
	private String genere;
	private String classificacio;
	private ArrayList<Sessio> sessionsPeli;

	// ---------------------------------
	//Constructor 1
	public Pelicula(String nomPeli) {

		this.nomPeli = nomPeli;
		this.sessionsPeli = null;
	}

	// ---------------------------------
	//Constructor 2
	public Pelicula(String nomPeli, String nacionalitat, int duracio,
			String director, String interprets, String argument, String genere,
			String classificacio) {

		this.nomPeli = nomPeli;
		this.nacionalitat = nacionalitat;
		this.duracio = duracio;
		this.director = director;
		this.interprets = interprets;
		this.argument = argument;
		this.genere = genere;
		this.classificacio = classificacio;
		this.sessionsPeli = new ArrayList<Sessio>();
	}

	// ---------------------------------
	//Constructor 3
	public Pelicula(String nomPeli, String nacionalitat, int duracio,
			String director, String interprets, String argument, String genere,
			String classificacio, ArrayList<Sessio> sessionsPeli) {

		this.nomPeli = nomPeli;
		this.nacionalitat = nacionalitat;
		this.duracio = duracio;
		this.director = director;
		this.interprets = interprets;
		this.argument = argument;
		this.genere = genere;
		this.classificacio = classificacio;
		this.sessionsPeli = sessionsPeli;
	}

	// ---------------------------------
	//Constructor INTERACTIU
	public Pelicula() {
		Scanner s = new Scanner(System.in);
		Sessio se = null;

		System.out.println(">>>>>>>>>>>>>>>>>>>");
		System.out.println("Creació de la PELICULA >>>>>>>>>>>>>>>>>>>>>> ");

		this.nomPeli = Validacio.validaCadena("\tNom de la Pelicula? ");
		this.nacionalitat = Validacio.validaCadena("\tNacionalitat de la Pelicula? ");
		this.duracio = Validacio.validaSencer("\tDuracio de la Pelicula?(min) ",200);
		this.director = Validacio.validaCadena("\tDirector de la Pelicula? ");
		this.interprets = Validacio.validaCadena("\tInterprets de la Pelicula? ");
		this.argument = Validacio.validaCadena("\tArgument de la Pelicula? ");
		this.genere = Validacio.validaCadena("\tGenere de la Pelicula? ");
		this.classificacio = Validacio.validaCadena("\tClassificació de la Pelicula? ");
		this.sessionsPeli = new ArrayList<Sessio>();
		System.out.print("\tIndentificador de sessio per la Pelicula? (0 per nova Sessio)");
		// Llista TOTES les SESSIONS disponibles
		Sessions.llistarSessionsLliures();

		String sessio = s.nextLine();
		if (sessio.equalsIgnoreCase("0")) { //Creació d'una nova SESSIO
			se = new Sessio();
			this.sessionsPeli.add(se);
			Sessions.afegirSessio(se);
		} else {// Associa una SESSIO triada a la PELICULA
			se = Sessions.retornaSessio(Integer.parseInt(sessio));
			this.sessionsPeli.add(se);
		}
		se.setAssignadaPeli(true);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	// ---------------------------------
	//modificacio PELICULA
	public void modificaPelicula() {
		Scanner s = new Scanner(System.in);
		Sessio se = null;
		String accio;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		System.out.println("\tModificació de la PELICULA\n>>>>>>>>>>>>>>>>>>>>>");
		System.err.println("\tPrem tecla INTRO per matenir informació anterior ");

		this.nomPeli = Validacio.validaCadenaDefecte("\tNom de la Pelicula? ",this.getNomPeli());

		this.nacionalitat = Validacio.validaCadenaDefecte("\tNacionalitat de la Pelicula? ", this.getNacionalitat());

		this.duracio = Validacio.validaSencerDefecte("\tDuracio de la Pelicula?(min) ",200, this.getDuracio());

		this.director = Validacio.validaCadenaDefecte("\tDirector de la Pelicula? ", this.getDirector());

		this.interprets = Validacio.validaCadenaDefecte("\tInterprets de la Pelicula? ", this.getInterprets());

		this.argument = Validacio.validaCadenaDefecte("\tArgument de la Pelicula? ",this.getArgument());

		this.genere = Validacio.validaCadenaDefecte("\tGenere de la Pelicula? ",this.getGenere());

		this.classificacio = Validacio.validaCadenaDefecte("\tClassificació de la Pelicula? ",this.getClassificacio());

		//Llistar les SESSIONS de la PELICULA
		System.out.println("\n\tLlista actual de SESSIONS per la Pelicula");
		this.llistarSessionsPeli();

		//Llistar TOTES les SESSIONS que hi ha
		System.out.println("\n\tModifica llistat de SESSIONS per la Pelicula? (0 per nova Sessio)");
		Sessions.llistarSessions();

		String sessio = s.nextLine();
		if (sessio.equalsIgnoreCase("0")) { //Nova sessio
			se = new Sessio();
			se.setAssignadaPeli(true);
			this.sessionsPeli.add(se);
			Sessions.afegirSessio(se);

		}else { //Sessio de la llista
			se = Sessions.retornaSessio(Integer.parseInt(sessio));

			if (this.getSessionsPeli().contains(se)){	//Si conté la Peli la sessio
				do{
					System.out.println("\tModificar(M) o Esborrar(E) Sessio de la Peli? ");
					accio = s.nextLine();
				}while (accio.toUpperCase().compareTo("M")!=0 & accio.toUpperCase().compareTo("E")!=0);

				if(accio.toUpperCase().compareTo("M")==0){  //M = Modificar Sessio de Peli
					se.modificaSessio();
				}else{		//E = Esborra Sessio de Peli
					se.esborraSessio();
					se.setAssignadaPeli(false);
					this.esborraSessioPeli(Integer.parseInt(sessio));
				};
			} else{ //Si no estava a la llista, s'afegeix
				if (Validacio.validaBoolea("\tAfegeix Sessio a la Peli?(S/N)")) {
					this.sessionsPeli.add(se);
					se.setAssignadaPeli(true);
				}
			}
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}


	//---------------------------------
	//Esborra PELICULA
	public void esborraPelicula() {
		setSessionsPeli(null);
		System.out.println("PELICULA esborrada!");
	}

	// ---------------------------------
	//metode ToString
	@Override
	public String toString() {
		return "Pelicula [\n\t nomPeli=" + nomPeli + "\n\t nacionalitat="
				+ nacionalitat + "\n\t duracio=" + duracio + "\n\t director="
				+ director + "\n\t interprets=" + interprets + "\n\t argument="
				+ argument + "\n\t genere=" + genere + "\n\t classificacio="
				+ classificacio + "\n\t sessionsPeli={" + sessionsPeli + "}]";
	}


	//---------------------------------
	//Lllista TOTES les SESSIONS de la PELICULA
	public int llistarSessionsPeli() {
		ArrayList<Sessio> sessions = this.getSessionsPeli();

		for (int i = 1; i <= sessions.size(); i++) {
			Sessio se = sessions.get(i - 1);
			System.out.println(" " + i + ": " + se);
		}
		return sessions.size();
	}


	//---------------------------------
	//Retorna la SESSIO que està a la posicio i del llistat de SESSIONS de la PELICULA
	public Sessio retornaSessioPeli(int i) {
		ArrayList<Sessio> sessions = this.getSessionsPeli();
		if (i <= sessions.size()) {
			return sessions.get(i - 1);
		} else {
			System.out
			.println("ERROR Pelicula:retornaSessioPeli: valor proporcionat fora de rang");
			return null;
		}
	}

	//---------------------------------
	//Esborra la SESSIO que està a la posicio i del llistat de SESSIONS de la PELICULA
	public void esborraSessioPeli(int i) {
		ArrayList<Sessio> sessions = this.getSessionsPeli();
		sessions.remove(i - 1);
	}

	//GETTERS & SETTERS
	public String getNomPeli() {
		return nomPeli;
	}

	public void setNomPeli(String nomPeli) {
		this.nomPeli = nomPeli;
	}

	public String getNacionalitat() {
		return nacionalitat;
	}

	public void setNacionalitat(String nacionalitat) {
		this.nacionalitat = nacionalitat;
	}

	public int getDuracio() {
		return duracio;
	}

	public void setDuracio(int duracio) {
		this.duracio = duracio;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getInterprets() {
		return interprets;
	}

	public void setInterprets(String interprets) {
		this.interprets = interprets;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getClassificacio() {
		return classificacio;
	}

	public void setClassificacio(String classificacio) {
		this.classificacio = classificacio;
	}

	public ArrayList<Sessio> getSessionsPeli() {
		return sessionsPeli;
	}

	public void setSessionsPeli(ArrayList<Sessio> sessionsPeli) {
		this.sessionsPeli = sessionsPeli;
	}

	public void setSessioPeli(Sessio s1) {
		this.sessionsPeli.add(s1);
		
	}

}
