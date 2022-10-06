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
public class UsuarioDTO {

    private Integer idusuario;
    private String login;
    private String nombre;
    private boolean activo;
    private Integer idorigenp_dd;
    private Integer idproducto_dd;
    private Integer idauxiliar_dd;
    private Integer idorigenp_ad;
    private Integer idproducto_ad;
    private Integer idauxiliar_ad;
    private String pingreso;
    private String pegreso;
    private String pdiario;
    private Integer idorigen;
    private Integer p_idorigen;
    private Integer p_idgrupo;
    private Integer p_idsocio;
    private String fechalimite;
    private String impticket;
    private String passwd2;
    private String passwd3;
    private String passwd;
    private String ip_local;
    private Integer ticket;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Integer getIdorigenp_dd() {
        return idorigenp_dd;
    }

    public void setIdorigenp_dd(Integer idorigenp_dd) {
        this.idorigenp_dd = idorigenp_dd;
    }

    public Integer getIdproducto_dd() {
        return idproducto_dd;
    }

    public void setIdproducto_dd(Integer idproducto_dd) {
        this.idproducto_dd = idproducto_dd;
    }

    public Integer getIdauxiliar_dd() {
        return idauxiliar_dd;
    }

    public void setIdauxiliar_dd(Integer idauxiliar_dd) {
        this.idauxiliar_dd = idauxiliar_dd;
    }

    public Integer getIdorigenp_ad() {
        return idorigenp_ad;
    }

    public void setIdorigenp_ad(Integer idorigenp_ad) {
        this.idorigenp_ad = idorigenp_ad;
    }

    public Integer getIdproducto_ad() {
        return idproducto_ad;
    }

    public void setIdproducto_ad(Integer idproducto_ad) {
        this.idproducto_ad = idproducto_ad;
    }

    public Integer getIdauxiliar_ad() {
        return idauxiliar_ad;
    }

    public void setIdauxiliar_ad(Integer idauxiliar_ad) {
        this.idauxiliar_ad = idauxiliar_ad;
    }

    public String getPingreso() {
        return pingreso;
    }

    public void setPingreso(String pingreso) {
        this.pingreso = pingreso;
    }

    public String getPegreso() {
        return pegreso;
    }

    public void setPegreso(String pegreso) {
        this.pegreso = pegreso;
    }

    public String getPdiario() {
        return pdiario;
    }

    public void setPdiario(String pdiario) {
        this.pdiario = pdiario;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public Integer getP_idorigen() {
        return p_idorigen;
    }

    public void setP_idorigen(Integer p_idorigen) {
        this.p_idorigen = p_idorigen;
    }

    public Integer getP_idgrupo() {
        return p_idgrupo;
    }

    public void setP_idgrupo(Integer p_idgrupo) {
        this.p_idgrupo = p_idgrupo;
    }

    public Integer getP_idsocio() {
        return p_idsocio;
    }

    public void setP_idsocio(Integer p_idsocio) {
        this.p_idsocio = p_idsocio;
    }

    public String getFechalimite() {
        return fechalimite;
    }

    public void setFechalimite(String fechalimite) {
        this.fechalimite = fechalimite;
    }

    public String getImpticket() {
        return impticket;
    }

    public void setImpticket(String impticket) {
        this.impticket = impticket;
    }

    public String getPasswd2() {
        return passwd2;
    }

    public void setPasswd2(String passwd2) {
        this.passwd2 = passwd2;
    }

    public String getPasswd3() {
        return passwd3;
    }

    public void setPasswd3(String passwd3) {
        this.passwd3 = passwd3;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getIp_local() {
        return ip_local;
    }

    public void setIp_local(String ip_local) {
        this.ip_local = ip_local;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "idusuario=" + idusuario + ", login=" + login + ", nombre=" + nombre + ", activo=" + activo + ", idorigenp_dd=" + idorigenp_dd + ", idproducto_dd=" + idproducto_dd + ", idauxiliar_dd=" + idauxiliar_dd + ", idorigenp_ad=" + idorigenp_ad + ", idproducto_ad=" + idproducto_ad + ", idauxiliar_ad=" + idauxiliar_ad + ", pingreso=" + pingreso + ", pegreso=" + pegreso + ", pdiario=" + pdiario + ", idorigen=" + idorigen + ", p_idorigen=" + p_idorigen + ", p_idgrupo=" + p_idgrupo + ", p_idsocio=" + p_idsocio + ", fechalimite=" + fechalimite + ", impticket=" + impticket + ", passwd2=" + passwd2 + ", passwd3=" + passwd3 + ", passwd=" + passwd + ", ip_local=" + ip_local + ", ticket=" + ticket + '}';
    }

}
