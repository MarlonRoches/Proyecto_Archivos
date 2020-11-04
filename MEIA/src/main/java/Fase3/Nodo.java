/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

/**
 *
 * @author roche
 */
public class Nodo 
{
    int NoNoRegistro;
    String Usuario;
    String Path;
    String FechaTransaccion;
    boolean Status;
    int hash;
    int foto;
    Nodo izq;
    Nodo der;
    
    public  Nodo(int valor)
    {
        this.foto = valor;
        //escribir Em el; archivo
        der = null;
        izq = null;
    }
    int GetKeyVal ()
    {
    
        return 0;
    }
    
    
}
