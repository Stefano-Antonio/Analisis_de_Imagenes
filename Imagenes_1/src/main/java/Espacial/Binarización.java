/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author stimp
 */
public class Binarización {
    
    public static Image binarizarImagen(Image original, int j){
    
        BufferedImage aux = Herramientas.HerramientasImagen.toBufferedImage(original);
        
           
        
        for(int x=0;x<aux.getWidth();x++){
        for(int y=0;y<aux.getHeight();y++){
            Color c = new Color(aux.getRGB(x,y));
            int base = c.getBlue();
            if (base>=j) base = 255;
            if (base<j) base =0;
            c = new Color(base,base,base);
            aux.setRGB(x, y, c.getRGB());
            
         }
}   
            
        Image img = Herramientas.HerramientasImagen.toImage(aux);
        
        
        return img;
    
    
    }

public static Image binarizarImagen(Image original, int J1,int J2){
    
        BufferedImage aux = Herramientas.HerramientasImagen.toBufferedImage(original);
        
        
        for(int x=0;x<aux.getWidth();x++){
        for(int y=0;y<aux.getHeight();y++){
         Color c = new Color(aux.getRGB(x, y));

                int gray = (int) (c.getRed() * 0.299 + c.getGreen() * 0.587 + c.getBlue() * 0.114);

                if (gray >= J1 && gray <= J2) {
                    aux.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    aux.setRGB(x, y, Color.BLACK.getRGB());
                }
            
        }}

return aux;

}

public static Image BinarizacionAutomatica(Image original){

BufferedImage aux = Herramientas.HerramientasImagen.toBufferedImage(original);
        





return aux;
}}