import java.util.Scanner;

public class BasicoEj8 {
	/*
	 * Crear un programa que reciba del usuario el radio de un círculo como un
	 * entero, y que imprima el diámetro, la circunferencia y el área del círculo
	 * mediante el uso del valor de punto flotante 3.14159 para π, en donde diámetro
	 * = 2r, circunferencia = 2 πr y área = πr^2.
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		float pi = 3.14159f;

		System.out.println("Ingrese el radio de una circunferencia: ");
		int r = s.nextInt();
		int diametro = 2 * r;
		float circunferencia = 2 * pi * r;
		float area = pi * (r * r);

		System.out.println("Según el radio: " + r + ", el diámetro es: " + diametro + ", la circunferencia es "
				+ circunferencia + " y el área es " + area);

	}

}
