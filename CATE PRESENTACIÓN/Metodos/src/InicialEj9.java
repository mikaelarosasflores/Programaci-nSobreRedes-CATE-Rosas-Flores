import java.util.Scanner;

public class InicialEj9 {
	public static int notaParcial(int nota) {
		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Ingrese una nota. Para terminar el programa pulse '99'");
			nota = s.nextInt();
			
			if (nota <= 3) {
				System.out.println("Estás desaprobado");
			} else if (nota >= 4 && nota <= 6) {
				System.out.println("Usted está aprobado");
			} else if (nota >= 7 && nota <= 10) {
				System.out.println("Usted está promocionado");
			}
		} while (nota != 99);
		if (nota == 99) {
			System.out.println("Programa finalizado");
		}
		return nota;
	}

	public static void main(String[] args) {
		int nota = 0;
		System.out.println(notaParcial(nota));

	}

}
