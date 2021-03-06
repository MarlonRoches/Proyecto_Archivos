/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meia_2020.meia;

import com.meia_2020.meia.models.Friendship;
import com.meia_2020.meia.models.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author misch
 */
public class AgregarAmigos extends javax.swing.JFrame {
    String fileRoute = "C:/MEIA/lista_amigos.txt";
    /**
     * Creates new form AgregarAmigos
     */
    public AgregarAmigos() {
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
        cbSearchCriteria = new javax.swing.JComboBox<>();
        BtnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shownList = new javax.swing.JList<>();
        searchedData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Seleccione el criterio de búsqueda:");

        cbSearchCriteria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Criterio de búsqueda...", "Usuario", "Nombre", "Apellido" }));

        BtnBuscar.setText("Buscar usuarios");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Usuarios resultantes:");

        shownList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(shownList);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ingrese el dato a buscar:");

        BtnAgregar.setText("Agregar usuario seleccionado");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchedData)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSearchCriteria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(searchedData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
        if (!"".equals(searchedData.getText())) {
            try {
                var file = new FileReader("C:/MEIA/usuario.txt");
                var buffer = new BufferedReader(file);
                var line = "";
                ArrayList<Usuario> usersList = new ArrayList<>();
                while((line = buffer.readLine()) != null)
                {
                    var newUserValues = line.split("\\|");
                    if ("1".equals(newUserValues[9])) {
                        usersList.add(new Usuario().setUsuariofromArray(newUserValues));
                    }
                }
                buffer.close();
                file.close();

                file = new FileReader("C:/MEIA/bitacora_Usuarios.txt");
                buffer = new BufferedReader(file);
                while((line = buffer.readLine()) != null)
                {
                    var newUserValues = line.split("\\|");
                    if ("1".equals(newUserValues[9]) && !newUserValues[0].equals(LoginForm.UsuarioActual.usuario)) {
                        usersList.add(new Usuario().setUsuariofromArray(newUserValues));
                    }
                }

                if (cbSearchCriteria.getSelectedIndex() != 0) {
                    switch(cbSearchCriteria.getSelectedIndex()){
                        case 1 -> {
                            usersList = (ArrayList<Usuario>) usersList.stream().filter(u -> u.usuario.contains(searchedData.getText())).collect(Collectors.toList());
                        }
                        case 2 -> {
                            usersList = (ArrayList<Usuario>) usersList.stream().filter(u -> u.nombre.contains(searchedData.getText())).collect(Collectors.toList());
                        }
                        case 3 -> {
                            usersList = (ArrayList<Usuario>) usersList.stream().filter(u -> u.usuarioApellido.contains(searchedData.getText())).collect(Collectors.toList());
                        }
                    }
                    DefaultListModel<String> model = new DefaultListModel<>();
                    for(var user : usersList)
                    {
                        model.addElement(user.getUsuario() + "|" + user.getNombre() + "|" + user.getUsuarioApellido());
                    }
                    shownList.setModel(model);
                    shownList.repaint();
                    shownList.revalidate();
                    if (usersList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ningún usuario ha cumplido los criterios de búsqueda." + " Por favor intente de nuevo.");
                    }
                    shownList.setSelectedIndex(-1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe escoger un parámetro para poder realizar la búsqueda.");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AgregarAmigos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AgregarAmigos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor ingrese un dato a buscar.");
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:
          var file = new File(fileRoute);
        if (!file.exists()) {
            try {
                new File(fileRoute).createNewFile();
                Friendship.WriteDescFile(LoginForm.UsuarioActual.usuario, false);
            } catch (IOException ex) {
                Logger.getLogger(AgregarAmigos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (shownList.getSelectedIndex() != -1) {
            if (file.length() != 0) {
                try {
                    var friendsDictionary = Friendship.GetMapFromFileRoute(fileRoute);
                    var selectedUsername = shownList.getSelectedValue().split("\\|")[0];
                    if (!Friendship.CheckIfExists(friendsDictionary, LoginForm.UsuarioActual.usuario, selectedUsername)) {
                        var newFriendship = Friendship.CreateNewFriendship(selectedUsername);
                        friendsDictionary.put(newFriendship.key, newFriendship);
                        Friendship.WriteFile(friendsDictionary, fileRoute, LoginForm.UsuarioActual.usuario, true);
                        JOptionPane.showMessageDialog(null, "La solicitud de amistad ha sido enviada.");
                        this.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El usuario que ha escogido ya es su amigo o ya existe una solicitud de amistad en proceso.");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AgregarAmigos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                try {
                    var friendsDictionary = Friendship.GetMapFromFileRoute(fileRoute);
                    var selectedUsername = shownList.getSelectedValue().split("\\|")[0];
                    var newFriendship = Friendship.CreateNewFriendship(selectedUsername);
                    friendsDictionary.put(newFriendship.key, newFriendship);
                    Friendship.WriteFile(friendsDictionary, fileRoute, LoginForm.UsuarioActual.usuario, true);
                    JOptionPane.showMessageDialog(null, "La solicitud de amistad ha sido enviada.");
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(AgregarAmigos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Por favor escoja un usuario para agregar.");
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarAmigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JComboBox<String> cbSearchCriteria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchedData;
    private javax.swing.JList<String> shownList;
    // End of variables declaration//GEN-END:variables
}
