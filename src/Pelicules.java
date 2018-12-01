import java.util.ArrayList;
import java.util.Scanner;


public class Pelicules {

	private static ArrayList<Pelicula> pelicules;

	//CONSTRUCTOR1
	public Pelicules() {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//CONSTRUCTOR2
	public Pelicules(ArrayList<Pelicula> pelicules) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//AFEGIR PELICULA AL LLISTAT
	public static void afegirPelicula(Pelicula s){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//COMPROVA SI LA ALGUNA PELICULA JA HA ESTAT INTRODUIDA  
	public static boolean validaIdSessio(String s){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//VISUALITZA TOTES LES PELICULES DISPONIBLES
	public static int llistarPelicules(){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}


	//*********************************************************
	//RETORNA PELICULA DE LA POSICIO i
	public static Pelicula retornaPelicula(int i){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//MODIFICA PELICULA DE LA POSICIO i
	public static void modificaPelicula(int i){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//ESBORRA LA PELICULA DE LA POSICIO i
	public static void esborraPelicula(int i){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//NUMERO DE PELICULES
	public static int quantitatPelicules(){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}


	// ---------------------------------

	public void associaPeliculaSessio(Pelicules pelicules, Sessions sessions) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//-------------------------------------

	//GETTERS & SETTERS
	public  ArrayList<Pelicula> getPelicules() {
		return pelicules;
	}

	public  void setPelicules(ArrayList<Pelicula> pelicules) {
		this.pelicules = pelicules;
	}


}

