/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.shoppingsans.gui;
import com.shoppingsans.Datastore.DataStore;
import com.shoppingsans.Plugins.JarClassLoader;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.FileDialog;
import java.awt.Frame;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.Data;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.io.FilenameFilter;
import java.lang.reflect.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


/**
 *
 * @author ahmad
 */
public class Settings extends javax.swing.JPanel {
    JarClassLoader jcl;
    /**
     * Creates new form Settings
     */
    DataStore ds = new DataStore();
    public Settings() throws JAXBException, IOException, ClassNotFoundException {
        initComponents();
        ds = new DataStore();
        
        switch (ds.getConfig().getSaveas()) {
            case "xml":
                jComboBox2.setSelectedIndex(1);
                break;
            case "json":
                jComboBox2.setSelectedIndex(0);
                break;
            case "obj":
                jComboBox2.setSelectedIndex(2);
                break;
            default:
                jComboBox2.setSelectedIndex(3);
                break;
        }
        
        /* Fill in the ComboBox */
        jComboBox3.removeAll();
        for(int i = 0; i < ds.getConfig().getPlugins().getPath().size(); i++){
            File f = new File(ds.getConfig().getPlugins().getPath().get(i));
            String name = f.getName().substring(0, f.getName().lastIndexOf("."));
            jComboBox3.addItem(name);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        KursButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        MataUangField = new javax.swing.JComboBox<>();
        MataUangField.addItem("IDR");
         /* Search through if there exists */        
        for(int i = 0; i < ds.getConfig().getPlugins().getPath().size(); i++){
            try {
                JarClassLoader jcl = new JarClassLoader(ds.getConfig().getPlugins().getPath().get(i));
                File f = new File(ds.getConfig().getPlugins().getPath().get(i));
                String name = f.getName().substring(0, f.getName().lastIndexOf("."));
                Class<?> c = jcl.getClassLoader().loadClass(name);
                Set <String> keys = ds.getConfig().getMapKurs().keySet();
                MataUangField.removeAllItems();
                for(String key: keys){
                    MataUangField.addItem(key);
                }
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        setBackground(new java.awt.Color(45, 43, 74));
        setPreferredSize(new java.awt.Dimension(1268, 685));

        jLabel1.setBackground(new java.awt.Color(45, 43, 74));
        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 198, 111));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Settings");

        jLabel5.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipe Data Penyimpanan");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JSON", "XML", "OBJ", "SQL" }));

        jButton1.setBackground(new java.awt.Color(242, 198, 111));
        jButton1.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jButton1.setText("Upload Plugin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pilih Plugin Untuk Dihapus");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(242, 198, 111));
        jButton2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(242, 198, 111));
        jButton3.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(242, 198, 111));
        jButton4.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jButton4.setText("Change Path");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        KursButton.setBackground(new java.awt.Color(242, 198, 111));
        KursButton.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        KursButton.setText("Simpan");
        KursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KursButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mata Uang");

        MataUangField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MataUangFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KursButton))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MataUangField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 401, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KursButton)
                    .addComponent(jLabel7)
                    .addComponent(MataUangField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3))
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton4)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // create a file dialog for opening .jar files
        FileDialog dialog = new FileDialog((Frame) null, "Open JAR file", FileDialog.LOAD);
        dialog.setFilenameFilter((dir, name) -> name.toLowerCase().endsWith(".jar"));
    
        // show the dialog and wait for the user to select a file
        dialog.setVisible(true);
    
        // get the selected file and create a JarClassLoader
        String filename = dialog.getFile();
        if (filename != null) {
            try {
                String path = dialog.getDirectory() + filename;
                System.out.println("You chose to open this file: " + path);
                ds.getConfig().getPlugins().getPath().add(path);
                ds.saveAs();
                jcl = new JarClassLoader(path);
                String name = filename.substring(0, filename.lastIndexOf("."));
                Main frame = (Main)SwingUtilities.getAncestorOfClass(Main.class, this);
                try{
                    Component obj = jcl.loadClassObject(name);
                    frame.addTab(obj);
                }
                catch(Exception e){
                    Class<?> c = jcl.getClassLoader().loadClass(name);
                    Set <String> keys = ds.getConfig().getMapKurs().keySet();
                    MataUangField.removeAllItems();
                    for(String key : keys){
                        MataUangField.addItem(key);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            String temp = (String) jComboBox2.getSelectedItem();
            temp = temp.toLowerCase();
            ds.getConfig().setSaveas(temp);
            ds.saveAs();
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jComboBox3.getSelectedItem() != null){
            for(int i = 0; i < ds.getConfig().getPlugins().getPath().size(); i++){
                if(ds.getConfig().getPlugins().getPath().get(i).contains((String)jComboBox3.getSelectedItem())){
                    try {
                        if (ds.getConfig().getPlugins().getPath().get(i).contains("Kurs")){
                            MataUangField.removeAllItems();
                            MataUangField.addItem("IDR");
                            ds.getConfig().getMapKurs().clear();
                            ds.getConfig().getMapKurs().put("IDR", 1);
                            ds.getConfig().setCurrentKurs("IDR");
                        }
                        jComboBox3.removeItemAt(i);
                        ds.getConfig().getPlugins().getPath().remove(i);
                        ds.saveAs();
                        JOptionPane.showMessageDialog(this, "Plugin berhasil dihapus, silakan restart program agar perubahan dapat dilakukan!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } catch (JAXBException ex) {
                        Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    System.out.println("WEH");
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(this);

        // Check if the user clicked the "Open" button
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                // Get the selected file path
                String path = fileChooser.getSelectedFile().getAbsolutePath()+"\\";
                
                // Display the selected file path in a message dialog
                JOptionPane.showMessageDialog(this, "Selected folder: " + path);
                
                ds.getConfig().setPath(path);
                ds.saveAs();
            } catch (JAXBException | FileNotFoundException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void KursButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KursButtonActionPerformed
        ds.getConfig().setCurrentKurs((String) MataUangField.getSelectedItem());
        try {
            ds.saveAs();
        } catch (FileNotFoundException | JAXBException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_KursButtonActionPerformed

    private void MataUangFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MataUangFieldActionPerformed
    
    }//GEN-LAST:event_MataUangFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KursButton;
    private javax.swing.JComboBox<String> MataUangField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
