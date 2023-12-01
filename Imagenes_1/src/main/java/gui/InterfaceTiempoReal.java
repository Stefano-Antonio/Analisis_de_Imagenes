/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import Espacial.convolucion;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author stimp
 */
public class InterfaceTiempoReal extends JFrame {
    
  private static final int MATRIX_SIZE = 25;
  private Image ImagenMod;
  private int[] matrixFields = new int[MATRIX_SIZE];
  private int Div;
  private int PorR;
      public InterfaceTiempoReal(Image imagen) {
        initComponents();
     //obtener valores de imagen:
        int w = imagen.getWidth(null);
        int h = imagen.getHeight(null);
        Image escalada = Herramientas.HerramientasImagen.toBufferedImage(imagen).getScaledInstance(w/3, h/3, BufferedImage.TYPE_INT_RGB);
     //Agregar imagen original al JLabel:
        this.originalImage.setIcon(new ImageIcon(imagen));
     //configuracion de la ventana
        setTitle("Editor");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // Configurar Slider1 blanco y negro:
        jSlider1.setMinimum(0);
        jSlider1.setMaximum(255);
        jSlider1.setValue(0);
     //agregar ChangeListeners para actualizar los JLabels:
        jSlider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int valorSlider1 = jSlider1.getValue();
                ValorSlider1.setText("Valor: " + valorSlider1);
                BlancoyNegro(imagen);
            }
        });
     //slider2 negativo:
        jSlider2.setMinimum(0);
        jSlider2.setMaximum(255);
        jSlider2.setValue(0);
     //agregar ChangeListeners para actualizar los JLabels:
        jSlider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int valorSlider2 = jSlider2.getValue();
                ValorSlider2.setText("Valor: " + valorSlider2);
                AplicarNegativo(imagen);
            }
        });
        //slider3 brillo:
        JSlider3.setMinimum(0);
        JSlider3.setMaximum(255);
        JSlider3.setValue(0);
        //agregar ChangeListeners para actualizar los JLabels:
        JSlider3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int valorSlider3 = JSlider3.getValue();
                ValorSlider3.setText("Valor: " + valorSlider3);
                Brillo(imagen);
         
            }
        });
        //boton para agrergar los numero de la tabla
        // Crear un ActionListener para el botón
        ActionListener guardarMatrizAction = new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
            guardarMatriz();
            }
            };
        ActionListener guardarDiv = new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
            guardarDiv();
            }
            };
        ActionListener Mostrar = new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
            Convolucion(imagen);
            }
            };
         // Asignar el ActionListener al botón
          ConvBot.addActionListener( guardarMatrizAction);
          ConvBot.addActionListener(guardarDiv);
          AplicarConvBot.addActionListener(Mostrar);
        //agregar Acciones de ruido
         
          //guardar porcentaje de rudi:
          ActionListener guardarporR = new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
            guardarPorR();
            }
            };
          
          GuardarR.addActionListener(guardarporR);
          // Agrega un ActionListener a la tabla de seleccion de ruido:
         // Define el ActionListener para el JComboBox
