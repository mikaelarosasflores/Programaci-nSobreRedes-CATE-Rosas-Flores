package encuesta;

import java.util.Scanner;

import encuesta.Persona.Persona;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Persona arrayDatos[] = new Persona[10];

		// int pos = ingresarPersona(s, arrayDatos);
		int pos = arrayDatos.length;
		arrayDatos[0] = new Persona(10000001, 'F', true, 6000);
		arrayDatos[1] = new Persona(20000002, 'M', false, 7000);
		arrayDatos[2] = new Persona(30000003, 'F', true, 8000);
		arrayDatos[3] = new Persona(40000004, 'M', true, 9000);
		arrayDatos[4] = new Persona(50000005, 'F', false, 10000);
		arrayDatos[5] = new Persona(60000006, 'M', true, 11000);
		arrayDatos[6] = new Persona(70000007, 'F', true, 12000);
		arrayDatos[7] = new Persona(80000008, 'M', false, 13000);
		arrayDatos[8] = new Persona(90000009, 'F', true, 14000);
		arrayDatos[9] = new Persona(95000010, 'M', true, 15000);

		// al solo poder declarar globalmente el
		// Scanner, solo puedo invocar ese junto a
		// los métodos

		obtenerPromedio(arrayDatos, pos);

	}

	public static int ingresarPersona(Scanner s, Persona arrayDatos[]) {
		int pos = 0;
		int dni;
		int sueldo;
		char sexo;
		boolean trabaja;

		boolean valido = true;

		while (pos < arrayDatos.length) {
			do {
				valido = true;

				System.out.println("Ingrese el DNI de la persona N°" + (pos + 1));

				dni = s.nextInt();

				valido = validarDni(dni, arrayDatos, pos);

				System.out.println("Ingrese el 'F' si el sexo es femenino y 'M' si es masculino");
				sexo = s.next().charAt(0);

				if (sexo != 'F' && sexo != 'f' && sexo != 'M' && sexo != 'm') {
					valido = false;
					System.out.println(sexo);
				}

				System.out.println("Ingrese '1' si la persona trabaja o '0' si no trabaja");
				int valor = s.nextInt();

				trabaja = false;
				sueldo = 0;

				if (valor != 1 && valor != 0) {

					valido = false;

				}
				if (valor == 1) {
					trabaja = true;

					System.out.println("Ingrese el sueldo de la persona | Rango: 6k a 20k");
					sueldo = s.nextInt();
					if (sueldo < 6000 || sueldo > 20000) {
						valido = false;
					}

				}

				if (!valido) {
					System.out.println("Hay un error en el ingreso de datos, ingrese los datos nuevamente.");
				}

			} while (!valido);

			arrayDatos[pos] = new Persona(dni, sexo, trabaja, sueldo);

			pos++;
		}
		return pos;
	}

	public static boolean validarDni(int dni, Persona arrayDatos[], int pos) {
		boolean valido;

		if (dni > 10000000 && dni < 99999999 && !buscarSiExiste(arrayDatos, dni, pos)) {
			valido = true;
		} else {

			valido = false;

		}

		return valido;

	}

	/**
	 * Busca si el DNI ingresado se encuentra en el array, devuelve true en caso de
	 * verdadero
	 */
	public static boolean buscarSiExiste(Persona arrayDatos[], int dni, int pos) {
		boolean repetido = false;
		int cont = 0;
		while (cont < pos && !repetido) {

			if (arrayDatos[cont].getDni() == dni) {
				repetido = true;
				System.out.println("El DNI está repetido");
			}

			cont++;
		}

		return repetido;
	}

	public static float sacarPorcentaje(int cant, int total) {
		return sacarPromedio(cant, total) * 100;
	}

	public static float sacarPromedio(int cant, int total) {
		return (float) cant / (total == 0 ? 1 : total);
	}

	public static void obtenerPromedio(Persona arrayDatos[], int pos) {
		int contM = 0;
		int contMT = 0;
		int contH = 0;
		int contHT = 0;
		int sueldoM = 0;
		int sueldoH = 0;
		float prom = 0;

		for (int i = 0; i < arrayDatos.length; i++) {

			if (arrayDatos[i].getSexo() == 'F' || arrayDatos[i].getSexo() == 'f') {
				contM++;

				if (arrayDatos[i].getTrabaja() == true) {
					contMT++;
					sueldoM += arrayDatos[i].getSueldo();

				}

			}

			if (arrayDatos[i].getSexo() == 'M' || arrayDatos[i].getSexo() == 'm') {
				contH++;

				if (arrayDatos[i].getTrabaja() == true) {
					contHT++;
					sueldoH += arrayDatos[i].getSueldo();
				}
			}

		}

		// % DE MUJERES, TRABAJEN O NO
		System.out.println("Hay un " + sacarPorcentaje(contM, arrayDatos.length) + "% de mujeres en TOTAL");

		// % DE HOMBRES, TRABAJEN O NO
		System.out.println("Hay un " + sacarPorcentaje(contH, arrayDatos.length) + "% de hombres en TOTAL");

		// PROMEDIO DE MUJERES QUE TRABAJAN
		System.out.println("Hay un " + sacarPorcentaje(contMT, contM) + "% de mujeres que trabajan");

		// PROMEDIO DE HOMBRES QUE TRABAJAN
		System.out.println("Hay un " + sacarPorcentaje(contHT, contH) + "% de hombres que trabajan");

		// SUELDO MUJERES QUE TRABAJAN
		sueldoM = sueldoM / (contMT == 0 ? 1 : contMT);

		System.out.println("El promedio de sueldo de mujeres es: " + sueldoM);

		sueldoH = sueldoH / (contHT == 0 ? 1 : contHT);

		System.out.println("El promedio de sueldo de hombres es: " + sueldoH);
	}
}
