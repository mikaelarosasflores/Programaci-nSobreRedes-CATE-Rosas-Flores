import java.util.Scanner;
/* Hacer un metodo el cual tenga como parametro de entrada 3 variables (min,max,s). Se le solicitara al usuario ingresar un valor. 
En caso de que este se encuentre entre las variables min y max, retornara al mismo.
Caso contrario, le solicitara al usuario ingresar otro valor, hasta que cumpla con las condiciones anteriores */

public class InicialEj3 {

	public static int ingresarNum(Scanner s, int min, int max) {

		int n;
		do {

			System.out.println("Ingresar un número del " + min + " al " + max);
			n = s.nextInt();

			if (n <= max && n >= min) {
				System.out.println(n);
			} else {
				System.out.println("Error.");
			}

		} while (n > max || n < min);

		return n;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(ingresarNum(s, 1, 10));
	}

}
