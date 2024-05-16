import java.util.Scanner;

public class BasicoEj18 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingresar un número a convertir a binario: ");
		int num = s.nextInt();

		int binario = 0;
		int posicion = 1;

		while (num > 0) { // tengo que usar num para parar el programa
			int resto = num % 2; // extraigo el valor binario del último numero, 243 ---> 1
			binario = binario + resto * posicion; // al binario se le suma ese dígito y se controla la posición para que
													// no haga una suma simple
			num /= 2;
			posicion *= 10; // va avanzando para sumar en diferentes espacios del número
		}

		System.out.println("El número en binario es: " + binario);

	}

}
