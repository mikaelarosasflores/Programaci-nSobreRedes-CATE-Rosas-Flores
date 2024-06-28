package Sim;

import Casa.Casa;
import Enum.Zodiaco;

public class Sim {

	private String nombre;
	private int edad;
	private float dinero;
	private Zodiaco signo;

	Casa casa = new Casa();

	public Sim(String nombre, int edad, Zodiaco signo) {
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = 10000;
		this.signo = signo;
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public int getEdad() {
		return edad;
	}



	public float getDinero() {
		return dinero;
	}



	public Zodiaco getSigno() {
		return signo;
	}



	public Casa getCasa() {
		return casa;
	}



	public void restarPrecio(float precio) { //está en sim pq es la plata del SIM
		dinero -= precio;
		
		System.out.println(dinero); //seguimos aca
	}
}
