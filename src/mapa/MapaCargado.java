package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa{
	
//	private int[] pixeles ={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,1,
//							1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2
//							,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
//							2,2,2,1,2,1,2,1,2,1,2,1,2,1,2,2,2,3,3,3,
//							1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,1,
//							1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2
//							,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
//							2,2,2,1,2,1,2,1,2,1,2,1,2,1,2,2,2,3,3,3,
//							1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,1,
//							1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2
//							,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
//							2,2,2,1,2,1,2,1,2,1,2,1,2,1,2,2,2,3,3,3};
private int[] pixeles;
	public MapaCargado(String ruta) {
		super(ruta);
		
	
	}
	
	protected void cargarMapa(String ruta){
		//en esta parte se cargaran mapas desde imagenes
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
			ancho =imagen.getWidth();
			alto = imagen.getHeight();
			cuadrosCatalogo= new Cuadro[ancho*alto];
			pixeles= new int[ancho * alto];
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	protected void generarMapa(){
		for(int i = 0; i<pixeles.length;i++){
			
			switch(pixeles[i]){
			case 0xff1874c2:
				cuadrosCatalogo[i]= Cuadro.ASFALTO;
				continue;
			case 0xff1ef11e:
				cuadrosCatalogo[i] = Cuadro.TIERRA;
				continue;
			default:
				
			
			}
		}
	}
//	
//	protected void generarMapa(int[] pixeles){
//		
//		for(int i = 0;i<pixeles.length;i++){
//			switch (pixeles[i]) {
//			case 0:
//				
//				cuadrosCatalogo[i]=	Cuadro.ASFALTO;
//				continue;
//			case 1:
//				cuadrosCatalogo[i]=	Cuadro.TIERRA;
//				continue;
//			case 2:
//				cuadrosCatalogo[i]= Cuadro.TIERRA2;
//				continue;
//
//			default:
//				cuadrosCatalogo[i]=Cuadro.VACIO;
//			}
//			
//		}
//		
//		
//	}
	
	

}
