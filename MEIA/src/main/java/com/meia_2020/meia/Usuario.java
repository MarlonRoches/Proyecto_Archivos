/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;

import java.time.LocalDate;

/**
 *
 * @author roche
 */
public class Usuario {
    String usuario;
    String nombre;
    String usuarioApellido;
    String passWord;
    boolean rol;
    LocalDate fecha;
    String correoAlterno;
    int telefono;
    String path_Fotografia;
    boolean estatus;

    public void setDatosUsuario(String usuario, String nombre, String usuarioApellido, String passWord, boolean rol, LocalDate fecha, String correoAlterno, int telefono, String path_Fotografia, boolean estatus) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.usuarioApellido = usuarioApellido;
        this.passWord = passWord;
        this.rol = rol;
        this.fecha = fecha;
        this.correoAlterno = correoAlterno;
        this.telefono = telefono;
        this.path_Fotografia = path_Fotografia;
        this.estatus = estatus;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCorreoAlterno() {
        return correoAlterno;
    }

    public void setCorreoAlterno(String correoAlterno) {
        this.correoAlterno = correoAlterno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPath_Fotografia() {
        return path_Fotografia;
    }

    public void setPath_Fotografia(String path_Fotografia) {
        this.path_Fotografia = path_Fotografia;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
