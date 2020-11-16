/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

import com.meia_2020.meia.LoginForm;
import com.meia_2020.meia.Main;
import fase2.GruposMetodos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author marce
 */
public class MetodosBitacora {
    public void reorganizar() throws IOException{
        
        int cont = 0;
        FileReader file;
        var linex = "";
        try {
            file = new FileReader("C:/MEIA/bitacora_mensajes.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var linea="";
            try {
                while ((linea=fileRead.readLine())!= null) {
                    cont++;
                }
                file.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cont>=5){
            escribirMaestro();
            sobreescribirArchivoBorrados();
            File fileBorrar = new File("C:/MEIA/bitacora_mensajes.txt");
            fileBorrar.delete();
            fileBorrar.createNewFile();
        }
    }
    
    public void escribirMaestro(){
        var actualizar = new ArrayList<String>();
        FileReader file;
        var linex = "";
        FileWriter archivo;
        
        try {
            file = new FileReader("C:/MEIA/bitacora_mensajes.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var linea="";
            try {
                while ((linea=fileRead.readLine())!= null) {
                    archivo = new FileWriter("C:/MEIA/mensajes.txt",true);
                    archivo.write(linea+"\n");
                    archivo.close();
                }
                file.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sobreescribirArchivoBorrados() throws IOException{
        var sobreescribir = new GruposMetodos();
        var actualizar = new ArrayList<String>();
        int cont = 0;
        
        //mostrar mensajes recibidos 
        FileReader file;
        var linex = "";
        try {
            file = new FileReader("C:/MEIA/mensajes.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var linea="";
            try {
                while ((linea=fileRead.readLine())!= null) {
                 
                    var splited =linea.split("\\|");
                    if (splited[5].equals("1")) {
                        linex = splited[0] + "|" + splited[1] + "|" + splited[2] + "|" + splited[3] + "|" + splited[4] + "|" + splited[5];
                        actualizar.add(linex);
                        
                    }
                }
                file.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File fileBorrar = new File("C:/MEIA/mensajes.txt");
        fileBorrar.delete();
        fileBorrar.createNewFile();
        sobreescribir.sobreescribirArchivo("C:/MEIA/mensajes.txt", actualizar);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        var desc = new Desc_Mensajes();
        desc = new Desc_Mensajes().devolverObjeto();
        desc.num_registros = desc.registros_activos;
        desc.registros_inactivos = 0;
        desc.fecha_modificacion = formatter.format(date);
        desc.usuario_modificacion =LoginForm.UsuarioActual.usuario;
        desc.actualizarJson(desc);
    }
    
    public void cambiarEstado(String mensaje) throws IOException{
        var actualizar = new ArrayList<String>();
        var actualizar2 = new ArrayList<String>();
        var desc = new Desc_Mensajes();
        boolean encontradoMensajes = true;
        
        //carga de listas
        var lm = new DefaultListModel();
        var sobreescribir = new GruposMetodos();
        
        //mostrar mensajes recibidos 
        FileReader file;
        var linex = "";
        try {
            file = new FileReader("C:/MEIA/mensajes.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var linea="";
            try {
                while ((linea=fileRead.readLine())!= null) {
                 
                    var splited =linea.split("\\|");
                    String lineaMensaje = " " + splited[3];
                    if (splited[1].equals(LoginForm.UsuarioActual.usuario) && lineaMensaje.equals(mensaje) ) {
                        linex = splited[0] + "|" + splited[1] + "|" + splited[2] + "|" + splited[3] + "|" + splited[4] + "|" + "0";
                        actualizar.add(linex);
                    }else{
                        linex = splited[0] + "|" + splited[1] + "|" + splited[2] + "|" + splited[3] + "|" + splited[4] + "|" + splited[5];
                        actualizar.add(linex);
                    }
                }
                file.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            file = new FileReader("C:/MEIA/bitacora_mensajes.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var linea="";
            try {
                while ((linea=fileRead.readLine())!= null) {
                 
                    var splited =linea.split("\\|");
                    String lineaMensaje = " " + splited[3];
                    if (splited[1].equals(LoginForm.UsuarioActual.usuario) && lineaMensaje.equals(mensaje) ) {
                        linex = splited[0] + "|" + splited[1] + "|" + splited[2] + "|" + splited[3] + "|" + splited[4] + "|" + "0";
                        actualizar2.add(linex);
                        encontradoMensajes = false;
                    }else{
                        linex = splited[0] + "|" + splited[1] + "|" + splited[2] + "|" + splited[3] + "|" + splited[4] + "|" + splited[5];
                        actualizar2.add(linex);
                    }
                }
                file.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(encontradoMensajes){
            sobreescribir.sobreescribirArchivo("C:/MEIA/mensajes.txt", actualizar);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            desc = new Desc_Mensajes().devolverObjeto();
            desc.registros_activos--;
            desc.registros_inactivos++;
            desc.fecha_modificacion = formatter.format(date);
            desc.usuario_modificacion =LoginForm.UsuarioActual.usuario;
            desc.actualizarJson(desc);
        }else{
            sobreescribir.sobreescribirArchivo("C:/MEIA/bitacora_mensajes.txt", actualizar2);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            desc = new Desc_Mensajes().devolverObjeto();
            desc.registros_activos--;
            desc.registros_inactivos++;
            desc.fecha_modificacion = formatter.format(date);
            desc.usuario_modificacion =LoginForm.UsuarioActual.usuario;
            desc.actualizarJson(desc);
        }
        
    }
}
