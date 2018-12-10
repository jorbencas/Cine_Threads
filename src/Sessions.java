import java.util.ArrayList;


public class Sessions {

    private static ArrayList<Sessio> sessions;

    //CONSTRUCTOR1
    public Sessions() {
        Sessions.sessions = new ArrayList<>();
    }

    //CONSTRUCTOR2	
    public Sessions(ArrayList<Sessio> sessions) {
        Sessions.sessions = sessions;
    }

    //METODES
    //AFEGIR SESSIO AL LLISTAT
    public static void afegirSessio(Sessio s) {
        if (validaIdSessio(s.getNomSessio()) == false) {
            sessions.add(s);
            System.out.println("Añadido con exito" + s.toString());
        } else {
            System.out.println("No se puede añadir porque ya existe " + s.toString());
        }
    }

    //*********************************************************
    //COMPROVA SI LA SESSIO JA EXISTEIX AL LLISTAT
    public static boolean validaIdSessio(String s) {
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getNomSessio().equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    //*********************************************************
    //MOSTRA EL LLISTAT DE SESSIONS
    public static void llistarSessions() {
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + sessions.get(i).toString());
        }
    }

    //*********************************************************
    //RETORNA LA SESSIO DE LA POSICIO i
    public static Sessio retornaSessio(int i) {
        return sessions.get(i);
    }

    //*********************************************************
    //MODIFICA LA SESSIO DE LA POSICIO i
    public void modificaSessio(int i) {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...
    }

    //*********************************************************
    //ESBORRA LA SESSIO DE LA POSICIO i
    public static void esborraSessio(int i) {
        if (sessions.get((i - 1)) != null) {
            Seient[][] matrizAsiento = sessions.get(i).getSeients();
            boolean hayReservados = false;
            for (int j = 0; j < matrizAsiento.length; j++) {
                for (int k = 0; k < matrizAsiento[0].length; k++) {
                    if (matrizAsiento[j][k].getDisponibilitat() == Seient.Estat.OCUPAT) {
                        hayReservados = true;
                    }
                }
            }
            if (hayReservados == false) {
                sessions.remove(i);
                System.out.println("Eliminado con exito");
            } else {
                System.out.println("No se puede eliminar porque hay un asiento reservado");
            }
        } else {
            System.out.println("No se puede eliminar porque no existe");
        }
    }

    //*********************************************************
    //NUMERO DE SESSIONS
    public static int quantitatSessions() {
        return sessions.size();
    }

    //GETTERS & SETTERS
    public ArrayList<Sessio> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Sessio> sessions) {
        this.sessions = sessions;
    }

}
