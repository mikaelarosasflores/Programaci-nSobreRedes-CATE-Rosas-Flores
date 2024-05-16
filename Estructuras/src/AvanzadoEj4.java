import java.util.Scanner;

public class AvanzadoEj4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la expresión matemática (ejemplo: 3 + 4 * (2 - 1)):");
        String expresion = scanner.nextLine();

        // Eliminar espacios en blanco de la expresión
        expresion = expresion.replaceAll("\\s+", "");

        // Validar la expresión
        String caracteresValidos = "+-*/^()0123456789.";
        boolean expresionValida = true;
        int contadorParentesis = 0;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (!caracteresValidos.contains(String.valueOf(c))) {
                expresionValida = false;
                break;
            }
            if (c == '(') {
                contadorParentesis++;
            } else if (c == ')') {
                contadorParentesis--;
                if (contadorParentesis < 0) {
                    expresionValida = false;
                    break;
                }
            }
        }

        if (!expresionValida || contadorParentesis != 0) {
            System.out.println("La expresión ingresada no es válida.");
            return;
        }

        // Resolver la expresión
        double resultado = 0;
        double numero = 0;
        char operador = '+';
        boolean nuevoNumero = true;
        boolean esNegativo = false;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isDigit(c)) {
                numero = numero * 10 + (c - '0');
                nuevoNumero = true;
            } else if (c == '-') {
                if (nuevoNumero) {
                    numero = -numero;
                    nuevoNumero = false;
                } else {
                    esNegativo = true;
                }
            } else {
                switch (operador) {
                    case '+':
                        resultado += numero;
                        break;
                    case '-':
                        resultado -= numero;
                        break;
                    case '*':
                        resultado *= numero;
                        break;
                    case '/':
                        resultado /= numero;
                        break;
                    case '^':
                        resultado = Math.pow(resultado, numero);
                        break;
                }

                if (esNegativo) {
                    resultado = -resultado;
                    esNegativo = false;
                }

                operador = c;
                numero = 0;
                nuevoNumero = false;
            }
        }

        switch (operador) {
            case '+':
                resultado += numero;
                break;
            case '-':
                resultado -= numero;
                break;
            case '*':
                resultado *= numero;
                break;
            case '/':
                resultado /= numero;
                break;
            case '^':
                resultado = Math.pow(resultado, numero);
                break;
        }

        System.out.println("Resultado: " + resultado);

	}

}
