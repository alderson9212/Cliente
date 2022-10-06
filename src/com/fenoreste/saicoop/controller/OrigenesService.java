/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.saicoop.httpService;

import com.fenoreste.saicoop.httpConnection.HttpUrlConnection;
import com.fenoreste.saicoop.modelos.OrigenDTO;
import com.google.gson.Gson;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author wilmer
 */
public class OrigenesService {

    Gson gson = new Gson();
    HttpUrlConnection httpConnection = new HttpUrlConnection();
    String basePath="/origenes";
    String buscarMatriz = "/buscarMatriz";
    
    
    public boolean obtenerSession(String ipbase,String nombrebase){
        boolean sesion = false;
        try {
            String response = httpConnection.consumo("","GET", "/get/connection/ip="+ipbase+"&db="+nombrebase);        
            if(!response.equals("")){
               sesion = Boolean.parseBoolean(response);  
            }  
        } catch (Exception e) {
            System.out.println("Error al obtener la sesion:"+e.getMessage());
        }
      return sesion;        
    }
    
    
    public OrigenDTO findMatriz(String ip,String base) {
        OrigenDTO matriz = new OrigenDTO();
        try {
            String response = httpConnection.consumo("","GET",basePath+buscarMatriz+"/ip="+ip+"&db="+base);            
            matriz = gson.fromJson(response, OrigenDTO.class);
            matriz.setFechatrabajo(matriz.getFechatrabajo().substring(0,10));
        } catch (Exception e) {
            System.out.println("Error al buscar Matriz:"+e.getMessage());            
        }
        return matriz;
    }

}
