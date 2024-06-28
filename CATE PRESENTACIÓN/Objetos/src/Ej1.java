import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import Enum.Zodiaco;
import Muebles.Mueble;
import Sim.Sim;

public class Ej1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Utiles utiles = new Utiles();
		Sim sim = new Sim("Julio Quiroga", 32, Zodiaco.CANCER);

		compraMuebles(s, sim, utiles);
		System.out.println("terminó");

		while (true) {

			switch (ingresarOpcion(s, utiles)) {
			case 1:
				mostrarDatos(sim);
				break;
			case 2:
				mostrarComodidad(sim);
				break;
			case 3:
				mostrarExtremos(sim);
				break;
			case 4:
				mostrarValor(sim);
				break;
			}
		}
	}

	public static Mueble obtenerMueble(int opc) {
		Mueble mueble = null;
		String opcArray[] = { "Silla", "Mesa", "Lampara", "PelucheCarpincho", "Cuadro", "Hornito",
				"Cama" };

		try {
			mueble = (Mueble) Class.forName("Muebles." + opcArray[opc - 1]).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(mueble.getNombre());
		return mueble;

	}

	public static void compraMuebles(Scanner s, Sim sim, Utiles utiles) {
		int eleccion;
		do {

			System.out.println("Ingrese el producto a comprar: ");

			System.out.println("1) Silla: Precio 50 Comodidad 2\r\n" + "2) Mesa: Precio 100 Comodidad 3\r\n"
					+ "3) Lampara: Precio 100 Comodidad 5\r\n" + "4) PelucheCarpincho: Precio 2000 Comodidad 10\r\n"
					+ "5) Cuadroo: Precio 250 Comodidad 1\r\n" + "6) Hornito: Precio -500 Comodidad -7\r\n"
					+ "7) Cama: Precio 1000 Comodidad 8 \n0) Salir ");

			eleccion = utiles.ingresarNum(s, 0, 7);

			if (eleccion != 0) {

				Mueble mueble = obtenerMueble(eleccion);
				if (mueble.getPrecio() > sim.getDinero()) {
					System.out.println("No hay plata");
				} else {
					sim.restarPrecio(mueble.getPrecio());

					sim.getCasa().agregarMueble(mueble);

				}
			}

		} while (sim.getCasa().getCant() < sim.getCasa().getMuebles().length && eleccion != 0);
	}

	public static int ingresarOpcion(Scanner s, Utiles utiles) {

		System.out.println("1)	Datos del Sim y lista de objetos que contiene la casa.\r\n"
				+ "2)	Promedio de comodidad que brinda la casa en porcentaje.\r\n"
				+ "3)	Objeto de mayor valor y objeto de menor valor en la casa.\r\n"
				+ "4)	Valor total de la casa según los objetos que contenga\r\n" + "");

		return utiles.ingresarNum(s, 1, 4);

	}

	public static void mostrarDatos(Sim sim) {
		System.out.println("Nombre: " + sim.getNombre() + "\nEdad " + sim.getEdad() + "\nDinero en cuenta: "
				+ sim.getDinero() + "\nSigno zodiacal: " + sim.getSigno());

		if (sim.getCasa().getMuebles()[0] == null) { // vacío
			System.out.println("No hay objetos en la casa");

		} else {
			for (int i = 0; i < sim.getCasa().getCant(); i++) {
				System.out.println(sim.getCasa().getMuebles()[i].getNombre());
			}
		}
	}

	public static void mostrarComodidad(Sim sim) {
		float prom = 0;
		if (sim.getCasa().getMuebles()[0] == null) { // el array está vacío
			System.out.println("No hay muebles en la casa");
		} else {
			for (int i = 0; i < sim.getCasa().getCant(); i++) {

				prom += sim.getCasa().getMuebles()[i].getComodidad();
			}

			prom /= (sim.getCasa().getCant() + (sim.getCasa().getCant() > 10 ? 0 : 1));
			prom *= 10;
		}
		System.out.println("El promedio de comodidad es " + prom + "%");
	}

	public static void mostrarExtremos(Sim sim) {
		int min = 0;
		int max = 0;
		for (int i = 1; i < sim.getCasa().getCant(); i++) {
			if (sim.getCasa().getMuebles()[min].getPrecio() > sim.getCasa().getMuebles()[i].getPrecio()) {
				min = i;
			} else if (sim.getCasa().getMuebles()[max].getPrecio() < sim.getCasa().getMuebles()[i].getPrecio()) {
				max = i;
			}

		}
		System.out.println("El producto con menor precio es: " + sim.getCasa().getMuebles()[min].getNombre());
		System.out.println("El producto con mayor precio es: " + sim.getCasa().getMuebles()[max].getNombre());
	}

	public static void mostrarValor(Sim sim) {
		int valor = 0;
		if (sim.getCasa().getMuebles()[0] == null) {
			System.out.println("No hay muebles en la casa");
		} else {
			for (int i = 0; i < sim.getCasa().getCant(); i++) {
				valor += sim.getCasa().getMuebles()[i].getPrecio();
			}
			
			System.out.println("El valor total de la casa es: " + valor);
		}
	}
}
