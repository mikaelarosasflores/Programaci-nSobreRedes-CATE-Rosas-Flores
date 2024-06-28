import java.util.Scanner;

public class InicialEj6 {

	public static float promediarNumeros(int n1, int n2, int n3) {

		float promedio = (n1 + n2 + n3) / 3f;

		return promedio;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingresar primer número: ");
		int n1 = s.nextInt();
		System.out.println("Ingresar segundo número: ");
		int n2 = s.nextInt();
		System.out.println("Ingresar tercer número: ");
		int n3 = s.nextInt();
		
		
		System.out.println(promediarNumeros(n1, n2, n3));
		
		
	}

}
