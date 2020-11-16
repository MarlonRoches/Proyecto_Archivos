/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 */
public class Desc_Mensajes {
    public String nombre_simbolico;
public String fecha_creacion;
public String usuario_creacion;
public String fecha_modificacion;
public String usuario_modificacion;
public int num_registros;
public int registros_activos;
public int registros_inactivos;

//recibe un usuario de creacion
  public void crearBitacora(String _UsuarioDeCreacion){
            var nuevo = new Desc_Mensajes();
            nuevo.nombre_simbolico = "Desc_Mensajes";
            nuevo.num_registros= 0;
            nuevo.registros_activos =0;
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            nuevo.fecha_creacion= formatter.format(date); 
            nuevo.usuario_creacion= _UsuarioDeCreacion;
            actualizarJson(nuevo);
        }
        
         public void actualizarJson(Desc_Mensajes actualizado)
        {
            var gson = new Gson(); 
            var objetoJson  = gson.toJson(actualizado);
         try {
             //return  JsonConvert.SerializeObject(new Desc_Bitacora());
             var fileWriter = new FileWriter("C:/MEIA/Desc_Mensajes.json", false); //overwrites file
             fileWriter.write(objetoJson);
             fileWriter.close();
         } catch (IOException ex) {
             Logger.getLogger(Desc_Arbol.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
        }

        public Desc_Mensajes devolverObjeto()
        {
            String json ="";
         try {
             BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/Desc_Mensajes.json"));
             String linea ="";
             
             try {
                 while((linea = buf.readLine()) != null)
                 {
                           json += linea;
                 }
                 buf.close();
             } catch (IOException ex) {
                 Logger.getLogger(Desc_Mensajes.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Desc_Mensajes.class.getName()).log(Level.SEVERE, null, ex);
         }

            var gson = new Gson(); 
                var objetoJson  = gson.fromJson(json, Desc_Mensajes.class);
            return objetoJson;
        }
}
