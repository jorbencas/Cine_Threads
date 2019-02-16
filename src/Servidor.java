import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor extends Thread {

	int numport = 3001;
	ServerSocket server_socket;
	Socket socket;
	int end = 300000000;
	public Servidor() {}

		public void run() {
			try {
				 System.out.println("El servidor esta escuchando...");
					server_socket = new ServerSocket(numport);
					long tempsInicial = System.currentTimeMillis();
					server_socket.setSoTimeout(end);
					while (System.currentTimeMillis() - tempsInicial < end) {
						socket = server_socket.accept();
						Thread client = new Thread(new ClientThread(socket));
						client.start();
					};
					System.out.println("Todos los mensajes han sido enviados.");
					server_socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
}
