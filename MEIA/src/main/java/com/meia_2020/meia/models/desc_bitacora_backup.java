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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author misch
 */
public class desc_bitacora_backup {
    public String nombreSimbolico;
    public String fechaCreacion;
    public String usuarioCreacion;
    public String fechaModificacion;
    public String usuarioModificacion;
    public int numRegistros;
    
    public static void WriteDescBinnacle(String modifUser)
    {
        String json = "";
        try
        {
            File desc = new File("C:/MEIA/desc_bitacora_backup.json");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            var gson = new Gson();
            var reader = new FileReader(desc.toString());
            var JsonToWrite = gson.fromJson(reader, desc_bitacora_backup.class);
            var writer = new FileWriter(desc.toString(), false);             
            reader.close();
            if (desc.length() != (long)0) {
                JsonToWrite.fechaModificacion = formatter.format(now);
                JsonToWrite.usuarioModificacion = modifUser;
                JsonToWrite.numRegistros++;
                writer.write(gson.toJson(JsonToWrite));
            }
            else
            {
                var Json = new desc_bitacora_backup();
                Json.nombreSimbolico = "bitacora_backup.json";
                Json.fechaCreacion = formatter.format(now);
                Json.usuarioCreacion = modifUser;
                Json.fechaModificacion = Json.fechaCreacion;
                Json.usuarioModificacion = modifUser;
                Json.numRegistros = 1;
                writer.write(gson.toJson((Json)));
            }
            writer.close();
        }
        catch (Exception e)
        {
            showMessageDialog(null, "No se ha podido actualizar la bitácora del backup correctamente.");
        }
    }
}
