/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espacial;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartColor;


public class convolucion {


    BufferedImage imagenOrg;

public convolucion(BufferedImage imagenOrg){
        this.imagenOrg = imagenOrg;

}
public Image convolucionar(int[] mascara, int div){
    Color nuevo;
    BufferedImage aux = new BufferedImage(this.imagenOrg.getWidth(),this.imagenOrg.getHeight(),this.imagenOrg.getType());
    for(int x=0;x<this.imagenOrg.getWidth();x++){
        for(int y=0;y<this.imagenOrg.getHeight();y++){
        
     //nuevo tono
    int rgb = convolucionar(x,y,mascara,div);
     nuevo = new Color(rgb);
    aux.setRGB(x,y, nuevo.getRGB());
        }}
return  Herramientas.HerramientasImagen.toImage(aux);}

public Image convolucionar5x5(int[] mascara, int div){
    Color nuevo;
    BufferedImage aux = new BufferedImage(this.imagenOrg.getWidth(),this.imagenOrg.getHeight(),this.imagenOrg.getType());
    for(int x=0;x<this.imagenOrg.getWidth();x++){
        for(int y=0;y<this.imagenOrg.getHeight();y++){
        
     //nuevo tono
    int rgb = convolucionarM5(x,y,mascara,div);
     nuevo = new Color(rgb);
    aux.setRGB(x,y, nuevo.getRGB());
        }}
return  Herramientas.HerramientasImagen.toImage(aux);}

    private int convolucionar(int x, int y, int[] mascara,int div) {
     
    Color aux;
    int aR=0,aG=0,aB=0;
    aux = new Color(this.imagenOrg.getRGB(x, y));
    for(int j=0; j<mascara.length;j++){
        //canales
        int rgb = obtenerRGB(x,y,j);
        if(rgb!=0){
        aux = new Color(rgb);
        aR += aux.getRed()*mascara[j];
        aG += aux.getGreen()*mascara[j];
        aB += aux.getBlue()*mascara[j];
        }
    }
    //evaluar divicion:
    aR/=div;
    aG/=div;
    aB/=div;
    aux = new Color(Espacial.Expansion.validar(aR), Espacial.Expansion.validar(aG), Espacial.Expansion.validar(aB));
    return aux.getRGB();
    }

