package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JugadorAnimado extends Personaje {
	
	public int puntuacion = 0;
	
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
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
	
	public void mover(){
		//limites de movimiento
		if (this.x > 660)
			this.x = 660;
		if (this.x <= -10)
			this.x = -10;
		if (this.y > 400)
			this.y = 400;
		if (this.y <= -10)
			this.y = -10; 
		
		
		if (Juego.derecha)
			this.x+=velocidad;
		
		if (Juego.izquierda)
			this.x-=velocidad;
		
		if (Juego.arriba)
			this.y-=velocidad;
		
		if (Juego.abajo)
			this.y+=velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.setFill(Color.RED);
		
		graficos.fillText("Puntuacion " + puntuacion, 900, 30);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasCorrer[]= {
					new Rectangle(10, 0, 131, 102),
					new Rectangle(141, 0, 131, 102),
					new Rectangle(272, 0, 131,102)
					
									
			};
			
			
			Animacion animacionCorrer = new Animacion("correr",coordenadasCorrer,0.13);
			animaciones.put("correr",animacionCorrer);
			
			Rectangle coordenadasDescanso[] = {
					new Rectangle(26, 16, 63,73),
					new Rectangle(89,16, 63,73),
					new Rectangle(154,16, 63,73),
					new Rectangle(226,16, 63,73)
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.2);
			animaciones.put("descanso",animacionDescanso);
	}
	
	public void verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!item.isCapturado())
					this.puntuacion++;
					
				item.setCapturado(true);				
		}
		
		
	}
	public void verificarColisiones1(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				
				if (!item.isCapturado())
					this.puntuacion++;
					
				item.setCapturado(true);
				System.out.println("Ganaste!"+this.puntuacion);
				System.exit(0);
				}				
		}
	public void verificarColisiones(Enemigo enemigo) {
		if (this.obtenerRectangulo().intersects(enemigo.obtenerRectangulo().getBoundsInLocal())) {
				Juego.fin=true;
			System.out.println("Haz perdido! Tu puntuacion fue: "+puntuacion);
			
			}
		}
		
	}
	

