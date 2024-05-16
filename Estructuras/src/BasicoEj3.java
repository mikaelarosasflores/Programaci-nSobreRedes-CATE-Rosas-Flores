public class BasicoEj3 {

	public static void main(String[] args) {

		System.out.println("Número          Cuadrado        Cubo");

		for (int numero = 0; numero <= 10; numero++) {
			int cuadrado = numero * numero;
			int cubo = numero * numero * numero;
			System.out.println(numero + "\t\t" + cuadrado + "\t\t" + cubo);
		}

	}
}
