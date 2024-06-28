package Muebles;

public abstract class Mueble {
	private String nombre;
	private float precio;
	private float comodidad;

	public Mueble(String nombre, float precio, float comodidad) {

		this.nombre = nombre;
		this.precio = precio;
		this.comodidad = comodidad;

	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public float getComodidad() {
		return comodidad;
	}

}
