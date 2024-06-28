package red;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Scanner;

import hilo.HiloCliente;
import mascotas.Mascota;
import utilidades.Utiles;

public class Cliente {
	static HiloCliente hc;
	private Mascota mascota;
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	boolean conectado = false;

	public Cliente() {

		boolean fin = false;

		mascota = adoptarMascota(s); // SACAR MASCOTA DE PARÁMETRO DE ENTRADA

		do {
			fin = mostrarOpciones(s, mascota);

		} while (!fin);

	}

	/**
	 * Eliges una mascota
	 */
	public static Mascota adoptarMascota(Scanner s) {
		Mascota mascota = null;
		String[] mascotas = { "Nimmo", "Koi" };
		System.out.println("¡Hola! adopta una mascota para empezar: ");
		System.out.println("1) NIMMO");
		System.out.println("2) KOI");

		int eleccion = Utiles.ingresarNum(s, 1, 2);

		try {
			mascota = (Mascota) Class.forName("mascotas." + mascotas[eleccion - 1]).getDeclaredConstructor()
					.newInstance(); // buscas a la mascota
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("¡Felicidades has adoptado un " + mascota.getNombre() + "!");

		return mascota;
	}

	/**
	 * Inicia la batalla basándose en los turnos y verifica la muerte si es el caso
	 */
	/*
	 * public static void iniciarBatalla(Mascota mascotas[], Random r, Scanner s) {
	 * boolean muerte = false; int turno = r.nextInt(0, 2); do {
	 * System.out.println("Turno del jugador " + turno); for (int i = 0; i <
	 * mascotas.length; i++) { mascotas[i].mostrarEstadisticas(); }
	 * mascotas[turno].mostrarAtaques(); while
	 * (!mascotas[turno].getAtaques()[Utiles.ingresarNum(s, 1,
	 * mascotas[turno].getAtaques().length) - 1] .iniciarAtaque(mascotas[turno],
	 * mascotas[cambiarTurno(turno)], r)) {
	 * 
	 * System.out.println("No se pudo seleccionar el ataque. Ingrese otra opción.");
	 * }
	 * 
	 * turno = cambiarTurno(turno);
	 * 
	 * if (mascotas[turno].verificarMuerte()) { muerte = true;
	 * 
	 * System.out.println("La mascota del jugador " + turno +
	 * " no puede seguir luchando"); System.out.println("El jugador " +
	 * cambiarTurno(turno) + " ha ganado"); } } while (!muerte); }
	 */

	/**
	 * Cambia el turno entre los jugadores
	 */
	public static int cambiarTurno(int turno) {

		return (turno == 0) ? 1 : 0;
	}

	/**
	 * Muestra las opciones accionables al jugador
	 */
	public boolean mostrarOpciones(Scanner s, Mascota mascota) {

		System.out.println(":::::::::MENÚ PRINCIPAL:::::::::");
		System.out.println("1) Mostrar estadísiticas de " + mascota.getNombre());
		System.out.println("2) Iniciar batalla");
		System.out.println("3) Alimentar");
		System.out.println("4) Mandar a dormir");
		System.out.println("5) Salir del juego");
		int eleccion = Utiles.ingresarNum(s, 1, 5);
		boolean fin = false;
		switch (eleccion) {

		case 1:
			mascota.mostrarEstadisticas();
			break;
		case 2:

			if (mascota.getVida() <= 1) {
				System.out.println("La mascota no tiene vida suficienta. Aliméntala para recuperarala.");
			} else if (mascota.getEnergia() < 1) {
				System.out.println("La mascota no tiene energía suficiente. Déjala dormir para recuperarla.");
			} else {

				hc = new HiloCliente(this);
				hc.start();

				do {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (!hc.isFin() && conectado);
				if (!conectado) {
					System.out.println("El servidor no se encuentra conectado");
				}
				conectado = false;
			}

			// iniciarBatalla(mascotas[], r, s); pasaje a server
			break;
		case 3:
			alimentarMascota(mascota);
			break;
		case 4:
			descansarMascota(mascota);
			break;
		case 5:
			fin = true;
			System.out.println("Usted ha salido del juego.");
			break;
		}
		return fin;
	}

	/**
	 * Mandas a la mascota a descansar, antes compruebas su nivel de energía
	 */

	private static void descansarMascota(Mascota mascota) {
		if (mascota.getEnergia() == mascota.getEnergiaMax()) {
			System.out.println("Su mascota tiene energía suficiente y no necesita descansar");
		} else {
			mascota.restarEnergia(-mascota.getEnergiaMax());
			mascota.comprobarSobrenergia();
			try {
				for (int i = 0; i < 3; i++) {
					System.out.print("Z...");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\nLa mascota descansó y ha recuperado toda su energía");
		}
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

	/**
	 * Alimenta a la mascota y restaura puntos de salud
	 */
	private static void alimentarMascota(Mascota mascota) {
		if (mascota.getVida() == mascota.getVidaMax()) {
			System.out.println("Su mascota tiene la vida máxima y no necesita ser alimentada");
		} else {
			mascota.restarVida(-400);
			mascota.comprobarSobrecuracion();
			System.out.println("Has alimentado a tu mascota y su vida es: " + mascota.getVida());
		}
	}

	/**
	 * Obtiene el nro de ID del jugador
	 */
	public void asignarID(int jugador) {
		mascota.setJugador(jugador);
		System.out.println("Conexión completada");
	}

	/**
	 * Envía la mascota al servidor
	 */
	public void enviarMascota() {
		hc.enviarMensaje("EnvioMascota_" + mascota.getNombre() + "_" + mascota.getJugador() + "_" + mascota.getVida()
				+ "_" + mascota.getEnergia());
	}

	/**
	 * Envía el ataque al servidor
	 */
	public void enviarAtaque() {
		mascota.mostrarAtaques();
		System.out.println("Seleccione un ataque: ");
		int eleccion = Utiles.ingresarNum(s, 1, 3);
		hc.enviarMensaje("EnviarAtaque_" + eleccion);
	}
}