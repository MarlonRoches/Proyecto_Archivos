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
        FileReader file;
        FileWriter escribir;
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
                        if(user == usuario){
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
            escribir = new FileWriter("C:/MEIA/grupo.txt");
            file = new FileReader("C:/MEIA/grupo.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var lineaArchivo = "";
            
                while((lineaArchivo = fileRead.readLine()) != null){
                    var separado = lineaArchivo.split("\\|");
                    if (separado[1].equals(grupo)) {
                        escribir = new FileWriter("C:/MEIA/grupo.txt");
                        descripcionGrupo = separado[2];
                        cantidadMiembros = Integer.parseInt(separado[3]) + 1;
                        String nuevaLinea = separado[0] + separado[1] + separado[2] + cantidadMiembros + separado[4] + separado[5];
                        escribir.write(nuevaLinea);
                        escribir.close();
                    }

                    for(String user : usuariosGrupo){
                        if(user == usuario){
                            existe = true;
                        }
                    }
                }
            
            String nuevoAmigo = usuario + "|" + grupo + "|" + descripcionGrupo + "|" + cantidadMiembros + "|" + fecha + "|" + 1;
            escribir = new FileWriter("C:/MEIA/grupo.txt");
            escribir.append(nuevoAmigo + "\n");
            escribir.close();
            JOptionPane.showMessageDialog(null, usuario + " fue agregado al grupo");
        }else{
            JOptionPane.showMessageDialog(null, usuario + " ya es parte del grupo");
        }
    }
    
    public void Eliminacion(String usuario, String grupo , String fecha)
    {
        
    }
}
