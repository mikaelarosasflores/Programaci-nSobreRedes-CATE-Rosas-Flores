
public class InicialEj4 {

	public static void main(String[] args) {
		int divisibles[] = new int[34];

		int indiceD = 0;

		for (int i = 0; i < 100; i++) { // al usar esto como dleimitante de los números, le pongo 100 y no array.lenght
										// no estoy recorriendo ni llenando el array, el for es para calcular # 3 == 0;
			if (i % 3 == 0) {

				divisibles[indiceD] = i;

				System.out.println("El número " + i + " está en la posición " + indiceD);

				indiceD++; // indiceD es lo que recorre el array
			}

		}

	}

}
