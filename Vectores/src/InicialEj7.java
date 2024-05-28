import java.util.Scanner;

public class InicialEj7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		float numeros[] = new float[5];
		int cont = 0;
		float prom = 0;

		while (cont < 5) {
			System.out.println("Ingrese un número para la posicion N" + (cont + 1) + ": ");

			int n = s.nextInt();
			numeros[cont] = n;
			prom = prom + numeros[cont];
			cont++;
		}

		prom = prom / numeros.length;

		System.out.println("El promedio de los números ingresados es: " + prom);
	}

}
