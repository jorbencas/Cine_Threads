import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread implements Runnable {

	private int numclient;
	
	 Socket socket;
	 DataInputStream entrada;
	 DataOutputStream salida;
	 String mensa = "11";
	 boolean iterar = true;
		int nPelicula = 0;
		int nSessio;
		ArrayList <Seient> llistaSeients;
		int fila = 0;
		int col = 0;
		Sessio se;
		Pelicula p;
	public ClientThread(Socket socket, int numclient,int nPelicula, int nSessio, ArrayList <Seient> llistaSeients) {
		super();
		this.numclient = numclient;
		this.socket = socket;
		this.nPelicula = nPelicula;
		this.nSessio = nSessio;
		this.llistaSeients = llistaSeients;
	}

	@Override
	public void run() {
		try {
			
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());
			System.out.println("El client " + this.numclient + "Va ha realitzar una reserva");
			
			salida.writeUTF(Pelicules.LlistaPelicules());
			this.nPelicula = Integer.parseInt(entrada.readUTF());
			Pelicula p = Pelicules.retornaPelicula(nPelicula);

			salida.writeUTF(Sessions.respuestaSessionsTCP());
			this.nSessio = Integer.parseInt(entrada.readUTF());
			Sessio se = p.getSessionsPeli().get(this.nSessio-1);
			
			System.out.println("Vamos a leer el numero de asientos");
			String val = entrada.readUTF();
			int entra = Integer.parseInt(val);
			salida.writeUTF(val);

			for(int i = 0; i < entra; i++) {
				String mapa = se.mapaSessionTCP();
				salida.writeUTF(mapa);
				this.fila = Integer.parseInt(entrada.readUTF());
				this.col = Integer.parseInt(entrada.readUTF());
				this.llistaSeients.add(new Seient(this.fila, this.col));
			}

			Sala sa = se.getSala();
			try {
				this.reserva_numEntradesNoInteractiva(p, se, sa, llistaSeients);
				String mapa = se.mapaSessionTCP();
				salida.writeUTF(mapa);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			entrada.close();
			salida.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void reserva_numEntradesNoInteractiva(Pelicula p, Sessio se, Sala sa, ArrayList <Seient> llistaSeients) throws InterruptedException {
		boolean isreservat = true;
		int nFila, nSeient;
		int nEntrades = llistaSeients.size();
		
		//ArrayList de la quantitat de seients que es volen comprar
		ArrayList<Seient> seientsAcomprar = new ArrayList<Seient>();

		//obtenim els Seients ACTUALSde la Sala
		Seient[][] seients = se.getSeients();

		for (int i = 0; i < nEntrades; i++) 
			System.out.println("["+Thread.currentThread().getName()+ "]\t Tractant reservar Seient ("+llistaSeients.get(i).getFilaSeient() +","+llistaSeients.get(i).getNumeroSeient()+"): Estat ACTUAL: " + seients[llistaSeients.get(i).getFilaSeient() - 1][llistaSeients.get(i).getNumeroSeient() - 1].getDisponibilitat());
			
		for (int i = 0; i < nEntrades; i++) {
			nFila = llistaSeients.get(i).getFilaSeient();
			nSeient = llistaSeients.get(i).getNumeroSeient();

			// 
			// SYNCHRONIZED ///////////////////////////////////////////////////////////////////////////////////////////////////
			synchronized (seients[nFila - 1][nSeient - 1]) {
				if (seients[nFila - 1][nSeient - 1].verificaSeient()) { // Reserva SEIENT
					seients[nFila - 1][nSeient - 1].reservaSeient(); 
					// afegeix seient a llista SEIENTS RESERVATS
					seientsAcomprar.add(seients[nFila - 1][nSeient - 1]);
				} else { // NO Reserva
					isreservat = false;
					System.out.println("["+Thread.currentThread().getName()+ "]\t ERROR Thread:validaSeientsNoInteractiu: Seient ("+nFila +","+nSeient+") OCUPAT o RESERVAT");
				}// else
			}
			// end SYNCHRONIZED	// ///////////////////////////////////////////////////////////////////////////////////////////
		}// for

		if (isreservat) { // Compra seients
			System.out.println("[" +Thread.currentThread().getName()+ "]\t SEIENT RESERVATS: " + seientsAcomprar.size());
			//pagamentEntrada
			this.pagamentEntrada(new BigDecimal(nEntrades).multiply(se.getPreu()));;
			for (int i=0; i < seientsAcomprar.size(); i++){
				Seient s = seientsAcomprar.get(i);
				s.ocupaSeient(); 		//ocupa seient
				se.imprimirTicket(s,se, sa, p);
				System.out.println();
			}//for
		}else{// Llibera seients
			System.out.println("["+Thread.currentThread().getName()+ "]\t\tNO sha pogut fer la compra de "+nEntrades+" entrades. Es queden Lliures");
			for (int i=0; i < seientsAcomprar.size(); i++){
				Seient s = seientsAcomprar.get(i);
				s.alliberaSeient(); 		//ocupa seient
			}//for
		}
		for (int i=seientsAcomprar.size(); i > 0; i--)
			seientsAcomprar.remove(i-1); //elimina seient de la llista

	}
//*********************************************************
//PAGAMENT D'UNA ENTRADA
private boolean pagamentEntrada(BigDecimal preu){
	System.out.println("["+Thread.currentThread().getName()+"] Import a pagar: "+preu);
	System.out.println("\n["+Thread.currentThread().getName()+"] Pagant...(2seg)");
	//pagant
	try {
		Thread.sleep((long) (2000*Math.random()));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	//return Validacio.validaBooleaDefecte("["+Thread.currentThread().getName()+"] Pagat? (S/N)",true);
	return true;

}

}
