package hilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HiloCliente extends Thread {
	boolean fin = false;
	DatagramSocket socket;
	private InetAddress ipServer;
	int puerto = 9992;
	public HiloCliente() {
		System.out.println("hola");
		try {
			socket = new DatagramSocket();
			ipServer = InetAddress.getByName("localhost");
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (!fin) {
			byte datos[] = new byte[1024];
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
		
		String msg = new String(dp.getData()).trim();
		System.out.println(msg);
		
	}
	
	public void enviarMensaje (String msg) {
		byte[] data =  msg.getBytes();
		InetAddress ipDestino;
		try {
			
			DatagramPacket dp = new DatagramPacket(data, data.length, ipServer, puerto);
			socket.send(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
