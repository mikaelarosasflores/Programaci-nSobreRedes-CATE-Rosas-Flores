
public class InicialEj6 {

	public static void main(String[] args) {

		int numerosPares[] = new int[20];

		int suma = 0;

		int indice = 0;
		System.out.print("La suma de los primeros 20 numeros pares (");
		for (int i = 2; i <= 40; i++) {
			if (i % 2 == 0) {
				numerosPares[indice] = i;

				if (numerosPares[indice] != 40) {
					System.out.print(numerosPares[indice] + ", ");
				} else {
					System.out.print(numerosPares[indice] + ") es:");
				}
				indice++;

				suma = suma + i;

			}

		}
		System.out.print(" " + suma);

	}

}
