/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author root
 */
/**
 *
 * @author prometeo
 */
public class Fichero {

    String fichero = "bases.config";
    String nbd = "";
    String ipbd = "";
    String url = "";

    public Fichero() {
        leeFichero();
    }

    private String getHome() {
        return System.getProperty("user.home");
    }

    private String getSeparador() {
        return System.getProperty("file.separator");
    }

    public File getFichero() {
        String sf = getHome() + getSeparador() + fichero;
        File f = new File(sf);
        if (f.exists()) {
            return f;
        } else {
            System.out.println("El fichero no existe: " + sf);
            return null;
        }
    }

    public void leeFichero() {
        if (getFichero() != null) {
            try {
                try (FileReader fr = new FileReader(getFichero())) {
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        establece(linea);
                    }
                }
            } catch (Exception e) {
                System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
            }
        } else {
            System.out.println("No se encontro el fichero.");
        }
    }

    public int numeroLineas() {
        int NumeroLineas = 0;
        if (getFichero() != null) {
            try {
                try (FileReader fr = new FileReader(getFichero())) {
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        NumeroLineas++;
                    }
                }
            } catch (Exception e) {
                System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
            }
        } else {
            System.out.println("No se encontro el fichero.");
        }
        return NumeroLineas;
    }

    public String Linea() {
        String linea;
        String lineaR = "";
        if (getFichero() != null) {
            try {
                try (FileReader fr = new FileReader(getFichero())) {
                    BufferedReader br = new BufferedReader(fr);
                    while ((linea = br.readLine()) != null) {
                        lineaR = linea;
                    }
                }
            } catch (Exception e) {
                System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
            }
        } else {
            System.out.println("No se encontro el fichero.");
        }
        return lineaR;
    }

    private void establece(String linea) {
        if (linea.contains("base_de_datos")) {
            nbd = linea.split("=")[1];
        }
        if (linea.contains("ip_servidor")) {
            ipbd = linea.split("=")[1];
        }
        if(linea.contains("webservice")){
            url = linea.split("=")[1];
        }
    }

    public String getBd() {
        return nbd;
    }

    public String getIpbd() {
        return ipbd;
    }
    
    public String getUrl(){
        return url;
    }
}
