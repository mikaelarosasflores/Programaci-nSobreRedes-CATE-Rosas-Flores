package enums;

public enum Tipo {
	AGUA("Agua", 0.5f, 2, 1), FUEGO("Fuego", 0.5f, 0.5f, 1), NORMAL("Normal", 1, 1, 1);

	private String nombre;
	private float efectividadAgua;
	private float efectividadFuego;
	private float efectividadNormal;

	Tipo(String nombre, float efectividadAgua, float efectividadFuego, float efectividadNormal) {
		this.nombre = nombre;
		this.efectividadAgua = efectividadAgua;
		this.efectividadFuego = efectividadFuego;
		this.efectividadNormal = efectividadNormal;

	}

	public String getNombre() {
		return nombre;
	}

	public float getEfectividadAgua() {
		return efectividadAgua;
	}

	public float getEfectividadFuego() {
		return efectividadFuego;
	}

	public float getEfectividadNormal() {
		return efectividadNormal;
	}

}
