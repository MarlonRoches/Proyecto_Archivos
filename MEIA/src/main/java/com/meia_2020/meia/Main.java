/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;
import static com.meia_2020.meia.BuscarUsuario.global_Ruta;
import com.meia_2020.meia.models.Archivo_Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
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
        
        
        
        if ((LoginForm.UsuarioActual.rol).equals("1")) {
         //es admin
         labelNombre.setText("Bienvenido admin: "+ LoginForm.UsuarioActual.usuario );
        } else{
         labelNombre.setText("Bienvenido usuario: "+ LoginForm.UsuarioActual.usuario );
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
                 
                     var splitted =linea.split("\\|");
                     if (splitted[1].equals(LoginForm.UsuarioActual.usuario) && splitted[6].equals("1") && splitted[3].equals("1")) {
                         linex += splitted[2]+"," ;
                     }
                      else if(splitted[2].equals(LoginForm.UsuarioActual.usuario) && splitted[6].equals("1") && splitted[3].equals("1")){
                        linex += splitted[1]+"," ;
                     }
                 }
             } 
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
                     if (splited[0].equals(LoginForm.UsuarioActual.usuario) && splited[5].equals("1")) {
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
        
       // mostrar mensajes
        linex = "";
        try {
            file = new FileReader("C:/MEIA/mensajes.txt");
              BufferedReader fileRead = new BufferedReader(file);
              var linea="";
             try {
                 while ((linea=fileRead.readLine())!= null) {
                 
                     var splited =linea.split("\\|");
                     if (splited[1].equals(LoginForm.UsuarioActual.usuario) && splited[5].equals("1")) {
                         linex += splited[0]+" : "+ splited[3] +"," ;
                     }
                     var lol =0;
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
                     if (splited[1].equals(LoginForm.UsuarioActual.usuario) && splited[5].equals("1")) {
                         linex += splited[0]+" : "+ splited[3] +"," ;
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
        ListaMensajes.setModel(lm);
        
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
        jButton3 = new javax.swing.JButton();
        bEnviarMensajes = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaMensajes = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        admin = new javax.swing.JButton();
        bMensajesAjenos1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Modificar mis datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnBackup.setText("Hacer un backup");
        BtnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackupActionPerformed(evt);
            }
        });

        Btn_CrearUsuario.setText("Crear usuario");
        Btn_CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CrearUsuarioActionPerformed(evt);
            }
        });

        Btn_BuscarUsuario.setText("Buscar usuario");
        Btn_BuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarUsuarioActionPerformed(evt);
            }
        });

        labelNombre.setText("Bienvenido: ");

        ListaAmigos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "none" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaAmigos);

        BtnBackup1.setText("Manejo de grupos");
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

        jButton2.setText("Log out");
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

        BtnAdministrarAmigos.setText("Administrar amigos");
        BtnAdministrarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdministrarAmigosActionPerformed(evt);
            }
        });

        jButton3.setText("Administrar mis fotos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        bEnviarMensajes.setText("Enviar mensaje");
        bEnviarMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarMensajesActionPerformed(evt);
            }
        });

        ListaMensajes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "none" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaMensajes.setEnabled(false);
        jScrollPane3.setViewportView(ListaMensajes);

        jLabel4.setText("Mis Mensajes");

        admin.setText("Administrar mensajes");
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });

        bMensajesAjenos1.setText("Ver perfil");
        bMensajesAjenos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMensajesAjenos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuscarUsuario_TxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BtnAgregarAmigos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnBackup1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnBackup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_CrearUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(Btn_BuscarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(BtnAdministrarAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(72, 72, 72)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bEnviarMensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bMensajesAjenos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 157, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bMensajesAjenos1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bEnviarMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BuscarUsuario_TxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Btn_BuscarUsuario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Btn_CrearUsuario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnBackup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnBackup1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnAgregarAmigos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnAdministrarAmigos))))
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
                this.setVisible(false);

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
        this.setVisible(false);
        var nuevoLogin = new LoginForm();
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        var form = new Imagenes();
        form.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bEnviarMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarMensajesActionPerformed
        
        this.setVisible(false);
                var enviarMensaje = new NuevoMensaje();
        enviarMensaje.setVisible(true);
    }//GEN-LAST:event_bEnviarMensajesActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        administrarMensajes administrar = new administrarMensajes();
        administrar.setVisible(true);
    }//GEN-LAST:event_adminActionPerformed

    private void bMensajesAjenos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMensajesAjenos1ActionPerformed
        this.setVisible(false);
        PerfilAmigo perfil = new PerfilAmigo();
        perfil.setVisible(true);
        perfil.mostrarMensajes(ListaAmigos.getSelectedValue().toString());
    }//GEN-LAST:event_bMensajesAjenos1ActionPerformed

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
    private javax.swing.JList<String> ListaMensajes;
    private javax.swing.JButton admin;
    private javax.swing.JButton bEnviarMensajes;
    private javax.swing.JButton bMensajesAjenos1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
}
