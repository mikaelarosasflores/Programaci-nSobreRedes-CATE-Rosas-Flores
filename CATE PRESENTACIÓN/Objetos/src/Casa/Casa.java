package Casa;

import Muebles.Mueble;

public class Casa {

	private Mueble muebles[] = new Mueble[5];
	private int cant = 0;

	public int getCant() {
		return cant;
	}

	public Mueble[] getMuebles() {
		return muebles;
	}

	public void agregarMueble(Mueble mueble) {
		muebles[cant] = mueble;
		cant++;

	}
}
