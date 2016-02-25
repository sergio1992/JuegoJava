package graficos;

import mapa.cuadro.Cuadro;

public final class Pantalla {

	private final int ancho;
	private final int alto;
	
	private int diferenciaX;
	private int diferenciaY;
	public final int[] pixeles;
//	//temporales
//	private final static int LADO_SPRITE = 32;
//	private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
//	//fin temporales
	
	public Pantalla(final int ancho, final int alto){
		this.ancho = ancho;
		this.alto = alto;
		pixeles = new int[ancho * alto];
		
		
		
	}
	public void limpiar(){
		for( int i = 0; i < pixeles.length;i++){
			pixeles[i] = 0;
		}
	}
//	//TEMPORAL
//	public void mostrar(final int compensacionX, final int compensancionY){
//		
//		for(int y = 0; y < alto; y ++){
//			int posicionY = y + compensancionY;
//			 if(posicionY < 0 || posicionY >= alto){
//				 continue;
//				 }
//			for(int x = 0;x<ancho;x++){
//				int posicionX = x + compensacionX;
//				if(posicionX < 0 || posicionX >= ancho){
//					continue;
//					}
//				//temporal
////				pixeles[posicionX  + posicionY * ancho]= Sprite.asfalto.pixeles[(x & MASCARA_SPRITE) +(y & MASCARA_SPRITE)* LADO_SPRITE]; 
//				pixeles[posicionX + posicionY * ancho] =  Sprite.ASFALTO.pixeles[(x & MASCARA_SPRITE)+(y & MASCARA_SPRITE)*LADO_SPRITE];
//			}
//		}
//	}
//	//FIN TEMPORAL
	
	public void mostrarCuadro(int compensacionX , int compensacionY , Cuadro cuadro){
		compensacionX -=diferenciaX;
		compensacionY -= diferenciaY;
		for(int y=0;y<cuadro.sprite.obtenLado();y++){
			int posicionY = y + compensacionY;
			for(int x=0; x < cuadro.sprite.obtenLado();x++){
				int posicionX = x + compensacionX;
				
					if(posicionX < -cuadro.sprite.obtenLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
						break;
					}
				
					if(posicionX < 0 ){
						posicionX = 0 ;
					}
					pixeles[posicionX + posicionY * ancho]= cuadro.sprite.pixeles[x+y * cuadro.sprite.obtenLado()];
			}
		}
	}
	public void establecerDiferencia(final int diferenciaX,final int diferenciaY){
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
		
	}
	public int obtenAncho(){
		return ancho;
	}
	public int obtenAlto(){
		return alto;
	}
}
