/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;
import fase2.Desc_IndiceGrupos;
import fase2.Manejo_de_Grupos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author roche
 */
public class AgregarAGrupos extends javax.swing.JFrame {

    /**
     * Creates new form AgregarAGrupos
     */
    public AgregarAGrupos() {
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
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaGrupos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaAmigos = new javax.swing.JList<>();
        AmigoSeleccionado = new javax.swing.JTextField();
        GrupoSeleccionado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Amigos = new javax.swing.JLabel();
        bCrearGrupo2 = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnModificar3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListaGrupos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaGrupos);

        ListaAmigos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListaAmigos);

        AmigoSeleccionado.setEnabled(false);

        GrupoSeleccionado.setEnabled(false);

        jButton1.setText("Agregar Amigo A Grupo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Amigos.setText("Mis Amigos");

        bCrearGrupo2.setLabel("Nuevo grupo");
        bCrearGrupo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearGrupo2ActionPerformed(evt);
            }
        });

        BtnModificar.setText("Administrar Grupo");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnModificar3.setText("Regresar");
        BtnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificar3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Mis Grupos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Amigos, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(AmigoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GrupoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(BtnModificar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bCrearGrupo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Amigos))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCrearGrupo2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(BtnModificar3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmigoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrupoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        int indexAmigo = ListaAmigos.getSelectedIndex();
        AmigoSeleccionado.setText((String) ListaAmigos.getSelectedValue());
        GrupoSeleccionado.setText((String) ListaGrupos.getSelectedValue());
        var txt1=AmigoSeleccionado.getText();        
        var txt2=GrupoSeleccionado.getText();

        if (!"".equals(txt1) && !"".equals(txt2)) {
            
            //creacion de descriptor
            boolean arch_Desc_IndiceGrupos = new File("C:/MEIA/Desc_IndiceGrupos.json").exists();
           if (!arch_Desc_IndiceGrupos) 
           {
                try 
                {  
                    var creado = new File("C:/MEIA/Desc_IndiceGrupos.json").createNewFile();
                    new Desc_IndiceGrupos().crearBitacora(LoginForm.UsuarioActual.usuario);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(AgregarAGrupos.class.getName()).log(Level.SEVERE, null, ex);
                }
           }

            try {
                var resultado = new Manejo_de_Grupos().AgregarAmigoAGrupo(LoginForm.UsuarioActual.usuario, (String) ListaAmigos.getSelectedValue(), (String) ListaGrupos.getSelectedValue());
                if (resultado)
                {
                    //Insercion exitosa
                    JOptionPane.showMessageDialog(null, "Solicitud Solicitud enviada con exito! :)");
                    this.setVisible(false);
                    var form = new AgregarAGrupos();
                    form.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El usuario ya fue agregado :(");
                }
            } catch (IOException ex) {
                Logger.getLogger(AgregarAGrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
                    JOptionPane.showMessageDialog(null, "Elija 2 opciones almenos ;D");
                    this.setVisible(false);
                    var form = new AgregarAGrupos();
                    form.setVisible(true);
        }
      
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bCrearGrupo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearGrupo2ActionPerformed
        var NuevoGrupoFrame = new CrearGrupo();
        NuevoGrupoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bCrearGrupo2ActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        var form = new AdministrarGrupo();
        
        form.setVisible(true);
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificar3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        var form = new Main();
        form.setVisible(true);
    }//GEN-LAST:event_BtnModificar3ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarAGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarAGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarAGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarAGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarAGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmigoSeleccionado;
    private javax.swing.JLabel Amigos;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnModificar3;
    private javax.swing.JTextField GrupoSeleccionado;
    private javax.swing.JList<String> ListaAmigos;
    private javax.swing.JList<String> ListaGrupos;
    private javax.swing.JButton bCrearGrupo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
