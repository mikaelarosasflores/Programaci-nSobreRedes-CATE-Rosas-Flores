package red;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.util.Random;
import java.util.Scanner;

import hilo.HiloCliente;
import hilo.HiloServidor;
import mascotas.Mascota;
import utilidades.Utiles;

public class Servidor {
	static HiloServidor hs;
	private boolean inicioBatalla = false;
	public static Mascota mascotasRed[] = new Mascota[2];
	private static int ataque = -1;
	static Scanner s = new Scanner(System.in);
	static Random r = new Random();

	public Servidor() {
		boolean fin = false;
		hs = new HiloServidor(this);
		hs.start();

		while (!fin) {
			try {
				Thread.sleep(5); // a veces el mnesaje es muy rápido para el mismo IDE
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (inicioBatalla) {
				inicioBatalla = false;
				iniciarCombate();
			}
		}

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
					.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("¡Felicidades has adoptado un " + mascota.getNombre() + "!");

		return mascota;
	}

	/**
	 * Cambia el turno entre los jugadores
	 */
	public static int cambiarTurno(int turno) {

		return (turno == 0) ? 1 : 0;
	}

	/**
	 * Muestra las opciones accionables al jugador
	 */
	public static boolean mostrarOpciones(Scanner s, Mascota mascota) {

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
			if (mascota.getVida() < 1) {
				System.out.println("La mascota no tiene vida suficienta. Aliméntala para recuperarala.");
			} else if (mascota.getEnergiaMax() < 1) {
				System.out.println("La mascota no tiene energía suficiente. Déjala dormir para recuperarla.");
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
	 * La mascota descansa y verifica la sobre-energía
	 */
	private static void descansarMascota(Mascota mascota) {
		if (mascota.getEnergia() == mascota.getEnergiaMax()) {
			System.out.println("Su mascota tiene energía suficiente y no necesita descansar");
		} else {
			mascota.restarEnergia(mascota.getEnergiaMax());
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
	 * Alimenta a la mascota y restaura puntos de salud
	 */
	public static void iniciarCombate() {
		boolean seleccionAtaque = false;
		boolean muerte = false;

		int turno = r.nextInt(0, 2); // el turno se elige de forma aleatoria
		hs.enviarMensajeGlobal("Imprimir_El combate ha iniciado");
		while (!muerte) {
			hs.enviarMensajeGlobal("Imprimir_Turno del jugador " + (turno + 1));

			mostrarEstadisticasMascota(turno);
			do {
				hs.enviarMensajePrivado("SolicitarAtaque", turno);
				do {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} while (ataque == -1); // verifica que cambie la variable, si cambia, el jugador ingresó un dato, se
										// usa en array

				if (mascotasRed[turno].getEnergia() >= mascotasRed[turno].getAtaques()[ataque].getCosto()) {
					seleccionAtaque = true; // verifica que la energía sea suficiente
				} else {
					ataque = -1; // eleccion en base al array (-1 no corresponde a ninguna posición)
					hs.enviarMensajePrivado("Imprimir_Energia insuficiente, seleccione otra opción", turno);
				}

			} while (!seleccionAtaque);
			seleccionAtaque = false;
			if (mascotasRed[turno].getAtaques()[ataque].iniciarAtaque(mascotasRed[turno], mascotasRed[cambiarTurno(turno)], r, hs)) { 
				//le avisa al cliente que le pegó, si sí le avisa que cambie la vida
				
				hs.enviarMensajePrivado("ModificarVida_" + mascotasRed[cambiarTurno(turno)].getVida(),
						cambiarTurno(turno)); //le mando el mensaje y el id del cliente
			}
			hs.enviarMensajePrivado("ModificarEnergia_" + mascotasRed[turno].getEnergia(), turno);
			turno = cambiarTurno(turno);
			ataque = -1;
			if (mascotasRed[turno].verificarMuerte()) {

				hs.enviarMensajeGlobal("Imprimir_La mascota del jugador " + (turno + 1) + " no puede seguir luchando");
				hs.enviarMensajeGlobal("Imprimir_El jugador " + (cambiarTurno(turno) + 1) + " ha ganado");
				muerte = true;
				hs.terminarConexion();
			}

		}

	}

	private static void mostrarEstadisticasMascota(int turno) {

		for (int i = 0; i < mascotasRed.length; i++) {
			hs.enviarMensajePrivado("Imprimir_ESTADÍSTICAS DE " + mascotasRed[i].getNombre() + "("
					+ (mascotasRed[i].getJugador() + 1) + ")", turno);
			hs.enviarMensajePrivado("Imprimir_ VIDA: " + mascotasRed[i].getVida(), turno);
			hs.enviarMensajePrivado("Imprimir_ ENERGÍA: " + mascotasRed[i].getEnergia(), turno);

		}

	}

	public void setAtaque(int ataque) {
		Servidor.ataque = ataque;
	}

	public void setInicioBatalla(boolean inicioBatalla) {
		this.inicioBatalla = inicioBatalla;
	}

}