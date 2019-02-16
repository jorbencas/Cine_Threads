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
	static String mensa = "";

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
			System.out.println(mensa);
			System.out.println("Eligue la pelicula que deseas reservar");
			String str = texto.next();
			//int pelicula = Validacio.validaSencer("",Integer.parseInt(rex[0]));
			//Validacio.validaSencerDefecte("", Integer.parseInt(rex[0]), pelicula);
			salida.writeUTF(str.trim());
			mensa = entrada.readUTF();
			rex = mensa.split("|");
			System.out.println(mensa);
			System.out.println(rex[2]);
			System.out.println("Eligue la sesion que deseas reservar");
			str = texto.next();
			//int sessio = Validacio.validaSencer("",Integer.parseInt(str));
			//Validacio.validaSencerDefecte("", Integer.parseInt(rex[0]), sessio);
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

				String msg = entrada.readUTF();
				System.out.println(msg);
				if (msg.contains("false")){
					i = -1;
					System.out.println("Error entrada no disponible");
				}
			}

			String msg = entrada.readUTF();

			if(msg.contains("true")) {
				boolean b = Validacio.validaBoolea("Vols Pagar?[s/n]");
				if (b) {
					salida.writeUTF(Boolean.toString(b));
					salida.flush();

					msg = entrada.readUTF();
					if (msg.contains("tiempo")){
						System.out.println("Error, tardaste demasiado en confirmar");
					}else if (msg.contains("false")){
						System.out.println("Error, no se a podido realizar la reserva");
					}else {
						msg = entrada.readUTF();
						System.out.println(msg);
						msg = entrada.readUTF();

						System.out.println(msg);
					}

				} else {
					System.out.println("Compra cancelada");
					salida.writeUTF(Boolean.toString(b));
					salida.flush();
				}
			}else System.out.println("No se va ha realizar la compra");



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
