package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public  class Cuadro {
	public int x;
	public int y;
	public static final int LADO =32;
	public Sprite sprite;
	//COLECCION DE CUADROS
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
	public static final Cuadro ASFALTO =  new Cuadro(Sprite.ASFALTO);
	public static final Cuadro TIERRA = new Cuadro(Sprite.TIERRA);
	public static final Cuadro TIERRA2 = new Cuadro(Sprite.TIERRA2);
	//FIN COLECCION DE CUADROS
	
	public Cuadro(Sprite sprite){
		this.sprite = sprite;
	}
	public void mostrar(int x, int y , Pantalla pantalla){
		pantalla.mostrarCuadro(x<<5, y<<5, this);
		
		
	}
	
	public boolean solido(){
		return false;
	}

}
