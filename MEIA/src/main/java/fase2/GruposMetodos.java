/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import com.meia_2020.meia.CrearGrupo;
import com.meia_2020.meia.LoginForm;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roche
 */
public class GruposMetodos {
    
   public void Busqueda(String Grupo)
    {
    
    }
    
   public void Modificacion(String usuario, String grupo, String fecha) throws FileNotFoundException, IOException
    {
        List<String> usuariosGrupo = new ArrayList<String>();
        var actualizar = new ArrayList<String>();
        FileReader file;
        boolean existe = false;
        
        try {
            file = new FileReader("C:/MEIA/grupo.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var lineaArchivo = "";

            try {
                while((lineaArchivo = fileRead.readLine()) != null){
                    var separado =lineaArchivo.split("\\|");
                    if (separado[1].equals(grupo)) {
                        usuariosGrupo.add(separado[0]);
                    }

                    for(String user : usuariosGrupo){
                        if(user.equals(usuario)){
                            existe = true;
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!existe){
            String descripcionGrupo = "";
            int cantidadMiembros = 0;
            file = new FileReader("C:/MEIA/grupo.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var lineaArchivo = "";
            
                while((lineaArchivo = fileRead.readLine()) != null){
                    var separado = lineaArchivo.split("\\|");
                    if (separado[1].equals(grupo)) {
                        descripcionGrupo = separado[2];
                        cantidadMiembros = Integer.parseInt(separado[3]) + 1;
                        String nuevaLinea = separado[0] + "|" + separado[1] + "|" + separado[2] + "|" + cantidadMiembros + "|" + separado[4] + "|" + separado[5];
                        actualizar.add(nuevaLinea);
                    }else{
                        String nuevaLinea = separado[0] +"|"+ separado[1] +"|"+ separado[2] +"|"+ separado[3] +"|"+ separado[4] +"|"+ separado[5];
                        actualizar.add(nuevaLinea);
                        
                    }
                }
            
            String nuevoAmigo = usuario + "|" + grupo + "|" + descripcionGrupo + "|" + cantidadMiembros + "|" + fecha + "|" + 1;
            actualizar.add(nuevoAmigo + "\n");
            sobreescribirArchivo("C:/MEIA/grupo.txt", actualizar);
            JOptionPane.showMessageDialog(null, usuario + " fue agregado al grupo");
        }else{
            JOptionPane.showMessageDialog(null, usuario + " ya es parte del grupo");
        }
    }
    
    public void Eliminacion(String usuario, String grupo) throws IOException
    {
        var actualizar = new ArrayList<String>();
        FileReader file;
        
        if(!LoginForm.UsuarioActual.usuario.equals(usuario)){
        try {
            file = new FileReader("C:/MEIA/grupo.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var lineaArchivo = "";

            try {
                while((lineaArchivo = fileRead.readLine()) != null){
                    var separado =lineaArchivo.split("\\|");
                    if (separado[0].equals(usuario)) {
                        if(separado[1].equals(grupo)){
                        String usuarioActualizado = separado[0] + "|" + separado[1] + "|" + separado[2] + "|" + separado[3] + "|" + separado[4] + "|" + 0;
                        actualizar.add(usuarioActualizado);
                        }
                    }else{
                        String usuarioActualizado = separado[0] + "|" + separado[1] + "|" + separado[2] + "|" + separado[3] + "|" + separado[4] + "|" + separado[5];
                        actualizar.add(usuarioActualizado);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sobreescribirArchivo("C:/MEIA/grupo.txt", actualizar);
        JOptionPane.showMessageDialog(null, usuario + " fue eliminado del grupo");
        }else{
            JOptionPane.showMessageDialog(null, "Eres el admin, no puedes eliminarte del grupo");
        }
        
        
        
    }
    
    public void sobreescribirArchivo(String ruta, ArrayList<String> array) throws IOException{
        
        FileWriter fw = new FileWriter(ruta, false);       
        PrintWriter pw = new PrintWriter(fw);       

        for (int i = 0; i <= array.size(); i++) {
            if (i == array.size() -1) {
                var linea =array.toArray()[i].toString();
                pw.print(array.toArray()[i].toString()+"\n");
                break;
            } else {
                var linea =array.toArray()[i].toString();
                pw.println(array.toArray()[i].toString());
            }
        }
        pw.close();
        fw.close();
    }
}
