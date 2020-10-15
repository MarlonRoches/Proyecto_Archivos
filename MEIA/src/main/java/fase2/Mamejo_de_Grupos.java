/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author roche
 */
public class Mamejo_de_Grupos {
    public int registro;
    public int posicion; 	
    String Key;
    public int siguiente;	
    public boolean estatus;
   public  boolean AgregarAmigoAGrupo(String UsuarioActual,String Amigo,String Grupo )throws FileNotFoundException, IOException
    {
        //registro0	posicion1	key2	siguiente3	estatus5
        FileReader file = new FileReader("C:/MEIA/IndiceGrupos.txt");
        BufferedReader fileRead = new BufferedReader(file);
        var linea = "";
        var existeEnelGrupo=false;
        while ((linea=fileRead.readLine())!= null ) {          
            linea="";
            if (linea.equals("")) {
                linea = null;
                break;
            }
            var splited = linea.split("\\|");
            var lol = new Desc_IndiceGrupos().devolverObjeto();
            if ((Grupo+"-"+UsuarioActual+"-"+Amigo).equals(splited[2])) 
            {
                //aqui ya existe el añadido al grupo
                 fileRead.close();       
                  file.close();
                return false;
            }
            else
            {
            // aqui no existe, lo vamos a insertar
            }
                  
        }
        fileRead.close();       
        file.close();
        if (linea==null) 
        {
            //No hay nada, entonces se agrega el indice
             var fileWriter = new FileWriter("C:/MEIA/IndiceGrupos.txt", true);
                 var aEscribir="1|1.1|"+Grupo+"-"+UsuarioActual+"-"+Amigo+"|0|1\n";
                 fileWriter.write(aEscribir);
                 fileWriter.close();
                 return true;
        }
        if (existeEnelGrupo) 
        {
            //si existe, no se agrega
             return true;
        }
        else
        {
            //no existe, agregar
            return false;           

        }
    }
}
