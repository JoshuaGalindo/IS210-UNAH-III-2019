package implementacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.Enemigo;
import clases.Item;
import clases.JugadorAnimado;
import clases.Puntaje;
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
	private Item item4;
	private Item item5;
	private Item item6;
	private Item item7;
	private Item item8;
	private Item item9;
	private Item item10;
	private Item item11;
	private Item item12;
	private Item item13;
	private Item item14;
	private Item item15;
	private Item item16;
	private Enemigo enemigo1;
	private Enemigo enemigo2;
	private Enemigo enemigo3;
	private Enemigo enemigo4;
	private Enemigo enemigo5;
	private Enemigo enemigo6;
	private Enemigo enemigo7;
	private Enemigo enemigo8;
	private Enemigo enemigo9;
	private Enemigo enemigo10;
	private Enemigo enemigo11;
	private Enemigo enemigo12;
	private Enemigo enemigo13;
	private Enemigo enemigo14;
	private Enemigo enemigo15;
	private Enemigo enemigo16;
	private Enemigo enemigo17;
	private Enemigo enemigo18;
	private Enemigo enemigo19;
	private Enemigo enemigo20;
	private Enemigo enemigo21;
	public static boolean fin=false;
	
	public void guardarRegistroArchivo() {
		Puntaje p = new Puntaje(JOptionPane.showInputDialog("Escribe tu nombre: "));
		try {
			BufferedWriter archivo = new BufferedWriter(new FileWriter("usuarios.csv",true));
			archivo.write(p.toCSV());
			
			archivo.flush(); //Descarga todo el contenido dentro del archivo
			archivo.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
			{5,1,1,4,1,1,1,1,1,1},
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
	
	private void finalizar() {
	
	System.out.println("Fin del juego!");  
	
	System.exit(0);
	
	}

	
	public void inicializarComponentes() {
		//jugador = new Jugador(-50,400,"goku",1);
		jugadorAnimado = new JugadorAnimado(100,200,"SpriteJugador",5, "correr");
		
		root = new Group();
		escena = new Scene(root,1000,500);
		canvas  = new Canvas(1000,500);
		imagenes = new HashMap<String,Image>();
		enemigo1 = new Enemigo(1000,100,"enemigo",5,"correrE");
		enemigo2 = new Enemigo(2000,280,"enemigo",5,"correrE");
		enemigo3 = new Enemigo(3000,200,"enemigo",5,"correrE");
		enemigo4 = new Enemigo(4000,380,"enemigo",5,"correrE");
		enemigo5 = new Enemigo(5000,420,"enemigo",5,"correrE");
		enemigo6 = new Enemigo(6000,400,"enemigo",5,"correrE");
		enemigo7 = new Enemigo(7000,280,"enemigo",5,"correrE");
		enemigo8 = new Enemigo(8500,180,"enemigo",5,"correrE");
		enemigo9 = new Enemigo(9000,380,"enemigo",5,"correrE");
		enemigo10 = new Enemigo(16000,290,"enemigo",5,"correrE");
		enemigo11 = new Enemigo(19600,100,"enemigo",5,"correrE");
		enemigo12 = new Enemigo(18100,80,"enemigo",5,"correrE");
		enemigo13 = new Enemigo(20800,400,"enemigo",5,"correrE");
		enemigo14 = new Enemigo(11800,380,"enemigo",5,"correrE");
		enemigo15 = new Enemigo(9400,280,"enemigo",5,"correrE");
		enemigo16 = new Enemigo(12300,300,"enemigo",5,"correrE");
		enemigo17 = new Enemigo(16400,280,"enemigo",5,"correrE");
		enemigo18 = new Enemigo(14700,280,"enemigo",5,"correrE");
		enemigo19 = new Enemigo(13700,100,"enemigo",5,"correrE");
		enemigo20 = new Enemigo(12700,250,"enemigo",5,"correrE");
		enemigo21 = new Enemigo(21700,400,"enemigo",5,"correrE");
		item = new Item(13800,200,0,0,"item");
		item2 = new Item(12700,400,0,0,"item");
		item3 = new Item(10500,300,0,0,"item");
		item4 = new Item(22000,500,0,0,"item");
		item5 = new Item(2000,300,0,0,"item");
		item6 = new Item(12500,200,0,0,"item");
		item7 = new Item(4000,100,0,0,"item");
		item8 = new Item(19000,450,0,0,"item");
		item9 = new Item(6500,324,0,0,"item");
		item10 = new Item(8700,300,0,0,"item");
		item11 = new Item(21800,20,0,0,"item");
		item12 = new Item(21890,500,0,0,"item");
		item13 = new Item(21890,400,0,0,"item");
		item14= new Item(21800,300,0,0,"item");
		item15= new Item(21800,200,0,0,"item");
		item16= new Item(21800,100,0,0,"item");
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
		enemigo1.pintar(graficos);
		enemigo2.pintar(graficos);
		enemigo3.pintar(graficos);
		enemigo4.pintar(graficos);
		enemigo5.pintar(graficos);
		enemigo6.pintar(graficos);
		enemigo7.pintar(graficos);
		enemigo8.pintar(graficos);
		enemigo9.pintar(graficos);
		enemigo10.pintar(graficos);
		enemigo11.pintar(graficos);
		enemigo12.pintar(graficos);
		enemigo13.pintar(graficos);
		enemigo14.pintar(graficos);
		enemigo15.pintar(graficos);
		enemigo16.pintar(graficos);
		enemigo17.pintar(graficos);
		enemigo18.pintar(graficos);
		enemigo19.pintar(graficos);
		enemigo20.pintar(graficos);
		enemigo21.pintar(graficos);
		
		item.pintar(graficos);
		item2.pintar(graficos);
		item3.pintar(graficos);
		item4.pintar(graficos);
		item5.pintar(graficos);
		item6.pintar(graficos);
		item7.pintar(graficos);
		item8.pintar(graficos);
		item9.pintar(graficos);
		item10.pintar(graficos);
		item11.pintar(graficos);
		item12.pintar(graficos);
		item13.pintar(graficos);
		item14.pintar(graficos);
		item15.pintar(graficos);
		item16.pintar(graficos);
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
		imagenes.put("enemigo", new Image("enemigo.png"));
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
				if(!Juego.fin) {
					pintar();
					actualizar(t);

				}else {finalizar();}
							
				
			}
			
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		enemigo1.actualizarAnimacion(t);
		enemigo2.actualizarAnimacion(t);
		enemigo3.actualizarAnimacion(t);
		enemigo4.actualizarAnimacion(t);
		enemigo5.actualizarAnimacion(t);
		enemigo6.actualizarAnimacion(t);
		enemigo7.actualizarAnimacion(t);
		enemigo8.actualizarAnimacion(t);
		enemigo9.actualizarAnimacion(t);
		enemigo10.actualizarAnimacion(t);
		enemigo11.actualizarAnimacion(t);
		enemigo12.actualizarAnimacion(t);
		enemigo13.actualizarAnimacion(t);
		enemigo14.actualizarAnimacion(t);
		enemigo15.actualizarAnimacion(t);
		enemigo16.actualizarAnimacion(t);
		enemigo17.actualizarAnimacion(t);
		enemigo18.actualizarAnimacion(t);
		enemigo19.actualizarAnimacion(t);
		enemigo20.actualizarAnimacion(t);
		enemigo21.actualizarAnimacion(t);
		jugadorAnimado.verificarColisiones(enemigo1);
		jugadorAnimado.verificarColisiones(enemigo2);
		jugadorAnimado.verificarColisiones(enemigo3);
		jugadorAnimado.verificarColisiones(enemigo4);
		jugadorAnimado.verificarColisiones(enemigo5);
		jugadorAnimado.verificarColisiones(enemigo6);
		jugadorAnimado.verificarColisiones(enemigo7);
		jugadorAnimado.verificarColisiones(enemigo8);
		jugadorAnimado.verificarColisiones(enemigo9);
		jugadorAnimado.verificarColisiones(enemigo10);
		jugadorAnimado.verificarColisiones(item);
		jugadorAnimado.verificarColisiones(item2);
		jugadorAnimado.verificarColisiones(item3);
		jugadorAnimado.verificarColisiones(item4);
		jugadorAnimado.verificarColisiones(item5);
		jugadorAnimado.verificarColisiones(item6);
		jugadorAnimado.verificarColisiones(item7);
		jugadorAnimado.verificarColisiones(item8);
		jugadorAnimado.verificarColisiones(item9);
		jugadorAnimado.verificarColisiones(item10);
		jugadorAnimado.verificarColisiones1(item11);
		jugadorAnimado.verificarColisiones(item12);
		jugadorAnimado.verificarColisiones1(item13);
		jugadorAnimado.verificarColisiones1(item14);
		jugadorAnimado.verificarColisiones1(item15);
		jugadorAnimado.verificarColisiones1(item16);
			}
	
		
	
}