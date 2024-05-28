
public class InicialEj9 {

	public static void main(String[] args) {
		int nPrimos[] = new int[25];
		int contDiv;
		int k = 0;
		for (int i = 2; i < 100; i++) {

			contDiv = 0;

			for (int j = 1; j < 100; j++) {
				if (i % j == 0) {
					contDiv++;
				}

			}
			if (contDiv == 2) {
				nPrimos[k] = i;
				System.out.println("El número primo " + nPrimos[k] + " está en el índice " + k);
				k++;
			}

		}
	}

}
