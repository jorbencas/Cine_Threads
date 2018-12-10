
public class Seient {

	private int filaSeient;
	private int numeroSeient;
	private Estat disponibilitat;

	public enum Estat {LLIURE, OCUPAT, RESERVANT}

	   //CONSTRUCTOR1
    public Seient(int filaSeient, int numeroSeient, Estat disponibilitat) {
        this.filaSeient = filaSeient;
        this.numeroSeient = numeroSeient;
        this.disponibilitat = disponibilitat;
    }

    //CONSTRUCTOR2
    public Seient(int filaSeient, int numeroSeient) {
        this.filaSeient = filaSeient;
        this.numeroSeient = numeroSeient;
        this.disponibilitat = Estat.LLIURE;
    }

    public Seient() {
        this.disponibilitat = Estat.LLIURE;
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
    public boolean verificaSeient() {
        if (this.getDisponibilitat() == Estat.LLIURE) {
            System.out.println("Esta libre " + this.toString());
            return true;
        }
        return false;
    }

    //*********************************************************
    //VISUALITZA UNA ICONA QUE REPRESENTA L'ESTAT DEL SEIENT
    public char iconaSeient() {
        char c;
        if (this.getDisponibilitat() == Estat.LLIURE) {
            c = 'O';
        } else if (this.getDisponibilitat() == Estat.OCUPAT) {
            c = 'X';
        } else {
            c = '?';
        }
        return c;
    }

    //*********************************************************
    //MODIFICA L'ESTAT DEL SEIENT UNA VEGADA SHA RESERVAT
    public void reservaSeient() {
        this.disponibilitat = Estat.OCUPAT;
    }

    //*********************************************************
    //DEIXA LLIURE EL SEIENT
    public void alliberaSeient() {
        this.disponibilitat = Estat.LLIURE;
    }

    //GETTERS & SETTERS
    public int getFilaSeient() {
        return filaSeient;
    }

    public void setFilaSeient(int filaSeient) {
        this.filaSeient = filaSeient;
    }

    public int getNumeroSeient() {
        return numeroSeient;
    }

    public void setNumeroSeient(int numeroSeient) {
        this.numeroSeient = numeroSeient;
    }

    public Estat getDisponibilitat() {
        return disponibilitat;
    }

    public void setDisponibilitat(Estat disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

}
