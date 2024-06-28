package mascotas;

import ataques.Ataque;
import enums.Tipo;

public abstract class Mascota {
	private int jugador;
	private String nombre;
	private Tipo tipo;
	protected float vida;
	private float vidaMax;
	protected int energia;
	private int energiaMax;
	protected int tiempoDebilitado;
	protected float potenciaDebilitado;

	private Ataque ataques[] = new Ataque[3];

	public Mascota(String nombre, Tipo tipo, float vida, int energia, Ataque ataque1, Ataque ataque2, Ataque ataque3) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.vida = vida;
		this.energia = energia;
		vidaMax = vida;
		energiaMax = energia;
		tiempoDebilitado = 0;
		potenciaDebilitado = 0;
		jugador = -1;
		ataques[0] = ataque1;
		ataques[1] = ataque2;
		ataques[2] = ataque3;

	}

	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public float getVida() {
		return vida;
	}

	public void setVida(float vida) {
		this.vida = vida;
	}

	public float getVidaMax() {
		return vidaMax;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getEnergiaMax() {
		return energiaMax;
	}

	public Ataque[] getAtaques() {
		return ataques;
	}

	public int getTiempoDebilitado() {
		return tiempoDebilitado;
	}

	public void setTiempoDebilitado(int tiempoDebilitado) {
		this.tiempoDebilitado = tiempoDebilitado;
	}

	public float getPotenciaDebilitado() {
		return potenciaDebilitado;
	}

	public void setPotenciaDebilitado(float potenciaDebilitado) {
		this.potenciaDebilitado = potenciaDebilitado;
	}

	/**
	 * Modifica el valor de vida, ya sea restando o sumando puntos de salud
	 */
	public void restarVida(float potencia) {

		vida -= potencia;

		if (vida < 1) {
			vida = 1;
		}
	}

	/**
	 * Modifica el valor de vida, ya sea restando o sumando puntos de energía
	 */
	public void restarEnergia(int resta) {
		energia -= resta;
	}

	/**
	 * Muestra las estadísticas de la mascota
	 */
	public void mostrarEstadisticas() {
		System.out.println("ESTADÍSTICAS DE " + nombre + "(" + (jugador + 1) + ")");
		System.out.println("VIDA: " + vida);
		System.out.println("ENERGÍA: " + energia);

	}

	/**
	 * Muestra los ataques de la mascota
	 */
	public void mostrarAtaques() {
		System.out.println("LISTA DE ATAQUES DE " + nombre + ":");

		for (int i = 0; i < ataques.length; i++) {
			System.out.println((i + 1) + ") " + ataques[i].getNombre() + "  Tipo: " + ataques[i].getTipo()
					+ "  Potencia: " + Math.abs(ataques[i].getPotencia()) + "  Precisión: " + ataques[i].getPrecision()
					+ "%" + "  Costo: " + ataques[i].getCosto());
		}
	}

	/**
	 * Comprueba si la curación excede la vida máxima y remueve el exceso
	 */
	public void comprobarSobrecuracion() {
		if (vida > vidaMax) {
			vida = vidaMax;
		}
	}

	/**
	 * Comprueba si recuperación excede la energía máxima y remueve el exceso
	 */

	public void comprobarSobrenergia() {
		if (energia > energiaMax) {
			energia = energiaMax;
		}
	}

	/**
	 * Disminuye el tiempo de debilidad y lo elimina en caso de finalizado
	 */
	public void pasarTiempoDebilitado() {
		tiempoDebilitado--;

		if (tiempoDebilitado == 0) {
			potenciaDebilitado = 0;
		}
	}

	/**
	 * Verifica si la mascota tiene vida inferior a 1
	 */
	public boolean verificarMuerte() {
		return (vida <= 1) ? true : false;
	}

	/**
	 * Verifica si la mascota tiene energía inferior a 1
	 */
	public boolean verificarBajaEnergía() {
		return (energia <= 1) ? true : false;
	}

}
