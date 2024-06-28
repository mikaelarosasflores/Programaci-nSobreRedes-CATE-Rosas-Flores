package Red;

import hilos.HiloServidor;

public class LanzadorServidor {
	static HiloServidor hs;

	public static void main(String[] args) {
		hs = new HiloServidor();

		while (true) {
			hs.start();
			
			System.out.println("A");
			break;
		}

	}

}
