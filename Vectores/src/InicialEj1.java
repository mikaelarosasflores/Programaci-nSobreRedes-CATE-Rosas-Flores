import java.util.Scanner;

public class InicialEj1 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int numeros[] = new int[10];
		int num = 0;
		int i;
		for (i = 0; i < numeros.length; i++) { //array para rellenar
			System.out.println("Ingrese un número para la posición N°" + (i + 1));
			numeros[i] = s.nextInt();

		}
		System.out.println();

		for (int j = 0; j < numeros.length; j++) { //array para mostrar
			System.out.println("El número " + numeros[j] + " está en la posición " + j);
		}

	}

}
