package hilo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import red.Cliente;

public class HiloCliente extends Thread {

	DatagramSocket socket;
	boolean fin = false;
	private InetAddress ipServer;
	int puerto = 9992;
	private Cliente cliente;

	public HiloCliente(Cliente cliente) {
		try {
			this.cliente = cliente;
			socket = new DatagramSocket(); // NO NECESITO CONOCER EL PUERTO, EL SO SE ENCARGA
			ipServer = InetAddress.getByName("192.168.1.45");
			enviarMensaje("Conectar");
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
			System.out.println("No conecta");
		}
	}

	@Override
	public void run() {

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

	private void procesarMensaje(DatagramPacket dp) {

		String msg[] = new String(dp.getData()).trim().split("_");

		switch (msg[0]) {
		case ("ConexionExitosa"):
			System.out
					.println("Se ha conectado con el servidor, usted es el jugador " + (Integer.parseInt(msg[1]) + 1));
			cliente.asignarID(Integer.parseInt(msg[1]));
			break;

		case ("Imprimir"):
			System.out.println((msg[1]));
			break;
		case ("SolicitarMascota"):
			cliente.enviarMascota();
			break;
		case ("SolicitarAtaque"):
			cliente.enviarAtaque();
			break;
		case ("ModificarEnergia"):
			cliente.getMascota().setEnergia(Integer.parseInt(msg[1]));
			break;
		case ("ModificarVida"):
			cliente.getMascota().setVida(Float.parseFloat(msg[1]));
			break;
		case ("FinalizarConexion"):
			fin = true;
		} 

	}

	public void enviarMensaje(String msg) {
		byte[] data = msg.getBytes();
		try {
			DatagramPacket dp = new DatagramPacket(data, data.length, ipServer, puerto);
			socket.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean isFin() {
		return fin;
	}
	
	
}
