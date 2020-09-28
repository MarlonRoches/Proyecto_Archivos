package com.meia_2020.meia;


import com.meia_2020.meia.models.Archivo_Usuario;
import com.meia_2020.meia.models.Data;
import com.meia_2020.meia.models.Usuario;
import java.awt.List;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import org.apache.commons.codec.digest.DigestUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marce
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public static Usuario UsuarioActual = new Usuario();
    public LoginForm() {
        initComponents();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                try {
                    CrearUsuario.pasarFichero("C:/MEIA/bitacora_Usuarios.txt","C:/MEIA/usuarios.txt");
                } catch (IOException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
        jUsername = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLogin = new javax.swing.JButton();
        jNewUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jUsername.setText("admin");
        jScrollPane1.setViewportView(jUsername);

        jLabel2.setText("Contraseña");

        jLogin.setText("Iniciar sesión");
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });

        jNewUser.setText("Crear usuario");
        jNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewUserActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\marce\\Desktop\\2020\\Semestre II 2020\\Manejo e implementación de archivos\\Proyecto_Archivos\\Logo S2.png")); // NOI18N

        jPassword.setText("admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2))
                            .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 90, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNewUser)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean comprobacionUsuarios (String usernamef, String passwordf) throws FileNotFoundException, IOException{
    
        Usuario user = new Usuario();
        boolean userFound = false;
          String ubicacion = new Archivo_Usuario().ArchivoPerteneciente(usernamef);
        
        
        boolean directory = new File("C:/MEIA").exists();
        if (!directory) {
            var creado = new File("C:/MEIA").mkdir();  
        }
         boolean imagenes = new File("C:/MEIA/Fotografias").exists();
        if (!imagenes) {
            var creado = new File("C:/MEIA/Fotografias").mkdir();  
        }
         boolean arch_Usuario = new File("C:/MEIA/usuario.txt").exists();
        if (!arch_Usuario) {
            var creado = new File("C:/MEIA/usuario.txt").createNewFile();  
        }
        
        boolean arch_Bit_Usuario = new File("C:/MEIA/bitacora_Usuarios.txt").exists();
        if (!arch_Bit_Usuario) {
            var creado = new File("C:/MEIA/bitacora_Usuarios.txt").createNewFile();  
        }
        
        
        
        boolean arch_desc_Usuario = new File("C:/MEIA/desc_Bitacora.json").exists();
        if (!arch_Bit_Usuario) {
            var creado = new File("C:/MEIA/desc_Bitacora.json").createNewFile();  
        }
        
        
        
        
        boolean arch_desc_BitUsuario = new File("C:/MEIA/desc_usuario.json").exists();
        if (!arch_Bit_Usuario) {
            var creado = new File("C:/MEIA/desc_usuario.json").createNewFile();  
        }
        
        
        
        
        
        
        
        FileReader file = new FileReader(ubicacion);
        BufferedReader fileRead = new BufferedReader(file);
        String usersFile = fileRead.toString();
        ArrayList<Usuario> usersList = new ArrayList<Usuario>();
        String linea = "";
        if(linea!=null){
        while((linea =fileRead.readLine())!= null){
             String[] addUser = linea.split("\\|");
            boolean rol = false;
            //var date = new SimpleDateFormat("dd/MM/yyyy").parse(addUser[5]);
            var date = LocalDate.now();
            var status = true;
            var usuario = addUser[0];

            int phoneNumber = Integer.parseInt(addUser[7]);
            if("1".equals(addUser[4])){
                rol = true;
            }
            if("1".equals(addUser[9])){
                status = true;
            }
            user = Usuario.setDatosUsuario(addUser[0], addUser[1], addUser[2], addUser[3], rol, date, addUser[6], phoneNumber, addUser[8], status);
            usersList.add(user);
        }       
        
        
           
        }
        for(var userCheck:usersList)
            {
                if((userCheck.usuario.equals(usernamef))&&(userCheck.passWord.equals(passwordf)))
                {
                    userFound = true;
                    Data y = Data.getInstance(); 
                   UsuarioActual = userCheck;
                    //Data singleton =  Data.Instance().usuarioActual = userCheck;
                    break;
                }
            }
        file.close();
        
        //Data.getInstance().usuarioActual.
        return userFound;
    }
    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed
        
       
        
        String username = jUsername.getText();
        String password = DigestUtils.sha1Hex(jPassword.getText());
      
        try {
            boolean logIn = comprobacionUsuarios(username, password);
            if(logIn){
                //abrimos uno nuevo
                Main AbrirMenuPrincipal = new Main();
                AbrirMenuPrincipal.setVisible(true);
                //cerramos este form
                this.setVisible(false);
            }else{
                int opcion = JOptionPane.showConfirmDialog(null,"Usuario o contraseña no fue encontrado, ¿desea crear un usuario?", "Aviso", JOptionPane.YES_NO_OPTION);
                if(opcion==0){
                    CrearUsuario crear = new CrearUsuario();
                    crear.setVisible(true);
                    this.setVisible(false);
                }
            }
 
            
        } catch (IOException ex) {
            showMessageDialog(null, "Los datos ingresados han sido incorrectos, por favor intente de nuevo");
        }
    }//GEN-LAST:event_jLoginActionPerformed

    private void jNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewUserActionPerformed
        // Abre menú de crear usuario 
        CrearUsuario crear = new CrearUsuario();
        crear.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jNewUserActionPerformed

    
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLogin;
    private javax.swing.JButton jNewUser;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jUsername;
    // End of variables declaration//GEN-END:variables
}
