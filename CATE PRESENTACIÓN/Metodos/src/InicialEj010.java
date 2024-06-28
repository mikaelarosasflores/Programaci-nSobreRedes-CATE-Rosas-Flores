import java.util.Scanner;

public class InicialEj010 {

	public static int ultimaCifra(int n) {

		int ultimoD = n % 10;
		return ultimoD;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

        System.out.println("Ingrese un número");
        int n = s.nextInt();


		System.out.println("El último dígito de " + n + " es " + ultimaCifra(n));
	}

}
