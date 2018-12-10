import java.util.ArrayList;
import java.util.Scanner;


public class Pelicules {

	private static ArrayList<Pelicula> pelicules;

	//Constructor 1
	public Pelicules() {
		this.pelicules = new ArrayList<Pelicula>();
	}

	//Constructor  2
	public Pelicules(ArrayList<Pelicula> pelicules) {
		this.pelicules = pelicules;
	}

	//*********************************************************
	//Afegeix una PELICULA al ArrayList
	public static void afegirPelicula(Pelicula s){
		pelicules.add(s);
	}

	//*********************************************************
	//Comprova si el nom de la PELICULA passada com a String ja està al ArrayList  
	public static boolean validaIdSessio(String s){
		boolean resultat = true;
		for(int i=0; i<quantitatPelicules();i++){
			if (pelicules.get(i).getNomPeli().compareToIgnoreCase(s)==0) return false;
		}
		return resultat;
	}

	//*********************************************************
	//Mostra TOTES les PELICULES
	public static int llistarPelicules(){
		if (quantitatPelicules()==0) 
			System.out.println("\n\t No hi ha cap PELICULA registrada");

		for(int i=1; i<=quantitatPelicules();i++){
			System.out.println("\n\t "+i+"-> "+pelicules.get(i-1).toString());
		}
		System.out.println();
		return quantitatPelicules();
	}


	//*********************************************************
	//Retorna la  PELICULA de la posicio i
	public static Pelicula retornaPelicula(int i){
		if (i <= quantitatPelicules()){
			return pelicules.get(i-1);

		}else {
			System.out.println("ERROR Pelicules:retornaSessio: valor proporcionat fora de rang");
			return null;
		}
	}

	//*********************************************************
	//Modifica la PELICULA de la posicio i
	public static void modificaPelicula(int i){
		if (i <= quantitatPelicules())
			pelicules.get(i-1).modificaPelicula();
		else {
			System.out.println("ERROR Pelicules.modificaSessio: valor proporcionat fora de rang");
		}
	}

	//*********************************************************
	//Esborra la PELICULA de la posicio i
	public static void esborraPelicula(int i){
		if (i <= quantitatPelicules()){
			if (pelicules.get(i-1).getSessionsPeli().size()>0) {//Si la Pelicula conté sessions, preguntem què fer
				if(Validacio.validaBoolea("\n\t La Pelicula conté Sessions. Esborra igualment? (S/N):")) { //Esborrem
					pelicules.get(i-1).esborraPelicula();
					pelicules.remove(i-1);
				}else //No esborrem
					System.out.println(" PELICULA NO esborrada");
			}
		}else {
			System.out.println("ERROR Sales.modificaSala: valor proporcionat fora de rang");
		}
	}

	//*********************************************************
	//Retorna el num de PELICULES
	public static int quantitatPelicules(){
		return pelicules.size();
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

