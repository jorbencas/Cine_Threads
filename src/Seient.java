
public class Seient {

	private int filaSeient;
	private int numeroSeient;
	private Estat disponibilitat;

	public enum Estat {LLIURE, OCUPAT, RESERVANT}

	//CONSTRUCTOR1
	public Seient(int filaSeient,int numeroSeient, Estat disponibilitat) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}


	//CONSTRUCTOR2
	public Seient(int filaSeient,int numeroSeient) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	public Seient() {
		// TODO Auto-generated constructor stub
	}


	//*********************************************************
	//metode TOSTRING
	@Override
	public String toString() {
		return "Seient [filaSeient=" + filaSeient + ", numeroSeient="
				+ numeroSeient + ", disponibilitat=" + disponibilitat + "]";
	}


	//*********************************************************
	//VERIFICA SI EL SEIENT ES LLIURE I HO MOSTRA PER PANTALLA
	public boolean verificaSeient(){

		if(this.getDisponibilitat() == disponibilitat.OCUPAT) {
			return false;
		}else {
			this.setDisponibilitat(disponibilitat.LLIURE);
			return true;
		}
	}

	//*********************************************************
	//VISUALITZA UNA ICONA QUE REPRESENTA L'ESTAT DEL SEIENT
	public char iconaSeient(){
		char visualitzaestat = ' ' ;
		if(this.getDisponibilitat() == disponibilitat.LLIURE)
			visualitzaestat = '?';
		else if(this.getDisponibilitat() == disponibilitat.OCUPAT)
			visualitzaestat = 'X';
		else if(this.getDisponibilitat() == disponibilitat.RESERVANT)
			visualitzaestat = 'O';
		return visualitzaestat;
	}

	//*********************************************************
	//MODIFICA L'ESTAT DEL SEIENT UNA VEGADA SHA RESERVAT
	public  void reservaSeient() {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//DEIXA LLIURE EL SEIENT
	public  void alliberaSeient() {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//GETTERS & SETTERS
	public  int getFilaSeient() {
		return filaSeient;
	}



	public  void setFilaSeient(int filaSeient) {
		this.filaSeient = filaSeient;
	}



	public  int getNumeroSeient() {
		return numeroSeient;
	}



	public  void setNumeroSeient(int numeroSeient) {
		this.numeroSeient = numeroSeient;
	}



	public  Estat getDisponibilitat() {
		return disponibilitat;
	}



	public  void setDisponibilitat(Estat disponibilitat) {
		this.disponibilitat = disponibilitat;
	}








}
