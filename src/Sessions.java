import java.util.ArrayList;


public class Sessions {

	private static ArrayList<Sessio> sessions;

	//CONSTRUCTOR1
	public Sessions() {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//CONSTRUCTOR2	
	public Sessions(ArrayList<Sessio> sessions) {
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//METODES
	//AFEGIR SESSIO AL LLISTAT
	public static  void afegirSessio(Sessio s){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//COMPROVA SI LA SESSIO JA EXISTEIX AL LLISTAT
	public static  boolean validaIdSessio(String s){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//MOSTRA EL LLISTAT DE SESSIONS
	public static  void llistarSessions(){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//RETORNA LA SESSIO DE LA POSICIO i
	public static Sessio retornaSessio(int i){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//MODIFICA LA SESSIO DE LA POSICIO i
	public void modificaSessio(int i){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//ESBORRA LA SESSIO DE LA POSICIO i
	public  void esborraSessio(int i){
		//...
		// IMPLEMENTAR CODI ACÍ
		//...
	}

	//*********************************************************
	//NUMERO DE SESSIONS
	public static  int quantitatSessions(){
		return sessions.size();
	}

	//GETTERS & SETTERS
	public  ArrayList<Sessio> getSessions() {
		return sessions;
	}

	public  void setSessions(ArrayList<Sessio> sessions) {
		this.sessions = sessions;
	}


}
