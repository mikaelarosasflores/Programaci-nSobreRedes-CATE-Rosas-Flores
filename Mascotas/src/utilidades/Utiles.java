package utilidades;
import java.util.Scanner;

public class Utiles {
	public static int ingresarNum(Scanner s, int min, int max) {
		boolean error = false;
		int n = 0;
		do {
			error = false;
			try {
				n = s.nextInt();

			} catch (Exception e) {
				error = true;
				s.nextLine();
			}

			if (n <= max && n >= min) {
			} else {
				System.out.println("Error. Elija nuevamente.");
			}

		} while (n > max || n < min && error);

		return n;

	}
}
