package ataques;

import java.util.Random;

import enums.Tipo;
import hilo.HiloServidor;
import mascotas.*;

public class Grunido extends Ataque {

	private int tiempoMin;
	private int tiempoMax;
	private int potenciaMin;
	private int potenciaMax;

	public Grunido() {

		super("Gruñido", 0, 100, 50, Tipo.NORMAL);
		// TODO Auto-generated constructor stub

		tiempoMin = 1;
		tiempoMax = 4;
		potenciaMin = 1;
		potenciaMax = 15;
	}

	@Override
	public boolean iniciarAtaque(Mascota mascota, Mascota objetivo, Random r, HiloServidor hs) {
		mascota.restarEnergia(getCosto());

		objetivo.setPotenciaDebilitado(r.nextInt(potenciaMin, potenciaMax + 1));
		objetivo.setTiempoDebilitado(r.nextInt(tiempoMin, tiempoMax + 1));

		mostrarAtaqueExitoso(objetivo, 0, hs);

		return true;

	}

	@Override
	public void mostrarAtaqueExitoso(Mascota objetivo, float potenciaFinal, HiloServidor hs) {
		// TODO Auto-generated method stub

		hs.enviarMensajeGlobal("Imprimir_" + objetivo.getNombre() + " ha sido debilitado un "
				+ objetivo.getPotenciaDebilitado() + "% durante " + objetivo.getTiempoDebilitado() + " turnos");

	}

}
