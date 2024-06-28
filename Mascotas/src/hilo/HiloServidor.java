package hilo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import mascotas.Mascota;
import red.Servidor;

public class HiloServidor extends Thread {

	private DatagramSocket socket;
	boolean fin = false;
	int cantConexiones = 0;
	int cantMascotas = 0;
	InetAddress ips[] = new InetAddress[2];
	int puertos[] = new int[2];
	private Servidor servidor;

	public HiloServidor(Servidor servidor) {
		try {
			this.servidor = servidor;
			socket = new DatagramSocket(9992);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("Inicia el servidor");

		while (!fin) {
			byte[] datos = new byte[1024];
			DatagramPacket dp = new DatagramPacket(datos, datos.length);
			try {
				
				socket.receive(dp);
				
				procesarMensaje(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void procesarMensaje(DatagramPacket dp) {

		String msg[] = new String(dp.getData()).trim().split("_");
		System.out.println(msg[0]);

		switch (msg[0]) {
		case ("Conectar"):
			if (cantConexiones < 2) {

				ips[cantConexiones] = dp.getAddress();
				puertos[cantConexiones] = dp.getPort();
				enviarMensaje("ConexionExitosa_" + cantConexiones, ips[cantConexiones], puertos[cantConexiones]);
				cantConexiones++;

				enviarMensaje("Imprimir_Esperando al otro jugador... ", dp.getAddress(), dp.getPort());
				System.out.println(cantConexiones);
				if (cantConexiones == 2) {
					for (int i = 0; i < ips.length; i++) {
						enviarMensaje("SolicitarMascota", ips[i], puertos[i]);
					}

				}
			} else {
				enviarMensaje("Imprimir_Límite de jugadores alcanzado (" + cantConexiones + ")", dp.getAddress(),
						dp.getPort());
			}
			break;

		case ("EnvioMascota"):
			// 1 = nombre 2 = id 3 = vida 4 = energía
			try {
				servidor.mascotasRed[Integer.parseInt(msg[2])] = (Mascota) Class.forName("mascotas." + msg[1])
						.getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			servidor.mascotasRed[Integer.parseInt(msg[2])].setJugador(cantMascotas);
			servidor.mascotasRed[Integer.parseInt(msg[2])].setVida(Float.parseFloat(msg[3]));
			servidor.mascotasRed[Integer.parseInt(msg[2])].setEnergia(Integer.parseInt(msg[4]));
			
			contarMascotas();
			
			break;

		case ("EnviarAtaque"):
			servidor.setAtaque(Integer.parseInt(msg[1]) - 1);
			break;
		}

	}

	private void enviarMensaje(String msg, InetAddress ipDestino, int puerto) {
		byte[] data = msg.getBytes();
		try {
			DatagramPacket dp = new DatagramPacket(data, data.length, ipDestino, puerto);
			socket.send(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	public DatagramSocket getSocket() {
		return socket;
	}

	public void contarMascotas() {
		cantMascotas++;
		if (cantMascotas == 2) {
			servidor.setInicioBatalla(true);
		}
	}

	public void enviarMensajeGlobal(String mensaje) {
		for (int i = 0; i < ips.length; i++) {
			enviarMensaje(mensaje, ips[i], puertos[i]);
		}

	}

	public void enviarMensajePrivado(String mensaje, int pos) {
		enviarMensaje(mensaje, ips[pos], puertos[pos]);
	}

	public void terminarConexion() {
		enviarMensajeGlobal("FinalizarConexion");
		for (int i = 0; i < ips.length; i++) {
			ips[i] = null;
			puertos[i] = 0;
		}
		
		cantMascotas = 0;
		cantConexiones = 0;
		
	}

}
