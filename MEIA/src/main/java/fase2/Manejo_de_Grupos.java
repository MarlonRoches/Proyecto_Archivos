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
public class Manejo_de_Grupos {
    public int registro;
    public int posicion; 	
    String Key;
    public int siguiente;	
    public boolean estatus;
    
    public void DesactivarRegistro(String UsuarioActual,String Amigo,String Grupo)
    {
    }
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
            //descIndiceGrupo.RegistroDeInicio=1;
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
                try 
                {  
                    var creado = new File("C:/MEIA/Desc_BloqueNo" + descIndiceGrupo.NoBloques+".json").createNewFile();
                    new Desc_Bloques().crearBitacora(LoginForm.UsuarioActual.usuario, String.valueOf(descIndiceGrupo.NoBloques));
                } 
                catch (IOException ex) 
                {
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
        
            // TODO add your handling code here:
           UpdateArchivoIndexado();
             new GruposMetodos().Modificacion(Amigo, Grupo, formatter.format(date));
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
           
                UpdateArchivoIndexado();
                new GruposMetodos().Modificacion(Amigo, Grupo, formatter.format(date));
             return true;
        }
        else
        {
            //no existe, agregar
            return false;           

        }
    }
   
   public void Solicitudes() throws FileNotFoundException, IOException
   {
        var Archivo = new FileReader("C:/MEIA/IndiceGrupos.txt");
        var lector = new BufferedReader(Archivo);
         List<String> Todos = new ArrayList<String>();   
        var linea ="";
         while ((linea = lector.readLine())!=null) {     
            Todos.add(linea);
        }
        lector.close();
        Archivo.close();
        
       //
   }
   public void UpdateArchivoIndexado() throws FileNotFoundException, IOException
   {
       if (new File("C:/MEIA/IndiceGrupos.txt").exists() && new File("C:/MEIA/Desc_IndiceGrupos.json").exists()) 
       {
        FileReader Archivo = new FileReader("C:/MEIA/IndiceGrupos.txt");
        BufferedReader lector = new BufferedReader(Archivo);
        var linea ="";
        List<String> Activos = new ArrayList<String>();        
        List<String> DesActivados = new ArrayList<String>();

        while ((linea = lector.readLine())!=null)
        {     
            var key = linea.split("\\|")[2];
            var status = linea.split("\\|")[4];
            if (status.equals("1")) 
            {
            Activos.add(key);
                
            }else
            {
            DesActivados.add(key); 
            }
       }
        // obteniendo
        List<String> ActivosOrdenados = Activos.stream().sorted().collect(Collectors.toList());
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
        //Para los activos
           for (int i = 0; i < ActivosOrdenados.size(); i++) 
           {
               
                   //actual, la que estoy buscando para asignarle
                    var KeyActual = ActivosOrdenados.get(i);
                   String infoActual="";
                   for (int j = 0; j < Todos.size(); j++) 
                       {//buscando la iteracion que conlleve al siguiente
                            var indice = Todos.get(j).split("\\|")[0];
                            var bloque = Todos.get(j).split("\\|")[1];
                            var llavesig = Todos.get(j).split("\\|")[2];
                            var siguiente = Todos.get(j).split("\\|")[3];
                            var estatusDePeticion = Todos.get(j).split("\\|")[4];
                           if (KeyActual.equals(llavesig)) 
                           {
                               //hace match con su siguiente
                               infoActual=Todos.get(j);
                               break;
                           }
                       }
                    var indiceSiguiente =i+1;
                   if (indiceSiguiente==ActivosOrdenados.size()) 
                   {
                    OrdenadosPorSiguiente.add(infoActual.split("\\|")[0]+"|"+infoActual.split("\\|")[1]+"|"+infoActual.split("\\|")[2]+"|"+0 +"|"+ 1);

                    break;
                    }
                       //buscar indice de la llave siguiente
                       var keySiguiente =ActivosOrdenados.get(indiceSiguiente);
                       for (int j = 0; j < Todos.size(); j++) 
                       {//buscando la iteracion que conlleve al siguiente
                            var indice = Todos.get(j).split("\\|")[0];
                            var bloque = Todos.get(j).split("\\|")[1];
                            var llavesig = Todos.get(j).split("\\|")[2];
                            var siguiente = Todos.get(j).split("\\|")[3];
                            var estatusDePeticion = Todos.get(j).split("\\|")[4];
                           if (keySiguiente.equals(llavesig)) 
                           {
                               //hace match con su siguiente
                               OrdenadosPorSiguiente.add(infoActual.split("\\|")[0]+"|"+infoActual.split("\\|")[1]+"|"+infoActual.split("\\|")[2]+"|"+indice +"|"+ 1);
                               
                               var sto=0;
                               break;
                           }
                       }
                       var stop=0;
           }
                      
//agregando los desactivados
           for (int i = 0; i < DesActivados.size(); i++) {
               var KeyActual = DesActivados.get(i);
                   var infoDesactivado="";
                   for (int j = 0; j < Todos.size(); j++) 
                       {//buscando la iteracion que conlleve al siguiente
                            var indice = Todos.get(j).split("\\|")[0];
                            var bloque = Todos.get(j).split("\\|")[1];
                            var llavesig = Todos.get(j).split("\\|")[2];
                            var siguiente = Todos.get(j).split("\\|")[3];
                            var estatusDePeticion = Todos.get(j).split("\\|")[4];
                           if (KeyActual.equals(llavesig)) 
                           {
                               //hace match con su siguiente
                               infoDesactivado=Todos.get(j);
                               OrdenadosPorSiguiente.add(indice+"|"+bloque+"|"+llavesig+"|"+0+"|"+0);
                               break;
                           }
                       }
           }
           
            var indiceInicial="";
           var KeyActual = ActivosOrdenados.get(0);
           for (int i = 0; i < Todos.size(); i++) {
               
                   var indfoInical="";
                   for (int j = 0; j < Todos.size(); j++) 
                       {//buscando la iteracion que conlleve al siguiente
                            var indice = Todos.get(j).split("\\|")[0];
                            var bloque = Todos.get(j).split("\\|")[1];
                            var llavesig = Todos.get(j).split("\\|")[2];
                            var siguiente = Todos.get(j).split("\\|")[3];
                            var estatusDePeticion = Todos.get(j).split("\\|")[4];
                           if (KeyActual.equals(llavesig)) 
                           {
                               //hace match con su siguiente
                               indiceInicial=indice;
                               break;
                           }
                       }
           }
           
            List<String> TodosOrdenados = OrdenadosPorSiguiente.stream().sorted().collect(Collectors.toList());
                     
            //mandar a escribir
            var WriterIndice = new FileWriter("C:/MEIA/IndiceGrupos.txt", false);
            for (int i = 0; i < TodosOrdenados.size(); i++) 
            {
            String aEscribir=TodosOrdenados.get(i)+"\n";
            WriterIndice.write(aEscribir);
           }
            WriterIndice.close();
            
            
            //actualizando json
              //actualizar descriptor
            var json = new Desc_IndiceGrupos().devolverObjeto();
            json.registro_inicial=Integer.parseInt(indiceInicial);
            json.registros_inactivos=DesActivados.size();
            json.registros_activos=Activos.size();
            json.num_registros=Todos.size();
            json.actualizarJson(json);
            
           var end=0;
        }
   }
}
