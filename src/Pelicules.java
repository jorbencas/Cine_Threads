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


	//*********************************************************
	//Associa una SESSIO a una PELICULA
	public void associaPeliculaSessio(Pelicules pelicules, Sessions sessions) {
		Scanner s = new Scanner(System.in);
		Sessio se = null;
		Pelicula p = null;
		int numSessionsLliures;
		if (Pelicules.quantitatPelicules() == 0) { //Si NO hi ha PELICULES, s'ix
			System.out.println("\t No hi ha PELICULES per ASSOCIAR");
			return;
		}

		if (Sessions.quantitatSessions() == 0) {//Si NO hi ha SESSIONS, s'ix
			System.out.println("\t No hi ha SESSIONS per ASSOCIAR");
			return;
		}

		//Llista actual de PELICULES
		System.out.println("\n\tLlista actual de PELICULES\n\t--------------------------");
		Pelicules.llistarPelicules();

		int numPelicula = Validacio.validaSencer("\n\tTria una PELICULA: ", Pelicules.quantitatPelicules());
		p = Pelicules.retornaPelicula(numPelicula);

		//Llista actual de les SESSIONS de la PELICULA
		System.out.println("\n\tLlistat actual de SESSIONS per la PELICULA " + p.getNomPeli()+"\n\t---------------------------------------");
		p.llistarSessionsPeli();

		//Llistat de TOTES les Sessions assignables a la PELICULA
		System.out.println("Llistat assignable de SESSIONS\n\t--------------------------");
		numSessionsLliures = Sessions.llistarSessionsLliures();

		if (numSessionsLliures == 0) { //Si NO hi ha SESSIONS, s'ix
			System.out.println("\t No hi ha SESSIONS LLIURES per ASSOCIAR");
			return;
		}

		int numSessio = Validacio.validaSencer("\n\tTria una SESSIO del llistat de les disponibles: ", Sessions.quantitatSessions());

		se = Sessions.retornaSessio(numSessio);

		if (p.getSessionsPeli().contains(se)){	//Si conté la PELICULA a la SESSIO
			System.out.println("PELICULA ja associada a la SESSIO escollida");

		} else{ //Si no estava a la llista, s'afegeix
			p.getSessionsPeli().add(se);
			se.setAssignadaPeli(true);
		}//end else
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

