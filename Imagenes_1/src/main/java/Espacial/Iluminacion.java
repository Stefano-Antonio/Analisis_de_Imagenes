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
public class Iluminacion {
    
    public static Image AumentoBrillo(Image original,int j,int r){
    
     BufferedImage aux = Herramientas.HerramientasImagen.toBufferedImage(original);
        
     for(int x=0;x<aux.getWidth();x++){
        for(int y=0;y<aux.getHeight();y++){
        
            int c = (aux.getRGB(x, y) >> 16) & 0xFF;
               

            if(c>j){
            
            c = Math.min(255, c + r);
            int nuevoPixel = (c << 16) | (c << 8) | c;
                aux.setRGB(x, y, nuevoPixel);
            }
            
        }}
    
    return aux;}
}
