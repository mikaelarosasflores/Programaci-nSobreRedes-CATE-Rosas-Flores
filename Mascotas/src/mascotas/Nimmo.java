package mascotas;

import ataques.*;
import enums.Tipo;

public class Nimmo extends Mascota {

	public Nimmo() {
		super("Nimmo", Tipo.FUEGO, 1200, 800, new Placaje(), new BolaDeFuego(), new Curacion());
		// TODO Auto-generated constructor stub
	}

}
