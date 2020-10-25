/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import com.google.gson.Gson;
import com.meia_2020.meia.models.Desc_Bitacora;
import com.meia_2020.meia.models.Desc_Usuarios;
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
 * @author roche
 */
public class Descriptores_Bloques 
{
    public String nombre_simbolico;
    public String fecha_creacion;
    public String usuario_creacion;
    public String fecha_modificacion;
    public String usuario_modificacion;

    public int NoBloques;
    public int RegistroDeInicio;
    public int RegistroSiguiente;

    public int num_registros;
    public int registros_activos;
    public int registros_inactivos;
    public int max_reorganizacion;
    public int registro_inicial;
    
    
    public void crearBitacora(String NumBloque){
            var nuevo = new Descriptores_Bloques();
            nuevo.nombre_simbolico = "Desc_BloqueNo" + NumBloque;
            nuevo.num_registros= 0;
            nuevo.registros_activos =0;
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            nuevo.fecha_creacion= formatter.format(date); 
            nuevo.RegistroDeInicio=1;
            nuevo.RegistroSiguiente=2;

          
           nuevo.max_reorganizacion =4;
            actualizarJson(nuevo);
        }
        
         public void actualizarJson(Descriptores_Bloques actualizado, String NumBloque)
        {

            
            var gson = new Gson(); 
            var objetoJson  = gson.toJson(actualizado);
         try {
             //return  JsonConvert.SerializeObject(new Desc_Bitacora());
             var fileWriter = new FileWriter("C:/MEIA/Desc_BloqueNo" + NumBloque+".json", false); //overwrites file
             fileWriter.write(objetoJson);
             fileWriter.close();
         } catch (IOException ex) {
             Logger.getLogger(Desc_Bitacora.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
        }

        public Descriptores_Bloques devolverObjeto(String NumBloque)
        {
            String json ="";
         try {
             BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/Desc_BloqueNo" + NumBloque+".json"));
             String linea ="";
             
             try {
                 while((linea = buf.readLine()) != null){
                           json += linea;
                 }
                 buf.close();
             } catch (IOException ex) {
                 Logger.getLogger(Desc_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Desc_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
         }

            var gson = new Gson(); 
            var objetoJson  = gson.fromJson(json, Descriptores_Bloques.class);
            return objetoJson;
        }
}