    private int obtenerRGB(int x, int y, int j) {
       int rgb = 0;
       try{
       switch (j){
           case 0:{
               if((x-1<0) || (y-1<0))return 0;
               if((x-1>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y-1);
             break;
           }
           case 1:{
           if((x-1<0) || (y<0))return 0;
               if((x-1>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y);
             break;  }
           case 2:{
           if((x-1<0) || (y+1<0))return 0;
               if((x-1>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y+1);
             break;  
           }
           case 3:{
           if((x<0) || (y-1<0))return 0;
               if((x>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y-1);
             break;  
           }
           case 4:{
           if((x<0) || (y<0))return 0;
               if((x>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y);
             break;   
           }
           case 5:{
           if((x<0) || (y+1<0))return 0;
               if((x>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y+1);
             break;   
           }
           case 6:{
           if((x+1<0) || (y-1<0))return 0;
               if((x+1>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y-1);
             break;   
           }
           case 7:{
           if((x+1<0) || (y<0))return 0;
               if((x+1>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y);
             break;  
           }
           case 8:{
           if((x+1<0) || (y+1<0)){return 0;}
               if((x+1>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y+1);
             break;  
           }}
       }catch (Exception e){
           System.out.println();}
    return rgb;}
    
    
    private int convolucionarM5(int x, int y, int[] mascara,int div) {
     
    Color aux;
    int aR=0,aG=0,aB=0;
    aux = new Color(this.imagenOrg.getRGB(x, y));
    for(int j=0; j<mascara.length;j++){
        //canales
        int rgb = obtenerRGB2(x,y,j);
        if(rgb!=0){
        aux = new Color(rgb);
        aR += aux.getRed()*mascara[j];
        aG += aux.getGreen()*mascara[j];
        aB += aux.getBlue()*mascara[j];
        }
    }
    //evaluar divicion:
    aR/=div;
    aG/=div;
    aB/=div;
    aux = new Color(Espacial.Expansion.validar(aR), Espacial.Expansion.validar(aG), Espacial.Expansion.validar(aB));
    return aux.getRGB();
    }

    private int obtenerRGB2(int x, int y, int j) {
       int rgb = 0;
       try{
       switch (j){
           case 0:{
               if((x-2<0) || (y+2<0))return 0;
               if((x-2>=this.imagenOrg.getWidth())||(y+2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-2,y+2);
             break;
           }
           case 1:{
           if((x-2<0) || (y+1<0))return 0;
               if((x-2>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-2,y+1);
             break;  }
           case 2:{
           if((x-2<0) || (y<0))return 0;
               if((x-2>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-2,y);
             break;  
           }
           case 3:{
           if((x-2<2) || (y-1<0))return 0;
               if((x-2>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-2,y-1);
             break;  
           }
           case 4:{
           if((x-2<0) || (y-2<0))return 0;
               if((x-2>=this.imagenOrg.getWidth())||(y-2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-2,y-2);
             break;   
           }
           case 5:{
           if((x-1<0) || (y+2<0))return 0;
               if((x-1>=this.imagenOrg.getWidth())||(y+2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y+2);
             break;   
           }
           case 6:{
           if((x-1<0) || (y+1<0))return 0;
               if((x-1>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y+1);
             break;   
           }
           case 7:{
           if((x-1<0) || (y<0))return 0;
               if((x-1>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y);
             break;  
           }
           case 8:{
           if((x-1<0) || (y-1<0)){return 0;}
               if((x-1>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y-1);
             break;  
           }
            case 9:{
           if((x-1<0) || (y-2<0)){return 0;}
               if((x-1>=this.imagenOrg.getWidth())||(y-2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x-1,y-2);
             break;  
           } case 10:{
           if((x<0) || (y+2<0)){return 0;}
               if((x>=this.imagenOrg.getWidth())||(y+2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y+2);
             break;  
           } case 11:{
           if((x<0) || (y+1<0)){return 0;}
               if((x>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y+1);
             break;  
           } case 12:{
           if((x<0) || (y<0)){return 0;}
               if((x>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y);
             break;  
           } case 13:{
           if((x<0) || (y-1<0)){return 0;}
               if((x>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y-1);
             break;  
           } case 14:{
           if((x<0) || (y-2<0)){return 0;}
               if((x+1>=this.imagenOrg.getWidth())||(y-2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x,y-2);
             break;  
           } case 15:{
           if((x+1<0) || (y-2<0)){return 0;}
               if((x+2>=this.imagenOrg.getWidth())||(y-2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y-2);
             break;  
           } case 16:{
           if((x+1<0) || (y-1<0)){return 0;}
               if((x+1>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y-1);
             break;  
           } case 17:{
           if((x+1<0) || (y<0)){return 0;}
               if((x+1>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y);
             break;  
           } case 18:{
           if((x+1<0) || (y+1<0)){return 0;}
               if((x+1>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y+1);
             break;  
           } case 19:{
           if((x+1<0) || (y+2<0)){return 0;}
               if((x+1>=this.imagenOrg.getWidth())||(y+2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+1,y+2);
             break;  
           } case 20:{
           if((x+2<0) || (y-2<0)){return 0;}
               if((x+2>=this.imagenOrg.getWidth())||(y-2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+2,y-2);
             break;  
           } case 21:{
           if((x+2<0) || (y-1<0)){return 0;}
               if((x+2>=this.imagenOrg.getWidth())||(y-1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+2,y-1);
             break;  
           } case 22:{
           if((x+2<0) || (y<0)){return 0;}
               if((x+2>=this.imagenOrg.getWidth())||(y>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+2,y);
             break;  
           } case 23:{
           if((x+2<0) || (y+1<0)){return 0;}
               if((x+2>=this.imagenOrg.getWidth())||(y+1>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+2,y+1);
             break;  
           } case 24:{
           if((x+2<0) || (y+2<0)){return 0;}
               if((x+2>=this.imagenOrg.getWidth())||(y+2>=this.imagenOrg.getHeight()))return 0;  
             rgb = this.imagenOrg.getRGB(x+2,y+2);
             break;  
           }
       }
       }catch (Exception e){
           System.out.println();}
    return rgb;}
}