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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author roche
 */
public class Arbol {
   public Nodo root;
   public List<String> Lista = new ArrayList<String>();
//List<String> TodosOrdenados = OrdenadosPorSiguiente.stream().sorted().collect(Collectors.toList());


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
           actual.left = InsertarNodo(actual.left, valor);
       } else if (valor.CalcularValor() > actual.CalcularValor()) {
           actual.right = InsertarNodo(actual.right, valor);
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
    public void delete(int value) {
    this.root = deleteRecursive(this.root, value);
    }
    
    private Nodo deleteRecursive(Nodo current, int value) {
    if (current == null) {
        return null;
    }
 
    if (value == current.CalcularValor()) {
        // Node to delete found
        // ... code to delete the node will go here
        
        // es Hoja
        if (current.left == null && current.left == null) {
            return null;
        }
        if (current.right == null) {
            return current.left;
        }
 
        if (current.left == null) {
            return current.right;
        }
        
        var smallestValue = findSmallestValue(current.right);
        current= smallestValue;
        
        current.right = deleteRecursive(current.right, smallestValue.CalcularValor());
        return current;
        
    } 
    
    if (value < current.CalcularValor()) {
        current.left = deleteRecursive(current.left, value);
        return current;
    }
        current.right = deleteRecursive(current.right, value);
        return current;
    }    
    
    
    private Nodo findSmallestValue(Nodo root) {
        return root.left == null ? root : findSmallestValue(root.left);
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
    
        void preOrder(Nodo raiz) 
        { 
            if (raiz == null) 
            { return; } 
            
            this.Lista.add(raiz.Stringer());
            
            preOrder(raiz.left); 
            preOrder(raiz.right); 
        }

       public void ActualizarArchivo()
        {
            
            preOrder(this.root);
        
            List<String> TodosOrdenados = Lista.stream().sorted().collect(Collectors.toList());
            if (new File("C:/MEIA/imagen_usuario.txt").exists())
            {
                //sobre escribir
                File fold=new File("C:/MEIA/imagen_usuario.txt");
                fold.delete();
                File fnew=new File("C:/MEIA/imagen_usuario.txt");
                String source = "";
                try 
                {
                    FileWriter f2 = new FileWriter(fnew, false);
                    for (int i = 0; i < TodosOrdenados.size(); i++) 
                    {    
                    f2.write(TodosOrdenados.get(i)+"\n");
                    }
                    f2.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }      
            }else
            {
            //crear y escribir
                File fnew=new File("C:/MEIA/imagen_usuario.txt");
                String source = "";
                try 
                {
                    FileWriter f2 = new FileWriter(fnew, false);
                    for (int i = 0; i < TodosOrdenados.size(); i++) 
                    {    
                    f2.write(TodosOrdenados.get(i)+"\n");
                    }
                    f2.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }      
                
            }
            
            
             var lol = 0;
        }
        
}
