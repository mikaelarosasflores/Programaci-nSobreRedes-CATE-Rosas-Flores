import java.util.Scanner;

public class BasicoEj10 {

	public static void main(String[] args) {
		/*
		 * Crear un programa en el que se ingrese el valor de un préstamo a obtener, el
		 * porcentaje de interés anual de ese préstamo y el valor que desea abonar por
		 * mes. Mediante esos datos calcule e informe cuanto tiempo en años y en meses,
		 * se tardará en pagar el préstamo.
		 */

		Scanner s = new Scanner(System.in);
		int meses = 0;
		int anios = 0;
		System.out.println("Ingrese la cantidad de dinero que necesita: ");
		int prestamo = s.nextInt();

		System.out.println("Ingrese el interés anual de ese préstamo (en %): ");
		int interesAnual = s.nextInt();

		System.out.println("Ingrese cuánto desea pagar por mes: ");
		int mensualidad = s.nextInt();

		int contAnios = (prestamo / mensualidad) / 12;

		if (contAnios >= 1) {

			prestamo = prestamo + (interesAnual * contAnios * 100);

			anios = (prestamo / mensualidad) / 12;
			meses = (prestamo / mensualidad) % 12;

			System.out.println("Ud. demorará " + anios + " años y " + meses + " meses " + " en pagar su deuda");

		} else {
			meses = prestamo / mensualidad;
			System.out.println("Ud. demorará " + meses + " meses " + " en pagar su deuda");
		}

	}

}
