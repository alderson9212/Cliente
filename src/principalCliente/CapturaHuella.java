/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalCliente;

import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author wilmer
 */
public class CapturaHuella {

    private boolean b = false;
    private List<Object> milista;
    private Reader m_reader;

    UtilidadesLector_1 utilidadesLector = new UtilidadesLector_1();

    public CapturaHuella(JLabel jLabelCapturaHuella,JLabel labelManos,int dedo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                m_reader = seleccionaLector(iniciaLector());
                b = true;
            }
        }).start();
        try {
            while (b == false) {
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Reader:" + m_reader);
        milista = Enrolar.Run(m_reader, jLabelCapturaHuella,labelManos,labelManos,dedo);
        if (m_reader != null) {
            try {
                m_reader.StopStreaming();
                System.out.println("deteniendo Stream +1");
            } catch (Exception e) {
                System.out.println("deteniendo Stream -1");
            }
            try {
                m_reader.CancelCapture();
            } catch (Exception e) {
                System.out.println("deteniendo Captura -1");
            }
            try {
                m_reader.Close();
            } catch (Exception e) {
                System.out.println("cerrando lector -1");
            }
        }
        
        System.out.println("Listaaaaaaaaaaaaaaaaaaaaaaaaa Huella:"+milista);
        
        apagaLector();
    }

    public ReaderCollection iniciaLector() {
        return utilidadesLector.enciendeLector();
    }

    public Reader seleccionaLector(ReaderCollection m_collection) {
        return utilidadesLector.seleccionaLector(m_collection);
    }

    public void apagaLector() {
        utilidadesLector.apagaLector();
    }
   

}