ActionListener comboBoxListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtén la opción seleccionada
        String opcionSeleccionada = (String) SeleccRuidoList.getSelectedItem();
        //eliminaacciones anteriores
        ActionListener[] actionListeners = RuidBot.getActionListeners();
    for (ActionListener listener : actionListeners) {
        RuidBot.removeActionListener(listener);
    }
        // Actualiza la lógica del ActionListener del botón basándote en la opción seleccionada
        RuidBot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción seleccionada
                switch (opcionSeleccionada) {
                    case "RuidoAditivo":
                        Ruido(imagen, PorR);
                        break;
                    case "RuidoSustractivo":
                        RuidoMezcladoAditivo(imagen, PorR);
                        break;
                    case "RuidoMezclado":
                        RuidoSustractivo(imagen, PorR);
                        break;
                    // Agrega más casos según sea necesario
                }
            }
        });
    }
};

         
         SeleccRuidoList.addActionListener(comboBoxListener);

         

        
        
}
      private void guardarMatriz() {
       // int[] matriz = new int[MATRIX_SIZE];

      
                try {
                    
                  matrixFields[0] = Integer.parseInt(x_2y_2.getText());
                  matrixFields[1] = Integer.parseInt(x_2y_1.getText());
                  matrixFields[2] = Integer.parseInt(x_2y.getText());
                  matrixFields[3] = Integer.parseInt(x_2y1.getText());
                  matrixFields[4] = Integer.parseInt(x_2y2.getText());
                  matrixFields[5] = Integer.parseInt(x_1y_2.getText());
                  matrixFields[6] = Integer.parseInt(x_1y_1.getText());
                  matrixFields[7] = Integer.parseInt(x_1y.getText());
                  matrixFields[8] = Integer.parseInt(x_1y1.getText());
                  matrixFields[9] = Integer.parseInt(x_1y2.getText());
                  matrixFields[10] = Integer.parseInt(xy_2.getText());
                  matrixFields[11] = Integer.parseInt(xy_1.getText());
                  matrixFields[12] = Integer.parseInt(xy.getText());
                  matrixFields[13] = Integer.parseInt(xy1.getText());
                  matrixFields[14] = Integer.parseInt(xy2.getText());
                  matrixFields[15] = Integer.parseInt(x1y_2.getText());
                  matrixFields[16] = Integer.parseInt(x1y_1.getText());
                  matrixFields[17] = Integer.parseInt(x1y.getText());
                  matrixFields[18] = Integer.parseInt(x1y1.getText());
                  matrixFields[19] = Integer.parseInt(x1y2.getText());
                  matrixFields[20] = Integer.parseInt(x2y_2.getText());
                  matrixFields[21] = Integer.parseInt(x2y_1.getText());
                  matrixFields[22] = Integer.parseInt(x2y.getText());
                  matrixFields[23] = Integer.parseInt(x2y1.getText());
                  matrixFields[24] = Integer.parseInt(x2y2.getText());
                  matrixFields[25] = Integer.parseInt(x2y2.getText());
                  
                } catch (NumberFormatException e) {
                    // Manejar la excepción si el usuario ingresa algo que no es un número
                    e.printStackTrace();
                }
            
      }
      //guardar valor div de la tabla de convolucion
      private void guardarDiv() {
     
      
                try {
                    
                  Div = Integer.parseInt(DivConvLab.getText());
                  
                } catch (NumberFormatException e) {
                    // Manejar la excepción si el usuario ingresa algo que no es un número
                    e.printStackTrace();
                }
            
      }
      //guardar porcentaje de ruido
      private void guardarPorR() {
     
      
                try {
                    
                  PorR = Integer.parseInt(PorRuidLab.getText());
                  
                } catch (NumberFormatException e) {
                    // Manejar la excepción si el usuario ingresa algo que no es un número
                    e.printStackTrace();
                }
            
      }
      
     private void Convolucion(Image imagen){
        int[] matriz = new int[MATRIX_SIZE];
            convolucion convu5x5 = new convolucion(Herramientas.HerramientasImagen.toBufferedImage(imagen));
            Image Matriz5X5 = convu5x5.convolucionar5x5(matrixFields, Div);
            ImagenMod = convu5x5.convolucionar5x5(matrixFields, Div);

            this.ModImagen.setIcon(new ImageIcon(ImagenMod));
      }
     private void BlancoyNegro(Image imagen) {
        int valorSlider1 = jSlider1.getValue();
        
        Image ByN = Espacial.basicas.blancoYNegro(ImagenMod, valorSlider1);
// ...
        // Actualizar el JLabel originalImage con la nueva imagen
        this.ModImagen.setIcon(new ImageIcon(ByN));
    }
     private void AplicarNegativo(Image imagen) {
        int valorSlider2 = jSlider2.getValue();
        
        Image neg = Espacial.basicas.negativoConIntensidad(ImagenMod, valorSlider2);
        // ...
        // Actualizar el JLabel originalImage con la nueva imagen
        this.ModImagen.setIcon(new ImageIcon(neg));
    }
     private void Brillo(Image imagen) {
        int valorSlider3 = JSlider3.getValue();
        
        Image Brill = Espacial.basicas.aumentarBrillo(ImagenMod, valorSlider3);
        // ...
        // Actualizar el JLabel originalImage con la nueva imagen
        this.ModImagen.setIcon(new ImageIcon(Brill));
    }
     private void Ruido(Image imagen, int porcentaje){
      
       Image ruido = Espacial.Ruido.agregarRuidoAditivo(imagen, porcentaje);
       this.ModImagen.setIcon(new ImageIcon(ruido));
     
     }
     private void RuidoMezcladoAditivo(Image imagen, int porcentaje){
      
       ImagenMod = Espacial.Ruido.agregarRuidoMezcladoMultiplicativo(imagen, porcentaje);
       this.ModImagen.setIcon(new ImageIcon(ImagenMod));
     
     }
     private void RuidoSustractivo(Image imagen, int porcentaje){
      
       Image ruidoS = Espacial.Ruido.agregarRuidoSustractivo(imagen, porcentaje);
       this.ModImagen.setIcon(new ImageIcon(ruidoS));
     
     }
