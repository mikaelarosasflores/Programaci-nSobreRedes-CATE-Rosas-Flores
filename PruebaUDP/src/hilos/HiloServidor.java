package hilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HiloServidor extends Thread {
	boolean fin = false;
	DatagramSocket socket;

	public HiloServidor() {
		try {
			socket = new DatagramSocket(9992);
		} catch (SocketException e) {
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
			ipDestino = InetAddress.getByName("192.168.1.50");
			int puerto = 9999;
			DatagramPacket dp = new DatagramPacket(data, data.length, ipDestino, puerto);
			socket.send(dp);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
