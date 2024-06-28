package encuesta.Persona;

public class Persona {
	private int dni;
	private char sexo;
	private boolean trabaja;
	private int sueldo;

	public Persona(int dni, char sexo, boolean trabaja, int sueldo) { //tengo que tener los datos listos
		this.dni = dni;
		this.sexo = sexo;
		this.trabaja = trabaja;
		this.sueldo = sueldo;
	}

	public int getDni() {
		return dni;
	}	

	public char getSexo() {
		return sexo;
	}

	public boolean getTrabaja() {
		return trabaja;
	}

	public int getSueldo() {
		return sueldo;
	}
	
	
}
