/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roche
 */
public class Archivo_Usuario {
    
    public boolean midificarUsuario(String archivo,String nombreDeUsuario, Usuario actualizado_)
    {
        var salida =false;
        int lineaindex =0;
         var lineas = new ArrayList<String>();
     try {
             BufferedReader buf = new BufferedReader(new FileReader(archivo));
             String linea ="";
             String[] array_nuevo;
             try {
                 while((linea = buf.readLine()) != null){
                           if (linea.split("\\|")[0].equals(nombreDeUsuario)) 
                           {
                               array_nuevo =linea.split("\\|");
                               
                               //cambiar datos
                               //setVariable(lineaindex, actualizado_.usuarioToString());
                               lineas.add(actualizado_.usuarioToString()); 
                               
                               salida = true;
                           }
                           else
                           {
                               lineaindex++;
                               lineas.add(linea);
                           }
                 }
                 buf.close();
                 if (salida) {
                     setVariable(archivo,lineas);
                 return true;
                 }
                 else{
                     return false;
                 }
             } catch (IOException ex) {
                 Logger.getLogger(Desc_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Desc_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
         }   
     

        
        return salida;
    }
    
    
    
    
    
    public void setVariable(String ruta, ArrayList<String> array) throws IOException {
   
        // Creates FileWriter. Append is on.
        FileWriter fw = new FileWriter(ruta, false);       

        PrintWriter pw = new PrintWriter(fw);       

        //cycles through file until line designated to be rewritten is reached
        for (int i = 0; i <= array.size(); i++) {     
            //TODO: need to figure out how to change the append to false to overwrite data   
            if (i == array.size() -1) {
                var linea =array.toArray()[i].toString();
                pw.print(array.toArray()[i].toString());
                break;
            } else {
                var linea =array.toArray()[i].toString();
             pw.println(array.toArray()[i].toString());
        }
    }
    
    pw.close();
    fw.close();
    
}
    public void sortNombres(){
        
    }
    
    //C:\MEIA\bitacora_Usuarios.txt
    public boolean estaEn_Bitacora(String nombreDeUsuario_) throws FileNotFoundException, IOException{
        BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/bitacora_Usuarios.txt"));
             String linea ="";
            
                 while((linea = buf.readLine()) != null){
                           if (linea.split("\\|")[0].equals(nombreDeUsuario_)) 
                           {
                               buf.close();
                               return true;
                           }
                 }
                               buf.close();
        return true;
    }
                 
                 //C:/MEIA/usuario.txt
   public boolean estaEn_Usuarios(String nombreDeUsuario_) throws FileNotFoundException, IOException{
        BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/usuarios.txt"));
             String linea ="";
            
                 while((linea = buf.readLine()) != null){
                           if (linea.split("\\|")[0].equals(nombreDeUsuario_)) 
                           {
                               buf.close();
                               return true;
                           }
                 }
                               buf.close();
        return true;
    }
}
