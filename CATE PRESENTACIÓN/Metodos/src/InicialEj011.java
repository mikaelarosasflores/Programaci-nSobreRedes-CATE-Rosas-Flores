import java.util.Scanner;

public class InicialEj011 {
	public static int numeroMayor (int n1, int n2, int n3) {
		int mayor = 0;
		if (n1 > n2 && n1 > n3) {
			mayor = n1;
		} else if (n2 > n1 && n2 > n3) {
			mayor = n2;
		} else {
			mayor = n3;
		}
		
		System.out.println("El número mayor es " + mayor);
		return mayor;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el primer número");
		int n1 = s.nextInt();
		System.out.println("Ingrese el segundo número");
		int n2= s.nextInt();
		System.out.println("Ingrese el tercer número");
		int n3 = s.nextInt();
		
		numeroMayor(n1, n2, n3);
	}

}
