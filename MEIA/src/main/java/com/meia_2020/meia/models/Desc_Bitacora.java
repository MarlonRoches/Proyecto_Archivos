/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author roche
 */
public class Desc_Bitacora {
     public String nombreSimbolico;
        public String fechaCreacion;
        public String usuarioCreacion;
        public String fechaModificacion;
        public String usuarioModificacion;
        public int numRegistros;
        public int registrosInActivos; 
        public int registrosActivos;
        public int reOrganizacionMax;

        public String actualizarJson(Desc_Bitacora actualizado)
        {

            var gson = new Gson(); 
            var objetoJson  = gson.toJson(actualizado);
            //return  JsonConvert.SerializeObject(new Desc_Bitacora());
            return objetoJson;
        }
        
        public Desc_Bitacora devolverObjeto()
        {
            String json ="";
         try {
             BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/desc_Bitacora.json"));
             String linea ="";
             
             try {
                 while((linea = buf.readLine()) != null){
                           json += linea;
                 }
                 buf.close();
             } catch (IOException ex) {
                 Logger.getLogger(Desc_Bitacora.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Desc_Bitacora.class.getName()).log(Level.SEVERE, null, ex);
         }

            var gson = new Gson(); 
            var objetoJson  = gson.fromJson(json, Desc_Bitacora.class);
            return objetoJson;
        }
}
