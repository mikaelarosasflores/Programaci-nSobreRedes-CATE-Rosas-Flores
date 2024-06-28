import java.util.Scanner;

public class InicialEj8 {

	public static int numerosPositivos(Scanner s) { // preguntar x scanner
		int cont = 0;
		System.out.println("Ingrese la cantidad de números que va a analizar: ");
		int cant = s.nextInt();

		for (int i = 0; i < cant; i++) {
			System.out.println("Ingresar el número en la posición " + (i + 1) + ": ");
			int n = s.nextInt();

			if (n > 0) {
				cont++;
			}
		}

		return cont;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("La cantidad de números positivos es: " + numerosPositivos(s));
	}

}
