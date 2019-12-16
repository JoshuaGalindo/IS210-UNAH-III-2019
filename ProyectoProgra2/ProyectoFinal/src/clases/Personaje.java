package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public abstract class Personaje {

	protected int x;
	protected int y;
	protected String indiceImagen;
	protected int velocidad;
	protected HashMap<String, Animacion> animaciones;
	protected String animacionActual;
	
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	public Personaje(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public abstract void actualizarAnimacion(double t);
	
	public abstract void pintar(GraphicsContext graficos);
	
	

	public abstract void inicializarAnimaciones();
		
		
		Rectangle coordenadasDescanso[] = {
				new Rectangle(26,16,63,73),
				new Rectangle(89,16,63,73),
				new Rectangle(154,16,63,73),
				new Rectangle(226,16,63,73)
};
}
