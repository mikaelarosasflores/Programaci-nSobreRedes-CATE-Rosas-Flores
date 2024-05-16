import java.util.Scanner;

public class BasicoEj19 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese una velocidad en Km/h: ");
		float velocidad = s.nextFloat();

		velocidad = (velocidad * (5 / 18f));

		System.out.println("La velocidad en m/s es " + velocidad);

	}

}
