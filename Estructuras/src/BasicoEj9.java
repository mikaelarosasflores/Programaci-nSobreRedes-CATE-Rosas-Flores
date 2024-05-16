import java.util.Scanner;

public class BasicoEj9 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long sigN = 0;
		System.out.println("Ingresar hasta que número desea calcular el factorial: ");
		long n = s.nextInt();
		long nFactorial = 1;
		for (long i = 1; i <= n; i++) {

			nFactorial = nFactorial * i;

		}
		System.out.println(nFactorial);
	}

}
