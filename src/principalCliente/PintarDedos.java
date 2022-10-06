/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalCliente;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wilmer
 */
public class PintarDedos {

    public BufferedImage bimg;
    private boolean f = false;

    private int r;
    private int b;
    private int gs;
    private Color color;

    //Run ru = new Run();

    public PintarDedos() {
      
    }
       
    
      public void imagenManos() {
        try {
            if (f == false) {
                bimg = ImageIO.read(new File("/home/wilmer/NetBeansProjects/IniciandoHuellav1.0/src/imagenes/manos.png"));
            }
        } catch (IOException | ClassCastException ex) {
            System.out.println("Error ControlPanelManos: filtroC ." + ex);
        }
        
          toBufferedImage(bimg);
    }
      
      public  BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }

    public void filtroC(int x1, int x2, int y1, int y2, int[] co1, int[] co2,JLabel label) {    
        label.setIcon(label.getIcon());       
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                //se obtiene el color del pixel
                color = new Color(bimg.getRGB(i, j));
                //se extraen los valores RGB
                r = color.getRed();
                gs = color.getGreen();
                b = color.getBlue();
                if (r == co1[0] && gs == co1[1] && b == co1[2]) {
                    //bimg.setRGB(i, j, new Color(0, 255, 0).getRGB());
                    bimg.setRGB(i, j, new Color(co2[0], co2[1], co2[2]).getRGB());
                }
            }
        }        
         label.setIcon(new ImageIcon(bimg));

    }

    public void cargarDedo(int dedo,JLabel label) {
        if (dedo >= 0 && dedo <= 9) {
            int[] co1 = {0, 0, 0}; // negro
            int[] co2 = {40, 100, 40}; // verde
            switch (dedo) {
                case 0:
                    filtroC(20, 40, 32, 91, co1, co2, label);
                    break;
                case 1:
                    filtroC(41, 65, 14, 91, co1, co2,label);
                    break;
                case 2:
                    filtroC(65, 87, 2, 91, co1, co2,label);
                    break;
                case 3:
                    filtroC(89, 112, 21, 91, co1, co2,label);
                    break;
                case 4:
                    filtroC(110, 145, 98, 170, co1, co2,label);
                    break;
                case 5:
                    filtroC(163, 194, 98, 170, co1, co2,label);
                    break;
                case 6:
                    filtroC(190, 219, 21, 91, co1, co2,label);
                    break;
                case 7:
                    filtroC(220, 240, 2, 91, co1, co2,label);
                    break;
                case 8:
                    filtroC(241, 264, 14, 91, co1, co2,label);
                    break;
                case 9:
                    filtroC(263, 288, 32, 91, co1, co2,label);
                    break;
            }
        }
    }

    public void cargarDedoSiguiente(int dedo,JLabel label) {
        if (dedo >= 0 && dedo <= 9) {
            int[] co1 = {0, 0, 0}; // negro
            int[] co2 = {215, 205, 28}; // amarillo
            switch (dedo) {
                case 0:
                    filtroC(20, 40, 32, 91, co1, co2,label);
                    break;
                case 1:
                    filtroC(41, 64, 14, 91, co1, co2,label);
                    break;
                case 2:
                    filtroC(64, 84, 2, 91, co1, co2,label);
                    break;
                case 3:
                    filtroC(87, 112, 21, 91, co1, co2,label);
                    break;
                case 4:
                    filtroC(110, 145, 98, 170, co1, co2,label);
                    break;
                case 5:
                    filtroC(163, 194, 98, 170, co1, co2,label);
                    break;
                case 6:
                    filtroC(190, 219, 21, 91, co1, co2,label);
                    break;
                case 7:
                    filtroC(220, 240, 2, 91, co1, co2,label);
                    break;
                case 8:
                    filtroC(241, 264, 14, 91, co1, co2,label);
                    break;
                case 9:
                    filtroC(263, 288, 32, 91, co1, co2,label);
                    break;
            }
        }
    }

}
