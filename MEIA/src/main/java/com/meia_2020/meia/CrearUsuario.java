/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;



import com.meia_2020.meia.models.Data;
import com.meia_2020.meia.models.Usuario;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.File;
import javax.swing.JFileChooser;
import com.meia_2020.meia.models.Desc_Usuarios;
import com.meia_2020.meia.models.desc_bitacora_usuarios;
import com.meia_2020.meia.models.desc_usuario;
import java.nio.file.Files;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author marce
 */

public class CrearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CrearUsuario
     */
    public int contadorUsuarios = 0;
    public int contadorFotografias = 0;
    FileInputStream entrada;
    FileOutputStream salida;
    File carpeta;
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] bytesFotografia;
    Usuario newUser = new Usuario();
    
    public CrearUsuario() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cNombre = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        cApellido = new javax.swing.JTextPane();
        cNacimiento = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        cCorreo = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        cRuta = new javax.swing.JTextPane();
        bBuscar = new javax.swing.JButton();
        bCrear = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        cUsuario = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        cTelefono = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        cPassword = new javax.swing.JTextPane();
        jFotografia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Teléfono");

        jLabel5.setText("Password");

        jLabel6.setText("Usuario");

        jLabel7.setText("Fecha de nacimiento");

        jLabel8.setText("Correo alterno");

        cNombre.setText("...");
        jScrollPane1.setViewportView(cNombre);

        cApellido.setText("...");
        jScrollPane2.setViewportView(cApellido);

        cNacimiento.setText("03/03/2020");
        cNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNacimientoActionPerformed(evt);
            }
        });

        cCorreo.setText("correo@ejemplo.com");
        jScrollPane5.setViewportView(cCorreo);

        cRuta.setText("C:\\Users\\roche\\Documents\\Captura de pantalla 2020-09-26 123822.png");
        jScrollPane6.setViewportView(cRuta);

        bBuscar.setText("Buscar foto");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bCrear.setText("Crear usuario");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        jScrollPane7.setViewportView(cUsuario);

        cTelefono.setText("12345678");
        jScrollPane8.setViewportView(cTelefono);

        cPassword.setText("...");
        jScrollPane3.setViewportView(cPassword);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(bCrear)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap(215, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFotografia)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jFotografia))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bBuscar)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bCrear)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public String comprobarContrasenia(String password){
        int contador = 0;
        String nivelSeguridad = "";
        String comprobacionNumeros = "(?=.*[0-9])";
        String comprobacionMinuscula = "(?=.*[a-z])";
        String comprobacionMayuscula = "(?=.*[A-Z])";
        String comprobacionSignos = "(?=.*[@#$%^&+=])";
        String comprobacionEspacios = "(?=\\S+$)";
        String comprobacionLargo = ".{8,}";
        
        if(password.matches(comprobacionNumeros)){
            contador++;
        }
        if(password.matches(comprobacionMinuscula)){
            contador++;
        }
        if(password.matches(comprobacionMayuscula)){
            contador++;
        }
        if(password.matches(comprobacionSignos)){
            contador++;
        }
        if(password.matches(comprobacionEspacios)){
            contador++;
        }
        if(password.matches(comprobacionLargo)){
            contador++;
        }
        
        switch(contador){
            case 1:
                nivelSeguridad = "Bajo";
                break;
            case 2:
                nivelSeguridad = "Bajo";
                break;
            case 3:
                nivelSeguridad = "Medio";
                break;
            case 4:
                nivelSeguridad = "Medio";
                break;
            case 5:
                nivelSeguridad = "Alto";
                break;
            case 6:
                nivelSeguridad = "Alto";
                break;
        }
        return "Alto";
    }
    public boolean llenarArchivo(String path,String usuarioIngresado) throws IOException
    {
        File Archivo = new File(path);
        FileWriter Escribir = new FileWriter(Archivo,true);
        BufferedWriter bw = new BufferedWriter(Escribir);
        bw.write(usuarioIngresado + '\n');
        bw.close();
        Escribir.close();
        return true;
    }
    public String rolString(Boolean rol){
        String estadoRol;
        if(rol){
            estadoRol = "administrador";
        }else{
            estadoRol = "usuario";
        }
        return estadoRol;
    }
    public byte[] abrirImagen(File archivo) throws FileNotFoundException, IOException{
        byte[] bytesFoto = new byte[1024*100];
        entrada = new FileInputStream(archivo);
        entrada.read(bytesFoto);
        return bytesFoto;
    }
    public String guardarFotografia(File carpeta, byte[] bytesFoto) throws FileNotFoundException, IOException{
        String respuesta = null;
        salida = new FileOutputStream(carpeta);
        salida.write(bytesFoto);
        respuesta = "La imagen se guardo con exito";
        return respuesta; 
    }
    public byte[] abrirFotografia(JFileChooser path) throws IOException{
     archivo = path.getSelectedFile();
     if(archivo.canRead()){
      if(archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")){
          bytesFotografia = abrirImagen(archivo);
      }   
     }
     return bytesFotografia;
    }
    public void guardar(JFileChooser path, File carpeta) throws IOException{
     //archivo = path.getSelectedFile();
     
        if(archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")){
            try{
            File newPhoto= new File(archivo.toString());
            File dirFoto = new File("C:/MEIA/Fotografias");
                if (!dirFoto.exists()) {
                    dirFoto.mkdir();
                }
            File copiaPhoto = new File("C:/MEIA/Fotografias/"+archivo.getName());
            Files.copy(newPhoto.toPath(),copiaPhoto.toPath());
            }catch(Exception e){
            
            }

        }
    }
    public boolean comprobarCaracteres(Usuario user){
        boolean siCumple = false;
        if(user.usuario.length() <= 20 && user.nombre.length() <= 30 && user.usuarioApellido.length() <= 30 && user.passWord.length() <= 40 && user.correoAlterno.length() <= 40 && user.path_Fotografia.length() <= 200){
            siCumple = true;
        }
        return siCumple;
    }
    public static void pasarFichero(String origen, String destino) throws FileNotFoundException, IOException{
        File origenArchivo = new File(origen);
        File destinoArchivo = new File(destino);
        FileInputStream stream = new FileInputStream(origenArchivo);
        byte[] data = new byte[(int) origenArchivo.length()];
        stream.read(data);
        stream.close();
        String file = new String(data, "UTF-8");
        byte[] data2 = new byte[(int) origenArchivo.length()];
        String file2 = new String(data2, "UTF-8");
        if (destinoArchivo.exists()) {
            FileInputStream stream2 = new FileInputStream(destinoArchivo);
            data2 = new byte[(int) destinoArchivo.length()];
            stream2.read(data2);
            stream2.close();
            file2 = new String(data2, "UTF-8");
            file2+=file;
            data2 = file2.getBytes();
        }
        else
        {
            file2 = file;
            data2 = file2.getBytes();
        }
        Files.write(destinoArchivo.toPath(), data2);
        data="".getBytes();
        Files.write(origenArchivo.toPath(), data);
    }
    public void crearNuevo() throws FileNotFoundException, IOException{
        String nivelSeguridad = comprobarContrasenia(newUser.passWord);
        String path = "C:/MEIA/bitacora_Usuarios.txt";
        File usuariosComprobacion = new File("C:/MEIA/usuarios.txt");
        if(comprobarCaracteres(newUser)){
            if(!"Bajo".equals(nivelSeguridad)){
                try{
                    if (usuariosComprobacion.length()!=0) {
                   newUser.rol = false;
                        if(contadorUsuarios!=0){

                             if(contadorUsuarios<5){
                                 //ingresarlos en bitacoraUsuario
                                 contadorUsuarios++;
                                 String usuario = newUser.usuarioToString();
                                 llenarArchivo("C:/MEIA/bitacora_Usuarios.txt",usuario);
                                 contadorUsuarios++;

                                 //actualizar el des_bitacora
                                 desc_bitacora_usuarios.WriteDescBinnacle();
                             }else{
                                 //Pasar los usuarios de bitacoraUsuario a Usuarios
                                 pasarFichero("C:/MEIA/bitacora_Usuarios.txt","C:/MEIA/usuarios.txt");

                                 //Actualizar el desc_Usuario
                                 desc_usuario.WriteDescBinnacle(contadorUsuarios);
                                 contadorUsuarios=0;

                                 //Insertar el nuevo en bitacoraUsuario
                                 String usuario = newUser.usuarioToString();
                                 llenarArchivo("C:/MEIA/bitacora_Usuarios.txt",usuario);
                                 contadorUsuarios++;

                             }
                         }else{
                             newUser.rol = false;
                             String usuario = newUser.usuarioToString();
                             llenarArchivo("C:/MEIA/bitacora_Usuarios.txt",usuario);
                         }
                    }else{
                        newUser.rol = true;
                        String usuario = newUser.usuarioToString();
                        llenarArchivo("C:/MEIA/bitacora_Usuarios.txt",usuario);
                    }
                }catch(Exception e){
                
                }
                
            }else{
                //lanza error de contrase;a insegura
                JOptionPane.showMessageDialog(null, "Contraseña insegura");
                
                //borra field contrase;a
                cPassword.setText(null);
            }
        }else{
            //no cumple con la cantidad de caracteres **voy a ponerle un limite a los textfields
            JOptionPane.showMessageDialog(null, "Campos incorrectos");
        }
    }
    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        newUser.usuario = cUsuario.getText();
        newUser.nombre = cNombre.getText();
        newUser.usuarioApellido = cApellido.getText();
        newUser.passWord = DigestUtils.md5Hex(cPassword.getText());
        newUser.fecha = (LocalDate.parse(cNacimiento.getText(),formatter));
        newUser.correoAlterno = cCorreo.getText();
        newUser.telefono = Integer.valueOf(cTelefono.getText());
        newUser.path_Fotografia = "C:/MEIA/Fotografias";
        newUser.estatus = true;
        String foto = "./Fotografias";
        File fotos = new File(foto);
        var desc = new Desc_Usuarios().devolverObjeto();
        
        try {
            crearNuevo();
            guardar(seleccionado, fotos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el usuarios");
        }
        
        var form = new LoginForm();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bCrearActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        JFileChooser dialogo = new JFileChooser();
        File fotoGuardada;
        String rutaFoto;
        int valor = dialogo.showOpenDialog(this);
        if(valor == JFileChooser.APPROVE_OPTION){
            try {
                fotoGuardada = dialogo.getSelectedFile();
                rutaFoto = fotoGuardada.getPath();
                cRuta.setText(rutaFoto);
                abrirFotografia(dialogo);
            } catch (IOException ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_bBuscarActionPerformed
    }
    private void cNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNacimientoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bCrear;
    private javax.swing.JTextPane cApellido;
    private javax.swing.JTextPane cCorreo;
    private javax.swing.JTextField cNacimiento;
    private javax.swing.JTextPane cNombre;
    private javax.swing.JTextPane cPassword;
    private javax.swing.JTextPane cRuta;
    private javax.swing.JTextPane cTelefono;
    private javax.swing.JTextPane cUsuario;
    private javax.swing.JLabel jFotografia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables
}
