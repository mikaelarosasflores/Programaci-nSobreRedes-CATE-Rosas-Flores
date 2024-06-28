package mascotas;

import ataques.*;
import enums.Tipo;

public class Koi extends Mascota {

	public Koi() {
		super("Koi", Tipo.AGUA, 700, 500, new Placaje(), new PistolaDeAgua(), new Grunido());

	}

	public void mostrarNombre() {
		System.out.println("Chupala gorda puta");
	}

}
