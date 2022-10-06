/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.saicoop.modelos;

/**
 *
 * @author wilmer
 */
public class NotaDTO {

    private String idnota;
    private String descripcion;
    private String nota;

    public String getIdnota() {
        return idnota;
    }

    public void setIdnota(String idnota) {
        this.idnota = idnota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "NotaDTO{" + "idnota=" + idnota + ", descripcion=" + descripcion + ", nota=" + nota + '}';
    }
    
    

}
