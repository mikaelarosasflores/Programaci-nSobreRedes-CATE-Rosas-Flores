import java.util.Scanner;

public class BasicoEj17 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.print("Ingrese el valor de a: ");
		double a = s.nextInt();

		System.out.print("Ingrese el valor de b: ");
		double b = s.nextInt();

		System.out.print("Ingrese el valor de c: ");
		double c = s.nextInt();

		double raizDe = (b * b) - (4 * a * c);

		if (raizDe > 0) {
			double x1 = ((-b + Math.sqrt(raizDe)) / (2 * a));
			double x2 = ((-b - Math.sqrt(raizDe)) / (2 * a));
			System.out.println("La ecuación tiene dos soluciones: " + x1 + " y " + x2);
		} else if (raizDe == 0) {
			double x1 = ((-b + Math.sqrt(raizDe)) / (2 * a));
			System.out.println("La ecuación tiene una solución " + x1);
		} else {
			System.out.println("La ecuación no tiene soluciones");
		}
	}

}
