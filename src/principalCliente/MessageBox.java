/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalCliente;

import javax.swing.JOptionPane;

import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.UareUException;

public class MessageBox {

    public static void BadQuality(Reader.CaptureQuality q) {
        JOptionPane.showMessageDialog(null,
                q.toString(),
                "Bad quality",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void BadStatus(Reader.Status s) {
        String str = String.format("Reader status: %s", s.toString());
        JOptionPane.showMessageDialog(null,
                str,
                "Reader status",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void DpError(String strFunctionName, UareUException e) {
        String str = String.format("%s returned DP error %d \n%s", strFunctionName, (e.getCode() & 0xffff), e.toString());
        JOptionPane.showMessageDialog(null,
                str,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void Warning(String strText) {
        JOptionPane.showMessageDialog(null,
                strText,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    // Mensaje si no ha conectado lector
    public static void SinLectorConectado() {
        JOptionPane.showMessageDialog(null, // Posicion de la ventana
                "No existen lectores conectados o estan en uso.", // Mensaje
                "Mensaje de Advertencia", // Título
                JOptionPane.WARNING_MESSAGE); // Tipo de mensaje
    }
}
