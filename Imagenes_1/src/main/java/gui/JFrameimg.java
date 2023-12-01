/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import static Herramientas.HerramientasImagen.toBufferedImage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

/**
 *
 * @author stimp
 */
public class JFrameimg extends JFrame{
    
    private JLabel lbimagen;
    
    public JFrameimg(Image imagen){
        Inicializarcomponentes(imagen);
    }
    
    private void Inicializarcomponentes(Image imagen){
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.lbimagen = new JLabel();
    add(this.lbimagen);
    this.lbimagen.setIcon(new ImageIcon(imagen));
    setSize(imagen.getWidth(this), imagen.getHeight(this)); // Establece el tamaño del JFrame según las dimensiones de la imagen
    setVisible(true);
        
    }
    
    //imagen to bufferedimage
  

}
