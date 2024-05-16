import java.util.Scanner;

public class BasicoEj6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int cantAnios;
		do {
			System.out.println("Ingrese la cantidad de años a predecir la población:");
			cantAnios = s.nextInt();

			long poblacion = 7309784505L;
			long crecAnual = 24807909L;

			poblacion = poblacion + (crecAnual * cantAnios);

			System.out.println(poblacion);
		} while (cantAnios != 0);

	}

}
