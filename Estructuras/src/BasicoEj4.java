import java.util.Iterator;

public class BasicoEj4 {

	public static void main(String[] args) {

		int espacio = 0;

		for (char asciiChar = 32; asciiChar <= 126; asciiChar++) {

			System.out.print(asciiChar + " ");
			espacio++;
			if (espacio == 15) {
				System.out.println("");
				espacio = 0;
			}

		}

	}

}
