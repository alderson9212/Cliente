/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.saicoop.httpConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import util.Fichero;

/**
 *
 * @author wilmer
 */
public class HttpUrlConnection {

    String path = "api";

    public HttpUrlConnection() {

    }

    public String consumo(String peticion, String metodo, String complemento) {
        StringBuilder resultado = new StringBuilder();
        Fichero fichero = new Fichero();

        String url = fichero.getUrl() + path + complemento;
        System.out.println("la url:" + url);
        try {
            URL url_privada = new URL(url);
            //Se genera la conexion
            HttpURLConnection conn = (HttpURLConnection) url_privada.openConnection();
            if (metodo.toUpperCase().contains("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setDoOutput(true);
                //El metodo que utilizo
                conn.setRequestMethod("POST");
                //Tipo de contenido aceptado por el WS
                conn.setRequestProperty("Content-Type", "application/json");
                //Obtengo el Stream
                OutputStream os = conn.getOutputStream();
                //Al stream le paso el request
                os.write(peticion.getBytes());
                os.flush();

                //Obtengo el codigo de respuesta
            }
            int codigoHTTP = conn.getResponseCode();
            /*  String output = "";
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            System.out.println("Output from Server .... \n");
            System.out.println("El codigo de respuesta es:" + codigoHTTP);
            if (codigoHTTP == 200) {
                while ((output = br.readLine()) != null) {
                    salida = output;
                }
            } else {
                while ((output = br.readLine()) != null) {
                    salida = output;
                }
            }
            conn.disconnect();  */
            // Búferes para leer
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String linea;
            // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
                System.out.println("Resultado:" + resultado);
            }
            // Cerrar el BufferedReader
            rd.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            if (e.getMessage().contains("refused")) {
                JOptionPane.showMessageDialog(null, "Error de conexion: Verifique su direccion de web service", "", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado.toString();
    }
}
