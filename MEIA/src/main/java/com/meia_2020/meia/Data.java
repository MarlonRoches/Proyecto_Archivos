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
    private static Data INSTANCE;
    public String info = "Initial info class";
    
    private Data() {        
    }
    
    public static Data getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }
    
}
