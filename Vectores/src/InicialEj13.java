import java.util.Iterator;

public class InicialEj13 {

	public static void main(String[] args) {
		int numeros[] = new int[100];

		System.out.print("Los números pares son: ");

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (i + 1);

			if (numeros[i] % 2 == 0) {
				System.out.print(numeros[i] + (" "));

			}
		}

		System.out.println("");
		System.out.print("Los números impares son: ");

		for (int j = 0; j < numeros.length; j++) {
			if (numeros[j] % 2 != 0) {
				System.out.print(numeros[j] + (" "));

			}
		}
	}
}
