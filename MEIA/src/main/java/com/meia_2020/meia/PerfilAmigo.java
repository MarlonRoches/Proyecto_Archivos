/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;

import Fase3.Desc_Arbol;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author roche
 */
public class PerfilAmigo extends javax.swing.JFrame {

    /**
     * Creates new form PerfilAmigo
     */
    
   public static String usuarioSeleccionado;
    
    public PerfilAmigo() {
        initComponents();
    }
    
    public void mostrarMensajes(String seleccionado){
        usuarioSeleccionado = seleccionado;
        //carga de listas
        var lm = new DefaultListModel();
        
        //mostrar amigos 
        FileReader file;
        var linex = "";
        try {
            file = new FileReader("C:/MEIA/mensajes.txt");
              BufferedReader fileRead = new BufferedReader(file);
              var linea="";
             try {
                 while ((linea=fileRead.readLine())!= null) {
                 
                     var splited =linea.split("\\|");
                     if (splited[1].equals(usuarioSeleccionado) && splited[4].equals("1") && splited[5].equals("1")) {
                         linex += splited[0] + ": " + splited[3] + "," ;
                     }
                 }} 
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
                     if (splited[1].equals(usuarioSeleccionado) && splited[4].equals("1") && splited[5].equals("1")) {
                         linex += splited[0] + ": " + splited[3] + "," ;
                     }
                 }} 
             catch (IOException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
     
     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        var week= linex.split(",");
        
        lm = new DefaultListModel();
        for (int i = 0; i < week.length; i++) {
            lm.addElement(week[i]);
        }
        lMensajesAmigo.setModel(lm);
        mostrarDatos(usuarioSeleccionado);
    }
    
    public void mostrarDatos(String seleccionado){
        //carga de listas
        var lm = new DefaultListModel();
        
        //mostrar amigos 
        FileReader file;
        var linex = "";
        try {
            file = new FileReader("C:/MEIA/usuario.txt");
              BufferedReader fileRead = new BufferedReader(file);
              var linea="";
             try {
                 while ((linea=fileRead.readLine())!= null) {
                 
                     var splited =linea.split("\\|");
                     if(splited[0].equals(seleccionado)){
                         NombreDeUsuario1.setText(splited[1] + " " + splited[2]);
                         NombreDeUsuario.setText(splited[0]);
                         NombreDeUsuario3.setText("Cumpleaños: " + splited[5]);
                         NombreDeUsuario4.setText(splited[6]);
                         NombreDeUsuario5.setText(splited[7]);
                     }
                 }} 
             catch (IOException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NombreDeUsuario = new javax.swing.JLabel();
        NombreDeUsuario1 = new javax.swing.JLabel();
        NombreDeUsuario3 = new javax.swing.JLabel();
        NombreDeUsuario4 = new javax.swing.JLabel();
        NombreDeUsuario5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lMensajesAmigo = new javax.swing.JList<>();
        NombreDeUsuario6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton2.setText("VER FOTOS");

        jButton3.setText("VER FOTOS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Perfil De:");

        NombreDeUsuario.setText("Nombre Usuario");

        NombreDeUsuario1.setText("Nombre");

        NombreDeUsuario3.setText("Cumpleaños");

        NombreDeUsuario4.setText("Correo");

        NombreDeUsuario5.setText("Telefono");

        lMensajesAmigo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lMensajesAmigo);

        NombreDeUsuario6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NombreDeUsuario6.setText("Mensajes:");

        jButton1.setText("Ver fotos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(NombreDeUsuario3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NombreDeUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NombreDeUsuario4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NombreDeUsuario5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NombreDeUsuario6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NombreDeUsuario6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NombreDeUsuario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreDeUsuario)
                        .addGap(11, 11, 11)
                        .addComponent(NombreDeUsuario3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreDeUsuario4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreDeUsuario5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        var form = new FotoDeAmigo();
        form.Path="C:/MEIA/Fotografias/";        
        form.Usuario=NombreDeUsuario.getText();
        form.setVisible(true);
        //NombreDeUsuario
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilAmigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NombreDeUsuario;
    private javax.swing.JLabel NombreDeUsuario1;
    private javax.swing.JLabel NombreDeUsuario3;
    private javax.swing.JLabel NombreDeUsuario4;
    private javax.swing.JLabel NombreDeUsuario5;
    private javax.swing.JLabel NombreDeUsuario6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lMensajesAmigo;
    // End of variables declaration//GEN-END:variables
}
