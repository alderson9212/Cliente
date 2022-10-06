/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalCliente;

import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author gerardo
 */
public class UtilidadesLector_1 {

    // Enciende el lector
    public ReaderCollection enciendeLector() {
        //initialize capture library by acquiring reader collection
        try {
            
            System.out.println("Entro a encender el lector"); // -- para prueba de fredy
            
            UareUGlobal.DestroyReaderCollection();
            return UareUGlobal.GetReaderCollection();
        } catch (UareUException e) {
            return null;
        }
    }

    //Apaga el lector
    public void apagaLector() {
        //release capture library by destroying reader collection
        try {
            
            System.out.println("Entro a apagar el lector"); // -- para prueba de fredy
            
            UareUGlobal.DestroyReaderCollection();
        } catch (UareUException e) {
        }
    }
    
    //Actualiza la lista de lectores
    public Reader seleccionaLector(ReaderCollection m_collection) {
        //acquire available readers
        try {
            
            System.out.println("Entro a seleccionar el lector"); // -- para prueba de fredy
            
            // Antes de traer la lista de lectores espera a encenderlos.
            //Thread.sleep(2000);
            //m_collection.GetReaders();
            int milis = 0;
            while (m_collection.isEmpty()) {
                Thread.sleep(1);
                milis = milis + 1;
                m_collection.GetReaders();
            }            
        } catch (UareUException e) {
        } catch (InterruptedException ex) {
            System.out.println("Error en cargar lector. \n" + ex.getMessage());
        }
        if (!m_collection.isEmpty()) {
            return m_collection.get(0);
        } else {
        }
        return null;
    }
    
    // Crea el bufferedimage a partir de un ImagePanel
    public BufferedImage createImage(ImagePanel image) {
        BufferedImage bi = new BufferedImage(340, 380, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        image.print(g);
        return bi;
    }

}
