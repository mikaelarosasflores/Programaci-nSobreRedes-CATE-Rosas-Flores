import java.util.Scanner;

public class BasicoEj13 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Ingresar un número entero: ");
		int num = s.nextInt();
		int numReves = 0;
		int numOriginal = num; // al terminar el programa, num ya va a estar todo desarmado, por eso lo
								// duplicamos antes

		while (num > 0) {
			int digito = num % 10; // 123 --> 3 (sacamos el último dígito)
			numReves = numReves * 10 + digito; // multiplicamos ---> 2 * 10 = 20, 20 + 3 = 23, vamos reconstruyendo el
											 // número con los dígitos que vamos sacando
			num /= 10; // sacamos el ultimo digito 123 pq ya lo analziamos arriba 123 --> 3 digito
						// 12---> num a seguir desarmando

		}

		if (numOriginal == numReves) {
			System.out.println("El número " + numOriginal + " es capicúa");

		} else {
			System.out.println("El número " + numOriginal + " no es capicúa");
		}

	}

}
