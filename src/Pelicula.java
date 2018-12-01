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

	public Pelicula() {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...	
	}

	// ---------------------------------

	public void modificaPelicula() {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}


	// ---------------------------------

	public Pelicula(String nomPeli) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	// ---------------------------------

	public Pelicula(String nomPeli, String nacionalitat, int duracio,
			String director, String interprets, String argument, String genere,
			String classificacio) {

		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	// ---------------------------------

	public Pelicula(String nomPeli, String nacionalitat, int duracio,
			String director, String interprets, String argument, String genere,
			String classificacio, ArrayList<Sessio> sessionsPeli) {

		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	// ---------------------------------

	@Override
	public String toString() {
		return "Pelicula [nomPeli=" + nomPeli + "\n\t nacionalitat="
				+ nacionalitat + "\n\t duracio=" + duracio + "\n\t director="
				+ director + "\n\t interprets=" + interprets + "\n\t argument="
				+ argument + "\n\t genere=" + genere + "\n\t classificacio="
				+ classificacio + "\n\t sessionsPeli=" + sessionsPeli + "]";
	}

	//LLISTA EL LLISTAT DE SESSIONS PER LA PELICULA
	public int llistarSessionsPeli() {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	public Sessio retornaSessioPeli(int i) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	public void esborraSessioPeli(int i) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

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

}
