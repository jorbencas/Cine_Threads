import java.util.ArrayList;


public class Sessions {

	private static ArrayList<Sessio> sessions;

	//Constructor 1
	public Sessions() {
		this.sessions = new ArrayList<Sessio>();
	}

	//Constructor 2	
	public Sessions(ArrayList<Sessio> sessions) {
		this.sessions = sessions;
	}

	//Afegir SESSIO al ArrayList
	public static  void afegirSessio(Sessio s){
		sessions.add(s);
	}

	//*********************************************************
	//Comprova si la ESSIO ja existeix
	//Retorna TRUE: SESSIO NO existeix
	//Retorna FALSE: SESSIO ja existeix
	public static  boolean validaIdSessio(String s){
		boolean resultat = true;
		for(int i=0; i<quantitatSessions();i++){
			if (sessions.get(i).getNomSessio().compareToIgnoreCase(s)==0) return false;
		}
		return resultat;
	}

	//*********************************************************
	//Mostra la llista de TOTES les SESSIONS
	public static void llistarSessions(){
		if (quantitatSessions()==0) System.out.println("\n\t No hi ha cap SESSIO registrada");
		else {
			//System.out.println("\n******** SESSIONS *******");
			for(int i=1; i<=quantitatSessions();i++){
				System.out.println("\n\t "+i+"-> "+sessions.get(i-1).toString());
				System.out.println("\t---");
			}
			System.out.println();
		}
	}


	//*********************************************************
	//Mostra la llista de  SESSIONS NO assignades a una PELICULA
	public static int llistarSessionsLliures(){
		int numSessionsLliures=0;
		if (quantitatSessions()==0) System.out.println("\n\t No hi ha cap SESSIO registrada");
		else {
			//System.out.println("\n******** SESSIONS *******");
			for(int i=1; i<=quantitatSessions();i++){
				if (!sessions.get(i-1).isAssignadaPeli()) {//si estan lliures, es mostren
					System.out.println("\n\t "+i+"-> "+sessions.get(i-1).toString());
					System.out.println("\t---");
					numSessionsLliures++;
				}
			}
			System.out.println();
		}
		return numSessionsLliures;
	}

	//*********************************************************
	//Retorna la SESSIO de la posicio i
	public static Sessio retornaSessio(int i){
		if (i <= quantitatSessions()){
			return sessions.get(i-1);
		}else {
			System.out.println("ERROR Sessions:retornaSessio: valor proporcionat fora de rang");
			return null;
		}
	}

	//*********************************************************
	//RETORNA LA SESSIO LLIURE DE LA POSICIO i
	/*	public static Sessio retornaSessioLliure(int index){
		Sessio s = null;
		int numSessionsLliures=0;
		if (quantitatSessions()==0) System.out.println("\n\t No hi ha cap SESSIO registrada");
		else {
			for(int i=1; i<=quantitatSessions();i++){
				if (!sessions.get(i-1).isAssignadaPeli()) {//si estan lliures, es mostren
					if (index == numSessionsLliures-1) 
						s = sessions.get(i-1);
					numSessionsLliures++;
				}
			}	
		}
		return s;
	}
	 */	
	//*********************************************************
	//Modifica la SESSIO de la posicio i
	public void modificaSessio(int i){
		if (i <= quantitatSessions())
			sessions.get(i-1).modificaSessio();
		else {
			System.out.println("ERROR Sessions.modificaSessio: valor proporcionat fora de rang");
		}
	}

	//*********************************************************
	//Esborra la SESSIO de la posicio i
	public  void esborraSessio(int i){
		if (i <= quantitatSessions()){
			Sessio s = sessions.get(i-1);
			//Eliminem qualsevol enllaç de la SESSIO al llistat de Sessions a qualsevol PELICULA
			for(int j=0; j < Pelicules.quantitatPelicules(); j++) {
				for (int k=0; k < Pelicules.retornaPelicula(j+1).getSessionsPeli().size(); k++)
					if (Pelicules.retornaPelicula(j+1).getSessionsPeli().contains(s))
						Pelicules.retornaPelicula(j+1).getSessionsPeli().remove(k);
			}

			sessions.get(i-1).esborraSessio();
			sessions.remove(i-1);
		}else {
			System.out.println("ERROR Sales.modificaSala: valor proporcionat fora de rang");
		}
	}

	//*********************************************************
	//Num de SESSIONS
	public static  int quantitatSessions(){
		return sessions.size();
	}

	//GETTERS & SETTERS
	//*********************************************************	
	public  ArrayList<Sessio> getSessions() {
		return sessions;
	}

	public  void setSessions(ArrayList<Sessio> sessions) {
		this.sessions = sessions;
	}


}
