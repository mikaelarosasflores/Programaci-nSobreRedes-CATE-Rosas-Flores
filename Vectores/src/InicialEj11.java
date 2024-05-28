import java.util.Scanner;

public class InicialEj11 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Introducir una cadena de texto");
		String cadena = s.next();

		for (int i = cadena.length() - 1; i >= 0; i--) {

			System.out.print(cadena.charAt(i));
		}
		s.close();
	}

}
