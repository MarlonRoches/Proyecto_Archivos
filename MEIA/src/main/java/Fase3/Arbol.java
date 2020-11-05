/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import com.google.gson.Gson;
import com.meia_2020.meia.models.Desc_Usuarios;
import fase2.Desc_IndiceGrupos;
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
public class Arbol {
   public Nodo root;




public Nodo InsertarNodo(Nodo actual, Nodo valor) 
{
    if (this.root==null) {
        this.root= valor;
    }
    else
    {   
        if (actual == null) {
           return valor;
       }

       if (valor.CalcularValor() < actual.CalcularValor()) {
           actual.izq = InsertarNodo(actual.izq, valor);
       } else if (valor.CalcularValor() > actual.CalcularValor()) {
           actual.der = InsertarNodo(actual.der, valor);
       } else {
           // foto already exists
           return actual;
       }
    }
   
 
    return actual;
}
            

        public Arbol CargarArbol()
        {
            
            String json ="";
            
         try {
             BufferedReader buf = new BufferedReader(new FileReader("C:/MEIA/Desc_Gruposs.json"));
             String linea ="";
             
             try
             {
                 while((linea = buf.readLine()) != null)
                 {
                    json += linea;
                 }
                 buf.close();
             }
             catch (IOException ex)
             {
                 Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (FileNotFoundException ex) 
         {
             Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
         }

            var gson = new Gson(); 
            var objetoJson  = gson.fromJson(json, Arbol.class);
            return objetoJson;
        }
    
        
        
        public void crearArbol(String _UsuarioDeCreacion){
            var nuevo = new Arbol();
            nuevo.root = null;
            actualizarJson(nuevo);
        }
        
    public void actualizarJson(Arbol actualizado)
        {
            var gson = new Gson(); 
            var objetoJson  = gson.toJson(actualizado);
         try {
             //return  JsonConvert.SerializeObject(new Desc_Bitacora());
             var fileWriter = new FileWriter("C:/MEIA/Desc_Gruposs.json", false); //overwrites file
             fileWriter.write(objetoJson);
             fileWriter.close();
         }
         catch (IOException ex) 
         {
             Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
        }
        
        
}
