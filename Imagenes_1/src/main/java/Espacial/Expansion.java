/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espacial;

import static Herramientas.HerramientasImagen.toBufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author stimp
 */
public class Expansion {
    public static Image expandir(Image original,double a[]){
      
                BufferedImage aux = toBufferedImage(original);

            int r1 = 255; 
            int r2 = 0;   
         for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
              r1 = Math.min(r1, i);
              r2 = Math.max(r2, i);
                 }
                }
            for (int x=0; x < aux.getWidth();x++){
                     for (int y=0; y < aux.getHeight();y++){
                 // obtener el color
                 Color pixel = new Color (aux.getRGB(x, y));
                 int r = validar((pixel.getRed()-r1)* (255/ (r2-r1)));
                 int g = validar((pixel.getGreen()-r1)* (255 / (r2-r1)));
                 int b = validar((pixel.getBlue()-r1)*(255/(r2-r1)));
                 // validamos
                 pixel = new Color(r, g, b);
                 aux.setRGB(x, y, pixel.getRGB());
    }}
    return aux;}
    public static int validar(double valor) {
        if (valor < 0) {
            return 0;
        } else if (valor > 255) {
            return 255;
        } else {
            return (int) valor;
        }
    }
}
