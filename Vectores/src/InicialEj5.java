
public class InicialEj5 {

	public static void main(String[] args) {

		int cincoNumeros[] = new int[5];
		int cincoNumeros2[] = new int[5];

		int indice = 0;
		for (int i = 1; i < 6; i++) {

			cincoNumeros[indice] = i;

			indice++;
		}

		for (int i = 0; i < cincoNumeros.length; i++) {

			cincoNumeros2[i] = cincoNumeros[i];

			System.out.println("El número " + cincoNumeros2[i] + " está en la posición " + i);
		}

	}

}
