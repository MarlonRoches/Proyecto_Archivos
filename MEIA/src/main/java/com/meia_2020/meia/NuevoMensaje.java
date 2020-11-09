/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class NuevoMensaje extends javax.swing.JFrame {

    /**
     * Creates new form NuevoMensaje
     */
    public NuevoMensaje() {
        initComponents();
        
        //carga de listas
         var lm = new DefaultListModel();
        //mostrar amigos 
        FileReader file;
        var linex = "";
        try {
            file = new FileReader("C:/MEIA/lista_amigos.txt");
              BufferedReader fileRead = new BufferedReader(file);
              var linea="";
             try {
                 while ((linea=fileRead.readLine())!= null) {
                 
                     var splited =linea.split("\\|");
                     if (splited[1].equals(LoginForm.UsuarioActual.usuario) && splited[6].equals("1") ) {
                         linex += splited[2]+"," ;
                     }
                     var lol =0;
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
        ListaAmigosMensajes.setModel(lm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensajeEnviar = new javax.swing.JTextPane();
        cTipoMensaje = new javax.swing.JComboBox<>();
        bEnviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaAmigosMensajes = new javax.swing.JList<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enviar a:");

        jLabel2.setText("Mensaje");

        jScrollPane2.setViewportView(mensajeEnviar);

        cTipoMensaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Público", "Privado" }));
        cTipoMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTipoMensajeActionPerformed(evt);
            }
        });

        bEnviar.setText("Enviar");
        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarActionPerformed(evt);
            }
        });

        ListaAmigosMensajes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(ListaAmigosMensajes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(98, 98, 98))
                    .addComponent(jScrollPane3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(cTipoMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(bEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cTipoMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEnviar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarActionPerformed
        Date fecha = new Date();
        
        //componentes del archivo 
        String mensaje = mensajeEnviar.getText();
        String amigoSeleccionado = ListaAmigosMensajes.getSelectedValue();
        String tipo = cTipoMensaje.getSelectedItem().toString();
        String fechaEnviado = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
        
        //linea a escribir
        String linea = LoginForm.UsuarioActual.usuario + "|" + amigoSeleccionado + "|" + fechaEnviado + "|" + mensaje + "|" + tipo + "|" + "1" + "\n";
        
        FileWriter archivo;
        if((!amigoSeleccionado.equals(null)) && (!mensaje.equals(null)) && (!LoginForm.UsuarioActual.usuario.equals(null))){
            try {
            archivo = new FileWriter("C:/MEIA/mensajes.txt",true);
            archivo.write(linea);
            archivo.close();
            JOptionPane.showMessageDialog(null, "Mensaje enviado correctamente :)");
            this.setVisible(false);
            var main = new Main();
            main.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Uno de los datos ingresados es incorrecto");
            }
        }
    }//GEN-LAST:event_bEnviarActionPerformed

    private void cTipoMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTipoMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cTipoMensajeActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoMensaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaAmigosMensajes;
    private javax.swing.JButton bEnviar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cTipoMensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane mensajeEnviar;
    // End of variables declaration//GEN-END:variables
}