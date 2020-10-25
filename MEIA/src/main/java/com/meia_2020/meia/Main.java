/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;
import static com.meia_2020.meia.BuscarUsuario.global_Ruta;
import com.meia_2020.meia.models.Archivo_Usuario;
import com.meia_2020.meia.models.Data;
import com.meia_2020.meia.models.Usuario;
import fase2.Amigo;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author roche
 */
public class Main extends javax.swing.JFrame {

    /**LoginForm.UsuarioActual.rol
     * Creates new form Main
     */
    public Main() {
        initComponents();
        
        
        
        if (LoginForm.UsuarioActual.rol) {
            
            //es admin
            labelNombre.setText("Bienvenido Admin: "+ LoginForm.UsuarioActual.usuario );
        } else{
         labelNombre.setText("Bienvenido Usuario: "+ LoginForm.UsuarioActual.usuario );
        }
        
        
        
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
                     if (splited[0].equals(LoginForm.UsuarioActual.usuario) && splited[5].equals("1") ) {
                         linex += splited[1]+"," ;
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
        ListaAmigos.setModel(lm);
        lm = new DefaultListModel();
        //mostrar amigos 
         
             linex = "";
        try {
            file = new FileReader("C:/MEIA/grupo.txt");
              BufferedReader fileRead = new BufferedReader(file);
              var linea="";
             try {
                 while ((linea=fileRead.readLine())!= null) {
                 
                     var splited =linea.split("\\|");
                     if (splited[0].equals(LoginForm.UsuarioActual.usuario)&& splited[5].equals("1")) {
                         linex += splited[1]+"," ;
                     }
                     var lol =0;
                 }} 
             catch (IOException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
     
     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
       week= linex.split(",");
        
       lm = new DefaultListModel();
        for (int i = 0; i < week.length; i++) {
            lm.addElement(week[i]);
        }
        ListaGrupos.setModel(lm);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        BtnBackup = new javax.swing.JButton();
        Btn_CrearUsuario = new javax.swing.JButton();
        Btn_BuscarUsuario = new javax.swing.JButton();
        BuscarUsuario_TxtBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaAmigos = new javax.swing.JList<>();
        BtnBackup1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaGrupos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BtnAgregarAmigos = new javax.swing.JButton();
        BtnAdministrarAmigos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Modoficar Mis Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnBackup.setText("Hacer Un BackUp");
        BtnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackupActionPerformed(evt);
            }
        });

        Btn_CrearUsuario.setText("Crear Usuario");
        Btn_CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CrearUsuarioActionPerformed(evt);
            }
        });

        Btn_BuscarUsuario.setText("Buscar Usuario");
        Btn_BuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Bienvenido: ");

        labelNombre.setText("Bienvenido: ");

        ListaAmigos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "none" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaAmigos.setEnabled(false);
        jScrollPane1.setViewportView(ListaAmigos);

        BtnBackup1.setText("Manejo De Grupos");
        BtnBackup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackup1ActionPerformed(evt);
            }
        });

        ListaGrupos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "none" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaGrupos.setEnabled(false);
        jScrollPane2.setViewportView(ListaGrupos);

        jLabel2.setText("Amigos");

        jLabel3.setText("Grupos");

        jButton2.setText("Log Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BtnAgregarAmigos.setText("Agregar amigos");
        BtnAgregarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarAmigosActionPerformed(evt);
            }
        });

        BtnAdministrarAmigos.setLabel("Administrar Amigos");
        BtnAdministrarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdministrarAmigosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuscarUsuario_TxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(BtnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_CrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnBackup1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnAgregarAmigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnAdministrarAmigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNombre)
                                .addGap(31, 31, 31)
                                .addComponent(BuscarUsuario_TxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_BuscarUsuario)
                                .addGap(36, 36, 36)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_CrearUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnBackup))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnBackup1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnAgregarAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnAdministrarAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackupActionPerformed
        // TODO add your handling code here:
        // Botón para el backup
        if (LoginForm.UsuarioActual.rol == true) {
            BackUpFrame backup = new BackUpFrame();
            backup.setVisible(true);
        }
        else
        {
            showMessageDialog(null, "No tienes permisos de administrador");
        }
        
        
        
    }//GEN-LAST:event_BtnBackupActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            //vamos a buscar el rol del usuario actual
          //if (LoginForm.UsuarioActual.rol) {
            //es admin
            //abrimos uno nuevo
            var buscarUsuarioFrame = new BuscarUsuario();
            buscarUsuarioFrame.setVisible(true);
        
              
       // } else{ 
       //      showMessageDialog(null, "No tienes permisos de Admin");
         // }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Btn_CrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CrearUsuarioActionPerformed
        // TODO add your handling code here:
        var crearUsuarioFrame = new CrearUsuario();
            crearUsuarioFrame.setVisible(true);
    }//GEN-LAST:event_Btn_CrearUsuarioActionPerformed

    private void Btn_BuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarUsuarioActionPerformed
        // TODO add your handling code here:
         String userName = BuscarUsuario_TxtBox.getText();
            boolean existe = false;
           global_Ruta= new Archivo_Usuario().ArchivoPerteneciente(userName);
           
            if (global_Ruta.equals(""))
        {
             showMessageDialog(null, "El usuario no existe");
             BuscarUsuario_TxtBox.setText("");
            
        }
        else
        {
            showMessageDialog(null, "El usuario si existe, se ubica en :" + global_Ruta );
            BuscarUsuario_TxtBox.setText("");
            
        }
           
           
    }//GEN-LAST:event_Btn_BuscarUsuarioActionPerformed

    private void BtnBackup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackup1ActionPerformed
        // TODO add your handling code here:
     var AgregarAGrupoFrame = new AgregarAGrupos();
     this.setVisible(false);
            AgregarAGrupoFrame.setVisible(true);
    }//GEN-LAST:event_BtnBackup1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        var nuevoLogin = new LoginForm();
        this.setVisible(false);
        nuevoLogin.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BtnAgregarAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarAmigosActionPerformed
        // TODO add your handling code here:
        var agregarAmigos = new AgregarAmigos();
        agregarAmigos.setVisible(true);
    }//GEN-LAST:event_BtnAgregarAmigosActionPerformed

    private void BtnAdministrarAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAdministrarAmigosActionPerformed
        // TODO add your handling code here:
        try {
            var administrarAmigos = new AdministrarAmigos();
            administrarAmigos.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnAdministrarAmigosActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdministrarAmigos;
    private javax.swing.JButton BtnAgregarAmigos;
    private javax.swing.JButton BtnBackup;
    private javax.swing.JButton BtnBackup1;
    private javax.swing.JButton Btn_BuscarUsuario;
    private javax.swing.JButton Btn_CrearUsuario;
    private javax.swing.JTextField BuscarUsuario_TxtBox;
    private javax.swing.JList<String> ListaAmigos;
    private javax.swing.JList<String> ListaGrupos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
}
