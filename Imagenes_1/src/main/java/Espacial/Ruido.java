/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author stimp
 */
public class Ruido {
    public static Image agregarRuidoAditivo(Image original, double por){
    BufferedImage bi = Herramientas.HerramientasImagen.toBufferedImage(original);
    //double aux = por/100;       
    double cp = (double)((por/100)*(bi.getHeight()*bi.getWidth()));
    Color aditivo = new Color(255,255,255);
    Random ran = new Random();
    int x,y;
        for (int j = 0; j < cp; j++) {
            //posicion aleatoria dentro de la imagen
            x = ran.nextInt(bi.getWidth());
            y = ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, aditivo.getRGB());
        }
    return Herramientas.HerramientasImagen.toImage(bi);
    }
    public static Image agregarRuidoSustractivo(Image original, double porcentaje) {
    BufferedImage bi = Herramientas.HerramientasImagen.toBufferedImage(original);
    double cantidadPixels = (porcentaje / 100) * (bi.getHeight() * bi.getWidth());

    Random random = new Random();
    for (int j = 0; j < cantidadPixels; j++) {
        int x = random.nextInt(bi.getWidth());
        int y = random.nextInt(bi.getHeight());

        // Restar un valor aleatorio al componente de luminancia (gris) de cada píxel
        Color colorOriginal = new Color(bi.getRGB(x, y));
        int nuevoGris = Math.max(0, colorOriginal.getRed() - random.nextInt(256));
        Color nuevoColor = new Color(nuevoGris, nuevoGris, nuevoGris);

        bi.setRGB(x, y, nuevoColor.getRGB());
    }

    return Herramientas.HerramientasImagen.toImage(bi);
}
public static Image agregarRuidoMezcladoAditivo(Image original, double porcentaje) {
    BufferedImage bi = Herramientas.HerramientasImagen.toBufferedImage(original);
    double cantidadPixels = (porcentaje / 100) * (bi.getHeight() * bi.getWidth());

    Random random = new Random();
    for (int j = 0; j < cantidadPixels; j++) {
        int x = random.nextInt(bi.getWidth());
        int y = random.nextInt(bi.getHeight());

        // Sumar un valor aleatorio al componente de luminancia (gris) de cada píxel
        Color colorOriginal = new Color(bi.getRGB(x, y));
        int nuevoGris = Math.min(255, colorOriginal.getRed() + random.nextInt(256));
        Color nuevoColor = new Color(nuevoGris, nuevoGris, nuevoGris);

        bi.setRGB(x, y, nuevoColor.getRGB());
    }

    return Herramientas.HerramientasImagen.toImage(bi);
}

public static Image agregarRuidoMezcladoMultiplicativo(Image original, double porcentaje) {
    BufferedImage bi = Herramientas.HerramientasImagen.toBufferedImage(original);
    double cantidadPixels = (porcentaje / 100) * (bi.getHeight() * bi.getWidth());

    Random random = new Random();
    for (int j = 0; j < cantidadPixels; j++) {
        int x = random.nextInt(bi.getWidth());
        int y = random.nextInt(bi.getHeight());

        // Multiplicar el componente de luminancia (gris) por un valor aleatorio
        Color colorOriginal = new Color(bi.getRGB(x, y));
        int nuevoGris = (int) (colorOriginal.getRed() * (1.0 + random.nextDouble()));
        nuevoGris = Math.min(255, nuevoGris);
        Color nuevoColor = new Color(nuevoGris, nuevoGris, nuevoGris);

        bi.setRGB(x, y, nuevoColor.getRGB());
    }

    return Herramientas.HerramientasImagen.toImage(bi);
}

}
