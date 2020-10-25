/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import com.meia_2020.meia.AgregarAGrupos;
import com.meia_2020.meia.LoginForm;
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
            //creacion descriptor de bloque
            boolean arch_Desc_Bloques = new File("C:/MEIA/Desc_BloqueNo" + descIndiceGrupo.NoBloques+".json").exists();
            if (!arch_Desc_Bloques) 
            {
            try {  
                var creado = new File("C:/MEIA/Desc_BloqueNo" + descIndiceGrupo.NoBloques+".json").createNewFile();
                new Desc_Bloques().crearBitacora(LoginForm.UsuarioActual.usuario, String.valueOf(descIndiceGrupo.NoBloques));
            } catch (IOException ex) {
                Logger.getLogger(AgregarAGrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
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
                       
                        //creacion descriptor de bloque
            boolean arch_Desc_Bloques = new File("C:/MEIA/Desc_BloqueNo" + descIndiceGrupo.NoBloques+".json").exists();
            if (!arch_Desc_Bloques) 
            {
            try {  
                var creado = new File("C:/MEIA/Desc_BloqueNo" + descIndiceGrupo.NoBloques+".json").createNewFile();
                new Desc_Bloques().crearBitacora(LoginForm.UsuarioActual.usuario, String.valueOf(descIndiceGrupo.NoBloques));
            } catch (IOException ex) {
                Logger.getLogger(AgregarAGrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else
            {
                // ya existe el descriptor, actualizar
                var desBloque = new Desc_Bloques().devolverObjeto( String.valueOf(descIndiceGrupo.NoBloques));
                
                desBloque.fecha_modificacion=formatter.format(date);
                desBloque.usuario_modificacion=UsuarioActual;
                desBloque.num_registros++;
                desBloque.registros_activos++;
                desBloque.actualizarJson(desBloque, String.valueOf(descIndiceGrupo.NoBloques));
                var stop =0;
            }
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
   
   
   public void ActualizarLista() throws FileNotFoundException, IOException
   {
       if (new File("C:/MEIA/IndiceGrupos.txt").exists()) 
       {
        FileReader Archivo = new FileReader("C:/MEIA/IndiceGrupos.txt");
        BufferedReader lector = new BufferedReader(Archivo);
        var linea ="";
        List<String> Activos = new ArrayList<String>();        
        List<String> DesActivados = new ArrayList<String>();

        while ((linea = lector.readLine())!=null) {     
            var key = linea.split("\\|")[2];
            var status = linea.split("\\|")[4];
           
           
                Activos.add(key);
       }
        // obteniendo
        List<String> sortedList = Activos.stream().sorted().collect(Collectors.toList());
        var lol =0;
        lector.close();
        Archivo.close();
        //inserando ordenados
        Archivo = new FileReader("C:/MEIA/IndiceGrupos.txt");
        lector = new BufferedReader(Archivo);
         List<String> Todos = new ArrayList<String>();   
        while ((linea = lector.readLine())!=null) {     
            Todos.add(linea);
        }
        lector.close();
        Archivo.close();
        //asignando valores de siguiente
        List<String> OrdenadosPorSiguiente = new ArrayList<String>();
        var encontrado = false;
           for (int i = 0; i < Todos.size(); i++) 
           {
               //recorremos el 
                   var indice = Todos.get(i).split("\\|")[0];
                   var bloque = Todos.get(i).split("\\|")[1];
                   var llave = Todos.get(i).split("\\|")[2];
                   var siguiente = Todos.get(i).split("\\|")[3];
                   var estatusDePeticion = Todos.get(i).split("\\|")[4];
               for (int j = 0; j < Activos.size(); j++) 
               {
                   //recorremos el arreglo para ver cual es su orden alfabetico
                   //1|1.1|compañeros-ElRoches-Mischa|0|1
                   if (sortedList.get(j).equals(llave)) 
                   {
                       var Escritura=indice+"|"+bloque+"|"+llave+"|"+ (j++) +"|"+estatusDePeticion;
                       OrdenadosPorSiguiente.add(Escritura);
                       encontrado = true;
                       break;
                   }
                   
               }
               if (encontrado = false) 
               {
                   //esta desactivado
                       var Escritura=indice+"|"+bloque+"|"+llave+"|"+ 0 +"|"+0;
                       OrdenadosPorSiguiente.add(Escritura);
                               
               }
               
           }
           //aasdasdas
           var stop=0;
        }
   }
}
