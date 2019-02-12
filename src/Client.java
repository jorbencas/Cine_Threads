import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	static int numport = 3001;
	static Socket client;
	static DataInputStream entrada;
	static DataOutputStream salida;
	static String mensague = "";
	static String mensa = "";
	static boolean iterar = true;
	
	static Scanner texto = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException {
	try {
		System.out.println("Conectant al servidor...");
		client = new Socket("localhost",numport);
		System.out.println("OK, conectat.");	
		salida = new DataOutputStream(client.getOutputStream());
		entrada = new DataInputStream(client.getInputStream());

		
			mensa = entrada.readUTF();
			String[] rex = mensa.split("|");
			System.out.println(rex[2]);
			System.out.println("Eligue la pelicula que deseas reservar");
			String str = texto.next();
			salida.writeUTF(str.trim());
			mensa = entrada.readUTF();
			rex = mensa.split("|");
			System.out.println(mensa);
			System.out.println(rex[2]);
			System.out.println("Eligue la sesion que deseas reservar");
			str = texto.next();
			//sala = Validacio.validaSencer("\t Tria SALA a modificar:",rex[0]);
			salida.writeUTF(str.trim());
			System.out.println("Eligue el numero de reservas que deseas hacer");
			salida.writeUTF(String.valueOf(texto.nextInt()));
			String entrades = entrada.readUTF();
			for (int i = 0; i < Integer.parseInt(entrades); i++) {
				String mapa = entrada.readUTF();
				System.out.println(mapa);
				System.out.println("");
				System.out.println("Introdueix el numero de fila:");
				salida.writeUTF(texto.next());
				System.out.println("Introdueix el numero de columna:");
				salida.writeUTF(texto.next());
			}
			System.out.println(entrada.readUTF());
		
		

		System.out.println("Ok conexio tancada");
		salida.close();
		entrada.close();
		System.out.println("Finalitzant conexio");
		client.close();

	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}
}
