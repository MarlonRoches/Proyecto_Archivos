/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import  com.meia_2020.meia.models.Desc_Bitacora;
import  com.meia_2020.meia.models.Desc_Usuarios;

/**
 *
 * @author roche
 */
public class BuscarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form BuscarUsuario
     */
    //true -> principal
    //false -> bitacora
    public static boolean Fuente = true; 
    public BuscarUsuario() {
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

        panel_Busqueda = new javax.swing.JPanel();
        Btn_EditarDatos = new javax.swing.JButton();
        Txt_Usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Txt_Nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Txt_Apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Txt_Contraseña = new javax.swing.JTextField();
        Radio_Rol = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Txt_Fecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Txt_Correo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Txt_Telefono = new javax.swing.JTextField();
        Label_PathFoto = new javax.swing.JLabel();
        Txt_Foto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Radio_Estado = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        BuscarUsuario_TxtBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_EditarDatos.setText("Editar Datos");
        Btn_EditarDatos.setEnabled(false);
        Btn_EditarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EditarDatosActionPerformed(evt);
            }
        });

        Txt_Usuario.setEnabled(false);

        jLabel2.setText("Usuario");

        jLabel3.setText("Nombre");

        Txt_Nombre.setEnabled(false);

        jLabel4.setText("Apellido");

        Txt_Apellido.setEnabled(false);

        jLabel5.setText("Contraseña");

        Txt_Contraseña.setEnabled(false);

        Radio_Rol.setText("Admin");
        Radio_Rol.setEnabled(false);

        jLabel6.setText("Rol");

        jLabel7.setText("Fecha De Nacimiento");

        Txt_Fecha.setEnabled(false);

        jLabel8.setText("Correo");

        Txt_Correo.setEnabled(false);

        jLabel9.setText("Telefono");

        Txt_Telefono.setEnabled(false);

        Label_PathFoto.setText("Foto");

        Txt_Foto.setEnabled(false);

        jLabel10.setText("Estatus");

        Radio_Estado.setText("Habilitado");
        Radio_Estado.setEnabled(false);

        javax.swing.GroupLayout panel_BusquedaLayout = new javax.swing.GroupLayout(panel_Busqueda);
        panel_Busqueda.setLayout(panel_BusquedaLayout);
        panel_BusquedaLayout.setHorizontalGroup(
            panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BusquedaLayout.createSequentialGroup()
                .addGroup(panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_Contraseña, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Txt_Apellido)
                    .addComponent(Txt_Nombre)
                    .addComponent(Txt_Usuario)
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addGroup(panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Radio_Rol)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 103, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_Fecha)
                    .addComponent(Txt_Foto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Txt_Telefono)
                    .addComponent(Txt_Correo)
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addGroup(panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_PathFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Radio_Estado)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(Btn_EditarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_BusquedaLayout.setVerticalGroup(
            panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_BusquedaLayout.createSequentialGroup()
                .addGroup(panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_PathFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(Radio_Rol))
                    .addGroup(panel_BusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(5, 5, 5)
                        .addComponent(Radio_Estado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_EditarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel1.setText("Usuario A Buscar");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuscarUsuario_TxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscarUsuario_TxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
            // TODO add your handling code here:
            String userName = BuscarUsuario_TxtBox.getText();
            boolean existe = false;
        try 
        {
            var in = new BufferedReader(new FileReader("C:/MEIA/usuario.txt"));
            var linea =in.readLine();
            while (linea != null) 
            {                
                var splited = linea.split("\\|");
                var xd =splited[0];
                if (xd.equals(userName)) {
                    //devolver datos del usuario en el frame 
                    var encontrado = true;
                    Txt_Usuario.setEnabled(true);   Txt_Usuario.setText(splited[0]);
                    Txt_Nombre.setEnabled(true);    Txt_Nombre.setText(splited[1]);
                    Txt_Apellido.setEnabled(true);  Txt_Apellido.setText(splited[2]);
                    Txt_Contraseña.setEnabled(true);Txt_Contraseña.setText(splited[3]);
                    
                    Radio_Rol.setEnabled(true);
                    if (splited[4].equals("1"))
                    {
                        Radio_Rol.setSelected(true);
                    }
                    else
                    {
                     Radio_Rol.setSelected(false);   
                    }
                    Txt_Fecha.setEnabled(true);     Txt_Fecha.setText(splited[5]);

                    Txt_Correo.setEnabled(true);    Txt_Correo.setText(splited[6]);

                    Txt_Telefono.setEnabled(true);  Txt_Telefono.setText(splited[7]);

                    Txt_Foto.setEnabled(true);      Txt_Foto.setText(splited[8]);

                    Radio_Estado.setEnabled(true);
                    if (splited[9].equals("1"))
                    {
                        Radio_Estado.setSelected(true);
                    }
                    else
                    {
                     Radio_Estado.setSelected(false);   
                    }       
                    Btn_EditarDatos.setEnabled(true);
                    break;
                }
                else
                {  
                linea =in.readLine();
                }
            }
            in.close();
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(BuscarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuscarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Btn_EditarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EditarDatosActionPerformed
        // TODO add your handling code here:
        //mandamos a revisar el descriptivo para saber si se mueven o se quedan los datos
        if (Fuente)
        {
            //al archivo principal
            // PENDIENTE cambiar |
            String lineaNueva= Txt_Usuario.getText()+"|"+Txt_Nombre.getText()+"|"+Txt_Apellido.getText()+"|"+Txt_Contraseña.getText()+"|"+ Radio_Rol.isSelected()+"|"+ Txt_Fecha.getText()+"|"+Txt_Correo.getText()+"|"+Txt_Telefono.getText()+"|"+Txt_Foto.getText()+"|"+ Radio_Estado.isSelected();
         
           
        }               
        else
        {
            //a labitacora
        }
    }//GEN-LAST:event_Btn_EditarDatosActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_EditarDatos;
    private javax.swing.JTextField BuscarUsuario_TxtBox;
    private javax.swing.JLabel Label_PathFoto;
    public javax.swing.JRadioButton Radio_Estado;
    public javax.swing.JRadioButton Radio_Rol;
    public javax.swing.JTextField Txt_Apellido;
    public javax.swing.JTextField Txt_Contraseña;
    public javax.swing.JTextField Txt_Correo;
    public javax.swing.JTextField Txt_Fecha;
    public javax.swing.JTextField Txt_Foto;
    public javax.swing.JTextField Txt_Nombre;
    public javax.swing.JTextField Txt_Telefono;
    public javax.swing.JTextField Txt_Usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel panel_Busqueda;
    // End of variables declaration//GEN-END:variables
}
