import java.util.Scanner;

public class InicialEj5 {
	public static int ingresarNum(Scanner s, int min, int max) {

		int n;
		do {

			System.out.println("Ingresar un número del " + min + " al " + max);
			n = s.nextInt();

			if (n <= max && n >= min) {
			} else {
				System.out.println("Error.");
			}

		} while (n > max || n < min);

		return n;

	}

	public static void encontrarDias(int n) {
		int dias[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		System.out.println("El mes número " + n + " tiene " + dias[n - 1] + " días ");

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		encontrarDias(ingresarNum(s, 1, 12));

	}

}
