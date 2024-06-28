package Red;

import java.util.Scanner;

import Utilidades.Utiles;
import hilos.HiloCliente;

public class LanzadorCliente {
	static HiloCliente hc;
	static boolean fin = false;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		hc = new HiloCliente();

		hc.start();
		do {
			System.out.println("Ingrese un mensaje");
			System.out.println("1) Enviar Mensaje");
			int eleccion = s.nextInt();
			switch (eleccion) {
			case 1: 
				String msg = "Mensaje enviado";
				hc.enviarMensaje(msg);
			}
			

		} while (!fin);

	}

}
