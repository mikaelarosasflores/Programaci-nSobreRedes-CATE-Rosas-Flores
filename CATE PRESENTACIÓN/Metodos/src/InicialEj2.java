import java.util.Iterator;
import java.util.Scanner;

public class InicialEj2 {

	public static int incrementarNum(int n) {
		return n + 1;

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Ingrese un número: ");
		int n = s.nextInt();

		n = incrementarNum(n);

		System.out.println(n);
	}
}
