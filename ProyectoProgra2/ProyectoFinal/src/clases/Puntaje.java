package clases;
import clases.JugadorAnimado;

public class Puntaje {

	public String nombre;
	public int puntos;
	public Puntaje(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Puntaje [nombre=" + nombre + "]";
	}
	
	public String toCSV() {
		return nombre+","+"\n";
	}
}
