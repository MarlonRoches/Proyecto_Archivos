/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
         var descIndiceGrupo = new Desc_IndiceGrupos().devolverObjeto();
        while ((linea=fileRead.readLine())!= null ) 
        {          
            if (linea.equals("")) {
                linea = null;
                break;
            }
            var splited = linea.split("\\|");
            if ((Grupo+"-"+UsuarioActual+"-"+Amigo).equals(splited[2])) 
            {
                //aqui ya existe el añadido al grupo
                 fileRead.close();       
                  file.close();
                return false;
            }
            else
            {
                existeEnelGrupo=false;
            }
                  
        }
        fileRead.close();       
        file.close();
        //primera insercion
        if (linea==null && descIndiceGrupo.num_registros==0) 
        {
            //No hay nada, entonces se agrega el indice
            descIndiceGrupo = new Desc_IndiceGrupos().devolverObjeto();
            descIndiceGrupo.NoBloques=1;
            descIndiceGrupo.RegistroDeInicio=1;
            descIndiceGrupo.RegistroSiguiente=2;
            descIndiceGrupo.registros_activos =1;
            descIndiceGrupo.num_registros =1;
             SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            descIndiceGrupo.fecha_modificacion= formatter.format(date); 
            descIndiceGrupo.usuario_modificacion=UsuarioActual;
            
            
            new Desc_IndiceGrupos().actualizarJson(descIndiceGrupo);
             var fileWriter = new FileWriter("C:/MEIA/IndiceGrupos.txt", true);
                 var aEscribir="1|1.1|"+Grupo+"-"+UsuarioActual+"-"+Amigo+"|0|1\n";
                 fileWriter.write(aEscribir);
                 fileWriter.close();
                 
                 boolean arch_BloqueActual = new File("C:/MEIA/grupo_amigos_"+descIndiceGrupo.NoBloques+".txt").exists();
                        if (!arch_BloqueActual) 
                        {
                            var creado = new File("C:/MEIA/grupo_amigos_"+descIndiceGrupo.NoBloques+".txt").createNewFile();  
                        }
                        //escribimos en el bloque
                        var WriterBloque = new FileWriter("C:/MEIA/grupo_amigos_"+descIndiceGrupo.NoBloques+".txt", true);
                         var aEscribirEnBloque= UsuarioActual+"|"+Grupo+"|"+Amigo+"|"+formatter.format(date)+"|"+"1\n";
                        WriterBloque.write(aEscribirEnBloque);
                        WriterBloque.close();
                 return true;
        }
        
        if (!existeEnelGrupo) 
        {
            //si existe, no se agrega
            // aqui no existe, lo vamos a insertar
                //modificar los datos del desc
               // var Escritura = infoDesc.NoBloques+"|"+;
                 
                    
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                     descIndiceGrupo.fecha_modificacion= formatter.format(date); 
                    descIndiceGrupo.usuario_modificacion=UsuarioActual;
                    //Usuario	Grupo	UsuarioAmigo	Fecha De Transaccion Estatus

                   
                    //si el registro siguiente es mayor al limite
                    if (descIndiceGrupo.RegistroSiguiente > descIndiceGrupo.max_reorganizacion) 
                    {
                        descIndiceGrupo.RegistroSiguiente=1;
                        descIndiceGrupo.NoBloques++;
                    }
                         //verificar si el archivo al ingresar existe
                        ///grupo_amigos_n.txt
                       
                        
                        //escribimos en el indice
                        //registro0	posicion1	key2	siguiente3	estatus5
                        descIndiceGrupo.num_registros++;
                        var WriterIndice = new FileWriter("C:/MEIA/IndiceGrupos.txt", true);
                        String aEscribirIndice=descIndiceGrupo.num_registros+"|"+(descIndiceGrupo.NoBloques+"."+descIndiceGrupo.RegistroSiguiente)+"|"+Grupo+"-"+UsuarioActual+"-"+Amigo+"|"+"0"+"|"+"1\n";
                        WriterIndice.write(aEscribirIndice);
                        WriterIndice.close();
                        
                          boolean arch_BloqueActual = new File("C:/MEIA/grupo_amigos_"+descIndiceGrupo.NoBloques+".txt").exists();
                        if (!arch_BloqueActual) 
                        {
                            var creado = new File("C:/MEIA/grupo_amigos_"+descIndiceGrupo.NoBloques+".txt").createNewFile();  
                        }
                        //escribimos en el bloque
                        var WriterBloque = new FileWriter("C:/MEIA/grupo_amigos_"+descIndiceGrupo.NoBloques+".txt", true);
                         var aEscribirEnBloque= UsuarioActual+"|"+Grupo+"|"+Amigo+"|"+formatter.format(date)+"|"+"1\n";
                        WriterBloque.write(aEscribirEnBloque);
                        WriterBloque.close();
                        
                    //actualizando el descriptor
                    descIndiceGrupo.registros_activos++;
                    descIndiceGrupo.RegistroSiguiente++;
                    new Desc_IndiceGrupos().actualizarJson(descIndiceGrupo);
                var lol =0;
             return true;
        }
        else
        {
            //no existe, agregar
            return false;           

        }
    }
   
   
   public void InsertarEnBloque(int numDeBloque, String Datos)
   {
       
   
   }
}
