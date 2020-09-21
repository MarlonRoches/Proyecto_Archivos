/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;

import java.time.LocalDate;

/**
 *
 * @author roche
 */
public class bitacora_backup {
    String ruta_absoluta;
    String Usuario;
    LocalDate fecha;

    public String getRuta_absoluta() {
        return ruta_absoluta;
    }

    public void setRuta_absoluta(String ruta_absoluta) {
        this.ruta_absoluta = ruta_absoluta;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
