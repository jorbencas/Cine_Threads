import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Cine {

	public static void main(String[] args) throws InterruptedException {
		int opcio=-1;
		Scanner s = new Scanner(System.in);
		// TODO Auto-generated method stub
		String nsala, nsessio, npelicula;
		int sala, sessio, pelicula; 
		ArrayList<Seient> llistaSeients1, llistaSeients2, llistaSeients3,llistaSeients4;

		Sales sales = new Sales();
		Sessions sessions = new Sessions();
		Pelicules pelicules = new Pelicules();

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
				//********

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
				System.out.println("Comprant ENTRADA...");
				
				Servidor servidor = new Servidor(2,1,llistaSeients1 = new ArrayList<Seient>());
				
				
				//COMPRA ENTRADES FIL NO INTERACTIVA, amb uns valors ja predefinits on hi ha conflicte
				/*FilCompraEntradesNoInteractiva noufil1 = new FilCompraEntradesNoInteractiva();
				FilCompraEntradesNoInteractiva noufil2 = new FilCompraEntradesNoInteractiva(2,1,llistaSeients2 = new ArrayList<Seient>());
				FilCompraEntradesNoInteractiva noufil3 = new FilCompraEntradesNoInteractiva(2,1,llistaSeients3 = new ArrayList<Seient>());
				FilCompraEntradesNoInteractiva noufil4 = new FilCompraEntradesNoInteractiva(2,1,llistaSeients4= new ArrayList<Seient>());
				
				llistaSeients1.add(new Seient(1,1));
				llistaSeients1.add(new Seient(1,2));
				
				llistaSeients2.add(new Seient(1,2));
				llistaSeients2.add(new Seient(2,2));
				
				llistaSeients3.add(new Seient(2,2));
				llistaSeients3.add(new Seient(2,3));
				llistaSeients3.add(new Seient(2,4));
				
				llistaSeients4.add(new Seient(2,4));
				llistaSeients4.add(new Seient(1,4));*/
				
				servidor.start();
				servidor.join();
				/*Thread fil1 = new Thread(noufil1,"Fil1");
				Thread fil2 = new Thread(noufil2,"Fil2");
				Thread fil3 = new Thread(noufil3,"Fil3");
				Thread fil4 = new Thread(noufil4,"Fil4");
				fil1.start();
				fil2.start();
				fil3.start();
				fil4.start();*/
				
				System.out.println("\n\n");

				break;
				//********


			default: System.out.println("Eixint CINE...\n Programa finalitzat!!!");
			System.out.println("\n\n");

			}
		}while(opcio!=0);

	}
	/*
	//*********************************************************
	//COMPRA INTERACTIVA D'UNA ENTRADA -> MENEJAT AL FIL D'EXECUCIO
	public static void compraEntradaPelicula() throws InterruptedException{

		Pelicula p = null;
		Sala sa = null;
		Sessio se = null;
		int sessio, pelicula, fila, seient, numEntrades; 

		//Si NO hi ha PELICULES, s'ix del procés de compra
		if (Pelicules.llistarPelicules() == 0) {
			System.out.println("\t ERROR Cine:compraEntradaPelicula: No hi ha PELICULES");
			return;
		}
		//Selecció de PELICULA
		pelicula = Validacio.validaSencer("\t Tria PELICULA:",Pelicules.quantitatPelicules());
		p = Pelicules.retornaPelicula(pelicula);
		System.out.println(p);
		System.out.println();
		System.out.println();

		//Si NO hi ha SESSIONS per la PELICULA, s'ix del procés de compra
		if (p.llistarSessionsPeli()== 0) {
			System.out.println("\t ERROR Cine:compraEntradaPelicula: No hi ha SESSIONS per a esta PELICULA");
			return;
		}
		//Selecció de la SESSIO
		sessio = Validacio.validaSencer("\t Tria la sessió per a "+p.getNomPeli()+":",p.getSessionsPeli().size());

		se = p.retornaSessioPeli(sessio);
		sa = se.getSala();
		se.mapaSessio();

		//Selecció de QUANTES entrades es volen comprar
		numEntrades = Validacio.validaSencer("\tQuantes ENTRADES vols comprar? ",sa.getFiles()*sa.getTamanyFila());
		Seient[][] seients = se.getSeients();

		//metode que gestiona la compra multiple d'entrades
		reserva_numEntrades(p,se,sa,numEntrades);

		se.mapaSessio();
	}

	//---------------------
	//metode que tracta de reservar totes les entrades sol·licitades, 
	// retorna TRUE  -> si es reserven TOTES les entrades
	// retorna FALSE -> si NO s'ha pogut reservar alguna entrada, aleshores no es reservarà CAP
		 
		public static void reserva_numEntrades(Pelicula p, Sessio se, Sala sa, int numEntrades) throws InterruptedException{
		boolean isReservat = true;
		int fila, seient;
		//ArrayList de la quantitat de seients que es volen comprar
		ArrayList<Seient> seientsAcomprar = new ArrayList<Seient>();

		for (int i=0; i < numEntrades; i++){
			System.out.println("\tSeient "+(i+1)+" :");
			fila = Validacio.validaSencer("\t\t Tria FILA: [1-"+sa.getFiles()+"] ",sa.getFiles());
			seient = Validacio.validaSencer("\t\t Tria SEIENT en la fila: [1-"+sa.getTamanyFila()+"]",sa.getTamanyFila());		
			Seient[][] seients = se.getSeients();
			if (seients[fila-1][seient-1].verificaSeient()){ //Reserva SEIENT
				seients[fila-1][seient-1].reservaSeient();	
				seientsAcomprar.add(seients[fila-1][seient-1]);//afegeix seient a llista SEIENTS RESERVATS
			}else{ //NO Reserva
				System.out.println("\t ERROR Cine:validaSeient: Seient reservat/ocupat");
				isReservat = false;
			};
			System.out.println("\tSegüent Seient...");
		}//endfor

		if (isReservat){ //Compra seients
			System.out.println("\nSEIENT RESERVATS: "+seientsAcomprar.size());
			pagamentEntrada(new BigDecimal(numEntrades).multiply(se.getPreu()));
			for (int i=0; i < seientsAcomprar.size(); i++){
				Seient s = seientsAcomprar.get(i);
				s.ocupaSeient(); 		//ocupa seient
				se.imprimirTicket(s,se, sa, p);
				System.out.println();
			}//for
		}else{// Llibera seients
			System.out.println("\t\tNO sha pogut fer la compra de "+numEntrades+" entrades. Es queden Lliures");
			for (int i=0; i < seientsAcomprar.size(); i++){
				Seient s = seientsAcomprar.get(i);
				s.alliberaSeient(); 		//ocupa seient
			}//for
		}
		for (int i=seientsAcomprar.size(); i > 0; i--)
			seientsAcomprar.remove(i-1); //elimina seient de la llista

		}

 */
	// ----------------------------------------
	// METODE DE COMPRA ENTRADES DEL FIL D'EXECUCIO NO INTERACTIU
	

	
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
