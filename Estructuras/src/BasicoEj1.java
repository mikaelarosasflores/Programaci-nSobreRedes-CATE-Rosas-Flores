import java.util.Scanner;

public class BasicoEj1 {

	
	// 1) Crear un programa que informe su peso efectivo en la luna, sabiendo que este será un 
	//17% respecto a su peso en la tierra.
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Ingrese su peso: ");

		float peso = s.nextFloat();

		float pesoLuna = (17f / 100) * peso;

		System.out.println("Su peso en la luna es: " + pesoLuna);

	}

}
