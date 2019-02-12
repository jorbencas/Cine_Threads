import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor extends Thread {

	int numport = 3001;
	Socket client;
	DataInputStream entrada;
	DataOutputStream salida;
	ServerSocket server_socket;
	Socket socket;
	String mensague = "";
	String mensa = "";
	boolean iterar = true;
	int nPelicula;
	int nSessio;
	ArrayList <Seient> llistaSeients;

	public Servidor(int nPelicula, int nSessio, ArrayList <Seient> llistaSeients) {
		this.nPelicula = nPelicula;
		this.nSessio = nSessio;
		this.llistaSeients = llistaSeients;
	}
	
	
	// ----------
		public void run() {
			try {
				 System.out.println("El servidor esta escuchando...");
					server_socket = new ServerSocket(numport);
					for(int i = 0; i < 3; i++){
						socket = server_socket.accept();
						Thread client = new Thread(new ClientThread(socket, i, this.nPelicula, this.nSessio, this.llistaSeients));
						client.start();
						client.join();
					};
					System.out.println("Todos los mensajes han sido enviados.");
					server_socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
}
