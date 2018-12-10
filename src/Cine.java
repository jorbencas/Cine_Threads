import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;


public class Cine { 

    
    public static Pelicula peliculaPagament;
    public static Sessio sesionPagament;
    public static Seient asientoPagament;
    
	public static void main(String[] args) throws InterruptedException {
		 int opcio = 999, opcionElegida = 999, numSala, numFilas, numAsientosXFila, dia, mes, año, hora, minutos, duracionPelicula;
	        String nombreSession, nombrePelicula, nacionalidad, director, interprete, arguments, genere, clasificacio;
	        Calendar calendario;
	        boolean es3d;
	        BigDecimal dec;
	        Scanner teclado = new Scanner(System.in);
	        Sales sales = new Sales();
	        Sessions sesiones = new Sessions();
	        Pelicules pelicules = new Pelicules();

	        Pelicula peliActiva = new Pelicula();
	        Sala salaActiva = new Sala();
	        Sessio sesionActiva = new Sessio();

	        do {
	            opcio = menu();

	            switch (opcio) {

	                case 1:
	                    numSala = Validacio.validaSencer(" Introdueix el numero de sala", 1000);
	                    es3d = Validacio.validaBoolea(" Es 3D? S/N");
	                    numFilas = Validacio.validaSencer("Introdueix numero de filas", 1000);
	                    numAsientosXFila = Validacio.validaSencer("Introdueix tamaño de fila", 1000);
	                    Sala sal = new Sala(numSala, es3d, numFilas, numAsientosXFila);
	                    System.out.println(sal.toString());
	                    Sales.afegirSala(sal);

	                    break;

	                case 2:
	                    Sales.llistarSales();
	                    opcionElegida = Validacio.validaSencer("Elige una sala a modificar , introduce su indice", Sales.quantitatSales());
	                    Sala s = Sales.retornaSala(opcionElegida);
	                    System.out.println("Introdueix nuevos datos en el siguiente orden : NUMERO SALA - NUMERO FILAS - CANTIDAD DE ASIENTOS POR FILA - ES 3D (False o True)");
	                    numSala = teclado.nextInt();
	                    if (Sales.validaIdSala(numSala) == false) {
	                        numFilas = teclado.nextInt();
	                        numAsientosXFila = teclado.nextInt();
	                        es3d = teclado.nextBoolean();
	                        s.setNumeroSala(numSala);
	                        s.setFiles(numFilas);
	                        s.setTamanyFila(numAsientosXFila);
	                        s.setSala3D(es3d);
	                        Sales.modificaSala(s, opcionElegida);
	                        System.out.println("Modificada con exito" + s.toString());
	                    } else {
	                        System.out.println("Ya existe una sala con ese numero de sala");
	                    }

	                    break;

	                case 3: //Esborrar SALA
	                    if (Sales.quantitatSales() > 0) {
	                        Sales.llistarSales();
	                        opcionElegida = Validacio.validaSencer("Elige una sala a borrar , introduce su indice", Sales.quantitatSales());
	                        Sales.esborraSala(opcionElegida);
	                        System.out.println("Eliminado con exito");
	                    } else {
	                        System.out.println("No hay salas");
	                    }
	                    break;

	                case 4:	//Crear SESSIO
	                    if (Sales.quantitatSales() > 0) {
	                        Sales.llistarSales();
	                        opcionElegida = Validacio.validaSencer("Elige una sala para la sesion, introduce su indice", Sales.quantitatSales());
	                        salaActiva = Sales.retornaSala(opcionElegida);
	                        System.out.println("sala seleccionada" + salaActiva);
	                        nombreSession = Validacio.validaCadena("Introdueix nombre de la sesion");
	                        calendario = Validacio.validaData("Introdueix la fecha con el siguiente formato DD/MM/AAAA");
	                        dec = Validacio.validaMoneda("Introdueix precio");
	                        Sessio sesion = new Sessio(nombreSession, calendario, salaActiva, dec);
	                        Seient[][] asiento = new Seient[salaActiva.getFiles()][salaActiva.getTamanyFila()];
	                        sesion.setSeients(asiento);
	                        Sessions.afegirSessio(sesion);
	                        sesion.setMapaSessio();
	                        sesion.mapaSessio();
	                        System.out.println("Deseas añadir salas a la sesion? [S] [N]");
	                        String eleccion = teclado.nextLine();
	                        if (eleccion.equalsIgnoreCase("S") && Sales.quantitatSales() > 0) {
	                            Sales.llistarSales();
	                            opcionElegida = Validacio.validaSencer("Elija una sala a para añadir a la sesion", Sales.quantitatSales());
	                            sesion.setSala(Sales.retornaSala(opcionElegida));
	                            System.out.println("Añadida con exito");
	                        } else {
	                            System.out.println("No hay salas ");
	                        }

	                    } else {
	                        System.out.println("Debes dar de alta alguna sala primero..");
	                    }
	                    break;

	                case 5: //Modifica SESSIO

	                    Sessions.llistarSessions();
	                    opcionElegida = Validacio.validaSencer("Eleguix una sessio a modificar", Sessions.quantitatSessions());
	                    sesionActiva = Sessions.retornaSessio(opcionElegida);
	                    String nombreSesion = Validacio.validaCadena("Introdueix el nom de la sessio");
	                    calendario = Validacio.validaData("Introdueix la fecha amb el siguent formato DD/MM/AAAA");
	                    Sales.llistarSales();
	                    salaActiva = Sales.retornaSala(Validacio.validaSencer("Eleguix la nuva sala", Sales.quantitatSales()));
	                    if (salaActiva != null) {
	                        dec = Validacio.validaMoneda("Introdueix el preu");
	                        sesionActiva = new Sessio(nombreSesion, calendario, salaActiva, dec);
	                        sesionActiva.setSeients(new Seient[salaActiva.getFiles()][salaActiva.getTamanyFila()]);
	                        System.out.println("Dades de la nova sessio" + sesionActiva);
	                    } else {
	                        System.out.println("Has introduit una sala incorrecta");
	                    }

	                    break;

	                case 6: //Esborrar SESSSIO
	                    if (Sessions.quantitatSessions() > 0) {
	                        Sessions.llistarSessions();
	                        opcionElegida = Validacio.validaSencer("Eleguix una sessio a eliminar", Sessions.quantitatSessions());
	                        Sessions.esborraSessio(opcionElegida);
	                    } else {
	                        System.out.println("No hi han sessions");
	                    }
	                    break;

	                case 7: //Crear PELICULA
	                    nombrePelicula = Validacio.validaCadena("Introdueix nombre de la pelicula");
	                    nacionalidad = Validacio.validaCadena("Introdueix nacionalidad");
	                    duracionPelicula = Validacio.validaSencer("Introdueix duracion pelicula en minutos", 1000);
	                    director = Validacio.validaCadena("Introdueix nombre del director");
	                    interprete = Validacio.validaCadena("Introdueix nombre de los interpretes");
	                    arguments = Validacio.validaCadena("Introdueix argumento");
	                    genere = Validacio.validaCadena("Introdueix genero");
	                    clasificacio = Validacio.validaCadena("Introdueix clasificacion");
	                    Pelicula pelicula = new Pelicula(nombrePelicula, nacionalidad, duracionPelicula, director, interprete, arguments, genere, clasificacio);
	                    Pelicules.afegirPelicula(pelicula);
	                    System.out.println("Deseas añadir sesiones a la pelicula? [S] [N]");
	                    String eleccion = teclado.nextLine();
	                    if (eleccion.equalsIgnoreCase("S")) {
	                        Sessions.llistarSessions();
	                        opcionElegida = Validacio.validaSencer("Elija una session para añadir a la pelicula", Sessions.quantitatSessions());
	                        pelicula.getSessionsPeli().add(Sessions.retornaSessio(opcionElegida));
	                        System.out.println("Añadida con exito");

	                    }
	                    break;

	                case 8: //Modifica PELICULA
	                    Pelicules.llistarPelicules();
	                    opcionElegida = Validacio.validaSencer("Eleguix pelicula a modificar", Pelicules.quantitatPelicules());
	                    peliActiva = Pelicules.retornaPelicula(opcionElegida);
	                    System.out.println("Seleccionada " + peliActiva.toString());
	                    peliActiva.setNomPeli(Validacio.validaCadena("Introdueix nombre de la pelicula"));
	                    peliActiva.setNacionalitat(Validacio.validaCadena("Introdueix nacionalidad"));
	                    peliActiva.setDuracio(Validacio.validaSencer("Introdueix duracion pelicula", 1000));
	                    peliActiva.setDirector(Validacio.validaCadena("Introdueix nombre del director"));
	                    peliActiva.setInterprets("Introdueix nombre de los interpretes");
	                    peliActiva.setArgument(Validacio.validaCadena("Introdueix argumento"));
	                    peliActiva.setGenere(Validacio.validaCadena("Introdueix generoº"));
	                    peliActiva.setClassificacio(Validacio.validaCadena("Introdueix clasificacion"));
	                    System.out.println("Noves dades... " + peliActiva.toString());
	                    break;

	                case 9: //Esborrar PELICULA
	                    Pelicules.llistarPelicules();
	                    opcionElegida = Validacio.validaSencer("Eleguix pelicula a eliminar", Pelicules.quantitatPelicules());
	                    Pelicules.esborraPelicula(opcionElegida);
	                    System.out.println("Pelicula eliminada amb exit!");

	                    break;

	                case 10: //Associar PELICULA a SESSIO 
	                    Pelicules.llistarPelicules();
	                    opcionElegida = Validacio.validaSencer("Eliguix una pelicula", Pelicules.quantitatPelicules());
	                    peliActiva = Pelicules.retornaPelicula(opcionElegida);
	                    System.out.println("Eliguix una sessio que vols afegir ala pelicula" + peliActiva.toString());
	                    Sessions.llistarSessions();
	                    opcionElegida = Validacio.validaSencer("Eliguix una sessio", Sessions.quantitatSessions());
	                    sesionActiva = Sessions.retornaSessio(opcionElegida);
	                    System.out.println("Has elegit la sessio " + sesionActiva.toString() + " para la pelicula " + peliActiva.toString());
	                    Thread.sleep(1000);
	                    Pelicules.asociarPeliculaSesion(peliActiva, sesionActiva);
	                    System.out.println("Asignats amb exit");

	                    break;

	                case 11: //Comprar ENTRADA
	                    Pelicules.llistarPelicules();
	                    opcionElegida = Validacio.validaSencer("Selecciona una pelicula", Pelicules.quantitatPelicules());
	                    peliculaPagament = Pelicules.retornaPelicula(opcionElegida);
	                    peliculaPagament.llistarSessionsPeli();
	                    opcionElegida = Validacio.validaSencer("Selecciona una sesion", Sessions.quantitatSessions());
	                    sesionPagament = peliculaPagament.retornaSessioPeli(opcionElegida);
	                    System.out.println("Selecciona un seient");
	                    sesionPagament.mapaSessio();
	                    int fila = Validacio.validaSencer("Introdueix fila", sesionPagament.getSala().getFiles());
	                    int col = Validacio.validaSencer("Introdueix columna", sesionPagament.getSala().getTamanyFila());
	                    asientoPagament = sesionPagament.getSeients()[fila][col];
	                    System.out.println(asientoPagament.toString());
	                    compraEntradaPelicula();
	                    System.out.println("La informaccio es correcta? [S] [N]");
	                    String aux = teclado.nextLine();
	                    if (aux.equalsIgnoreCase("S")) {
	                        compraEntradaPelicula();
	                        System.out.println("Introdueix metodo de pago");
	                        String metodo = teclado.nextLine();
	                        System.out.println("Introdueix dades de tarjeta");
	                        String datosTarjeta = teclado.nextLine();
	                        pagamentEntrada(sesionPagament.getPreu(), metodo, datosTarjeta);

	                    } else if (aux.equalsIgnoreCase("N")) {
	                        System.out.println("Exint...");
	                        break;
	                    } else {
	                        System.out.println("Has introduit un valor incorrecte");
	                    }

	                    break;
	                default:
	            }
	} while (opcio != 0);

	}

