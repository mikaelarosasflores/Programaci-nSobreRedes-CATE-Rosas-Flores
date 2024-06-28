package ataques;

import mascotas.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import enums.Tipo;
import hilo.HiloServidor;

public abstract class Ataque {
	private String nombre;
	private int potencia;
	private float precision;
	private int costo;
	private Tipo tipo;

	public Ataque(String nombre, int potencia, float precision, int costo, Tipo tipo) {
		this.nombre = nombre;
		this.potencia = potencia;
		this.precision = precision;
		this.costo = costo;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPotencia() {
		return potencia;
	}

	public float getPrecision() {
		return precision;
	}

	public int getCosto() {
		return costo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Comprueba (energía suficiente y probabilidad) y realiza el ataque
	 */
	public boolean iniciarAtaque(Mascota mascota, Mascota objetivo, Random r, HiloServidor hs) {
		boolean valido = true;

		float random = r.nextFloat();
		mascota.restarEnergia(costo);
		if (random <= (precision / 100)) {

			try {
				float potenciaFinal = (potencia * (1 - mascota.getPotenciaDebilitado() / 100) * (float) (tipo.getClass()
						.getMethod("getEfectividad" + objetivo.getTipo().getNombre()).invoke(tipo)));
				potenciaFinal = (float) (Math.round(potenciaFinal * 100.0) / 100.0);
				objetivo.restarVida(potenciaFinal);
				mostrarAtaqueExitoso(objetivo, potenciaFinal, hs);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			valido = false;
			hs.enviarMensajeGlobal("Imprimir_El ataque del " + mascota.getNombre() + " del jugador "
					+ (mascota.getJugador() + 1) + " falló");
		}

		mascota.pasarTiempoDebilitado();

		return valido;

	}

	/**
	 * Muestra el resultado del ataque (ya sea curación o daño)
	 */
	public void mostrarAtaqueExitoso(Mascota objetivo, float potenciaFinal, HiloServidor hs) {
		if (potencia < 0) {
			hs.enviarMensajeGlobal(
					"Imprimir_La mascota " + objetivo.getNombre() + " del jugador N°" + (objetivo.getJugador() + 1)

							+ " se curó hasta un máximo de " + (-potenciaFinal));
		} else {
			hs.enviarMensajeGlobal("Imprimir_La mascota " + objetivo.getNombre() + " del jugador N°"
					+ (objetivo.getJugador() + 1) + " recibió " + potenciaFinal + " puntos de daño");
		}

	}
}
