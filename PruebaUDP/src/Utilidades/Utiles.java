package Utilidades;
import java.util.Scanner;

public class Utiles {
	
	
	public static int ingresarNum(Scanner s, int min, int max) {

		int n;
		do {

			n = s.nextInt();

			if (n <= max && n >= min) {
				System.out.println(n);
			} else {
				System.out.println("Error.");
			}

		} while (n > max || n < min);

		return n;

	}
}
