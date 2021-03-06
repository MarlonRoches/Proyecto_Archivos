/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia.models;

import com.google.gson.Gson;
import com.meia_2020.meia.LoginForm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author misch
 */
public class Friendship {
    public String key;
    public String user;
    public String friend;
    public boolean accepted;
    public String transactionDate;
    public String transactionUser;
    public boolean status;
    
    public Friendship(){}
    
    public static Friendship CreateNewFriendship(String friend)
    {
        var newFriendship = new Friendship();
        newFriendship.key = LoginForm.UsuarioActual.usuario + "," + friend;
        newFriendship.user = LoginForm.UsuarioActual.usuario;
        newFriendship.friend = friend;
        newFriendship.accepted = false;
        newFriendship.transactionDate = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z").format(new Date(System.currentTimeMillis()));
        newFriendship.transactionUser = LoginForm.UsuarioActual.usuario;
        newFriendship.status = true;
        return newFriendship;
    }
    
    public static void WriteFile(HashMap<String, Friendship> friendsDictionary, String route, String user, boolean addedRegister) throws IOException
    {
        var fileToWrite = new File(route);
        try (java.io.FileWriter writer = new FileWriter(fileToWrite, false)) {
            for (var value : friendsDictionary.values()) {
                writer.write(Friendship.GetString(value) + System.lineSeparator());
            }
        }
        WriteDescFile(user, addedRegister);
    }
    
    public static void WriteDescFile(String modifUser, boolean addedRegister){
        String json = "";
        try
        {
            File desc = new File("C:/MEIA/desc_lista_amigos.json");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'at' HH:mm:ss");
            var now = LocalDateTime.now();
            var gson = new Gson();
            var reader = new FileReader(desc.toString());
            var JsonToWrite = gson.fromJson(reader, desc_lista_amigos.class);  
            var writer = new FileWriter(desc.toString(), false);
            reader.close();
            if (JsonToWrite != null) {
                JsonToWrite.fechaModificacion = formatter.format(now);
                JsonToWrite.usuarioModificacion = modifUser;
                if (addedRegister) {
                    JsonToWrite.numRegistros++;
                }
                writer.write(gson.toJson(JsonToWrite));
            }
            else
            {
                var Json = new desc_lista_amigos();
                Json.nombreSimbolico = "lista_amigos.txt";
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
    
    private static String GetString(Friendship friends)
    {
        String friendshipString = "";
        friendshipString += friends.key + "|";
        friendshipString += friends.user + "|";
        friendshipString += friends.friend + "|";
        friendshipString += friends.accepted ? "1" : "0";
        friendshipString += "|" + friends.transactionDate + "|";
        friendshipString += friends.transactionUser + "|";
        friendshipString += friends.status ? "1" : "0";
        return friendshipString;
    }
    
    public static HashMap<String, Friendship> GetMapFromFileRoute(String route) throws FileNotFoundException, IOException
    {
        HashMap<String, Friendship> friendsDictionary;
        try (java.io.FileReader fileForReading = new FileReader(route)) {
            var buffer = new BufferedReader(fileForReading);
            var line = "";
            friendsDictionary = new HashMap<>();
            while((line = buffer.readLine()) != null)
            {
                var newFriends = CreateFriendshipFromString(line);
                friendsDictionary.put(newFriends.key, newFriends);
            }
            buffer.close();
        }
        return friendsDictionary;
    }
    
    private static Friendship CreateFriendshipFromString(String line)
    {
        var array = line.split("\\|");
        var newFriends = new Friendship();
        newFriends.key = array[0];
        newFriends.user = array[1];
        newFriends.friend = array[2];
        newFriends.accepted = "1".equals(array[3]);
        newFriends.transactionDate = array[4];
        newFriends.transactionUser = array[5];
        newFriends.status = "1".equals(array[6]);
        return newFriends;
    }
    
    public static void AddFriend(HashMap<String, Friendship> friendsDictionary, String friend, String user, String route) throws IOException{
        for(var friendship : friendsDictionary.keySet()){
            if (friendship.contains(user) && friendship.contains(friend)) {
                friendsDictionary.get(friendship).accepted = true;
            }
        }
        Friendship.WriteFile(friendsDictionary, route, user, false);
    }
    
    public static void DeleteFriend(HashMap<String, Friendship> friendsDictionary, String friend, String user, String route) throws IOException{
        for(var friendship : friendsDictionary.keySet()){
            if (friendship.contains(user) && friendship.contains(friend)) {
                friendsDictionary.get(friendship).status = false;
            }
        }
        Friendship.WriteFile(friendsDictionary, route, user, false);
    }
    
    public static boolean CheckIfExists(HashMap<String, Friendship> friendsDictionary, String user, String friend){
        var keyList = friendsDictionary.keySet();
        for(var key : keyList){
            if (key.contains(user) && key.contains(friend)) {
                return true;
            }
        }
        return false;
    }
}
