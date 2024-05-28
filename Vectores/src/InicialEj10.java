import java.util.Iterator;
import java.util.Scanner;

public class InicialEj10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Introduzca una cadena de cáracteres (en minúsculas): ");
		String cadena = s.next();
		int contV = 0;
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				contV++;

			}

		}

		System.out.println("Su cadena de texto tiene: " + contV + " vocales");

	}

}
