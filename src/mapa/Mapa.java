package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] cuadros;
	
	public Mapa(int ancho, int alto){
		this.alto = alto;
		this.ancho = ancho;
		
		cuadros = new int[ancho * alto];
		generarMapa();
	}
	public Mapa(String ruta){
		cargarMapa(ruta);
	}
	protected void generarMapa(){
		
		
	}
	private void cargaMapa(){
		
	}
	private void cargarMapa(String ruta){
		
	}
	public void actualizar(){
		
	}
	public void mostrar(int compensacionX, int compensacionY,Pantalla pantalla){
		pantalla.establecerDiferencia(compensacionX, compensacionY);
		int o = compensacionX >> 5;//32
		int e = (compensacionX + pantalla.obtenAncho()+Cuadro.LADO) >> 5;
		int n = compensacionY >>5;
		int s= (compensacionY + pantalla.obtenAlto()+Cuadro.LADO)>>5;
		
		for(int y = n; y<s;y++){
			for(int x = o;x<e;x++){
				obtenCuadro(x, y).mostrar(x, y, pantalla);
			}
		}
	}
	public Cuadro obtenCuadro(final int x, final int y){
		if(x <0 || y <0 || x>=ancho ||y>=alto){
			return Cuadro.VACIO;
		}
		switch (cuadros[x+y*ancho]) {
		case 0:
			
			return Cuadro.ASFALTO;
		case 1:
			return Cuadro.TIERRA;
		case 2:
			return Cuadro.TIERRA2;

		default:
			return Cuadro.VACIO;
		}
	}
}
