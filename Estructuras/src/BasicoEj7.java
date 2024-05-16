import java.util.Scanner;

public class BasicoEj7 {

	public static void main(String[] args) {

		/*
		 * Crear un programa que pida al usuario ingresar un valor en pesos, e informe
		 * la cantidad mínima de billetes y monedas necesarias para la cantidad
		 * ingresada
		 */
		// Este ejercicio toma en cuenta la existencia en monedas de: 1, 2 y 5 pesos y
		// billetes de 10, 20, 50, 100, 200 pesos.

		Scanner s = new Scanner(System.in);
		System.out.println("Ingresar la cantidad de dinero en pesos a ingresar: ");
		int ingreso = s.nextInt();

		int cantMin = 0;
		int moneda1 = 0;
		int moneda2 = 0;
		int moneda5 = 0;

		int billete10 = 0;
		int billete20 = 0;
		int billete50 = 0;
		int billete100 = 0;
		int billete200 = 0;

		if (ingreso >= 200) {
			billete200 = ingreso / 200;
			ingreso = ingreso % 200;
		}

		if (ingreso >= 100) {
			billete100 = ingreso / 100;
			ingreso = ingreso % 100;
		}

		if (ingreso >= 50) {
			billete50 = ingreso / 50;
			ingreso = ingreso % 50;
		}

		if (ingreso >= 20) {
			billete20 = ingreso / 20;
			ingreso = ingreso % 20;
		}

		if (ingreso >= 10) {
			billete10 = ingreso / 10;
			ingreso = ingreso % 10;
		}

		if (ingreso >= 5) {
			moneda5 = ingreso / 5;
			ingreso = ingreso % 5;
		}

		if (ingreso >= 2) {
			moneda2 = ingreso / 2;
			ingreso = ingreso % 2;
		}

		if (ingreso >= 1) {
			moneda1 = ingreso / 1;
			ingreso = ingreso % 1;
		}

		if (billete200 >= 1) {
			System.out.println("La cantidad necesaria de billetes de 200 es: " + billete200);
		}
		if (billete100 >= 1) {
			System.out.println("La cantidad necesaria de billetes de 100 es: " + billete100);
		}
		if (billete50 >= 1) {
			System.out.println("La cantidad necesaria de billetes de 50 es: " + billete50);
		}
		if (billete20 >= 1) {
			System.out.println("La cantidad necesaria de billetes de 20 es: " + billete20);
		}
		if (billete10 >= 1) {
			System.out.println("La cantidad necesaria de billetes de 10 es: " + billete10);
		}
		if (moneda5 >= 1) {
			System.out.println("La cantidad necesaria de monedas de 5 es: " + moneda5);
		}
		if (moneda2 >= 1) {
			System.out.println("La cantidad necesaria de monedas de 2 es: " + moneda2);
		}
		if (moneda1 >= 1) {
			System.out.println("La cantidad necesaria de monedas de 1 es: " + moneda1);
		}

	}

}
