/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;
import com.google.gson.Gson;
import com.meia_2020.meia.LoginForm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
        
        //no se toca
        public int reOrganizacionMax;
        

        public Desc_Bitacora(){
          this.nombreSimbolico="bitacora_Usuarios";
          SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss ");
            Date date = new Date(System.currentTimeMillis());
          this.fechaCreacion=formatter.format(date);
        
          this.usuarioCreacion="";
        
          this.fechaModificacion="";
          this.usuarioModificacion="";
        
          this.numRegistros=0;
          this.registrosInActivos=0; 
          this.registrosActivos=0;
          this.reOrganizacionMax=5;
        }
        public void crearBitacora(){
            var nuevo = new Desc_Bitacora();
            actualizarJson(nuevo);
        }
        public Desc_Bitacora calcularBitacora(Desc_Bitacora viejo_) throws FileNotFoundException, IOException{
            BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/desc_Bitacora.json"));
            String linea ="";
            
             viejo_.nombreSimbolico = "bitacora_Usuarios";  
            
  
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            viejo_.fechaModificacion = dtf.format(now);
            
            int registrosTotales=0;
            int contadorregistrosInActivos=0;
            int contadorregistrosActivos=0;
            
            viejo_.usuarioModificacion= LoginForm.UsuarioActual.usuario;
            
            
            while((linea= buf.readLine())!= null){
            var splited = linea.split("/|");
                if (splited[9].equals("1")) {
                    //está habilitado
                    contadorregistrosActivos++;
                }else{
            contadorregistrosInActivos++;
            }
            
            registrosTotales++;
        }
            viejo_.numRegistros= registrosTotales;
             viejo_.registrosInActivos = contadorregistrosInActivos;
             viejo_.registrosActivos = contadorregistrosActivos;
            return viejo_;
        }
        //boolean contiene usuario
        //
        
        public void actualizarJson(Desc_Bitacora actualizado)
        {

            
            var gson = new Gson(); 
            var objetoJson  = gson.toJson(actualizado);
         try {
             //return  JsonConvert.SerializeObject(new Desc_Bitacora());
             var fileWriter = new FileWriter("C:/MEIA/desc_Bitacora.json", false); //overwrites file
             fileWriter.write(objetoJson);
             fileWriter.close();
         } catch (IOException ex) {
             Logger.getLogger(Desc_Bitacora.class.getName()).log(Level.SEVERE, null, ex);
         }
        
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
