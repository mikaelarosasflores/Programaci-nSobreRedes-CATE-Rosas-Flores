import java.util.Scanner;

public class BasicoEj14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese una fecha en formato dd mm aaaa: ");
		String fecha = scanner.nextLine();

		int espacio1 = -1, espacio2 = -1;
		for (int i = 0; i < fecha.length(); i++) {
			char c = fecha.charAt(i);
			if (c == ' ') {
				if (espacio1 == -1)
					espacio1 = i;
				else
					espacio2 = i;
			}
		}

		String dia = fecha.substring(0, espacio1);
		String mes = fecha.substring(espacio1 + 1, espacio2);
		String anio = fecha.substring(espacio2 + 1);

		String nombreMes = "";
		if (mes.equals("01"))
			nombreMes = "enero";
		else if (mes.equals("02"))
			nombreMes = "febrero";
		else if (mes.equals("03"))
			nombreMes = "marzo";
		else if (mes.equals("04"))
			nombreMes = "abril";
		else if (mes.equals("05"))
			nombreMes = "mayo";
		else if (mes.equals("06"))
			nombreMes = "junio";
		else if (mes.equals("07"))
			nombreMes = "julio";
		else if (mes.equals("08"))
			nombreMes = "agosto";
		else if (mes.equals("09"))
			nombreMes = "septiembre";
		else if (mes.equals("10"))
			nombreMes = "octubre";
		else if (mes.equals("11"))
			nombreMes = "noviembre";
		else if (mes.equals("12"))
			nombreMes = "diciembre";

		System.out.println(dia + " de " + nombreMes + " de " + anio);

		scanner.close();

	}

}