/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        originalImage = new javax.swing.JLabel();
        ModImagen = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        ValorSlider1 = new javax.swing.JLabel();
        ValorSlider2 = new javax.swing.JLabel();
        JSlider3 = new javax.swing.JSlider();
        ValorSlider3 = new javax.swing.JLabel();
        ByNText = new javax.swing.JLabel();
        BrllText = new javax.swing.JLabel();
        NegText = new javax.swing.JLabel();
        ImgOText = new javax.swing.JLabel();
        ImgRText = new javax.swing.JLabel();
        SeleccRuidoList = new javax.swing.JComboBox<>();
        PorRuidLab = new javax.swing.JTextField();
        x2y_2 = new javax.swing.JTextField();
        x2y_1 = new javax.swing.JTextField();
        x2y = new javax.swing.JTextField();
        x_2y_2 = new javax.swing.JTextField();
        x_2y = new javax.swing.JTextField();
        x_2y_1 = new javax.swing.JTextField();
        x_1y_2 = new javax.swing.JTextField();
        x_1y_1 = new javax.swing.JTextField();
        x_1y = new javax.swing.JTextField();
        x2y2 = new javax.swing.JTextField();
        x2y1 = new javax.swing.JTextField();
        x_2y1 = new javax.swing.JTextField();
        x_1y1 = new javax.swing.JTextField();
        x_2y2 = new javax.swing.JTextField();
        x_1y2 = new javax.swing.JTextField();
        xy_1 = new javax.swing.JTextField();
        xy_2 = new javax.swing.JTextField();
        xy1 = new javax.swing.JTextField();
        xy = new javax.swing.JTextField();
        x1y_2 = new javax.swing.JTextField();
        x1y_1 = new javax.swing.JTextField();
        x1y = new javax.swing.JTextField();
        x1y1 = new javax.swing.JTextField();
        xy2 = new javax.swing.JTextField();
        x1y2 = new javax.swing.JTextField();
        DivConvLab = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RuidBot = new javax.swing.JButton();
        ConvBot = new javax.swing.JButton();
        AplicarConvBot = new javax.swing.JButton();
        GuardarR = new javax.swing.JButton();

        originalImage.setText("ImagenOrg");

        ModImagen.setText("imagenMod");

        ValorSlider1.setText("0");

        ValorSlider2.setText("0");

        ValorSlider3.setText("0");

        ByNText.setText("Blanco y Negro");

        BrllText.setText("Brillo");

        NegText.setText("Negativo");

        ImgOText.setText("Imagen Original");

        ImgRText.setText("Imagen Resultante");

        SeleccRuidoList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Tipo de Ruido", "RuidoAditivo", "RuidoSustractivo", "RuidoMezclado" }));
        SeleccRuidoList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccRuidoListActionPerformed(evt);
            }
        });

        PorRuidLab.setText("0");
        PorRuidLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorRuidLabActionPerformed(evt);
            }
        });

        x2y_2.setText("0");
        x2y_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2y_2ActionPerformed(evt);
            }
        });

        x2y_1.setText("0");
        x2y_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2y_1ActionPerformed(evt);
            }
        });

        x2y.setText("0");

        x_2y_2.setText("0");

        x_2y.setText("0");

        x_2y_1.setText("0");
        x_2y_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_2y_1ActionPerformed(evt);
            }
        });

        x_1y_2.setText("0");

        x_1y_1.setText("0");

        x_1y.setText("0");
        x_1y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_1yActionPerformed(evt);
            }
        });

        x2y2.setText("0");
        x2y2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2y2ActionPerformed(evt);
            }
        });

        x2y1.setText("0");

        x_2y1.setText("0");

        x_1y1.setText("0");

        x_2y2.setText("0");
        x_2y2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_2y2ActionPerformed(evt);
            }
        });

        x_1y2.setText("0");

        xy_1.setText("0");

        xy_2.setText("0");

        xy1.setText("0");

        xy.setText("0");

        x1y_2.setText("0");

        x1y_1.setText("0");

        x1y.setText("0");

        x1y1.setText("0");

        xy2.setText("0");

        x1y2.setText("0");

        DivConvLab.setText("1");

        jLabel1.setText("Tipo de ruido");

        jLabel2.setText("Porcentaje de ruido");

        jLabel3.setText("Tabla convolucion");

        jLabel4.setText("Div convolucion");

        RuidBot.setText("Aplicar");
        RuidBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RuidBotActionPerformed(evt);
            }
        });

        ConvBot.setText("Guardar");
        ConvBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvBotActionPerformed(evt);
            }
        });

        AplicarConvBot.setText("Aplicar");

        GuardarR.setText("Guardar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(ByNText)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(SeleccRuidoList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(PorRuidLab, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(ValorSlider3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(ValorSlider2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(ValorSlider1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(BrllText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(NegText)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ConvBot)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(x2y_2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x2y_1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x2y, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x2y1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x2y2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AplicarConvBot))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(x1y_2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x1y_1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x1y, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x1y1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x1y2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(x_1y_2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(xy_2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(xy_1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xy, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(xy1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(x_1y_1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x_1y, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x_1y1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(x_1y2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(xy2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(DivConvLab, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(x_2y_2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x_2y_1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x_2y, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x_2y1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(x_2y2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(GuardarR)
                                        .addGap(32, 32, 32)
                                        .addComponent(RuidBot)))
                                .addGap(6, 6, 6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgOText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgRText)
                    .addComponent(ModImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ImgOText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(originalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ByNText)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PorRuidLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeleccRuidoList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ImgRText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarR)
                    .addComponent(ValorSlider1)
                    .addComponent(RuidBot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(BrllText, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_2y_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_2y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_2y_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_2y1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_2y2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ValorSlider3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NegText)
                        .addGap(12, 12, 12)
                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValorSlider2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(x_1y_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_1y_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_1y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_1y1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x_1y2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xy_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xy_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DivConvLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(x1y_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x1y_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x1y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x1y1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x1y2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(x2y_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x2y_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x2y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x2y1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x2y2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConvBot)
                    .addComponent(AplicarConvBot))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PorRuidLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorRuidLabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PorRuidLabActionPerformed

    private void x_1yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_1yActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x_1yActionPerformed

    private void x_2y_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_2y_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x_2y_1ActionPerformed

    private void x2y_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x2y_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x2y_2ActionPerformed

    private void x_2y2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_2y2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x_2y2ActionPerformed

    private void x2y_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x2y_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x2y_1ActionPerformed

    private void x2y2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x2y2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x2y2ActionPerformed

    private void SeleccRuidoListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccRuidoListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccRuidoListActionPerformed

    private void RuidBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RuidBotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RuidBotActionPerformed

    private void ConvBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvBotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConvBotActionPerformed

    public static void main(String args[]) {
        
    //obtenerImagen
    Image imagen = Herramientas.HerramientasImagen.abrirImagen();
    //abrir venata:
    InterfaceTiempoReal ventana = new InterfaceTiempoReal(imagen);
    ventana.setVisible(true);
    
    
    
    
 }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AplicarConvBot;
    private javax.swing.JLabel BrllText;
    private javax.swing.JLabel ByNText;
    private javax.swing.JButton ConvBot;
    private javax.swing.JTextField DivConvLab;
    private javax.swing.JButton GuardarR;
    private javax.swing.JLabel ImgOText;
    private javax.swing.JLabel ImgRText;
    private javax.swing.JSlider JSlider3;
    private javax.swing.JLabel ModImagen;
    private javax.swing.JLabel NegText;
    private javax.swing.JTextField PorRuidLab;
    private javax.swing.JButton RuidBot;
    private javax.swing.JComboBox<String> SeleccRuidoList;
    private javax.swing.JLabel ValorSlider1;
    private javax.swing.JLabel ValorSlider2;
    private javax.swing.JLabel ValorSlider3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JLabel originalImage;
    private javax.swing.JTextField x1y;
    private javax.swing.JTextField x1y1;
    private javax.swing.JTextField x1y2;
    private javax.swing.JTextField x1y_1;
    private javax.swing.JTextField x1y_2;
    private javax.swing.JTextField x2y;
    private javax.swing.JTextField x2y1;
    private javax.swing.JTextField x2y2;
    private javax.swing.JTextField x2y_1;
    private javax.swing.JTextField x2y_2;
    private javax.swing.JTextField x_1y;
    private javax.swing.JTextField x_1y1;
    private javax.swing.JTextField x_1y2;
    private javax.swing.JTextField x_1y_1;
    private javax.swing.JTextField x_1y_2;
    private javax.swing.JTextField x_2y;
    private javax.swing.JTextField x_2y1;
    private javax.swing.JTextField x_2y2;
    private javax.swing.JTextField x_2y_1;
    private javax.swing.JTextField x_2y_2;
    private javax.swing.JTextField xy;
    private javax.swing.JTextField xy1;
    private javax.swing.JTextField xy2;
    private javax.swing.JTextField xy_1;
    private javax.swing.JTextField xy_2;
    // End of variables declaration//GEN-END:variables

 
}