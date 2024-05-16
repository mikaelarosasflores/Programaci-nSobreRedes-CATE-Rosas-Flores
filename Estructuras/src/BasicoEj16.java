import java.util.Scanner;

public class BasicoEj16 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la hora en formato hh:mm:ss: ");
		String horaInicial = scanner.nextLine();

		System.out.print("Ingrese la cantidad de segundos a agregar: ");
		int segundos = scanner.nextInt();

		String[] partesHora = horaInicial.split(":");
		int hora = Integer.parseInt(partesHora[0]);
		int minuto = Integer.parseInt(partesHora[1]);
		int segundo = Integer.parseInt(partesHora[2]);

		int totalSegundosInicial = hora * 3600 + minuto * 60 + segundo;
		int totalSegundosDespues = totalSegundosInicial + segundos;

		int nuevaHora = totalSegundosDespues / 3600;
		int nuevoMinuto = (totalSegundosDespues % 3600) / 60;
		int nuevoSegundo = totalSegundosDespues % 60;

		System.out.println("El tiempo después de " + segundos + " segundos será: "
				+ String.format("%02d:%02d:%02d", nuevaHora, nuevoMinuto, nuevoSegundo));

		scanner.close();

	}

}
