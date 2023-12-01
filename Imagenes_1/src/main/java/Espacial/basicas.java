/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espacial;

import Herramientas.Graficador;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author stimp
 */
public class basicas {
    
    public static Image escalaDeGrises(Image original){
    
        BufferedImage aux = Herramientas.HerramientasImagen.toBufferedImage(original);
        
        for(int x=0;x<aux.getWidth();x++){
        for(int y=0;y<aux.getHeight();y++){
        
            int c = aux.getRGB(x, y);
            
            Color c2 = new Color(c);
            int prom;
            prom=(c2.getRed()+c2.getGreen()+c2.getBlue())/3;
           // System.out.println(prom);
            c2 = new Color(prom,prom,prom);
            aux.setRGB(x, y, c2.getRGB());
            
        }}
        Image img = Herramientas.HerramientasImagen.toImage(aux);
        
                
        return aux;
    
    
    }
    public static Image blancoYNegro(Image imagen, int umbral) {
        // Convertir la imagen a un objeto BufferedImage
        BufferedImage imagenBuffered = Herramientas.HerramientasImagen.toBufferedImage(imagen);
        int ancho = imagenBuffered.getWidth();
        int alto = imagenBuffered.getHeight();

        // Recorrer todos los píxeles de la imagen
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                // Obtener el color del píxel
                Color color = new Color(imagenBuffered.getRGB(x, y));

                // Calcular el valor de gris promedio del píxel
                int valorGris = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                // Aplicar el umbral de blanco y negro
                if (valorGris >= umbral) {
                    imagenBuffered.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    imagenBuffered.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        } return imagenBuffered.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
    }
    
    public static double[] histogramaGrises(Image imagen) {
        
          BufferedImage bufferedImage = Herramientas.HerramientasImagen.toBufferedImage(imagen);
      
    double[] cG = new double[256];
    for(int i=0;i<bufferedImage.getWidth();i++){
       for(int j=0;j<bufferedImage.getHeight();j++){
            Color col = new Color(bufferedImage.getRGB(i, j));
       
    cG[col.getRed()]=cG[col.getRed()]+1;
 }
    }   
   Graficador g = new Graficador("EjeX","EjeY","Grafica1");
        g.agregarSerie("gris", cG);
        g.crearGrafica();
        g.muestraGrafica();
        
 return cG;}
    
    
    public static Image negativoImagen(Image original){
    
        
         BufferedImage aux = Herramientas.HerramientasImagen.toBufferedImage(original);
       
         
    for(int x=0;x<aux.getWidth();x++){
        for(int y=0;y<aux.getHeight();y++){
        
        int pixel = aux.getRGB(x, y);
            
         Color c2 = new Color(pixel);
        
         int alpha = (pixel >> 24) & 0xFF;
                    int red = 255 - ((pixel >> 16) & 0xFF);
                    int green = 255 - ((pixel >> 8) & 0xFF);
                    int blue = 255 - (pixel & 0xFF);

                    // Combina los componentes en un nuevo píxel
                    int negativePixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                    aux.setRGB(x, y, negativePixel);
                    
        }}
    
    return aux;}
    
    public static Image negativoConIntensidad(Image imagen, int intensidad) {
        // Convertir la imagen a un objeto BufferedImage
        BufferedImage imagenBuffered = Herramientas.HerramientasImagen.toBufferedImage(imagen);
        int ancho = imagenBuffered.getWidth();
        int alto = imagenBuffered.getHeight();

        // Calcular la máxima intensidad posible (255) menos la intensidad especificada
       

        // Recorrer todos los píxeles de la imagen
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                 int maxIntensidad = 255 - intensidad;
                // Obtener el color del píxel
                Color color = new Color(imagenBuffered.getRGB(x, y));

                // Calcular el negativo del color con la intensidad especificada
                int nuevoRojo = maxIntensidad - color.getRed();
                int nuevoVerde = maxIntensidad - color.getGreen();
                int nuevoAzul = maxIntensidad - color.getBlue();

                // Crear un nuevo color con los componentes negativos
                Color nuevoColor = new Color(nuevoRojo, nuevoVerde, nuevoAzul);

                // Establecer el nuevo color en el píxel
                imagenBuffered.setRGB(x, y, nuevoColor.getRGB());
            }
        }

        // Convertir el BufferedImage de nuevo a Image
        return imagenBuffered.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
    }
    
    public static void Histograma(Image original){
         BufferedImage bufferedImage = Herramientas.HerramientasImagen.toBufferedImage(original);
       
      double[] cR = new double[256];
        double[] cG = new double[256];
        double[] cB = new double[256];
    
   
    for(int i=0;i<bufferedImage.getWidth();i++){
       for(int j=0;j<bufferedImage.getHeight();j++){
       Color col = new Color(bufferedImage.getRGB(i, j));
       
               cR[col.getRed()]=cR[col.getRed()]+1;
               cG[col.getGreen()]=cR[col.getGreen()]+1;
               cB[col.getBlue()]=cR[col.getBlue()]+1;
       }
    }
    
                 Graficador g = new Graficador("EjeX","EjeY","Grafica1");
        g.agregarSerie("rojo", cR);
        g.agregarSerie("verde", cG);
        g.agregarSerie("azul", cB);
        g.crearGrafica();
        g.muestraGrafica();
      
    
       
     }
    
    public static Image aumentarBrillo(Image imagen, int incrementoBrillo) {
        // Convertir la imagen a un objeto BufferedImage
        BufferedImage imagenBuffered = Herramientas.HerramientasImagen.toBufferedImage(imagen);
        int ancho = imagenBuffered.getWidth();
        int alto = imagenBuffered.getHeight();

        // Recorrer todos los píxeles de la imagen
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                // Obtener el color del píxel
                Color color = new Color(imagenBuffered.getRGB(x, y));

                // Calcular el nuevo color con brillo aumentado
                int nuevoRojo = Math.min(255, color.getRed() + incrementoBrillo);
                int nuevoVerde = Math.min(255, color.getGreen() + incrementoBrillo);
                int nuevoAzul = Math.min(255, color.getBlue() + incrementoBrillo);

                // Crear un nuevo color con el brillo aumentado
                Color nuevoColor = new Color(nuevoRojo, nuevoVerde, nuevoAzul);

                // Establecer el nuevo color en el píxel
                imagenBuffered.setRGB(x, y, nuevoColor.getRGB());
            }
        }

        // Convertir el BufferedImage de nuevo a Image
        return imagenBuffered.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
    }
    
    }
    

