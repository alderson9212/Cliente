/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.saicoop.httpService;

import com.fenoreste.saicoop.httpConnection.HttpUrlConnection;
import com.fenoreste.saicoop.modelos.UsuarioDTO;
import com.google.gson.Gson;

/**
 *
 * @author wilmer
 */
public class UsuariosService {
    
    private String basePath = "/user";
    private final String buscarPorId = "/buscarPorId";
    HttpUrlConnection conexionws = new HttpUrlConnection();
   
    public UsuarioDTO buscarPorId(int id,String ip,String db){
        UsuarioDTO user = null;
        try {
            String response = conexionws.consumo("","GET",basePath+buscarPorId+"/id="+id+"&ip="+ip+"&db="+db);
            //JSONObject jsonResponse = new JSONObject(response);
            user = new Gson().fromJson(response,UsuarioDTO.class);
        } catch (Exception e) {
            System.out.println("Error al buscar usuario por id:"+e.getMessage());
        }
        return user;
    }
}
