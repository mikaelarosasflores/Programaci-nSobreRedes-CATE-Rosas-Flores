import java.util.Scanner;
/* Crear un programa que pida al usuario un número entero de 5 dígitos, y que muestre 
por consola el resultado de la suma de todos sus dígitos. En el caso de que se ingrese 
un número de más dígitos o de menos dígitos informar el error y volver a pedir el 
número.*/

public class BasicoEj2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = 0;
		int digito = 0;
		int suma = 0;

		do {
			System.out.println("Ingresar un número de '5 DÍGITOS'");
			n = s.nextInt();

			if (n > 99999 || n < 10000) {
				System.out.println("Error, el número debe tener 5 dígitos");
			}

		} while (n > 99999 || n < 10000);

		while (n > 0) {
			digito = n % 10; // para obtener el último digito ej N= 12345, n%10 obtiene el 5
			suma += digito; // va sumando los dígitos
			n /= 10; // saca el resultado entero de 12345 / 10 = 1234, suponiento que el decimal es
						// el resto

		}

		System.out.println("La suma de los dígitos es: " + suma);
	}

}
