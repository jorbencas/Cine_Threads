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
        this.sessionsPeli = new ArrayList<Sessio>();
    }

    // ---------------------------------
    public void modificaPelicula() {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...
    }

    // ---------------------------------
    public Pelicula(String nomPeli) {
        this.nomPeli = nomPeli;
        this.sessionsPeli = new ArrayList<Sessio>();
    }

    // ---------------------------------
    public Pelicula(String nomPeli, String nacionalitat, int duracio,
            String director, String interprets, String argument, String genere,
            String classificacio) {

        this.nomPeli = nomPeli;
        this.nacionalitat = nacionalitat;
        this.duracio = duracio;
        this.director = director;
        this.interprets = interprets;
        this.argument = argument;
        this.genere = genere;
        this.classificacio = classificacio;
        this.sessionsPeli = new ArrayList<Sessio>();

    }

    // ---------------------------------
    public Pelicula(String nomPeli, String nacionalitat, int duracio,
            String director, String interprets, String argument, String genere,
            String classificacio, ArrayList<Sessio> sessionsPeli) {

        this.nomPeli = nomPeli;
        this.nacionalitat = nacionalitat;
        this.duracio = duracio;
        this.director = director;
        this.interprets = interprets;
        this.argument = argument;
        this.genere = genere;
        this.classificacio = classificacio;
        this.sessionsPeli = sessionsPeli;
    }

    // ---------------------------------
    @Override
    public String toString() {
        return "Pelicula [nomPeli=" + nomPeli + "\t nacionalitat="
                + nacionalitat + "\t duracio=" + duracio + "\t director="
                + director + "\t interprets=" + interprets + "\t argument="
                + argument + "\t genere=" + genere + "\t classificacio="
                + classificacio + "\t sessionsPeli=" + sessionsPeli + "]";
    }

    //LLISTA EL LLISTAT DE SESSIONS PER LA PELICULA
    public int llistarSessionsPeli() {
        if (this.getSessionsPeli().size() > 0) {
            for (int i = 0; i < this.getSessionsPeli().size(); i++) {
                System.out.println("[" + (i - 1 ) + "] " + this.getSessionsPeli().get(i));
            }
            return 1;
        } else {
            return 0;
        }
    }

    public Sessio retornaSessioPeli(int i) {
        if (this.getSessionsPeli().get(i) != null) {
            return this.getSessionsPeli().get(i);
        } else {
            System.out.println("No existe");
        }
        return null;
    }

    public void esborraSessioPeli(int i) {
        if (this.getSessionsPeli().get(i) != null) {
            Seient[][] asientos = this.getSessionsPeli().get(i).getSeients();
            boolean hayReservados = false;
            for (int j = 0; j < asientos.length; j++) {
                for (int k = 0; k < asientos[0].length; k++) {
                    if (asientos[j][k].getDisponibilitat() == Seient.Estat.OCUPAT) {
                        hayReservados = true;
                    }
                }
            }
            if (hayReservados == false) {
                this.getSessionsPeli().remove(this.retornaSessioPeli(i));
                System.out.println("Eliminado con exito");
            } else {
                System.out.println("No se puede eliminar porque hay un asiento reservado");
            }

        } else {
            System.out.println("No existe, por lo que no se puede borrar");
        }
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
