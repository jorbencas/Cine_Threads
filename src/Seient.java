
public class Seient {

	private int filaSeient;
	private int numeroSeient;
	private Estat disponibilitat;

	public enum Estat {LLIURE, OCUPAT, RESERVANT}

	//Constructor 1
	public Seient(int filaSeient,int numeroSeient, Estat disponibilitat) {
		this.filaSeient = filaSeient;
		this.numeroSeient = numeroSeient;
		this.disponibilitat = disponibilitat;
	}


	//Constructor  2
	public Seient(int filaSeient,int numeroSeient) {
		this.filaSeient = filaSeient;
		this.numeroSeient = numeroSeient;
		this.disponibilitat = Estat.LLIURE;
	}

	//*********************************************************
	//metode ToString
	@Override
	public String toString() {
		return "Seient [filaSeient=" + filaSeient + ", numeroSeient="
				+ numeroSeient + ", disponibilitat=" + disponibilitat + "]";
	}


	//*********************************************************
	//Verifica si el SEIENT es LLIURE
	public boolean verificaSeient(){

		switch(this.getDisponibilitat()){

		case LLIURE://LLIURE 
			return true;
		case OCUPAT://OCUPAT
			System.out.println("\t ERROR Cine:verificaSeient: Seient OCUPAT"); 
			return false;

		case RESERVANT://RESERVAT
			System.out.println("\t ERROR Cine:verificaSeient: Seient RESERVANT, intenta-ho passat un temps"); 
			return false;
		default: 
			System.out.println("\t ERROR Cine:verificaSeient: Cas no contemplat");
			return false;
		}
	}

	//*********************************************************
	//Visualitza la ICONA que representa L'ESTAT del SEIENT
	public char iconaSeient(){
		char caracter;

		switch(this.getDisponibilitat()){

		case LLIURE: //LLIURE 
			caracter='O';
			break;
		case OCUPAT://OCUPAT
			caracter='X'; 
			break;

		case RESERVANT: 
		default://RESERVAT
			caracter='?'; 
		}
		return caracter;
	}

	//*********************************************************
	//Modifica L'ESTAT del SEIENT a RESERVANT
	public  void reservantSeient() {
		this.disponibilitat = Estat.RESERVANT;
	}

	//*********************************************************
	//Modifica L'ESTAT del SEIENT a OCUPAT
	public  void ocupaSeient() {
		this.disponibilitat = Estat.OCUPAT;
	}
	
	//*********************************************************
	//Modifica l'ESTAT  del SEIENT a LLIURE
	public  void alliberaSeient() {
		this.disponibilitat = Estat.LLIURE;
	}

	//GETTERS & SETTERS
	//*********************************************************
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
