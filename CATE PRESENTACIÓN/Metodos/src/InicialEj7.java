import java.util.Scanner;

public class InicialEj7 {

	public static int sumarNumeros(int n) {
		int suma = 0;
		for (int i = 1; i <= n; i++) {

			suma += i;
		}
		return suma;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingresar un número máximo para la suma: ");
		int n = s.nextInt();

		System.out.println("La suma de 1 al " + n + " es igual a " + sumarNumeros(n));
	}

}
