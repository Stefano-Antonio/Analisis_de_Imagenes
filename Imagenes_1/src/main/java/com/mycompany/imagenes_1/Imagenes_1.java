

package com.mycompany.imagenes_1;

import Espacial.convolucion;
import gui.JFrameImagen;
import gui.JFrameimg;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author stimp
 */
public class Imagenes_1 extends JPanel {

  
    public static void main(String[] args) {
            Image imagen = Herramientas.HerramientasImagen.abrirImagen();
            JFrameimg frame = new JFrameimg(imagen); 
           /* 
            Image ruido = Espacial.Ruido.agregarRuidoAditivo(imagen, 80);
            JFrameimg frame3 = new JFrameimg(ruido);
            Image ruidosus = Espacial.Ruido.agregarRuidoSustractivo(imagen, 80);
            JFrameimg frame4 = new JFrameimg(ruidosus);
            Image ruidomezadi = Espacial.Ruido.agregarRuidoMezcladoAditivo(imagen, 80);
            JFrameimg frame5 = new JFrameimg(ruidomezadi);
            Image ruidomezmulti = Espacial.Ruido.agregarRuidoMezcladoMultiplicativo(imagen, 80);
            JFrameimg frame6 = new JFrameimg(ruidomezmulti);
            */
            
            convolucion convu = new convolucion(Herramientas.HerramientasImagen.toBufferedImage(imagen));
            Image Matriz3x3 = convu.convolucionar(new int[]{0,-1,0,
                                                            -1,5,-1,
                                                             0,-1,0}, 1);
            convolucion convu5x5 = new convolucion(Herramientas.HerramientasImagen.toBufferedImage(imagen));
            Image Matriz5X5 = convu5x5.convolucionar5x5(new int[]{1,1,1,1,1,
                                                                  1,4,4,4,1,
                                                                  1,4,12,4,1,
                                                                  1,4,4,4,1,
                                                                  1,1,1,1,1}, 1);
            
            JFrameimg frame2 = new JFrameimg(Matriz3x3);
            
            JFrameimg frame3 = new JFrameimg(Matriz5X5);
            
            //mascaras para desenfoque y enfoque 
            
    }
    
    
    
}
