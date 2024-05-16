import java.util.Scanner;

public class BasicoEj12 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Ingrese un año: ");
		int anio = s.nextInt();
		boolean bisiesto = false;

		if (anio % 4 == 0) 	{
			bisiesto = true;

			if (anio % 100 == 0) {
				bisiesto = false;
				if (anio % 400 == 0) {
					bisiesto = true;
				} else {
					bisiesto = false;
				}
			}
		}

		if (bisiesto == true) {
			System.out.println("Su año es bisiesto");
		} else {
			System.out.println("Su año no es bisiesto");
		}

	}

}
