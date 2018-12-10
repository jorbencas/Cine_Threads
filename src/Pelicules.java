import java.util.ArrayList;
import java.util.Scanner;


public class Pelicules {
    private static ArrayList<Pelicula> pelicules;

    //CONSTRUCTOR1
    public Pelicules() {
        pelicules = new ArrayList<>();
    }

    //CONSTRUCTOR2
    public Pelicules(ArrayList<Pelicula> pelicules) {
        Pelicules.pelicules = pelicules;
    }

    //*********************************************************
    //AFEGIR PELICULA AL LLISTAT
    public static void afegirPelicula(Pelicula s) {
        Pelicules.pelicules.add(s);
    }

    //*********************************************************
    //VISUALITZA TOTES LES PELICULES DISPONIBLES
    public static int llistarPelicules() {
        for (int i = 0; i < Pelicules.pelicules.size(); i++) {
            System.out.println("[" + ( i + 1 ) + "] " + Pelicules.pelicules.get(i).toString());
        }
        return  Pelicules.pelicules.size();
    }

    //*********************************************************
    //RETORNA PELICULA DE LA POSICIO i
    public static Pelicula retornaPelicula(int i) {
        return Pelicules.pelicules.get(i);
    }

    //*********************************************************
    //MODIFICA PELICULA DE LA POSICIO i
    public static void modificaPelicula(int i) {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...
    }

    //*********************************************************
    //ESBORRA LA PELICULA DE LA POSICIO i
    public static void esborraPelicula(int i) {
        if (Pelicules.retornaPelicula(i) != null) {
            Pelicules.pelicules.remove(i);
        } else {
            System.out.println("No existe dicha pelicula");
        }
    }

    //*********************************************************
    //NUMERO DE PELICULES
    public static int quantitatPelicules() {
        return Pelicules.pelicules.size();
    }

    // ---------------------------------
    public void associaPeliculaSessio(Pelicules pelicules, Sessions sessions) {
        //...
        // IMPLEMENTAR CODI ACÍ
        //...
    }

    public static void asociarPeliculaSesion(Pelicula pel, Sessio ses) {
        pel.getSessionsPeli().add(ses);
    }

    //-------------------------------------
    //GETTERS & SETTERS
    public ArrayList<Pelicula> getPelicules() {
        return pelicules;
    }

    public void setPelicules(ArrayList<Pelicula> pelicules) {
        this.pelicules = pelicules;
    }

}

