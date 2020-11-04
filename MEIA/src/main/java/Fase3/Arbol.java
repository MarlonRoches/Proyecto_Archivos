/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import com.google.gson.Gson;

/**
 *
 * @author roche
 */
public class Arbol {
    Nodo root;




private Nodo InsertarNodo(Nodo actual, int valor) {
    if (actual == null) {
        return new Nodo(valor);
    }
 
    if (valor < actual.foto) {
        actual.izq = InsertarNodo(actual.izq, valor);
    } else if (valor > actual.foto) {
        actual.der = InsertarNodo(actual.der, valor);
    } else {
        // foto already exists
        return actual;
    }
 
    return actual;
}
            

    public void PasarAJson (Arbol Actual)
    {

        var gson = new Gson(); 
        var objetoJson  = gson.toJson(Actual);
        
        
    }
    
}
