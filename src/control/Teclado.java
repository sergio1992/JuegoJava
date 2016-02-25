package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{
	
	private static final int numeroTeclas = 120;
	private boolean[] teclas = new boolean[numeroTeclas];
	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	public boolean salir;
	
	public void actualizar(){
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		izquierda = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
		salir = teclas[KeyEvent.VK_ESCAPE];
	}

	public void keyPressed(KeyEvent arg0) {
		teclas[arg0.getKeyCode()]= true;
		
	}

	public void keyReleased(KeyEvent arg0) {
		teclas[arg0.getKeyCode()]= false;
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
