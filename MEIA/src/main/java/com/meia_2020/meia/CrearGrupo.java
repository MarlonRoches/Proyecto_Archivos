/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;

import fase2.Desc_Grupos;
import java.io.BufferedReader;
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
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class CrearGrupo extends javax.swing.JFrame {

    /**
     * Creates new form CrearGrupo
     */
    public CrearGrupo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tNombreGrupo = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDescripcionGrupo = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del grupo:");

        jScrollPane1.setViewportView(tNombreGrupo);

        jLabel2.setText("Descripción:");

        jScrollPane2.setViewportView(tDescripcionGrupo);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreGrupo = tNombreGrupo.getText();
        String descripcionGrupo = tDescripcionGrupo.getText();
        List<String> gruposUsuario = new ArrayList<String>();
        boolean repetido = false;
        boolean creado = false;
        FileReader file;
        FileReader file2;
        var linea = "";
        
        try {
            file2 = new FileReader("C:/MEIA/Desc_Grupo.txt");
            BufferedReader fileRead = new BufferedReader(file2);
            try {
                if((linea=fileRead.readLine())!=null){
                    creado = true;
                }
            } catch (IOException ex) {
                Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            file = new FileReader("C:/MEIA/grupo.txt");
            BufferedReader fileRead = new BufferedReader(file);
            var lineaArchivo = "";

            try {
                while((lineaArchivo = fileRead.readLine()) != null){
                    var separado =lineaArchivo.split("\\|");
                    if (separado[0].equals(LoginForm.UsuarioActual.usuario)) {
                        gruposUsuario.add(separado[1]);
                    }

                    for(String grupo : gruposUsuario){
                        if(grupo.equals(nombreGrupo)){
                            repetido = true;
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(!repetido){
            Date fecha = new Date();
            FileWriter archivo;
            FileWriter admins;
            String lineaEscribir = LoginForm.UsuarioActual.usuario + "|" + nombreGrupo + "|" + descripcionGrupo + "|" + 0 + "|" + (new SimpleDateFormat("dd-MM-yyyy").format(fecha)) + "|" + 1;
            try {
                archivo = new FileWriter("C:/MEIA/grupo.txt",true);
                admins = new FileWriter("C:/MEIA/AdminsGrupo.txt",true);
                admins.write(LoginForm.UsuarioActual.usuario + "|" + nombreGrupo + "\n");
                admins.close();
                archivo.write(lineaEscribir+"\n");
                archivo.close();
                JOptionPane.showMessageDialog(null, "Grupo creado correctamente");
                this.setVisible(false);
                var manejoDeGrupos= new AgregarAGrupos();
                manejoDeGrupos.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar grupo");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya existe un grupo con el mismo nombre");
        }
        
        Date fecha = new Date();
        var json = new Desc_Grupos();
        if(creado){
            json.fecha_modificacion = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
            json.num_registros++; 
            json.registros_activos++;
            json.usuario_modificacion = LoginForm.UsuarioActual.usuario;
            json.actualizarJson(json);
        }else{
            json.crearBitacora(LoginForm.UsuarioActual.usuario);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        var form = new AgregarAGrupos();
        form.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane tDescripcionGrupo;
    private javax.swing.JTextPane tNombreGrupo;
    // End of variables declaration//GEN-END:variables
}
