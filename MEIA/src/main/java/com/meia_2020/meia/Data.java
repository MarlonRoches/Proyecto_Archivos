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
     // static variable single_instance of type Singleton 
    private static Data single_instance = null; 
  
    // variable of type String 
    public String s; 
    public Usuario usuarioActual = new Usuario();
    // private constructor restricted to this class itself 
    private Data() 
    { 
        
    } 
  
    // static method to create instance of Singleton class 
    public static Data getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Data(); 
  
        return single_instance; 
    } 
    
    
}
