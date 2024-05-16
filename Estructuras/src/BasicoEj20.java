import java.util.Scanner;

public class BasicoEj20 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int cantArt = 0;
		int cantProd = 0;
		float precio = 0;
		float total = 0;

		do {

			System.out.println("Ingresar el número de artículos a ingresar");

			cantArt = s.nextInt();

			for (int i = 0; i < cantArt; i++) {
				System.out.println("Ingrese la cantidad del producto N°" + (i + 1));
				cantProd = s.nextInt();

				System.out.println("Ingresar el precio del producto N°" + (i + 1));
				precio = s.nextFloat();

				float precioTotalproducto = cantProd * precio;

				total = total + precioTotalproducto;

				System.out.println("Artículo N°:" + (i + 1));
				System.out.println("Cantidad: " + cantProd);
				System.out.println("Precio unitario: $" + precio);
				System.out.println("Subtotal del producto: $" + precioTotalproducto);
				System.out.println("----------------------------------");

			}

			System.out.println("El total a pagar es: $" + total);

		} while (cantArt > 0);

	}

}
