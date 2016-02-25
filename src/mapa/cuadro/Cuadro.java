package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {
	public int x;
	public int y;
	public static final int LADO =32;
	public Sprite sprite;
	//COLECCION DE CUADROS
	public static final Cuadro VACIO = new CuadroVacio(Sprite.VACIO);
	public static final Cuadro ASFALTO =  new CuadroAsfalto(Sprite.ASFALTO);
	public static final Cuadro TIERRA = new CuadroTierra(Sprite.TIERRA);
	public static final Cuadro TIERRA2 = new CuadroTierra2(Sprite.TIERRA2);
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
