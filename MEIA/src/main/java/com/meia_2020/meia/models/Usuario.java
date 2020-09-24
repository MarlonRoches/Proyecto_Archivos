/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author roche
 */
public class Usuario {
    public String usuario;
    public String nombre;
    public String usuarioApellido;
    public String passWord;
    public Boolean rol;
    public LocalDate fecha;
    public String correoAlterno;
    public int telefono;
    public String path_Fotografia;
    public boolean estatus;

    
    public static Usuario setDatosUsuario(String usuario, String nombre, String usuarioApellido, String passWord, boolean rol, LocalDate fecha, String correoAlterno, int telefono, String path_Fotografia, boolean estatus) {
        Usuario newUsuario = new Usuario();
        newUsuario.usuario = usuario;
        newUsuario.nombre = nombre;
        newUsuario.usuarioApellido = usuarioApellido;
        newUsuario.passWord = passWord;
        newUsuario.rol = rol;
        newUsuario.fecha = fecha;
        newUsuario.correoAlterno = correoAlterno;
        newUsuario.telefono = telefono;
        newUsuario.path_Fotografia = path_Fotografia;
        newUsuario.estatus = estatus;
        return newUsuario;
    }
    
    
    public Usuario setUsuariofromArray(String[] array) {
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        
        Usuario newUsuario = new Usuario();
        newUsuario.usuario = array[0];
        newUsuario.nombre = array[1];
        newUsuario.usuarioApellido = array[2];
        newUsuario.passWord = array[3];
        newUsuario.rol = array[4].equals("1") ? true: false;
        newUsuario.fecha = LocalDate.parse(array[5],formatter);
        newUsuario.correoAlterno = array[6];
        newUsuario.telefono = Integer.parseInt(array[7]);
        newUsuario.path_Fotografia = array[8];
        newUsuario.estatus = array[9].equals("1") ? true: false;
        return newUsuario;
    }
    public String usuarioToString(){
        String unpadded = "";
        unpadded += this.fecha.getMonthValue();
        String padded =  "00".substring(unpadded.length()) +unpadded ;
        
        String unpadded1 = "";
        unpadded1 += this.fecha.getDayOfMonth();
        String padded2 =  "00".substring(unpadded1.length())+unpadded1;
        
        return this.usuario+"|"+ this.nombre+"|"+this.usuarioApellido +"|"+this.passWord +"|"+ (this.rol ? 1 : 0)+"|"+padded2+"/"+padded+"/"+this.fecha.getYear()+"|"+this.correoAlterno +"|"+ this.telefono+"|"+this.path_Fotografia +"|"+(this.estatus? 1 : 0);
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
