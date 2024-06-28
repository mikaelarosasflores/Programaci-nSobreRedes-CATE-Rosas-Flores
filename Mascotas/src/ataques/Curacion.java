package ataques;

import java.util.Random;

import enums.Tipo;
import hilo.HiloServidor;
import mascotas.Mascota;

public class Curacion extends Ataque {
	@Override

	public boolean iniciarAtaque(Mascota mascota, Mascota objetivo, Random r, HiloServidor hs) {
		boolean valido = super.iniciarAtaque(mascota, mascota, r, hs);
		mascota.comprobarSobrecuracion();
		return valido;
	}

	public Curacion() {
		super("Curacion", -130, 40, 75, Tipo.NORMAL);
		// TODO Auto-generated constructor stub
	}

}
