import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

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
	int numEntradas;
	Long tiempoCompra;
	Long tiempoResultado;

	public ClientThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());
			System.out.println("El client " + Thread.currentThread().getName() + "Va ha realitzar una reserva");

			salida.writeUTF(Pelicules.LlistaPelicules());
			this.nPelicula = Integer.parseInt(entrada.readUTF());
			System.out.println("La pelicula eleguida ha sigut: " + this.nPelicula);
			p = Pelicules.retornaPelicula(nPelicula);

			salida.writeUTF(Sessions.respuestaSessionsTCP());
			this.nSessio = Integer.parseInt(entrada.readUTF());
			System.out.println("la session eleguia ha sigut: " + this.nSessio);
			se = p.retornaSessioPeli(this.nSessio);

			System.out.println("Vamos a leer el numero de asientos");
			String val = entrada.readUTF();
			numEntradas = Integer.parseInt(val);
			salida.writeUTF(val);

			String mapa = se.mapaSessionTCP();
			salida.writeUTF(mapa);

			for(int i = 0; i < numEntradas; i++) {
				this.fila = Integer.parseInt(entrada.readUTF());
				this.col = Integer.parseInt(entrada.readUTF());
				if(se.getSeients()[this.fila][this.col].verificaSeient()) {
					se.getSeients()[this.fila ][this.col].reservaSeient();
					llistaSeients.add(se.getSeients()[this.fila][this.col]);
					salida.writeUTF("true");
				}else {
					se.getSeients()[this.fila][this.col].alliberaSeient(); 		//ocupa seient
					salida.writeUTF("false");
					numEntradas = 0;
					for (Seient s : llistaSeients) 
						s.alliberaSeient();
					llistaSeients.removeAll(llistaSeients);
				}
			}

			Sala sa = this.se.getSala();
			tiempoCompra = System.currentTimeMillis();
			boolean b = pagamentEntrada(this.se.getPreu().multiply(BigDecimal.valueOf(numEntradas)));
			tiempoResultado = System.currentTimeMillis() - tiempoCompra;
			if (tiempoResultado > 10000){
				for (Seient s : llistaSeients) {
					s.alliberaSeient();
				}
				salida.writeUTF("tiempo");
			}else if (!b){
				for (Seient s : llistaSeients) {
					s.alliberaSeient();
				}
				salida.writeUTF("false");
			}else {
				for (Seient s : llistaSeients) {
					s.ocupaSeient();
				}
				salida.writeUTF("true");
				String st="";

				for (Seient s : llistaSeients) {
					st+=imprimirTicket(s, se, sa, p);
					System.out.println(s);
				}

				salida.writeUTF(st);
				salida.writeUTF(se.mapaSessionTCP());

			}
			entrada.close();
			salida.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public String imprimirTicket(Seient s, Sessio se, Sala sa, Pelicula p) {
		String st = "";

		st += ("\nImprimint el seu Ticket...\n");
		st += ("***************************\n");
		st += ("* ***TICKET ENTRADA *******\n");
		st += ("* PELICULA: " + p.getNomPeli() + " *\n");
		st += ("* HORARI: \n");
		st = mostraDataFormatada(st);
		st += ("*\n* Seient FILA:" + (s.getFilaSeient() + 1) + " SEIENT:" + (s.getNumeroSeient() + 1) + "*\n");
		st += ("* Preu: " + se.getPreu() + " €\n");
		st += ("****************************\n");

		return st;
	}

	public String mostraDataFormatada(String s) {
		int day = se.getData().get(Calendar.DAY_OF_MONTH);
		int month = se.getData().get(Calendar.MONTH);
		int year = se.getData().get(Calendar.YEAR);
		int hour = se.getData().get(Calendar.HOUR_OF_DAY);
		int minute = se.getData().get(Calendar.MINUTE);

		s += (day + "/" + month + "/" + year + " " + hour + ":" + minute);
		return s;
	}

	//*********************************************************
	//PAGAMENT D'UNA ENTRADA
	private boolean pagamentEntrada(BigDecimal preu) throws IOException{
		System.out.println("["+Thread.currentThread().getName()+"] Import a pagar: "+preu);
		String s = "true";

		s += ("Import a pagar: " + preu);
		//pagant

		salida.writeUTF(s);
		String cadenaRebuda = entrada.readUTF();

		return Boolean.parseBoolean(cadenaRebuda);

	}

}
