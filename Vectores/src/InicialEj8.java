
public class InicialEj8 {

	public static void main(String[] args) {
		int numeros[] = { -2, 5, 8, -9, 10, 15, -4 };
		int sumaPos = 0;
		int sumaNeg = 0;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > 0) {
				sumaPos = sumaPos + numeros[i];
			} else if (numeros[i] < 0) {
				sumaNeg = (sumaNeg + numeros[i]);
			}
		}

		System.out.println("La suma de los números positivos es: " + sumaPos);
		System.out.println("La suma de los números negativos es: " + sumaNeg);
	}

}
