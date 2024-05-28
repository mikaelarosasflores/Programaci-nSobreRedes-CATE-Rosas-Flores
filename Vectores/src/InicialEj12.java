import java.util.Scanner;

public class InicialEj12 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean palindromo = true;
		System.out.println("Ingrese una cadema de texto: ");

		String cadena = s.next();

		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) != cadena.charAt(cadena.length() - 1 - i)) { // vamos moviendo el numero de derecha a
																				// izq hasta el medio, OSO [O, S, O]
																										//  0, 1, 2
																			//Inicio en 0 y sería la O, y 2 (lon = 3) = O, se resta el 1
																			// pq long != indice, ahi rest 0 y compara lo primero con
																		// lo último, 1 = S, 3 (lon) - 1 (indice) = 2 - i (1) = 1, penúltima
																		// pos
				palindromo = false;

			}
		}

		System.out.println(palindromo);

	}

}
