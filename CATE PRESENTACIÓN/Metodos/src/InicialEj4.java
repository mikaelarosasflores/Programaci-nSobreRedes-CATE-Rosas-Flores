/*  Crear un programa que, mediante un método, calcule el resultado de restar el 
doble de un número a su cuadrado. */

import java.util.Scanner;

public class InicialEj4 {

	public static int restarDoble(int n) {

		int doble = n * 2;

		int cuadrado = n * n;

		int resta = cuadrado - doble;
		n = resta;
		return resta;

	}

	public static void main(String[] args) {
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Ingresar número: ");
		n = s.nextInt();
		System.out.println(restarDoble(n));

	}

}
