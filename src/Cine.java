import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Cine {

	static Sessions sessions;
	static Pelicules pelicules;
	public static void main(String[] args) throws InterruptedException {
		int opcio=-1;
		Scanner s = new Scanner(System.in);
		// TODO Auto-generated method stub
		String nsala, nsessio, npelicula;
		int sala, sessio, pelicula; 
		ArrayList<Seient> llistaSeients1, llistaSeients2, llistaSeients3,llistaSeients4;

		Sales sales = new Sales();
		 sessions = new Sessions();
		 pelicules = new Pelicules();

		//carregaDades Inicials
		carregaDadesInicials();

		do{
			opcio = menu();

			switch(opcio){

			case 1: //Crear SALA
				System.out.println("Creant SALA...");
				Sala sa = new Sala();
				System.out.println(sa);
				Sales.afegirSala(sa);
				System.out.println("\n\n");
				break;
				//********

			case 2: //Modificar SALA
				System.out.println("Modificant SALA...");
				if(Sales.quantitatSales()==0) //NO hi ha sales
					System.out.println("ERROR Modifica SALA: No hi ha Sales a modificar");
				else{ //Hi ha sales creades
					Sales.llistarSales();
					sala = Validacio.validaSencer("\t Tria SALA a modificar:",Sales.quantitatSales());
					Sales.modificaSala(sala);
				}
				System.out.println("\n\n");
				break;
				//********

			case 3: //Esborrar SALA
				System.out.println("Esborrant SALA...");
				if(Sales.quantitatSales()==0) //NO hi ha sales
					System.out.println("ERROR Esborra SALA: No hi ha Sales a esborrar");
				else{ //Hi ha sales creades
					Sales.llistarSales();
					sala = Validacio.validaSencer("\t Tria SALA a esborrar:",Sales.quantitatSales());
					Sales.esborraSala(sala);
				}
				System.out.println("\n\n");
				break;
				//********

			case 4: //Crear SESSIO
				System.out.println("Creant SESSIO...");
				Sessio se = new Sessio();
				System.out.println(se);
				Sessions.afegirSessio(se);
				System.out.println("\n\n");
				break;
				//********

			case 5: //Modifica SESSIO
				System.out.println("Modificant SESSIO...");

				if(Sessions.quantitatSessions()==0) //NO hi ha sessions
					System.out.println("ERROR Modifica SESSIO: No hi ha Sessions a modificar");
				else{ //Hi ha sessions creades
					Sessions.llistarSessions();
					sessio = Validacio.validaSencer("\t Tria SESSIO a modificar:",Sessions.quantitatSessions());
					sessions.modificaSessio(sessio);
				}
				System.out.println("\n\n");
				break;
				//********

			case 6: //Esborrar SESSSIO
				System.out.println("Esborrant SESSIO...");
				if(Sessions.quantitatSessions()==0) //NO hi ha sessions
					System.out.println("ERROR Esborra SESSIO: No hi ha Sessions a modificar");
				else{ //Hi ha sessions creades
					Sessions.llistarSessions();
					sessio = Validacio.validaSencer("\t Tria SESSIO a esborrar:",Sessions.quantitatSessions());
					sessions.esborraSessio(sessio);
				}
				System.out.println("\n\n");
				break;

			case 7: //Crear PELICULA
				System.out.println("Creant PELICULA...");
				Pelicula p = new Pelicula();
				System.out.println(p);
				Pelicules.afegirPelicula(p);
				System.out.println("\n\n");
				break;
				//********

			case 8: //Modifica PELICULA
				System.out.println("Modificant PELICULA...");

				if( Pelicules.quantitatPelicules()==0) //NO hi ha pelicules
					System.out.println("ERROR Modifica PELICULA: No hi ha Pelicules a modificar");
				else{ //Hi ha pelicules creades
					Pelicules.llistarPelicules();
					pelicula = Validacio.validaSencer("\t Tria PELICULA a modificar:", Pelicules.quantitatPelicules());
					Pelicules.modificaPelicula(pelicula);
				}
				System.out.println("\n\n");
				break;
				//********

			case 9: //Esborrar PELICULA
				System.out.println("Esborrant PELICULA...");
				if( Pelicules.quantitatPelicules()==0) //NO hi ha pelicules
					System.out.println("ERROR Esborra PELICULA: No hi ha pelicules a esborrar");
				else{ //Hi ha pelicules creades
					Pelicules.llistarPelicules();
					pelicula = Validacio.validaSencer("\t Tria PELICULA a esborrar:", Pelicules.quantitatPelicules());
					Pelicules.esborraPelicula(pelicula);
				}
				System.out.println("\n\n");
				break;
				//********

			case 10: //Associar PELICULA a SESSIO 
				System.out.println("Associant PELICULA a SESSIO...");
				pelicules.associaPeliculaSessio(pelicules, sessions);
				System.out.println("\n\n");
				break;

			case 11: //Comprar ENTRADA
				Servidor servidor = new Servidor();
				servidor.start();
				servidor.join();
				break;
				//********
			default: System.out.println("Eixint CINE...\n Programa finalitzat!!!");
			System.out.println("\n\n");

			}
		}while(opcio!=0);

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

			synchronized(s) {
				System.out.println("\n\nIntrodueix opció de menu:");
				String stropcio = s.next();
				opcio=Integer.parseInt(stropcio);
			}
		}while (opcio < 0 || opcio > 11);

		return opcio;
	}

	public static void carregaDadesInicials() {
		System.out.println("Càrrega INICIAL de DADES...");
		Sala sa1, sa2, sa3;
		Sales.afegirSala( sa1 = new Sala(1, true, 5, 5));
		Sales.afegirSala( sa2 = new Sala(2, true, 7, 7));
		Sales.afegirSala( sa3 = new Sala(3, false, 9, 9));

		Sessio s1, s2, s3;
		Sessions.afegirSessio(s1 = new Sessio("sesA-sala1", 15,12,2018,21,30, sa1, new BigDecimal(6)));
		Sessions.afegirSessio(s2 = new Sessio("sesB-sala1", 14,12,2018,22,0, sa2, new BigDecimal(4.5)));
		Sessions.afegirSessio(s3 = new Sessio("sesC-sala1", 16,12,2018,18,45, sa3, new BigDecimal(8)));

		Pelicula p1, p2, p3;
		Pelicules.afegirPelicula(p1 = new Pelicula("Avatar", "USA", 195,	"James Cameron", "actor1, actriu1, ...", "bla, bla, bla ...", "Ficció",	"TP",new ArrayList<Sessio>()));
		p1.setSessioPeli(s1);
		Pelicules.afegirPelicula(p2 = new Pelicula("Gladiator", "USA", 160,	"Ridley Scott", "actor1, actriu1, ...", "bla, bla, bla ...", "Ficció",	">18",new ArrayList<Sessio>()));
		p2.setSessioPeli(s2);
		Pelicules.afegirPelicula(p3 = new Pelicula("Regreso al futuro", "USA", 195,	"Robert Zemeckis", "actor1, actriu1, ...", "bla, bla, bla ...", "Ficció",	"TP",new ArrayList<Sessio>()));
		p3.setSessioPeli(s3);

	}
}
