import java.util.Iterator;
import java.util.Scanner;

public class BasicoEj5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x1 = 1;
		int x2 = 1;
		int xn;

		System.out.println("Ingresar los números de la sucesión de Fibonacci a imprimir: ");
		int n = s.nextInt();

		System.out.print(x1 + " " + x2 + " ");

		for (int i = 3; i < n; i++) {

			xn = x1 + x2;

			System.out.print(xn + " ");

			x1 = x2;

			x2 = xn;

		}

		System.out.println("");
	}

}
