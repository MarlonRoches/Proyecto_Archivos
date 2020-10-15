/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author roche
 */
public class Mamejo_de_Grupos {
   public  boolean AgregarAmigoAGrupo(String UsuarioActual,String Amigo,String Grupo )throws FileNotFoundException, IOException
    {
        //registro0	posicion1	usuario2	siguiente3	estatus5
        FileReader file = new FileReader("C:/MEIA/IndiceGrupos.txt");
        BufferedReader fileRead = new BufferedReader(file);
        var linea = "";
        var existeEnelGrupo=false;
        while ((linea=fileRead.readLine())== null) {          
            var splited = linea.split("\\|");
            var lol = new Desc_IndiceGrupos().devolverObjeto();
            if (existeEnelGrupo) 
            {
                
            }
            else
            {
            
            }
                  
        }
        fileRead.close();       
        file.close();
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