	//*********************************************************
	 public static void compraEntradaPelicula() throws InterruptedException {

	        System.out.println("Es va a comprar el seient " + asientoPagament.toString() + " que se encuentra en ");
	        Thread.sleep(1000);
	        System.out.println("Sesio " + sesionPagament.toString() + " que a al metix temps te la pelicula ");
	        Thread.sleep(1000);
	        System.out.println("Pelicula " + peliculaPagament.toString());
	        Thread.sleep(1000);
	    }

	    //*********************************************************
	    //PAGAMENT D'UNA ENTRADA
	    static boolean pagamentEntrada(BigDecimal preu, String metodoPago, String datosTarjeta) throws InterruptedException {
	        System.out.println("Total a pagar " + preu + " €");
	        System.out.println("Metode de pagament " + metodoPago);
	        System.out.println("Dades de la tarjeta " + datosTarjeta);
	        int i = 0;
	        while (i < 5) {
	            System.out.println("Procesant pago...");
	            Thread.sleep(1000);
	            i++;
	        }
	        System.out.println("Pago realitzat amb exit");
	        asientoPagament.reservaSeient();
	        sesionPagament.mapaSessio();
	        return false;
	    }



	//*********************************************************
	//VISUALITZA EL MENU PRINCIPAL
	public static int menu(){
		int opcio;
		Scanner s = new Scanner(System.in);

		do{
			System.out.println("MENU Aplicació CINE:");
			System.out.println("====================");
			System.out.println("1.  Crear SALA");
			System.out.println("2.  Modificar SALA");
			System.out.println("3.  Eliminar SALA");

			System.out.println("4.  Crear SESSIO");
			System.out.println("5.  Modificar SESSIO");
			System.out.println("6.  Eliminar SESSIO");

			System.out.println("7.  Crear PELICULA");
			System.out.println("8.  Modificar PELICULA");
			System.out.println("9.  Eliminar PELICULA");

			System.out.println("10. Associar PELICULA a SESSIO");
			System.out.println("11. Comprar ENTRADA");
			System.out.println("0. Eixir Aplicació CINE");

			String stropcio = s.next();
			opcio=Integer.parseInt(stropcio);
		}while (opcio < 0 || opcio > 11);

		return opcio;
	}
	
	static int menumodificasesio() {
		int opcio = 0;
		do {
			System.out.println("1 El nom");
			System.out.println("2 la data");
			System.out.println("3 la sala");
			System.out.println("4 el preu");
		}while(opcio != 0);
		return opcio;
				
	}

}
