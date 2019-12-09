package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.Item;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private int puntuacion = 0;
	//private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	private Item item;
	private Item item2;
	private Item item3;
	//private ArrayList<Image> imagenes;
	
	private ArrayList<Tile> tiles;
	
	private int[][] mapa = {
			
			
			{1,4,1,1,1,5,1,1,1,1},
			{3,3,3,5,3,3,3,3,3,3},
			{5,1,1,1,4,1,1,1,1,1},		
			{4,3,3,3,3,3,3,3,3,3},
			{1,1,4,1,1,1,1,1,1,1},	
			{5,4,3,3,3,5,3,3,3,3},
			{1,1,5,1,1,1,1,1,1,1},
			{3,3,3,3,3,3,3,4,3,3},
			{5,1,1,1,5,1,1,1,1,1},
			{3,3,3,3,3,3,3,3,3,3},
			{1,1,1,1,1,1,1,4,1,1},
			{4,3,3,3,3,3,5,3,3,3},
			{1,1,1,1,1,4,1,1,1,1},
			{3,3,3,3,3,3,3,3,3,3},
			{1,1,1,5,1,1,1,1,1,1},
			{3,3,3,3,4,3,3,3,5,3},
			{5,1,1,4,1,1,1,1,1,1}
			
			
			
			
	};
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("Las Crónicas de un Elfo Cachureco");
		gestionarEventos();
		ventana.show();
		cicloJuego();		
	}
	
	public void inicializarComponentes() {
		//jugador = new Jugador(-50,400,"goku",1);
		jugadorAnimado = new JugadorAnimado(100,200,"SpriteJugador",5, "correr");
		root = new Group();
		escena = new Scene(root,1000,500);
		canvas  = new Canvas(1000,500);
		imagenes = new HashMap<String,Image>();
		item = new Item(10,200,0,0,"item");
		item2 = new Item(30,400,0,0,"item");
		item3 = new Item(500,300,0,0,"item");
		cargarImagenes();
		cargarTiles();
	}
	
	
	
	public void pintar() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, 1000, 500);
				
		///Pintar tiles
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		//jugador.pintar(graficos);
			jugadorAnimado.pintar(graficos);
		
		item.pintar(graficos);
		item2.pintar(graficos);
		item3.pintar(graficos);
		
		

	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*60, j*60, "tilemap",0));
			}
		}
	}
	public void cargarImagenes() {
		
		imagenes.put("tilemap", new Image("tilemapFinal2.png"));
		imagenes.put("SpriteJugador", new Image("SpriteJugador.png"));
		imagenes.put("item", new Image("50pesosEditado.png"));
	}
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							break;
						case "LEFT": //derecha
							izquierda=true;
						break;
						case "UP":
							arriba=true;
							break;
						case "DOWN":
							abajo=true;
							break;
						case "SPACE":
							//jugador.setVelocidad(10);
							//jugador.setIndiceImagen("goku-furioso");
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					break;
				case "LEFT": //derecha
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					//jugador.setVelocidad(1);
					//jugador.setIndiceImagen("goku");
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);
				
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		jugadorAnimado.verificarColisiones(item);
		jugadorAnimado.verificarColisiones(item2);
		jugadorAnimado.verificarColisiones(item3);
	}

}