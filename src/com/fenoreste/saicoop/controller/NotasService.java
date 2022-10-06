/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.saicoop.controller;

import com.fenoreste.saicoop.httpConnection.HttpUrlConnection;
import com.fenoreste.saicoop.modelos.NotaDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;

/**
 *
 * @author wilmer
 */
public class NotasService {

    Gson gson = new Gson();
    HttpUrlConnection httpConnection = new HttpUrlConnection();
    String basePath = "/notas";
    String buscarMatriz = "/buscarMatriz";
    String obtenerQuery = "/buscarPorId/";
    String ejecutaQuery = "/ejecutar/";
    NotaDTO nota = null;

    public NotaDTO obtenerQuery(String id, String ip, String db) {
        try {
            String response = httpConnection.consumo("", "GET", basePath + obtenerQuery + "id=" + id + "&ip=" + ip + "&db=" + db);
            if (!response.equals("")) {
                nota = new Gson().fromJson(response, NotaDTO.class);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener busqueda query:" + e.getMessage());
        }
        return nota;
    }

    public JsonObject respuestaEjecucion(String ip, String db, String query) {
        JSONObject json = new JSONObject();
        JsonObject respuesta = new JsonObject();
        try {
            String response = httpConnection.consumo(query, "POST", basePath + ejecutaQuery + "ip=" + ip + "&db=" + db);
            respuesta = new JsonParser().parse(response).getAsJsonObject();           
            json = new JSONObject(response);
        } catch (Exception e) {
        }
        return respuesta;
    }

}
