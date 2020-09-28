/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;

import com.meia_2020.meia.models.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roche
 */
public class Bitacora_Usuario {
          
     public boolean contieneUsuario(String userName)
    {
        var salida =false;
     try {
             BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/bitacora_Usuarios.txt "));
             String linea ="";
             String[] array_nuevo;
             try {
                 while((linea = buf.readLine()) != null){
                           if (linea.split("\\|")[0].equals(userName)) {
                          
                               array_nuevo =linea.split("\\|");
                               //cambiar datos
                               
                               return true;
                     }
                 }
                 buf.close();
             } catch (IOException ex) {
                 Logger.getLogger(Desc_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Desc_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
         }   
        
        
        return false;
    }
}
