import java.util.Scanner;

public class BasicoEj11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Ingresar la duración de la llamada en minutos: ");
		int minutos = s.nextInt();
		float precio = 5;

		if (minutos > 5) {
			int minAdic = minutos - 5;
			precio += minAdic * 0.5f;

		}

		System.out.println("Su llamada tiene un valor de " + precio);

	}

}
