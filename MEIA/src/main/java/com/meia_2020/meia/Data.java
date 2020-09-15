/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;

/**
 *
 * @author roche
 */
public class Data {
    private static Data instance;
    
    private Data(){}
    
    public static Data getInstance(){
        if(instance == null){
            instance = new Data();
        }
        return instance;
    }
    Usuario usuarioActual = new Usuario();
    
}
