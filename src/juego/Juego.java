package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.Teclado;
import graficos.Pantalla;
import mapa.Mapa;
import mapa.MapaGenerado;

public class Juego extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;
	private static final int ALTO = 480;
	private static volatile boolean enFuncionamiento;
	private static final String NOMBRE = "Juego";
	private static int aps = 0;
	private static int fps = 0;
	private static int x = 0;
	private static int y = 0 ;
	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;
	private static Mapa mapa;
	private static String CONTADOR_FPS = "";
	private static String CONTADOR_APS = "";
	
	
	 private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	 private static int[] pixeles =((DataBufferInt)imagen.getRaster().getDataBuffer()).getData();
	private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));	
	
	
	private Juego(){
		setPreferredSize(new Dimension(ANCHO, ALTO));
		pantalla = new Pantalla(ANCHO, ALTO);
		mapa = new MapaGenerado(128,128);
		teclado = new Teclado();
		addKeyListener(teclado);
		
		ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setIconImage(icono.getImage());
		ventana.setUndecorated(true);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this,BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		
	
	}
	
	public static void main(String[] args){
		Juego juego = new Juego();
		juego.iniciar();
	}
	private synchronized void iniciar(){
		enFuncionamiento = true;
		thread = new Thread(this,"GRAFICOS");
		thread.start();
		
		
	}
	private synchronized void detener(){
		enFuncionamiento = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void actualizar(){
		teclado.actualizar();
		
		if (teclado.arriba) {
		    y--;
			}
		if (teclado.abajo) {
			y++;
			
			}
		if (teclado.izquierda) {
			x--;
			
			}
		if (teclado.derecha) {
			x++;
			}
		if(teclado.salir){
			System.exit(0);
		}
		aps++;
		
	}
	public void mostrar(){
		BufferStrategy estrategia = getBufferStrategy();
		if(estrategia == null){
			createBufferStrategy(3);
			return;
		}
		pantalla.limpiar();
		
		mapa.mostrar(x, y, pantalla);
//		pantalla.mostrar(x, y);
//		for(int i = 0; i<pixeles.length;i++){ 
//			pixeles[i] = pantalla.pixeles[i];
//		}
		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
		
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(),getHeight(),null);
		g.setColor(Color.white);
		g.drawString(CONTADOR_APS, 10, 20);
		g.setColor(Color.red);
		g.drawString(CONTADOR_FPS, 10, 35);
		g.dispose();
		estrategia.show();
		fps++;
	}

	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		double tiempoTranscurrido ;
		double delta = 0 ;
		requestFocus();
		 
		while(enFuncionamiento){
			final long inicioBucle =  System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			while(delta >= 1 ){
				actualizar();
				delta--;
			}
			
			mostrar();
			if(System.nanoTime()- referenciaContador > NS_POR_SEGUNDO){
				CONTADOR_APS = "APS : "+ aps;
				CONTADOR_FPS = "FPS : "+ fps;
				
				
				aps = 0; 
				fps =0;
				
				
				
				referenciaContador = System.nanoTime();
			}
		}
		
	}

}