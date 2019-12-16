package clases;

import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemigo extends Personaje{
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	
	public Enemigo(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x, y, indiceImagen, velocidad, animacionActual);
	}

	
	
	
	
	//Obtener las coordenadas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
		
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x-=7, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		
	}
	
	
	

	
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x-=7, this.y, 59, 82);
	}





	@Override
	public void inicializarAnimaciones() {
		animaciones = new HashMap<String, Animacion>();
		Rectangle coordenadasCorrerE[]= {
				new Rectangle(0, 0, 60, 82),
				new Rectangle(59, 0, 60, 82),
				new Rectangle(120, 0,60,82),
				new Rectangle(180,0,60,82),
				new Rectangle(240,0,60,82)
								
		};
		
		
		Animacion animacionCorrerE = new Animacion("correrE",coordenadasCorrerE,0.1);
		animaciones.put("correrE",animacionCorrerE);
		// TODO Auto-generated method stub
		
	}

	}
	/*public void verificarColisiones(Enemigo enemigo) {
		if (this.obtenerRectangulo().intersects(enemigo.obtenerRectangulo().getBoundsInLocal())) {
			System.out.println("Estan colisionando");
			
			JOptionPane.showMessageDialog(null, "Haz perdido, tu puntuacion fue: "+puntuacion);				
	}*/
	

	
