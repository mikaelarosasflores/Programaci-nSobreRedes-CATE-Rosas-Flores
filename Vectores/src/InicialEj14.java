import java.util.Scanner;

public class InicialEj14 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Ingresar la longitud del vector: ");
		// int x = s.nextInt();
		int numeros[] = { 8, 2, 1, 5 };

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Ingrese un número para la posición N" + (i + 1) + ": ");
			// numeros[i] = s.nextInt();

		}

		for (int i = 0; i < numeros.length - 1; i++) { // 8
			int minIndice = i;
  			for (int j = (i + 1); j < numeros.length; j++) {
				if (numeros[j] < numeros[minIndice]) {
					minIndice = j;
				}
			}
			int temporal = numeros[minIndice];
			numeros[minIndice] = numeros[i];
			numeros[i] = temporal;

		}

		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);

		}
	}

}
