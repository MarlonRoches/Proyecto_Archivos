/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author marce
 */
public class desc_usuario {
    public String nombreSimbolico;
    public String fechaCreacion;
    public String usuarioCreacion;
    public String fechaModificacion;
    public String usuarioModificacion;
    public int numRegistros;
    
    public static void WriteDescBinnacle(int contador) throws IOException
    {
        String json = "";
        try
        {
            File desc = new File("C:/MEIA/desc_usuario.json");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            var writer = new FileWriter(desc.toString(), false);
            var gson = new Gson();
            if (desc.length() != 0) {
                BufferedReader reader = new BufferedReader(new FileReader(desc.toString()));
                String line = "";
                while((line = reader.readLine()) != null) json += line;
                reader.close();
                var JsonToWrite = gson.fromJson(json, desc_bitacora_backup.class);
                JsonToWrite.fechaModificacion = formatter.format(now);
                JsonToWrite.usuarioModificacion = "admin";
                JsonToWrite.numRegistros += contador;
                writer.write(gson.toJson(JsonToWrite));
            }
            else
            {
                var Json = new desc_bitacora_usuarios();
                Json.nombreSimbolico = "usuario.txt";
                Json.fechaCreacion = formatter.format(now);
                Json.usuarioCreacion = "admin";
                Json.fechaModificacion = Json.fechaCreacion;
                Json.usuarioModificacion = "admin";
                Json.numRegistros = 1;
                writer.write(gson.toJson((Json)));
            }
            writer.close();
        }
        catch(Exception e)
        {
            showMessageDialog(null, "No se ha podido actualizar la bitácora de usuarios correctamente.");
        }
    }
}
