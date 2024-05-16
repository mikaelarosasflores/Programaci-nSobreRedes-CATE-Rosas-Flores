import java.util.Scanner;

public class BasicoEj15 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Ingresar un número entero que equivaldrá a segundos: ");
		int seg = s.nextInt();

		int horas = seg / 3600;

		int min = (seg % 3600) / 60;

		seg = seg % 60;

		System.out.println("La cantidad de horas es " + horas + ", la cantidad de minutos es " + min
				+ " y la cantidad de segundos es " + seg);

	}

}
