/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shoppingsans.gui;

/**
 *
 * @author Matthew
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        Home h = new Home();
        jTabbedPane1.add("Home", h);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        HomeButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AddMember = new javax.swing.JMenuItem();
        UpdateCustomer = new javax.swing.JMenuItem();
        HistoryTransaksi = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ManajemenBarang = new javax.swing.JMenuItem();
        Laporan = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        JualBarang = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Settings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1280, 720));

        jMenu1.setText("Home");

        HomeButton.setText("Home Page");
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });
        jMenu1.add(HomeButton);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleDescription("");

        jMenu2.setText("Member Area");

        AddMember.setText("Add Member");
        AddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemberActionPerformed(evt);
            }
        });
        jMenu2.add(AddMember);

        UpdateCustomer.setText("Update Customer");
        UpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCustomerActionPerformed(evt);
            }
        });
        jMenu2.add(UpdateCustomer);

        HistoryTransaksi.setText("History Transaksi");
        HistoryTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryTransaksiActionPerformed(evt);
            }
        });
        jMenu2.add(HistoryTransaksi);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Penjualan");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        ManajemenBarang.setText("Manajemen Barang");
        ManajemenBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManajemenBarangActionPerformed(evt);
            }
        });
        jMenu3.add(ManajemenBarang);

        Laporan.setText("Laporan");
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });
        jMenu3.add(Laporan);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Jual Barang");

        JualBarang.setText("Jual Barang");
        JualBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JualBarangActionPerformed(evt);
            }
        });
        jMenu5.add(JualBarang);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Settings");

        Settings.setText("Settings");
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });
        jMenu4.add(Settings);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.add("Home", new Home());
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void AddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemberActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.add("Add New Member", new AddMember());
    }//GEN-LAST:event_AddMemberActionPerformed

    private void UpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCustomerActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.add("Update Customer", new UpdateCustomer());
    }//GEN-LAST:event_UpdateCustomerActionPerformed

    private void HistoryTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryTransaksiActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.add("History Transaksi", new HistoryTransaksi());
    }//GEN-LAST:event_HistoryTransaksiActionPerformed

    private void ManajemenBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManajemenBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManajemenBarangActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.add("Settings", new Settings());
    }//GEN-LAST:event_SettingsActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LaporanActionPerformed

    private void JualBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JualBarangActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.add("Jual Barang", new JualBarang());
    }//GEN-LAST:event_JualBarangActionPerformed

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
    private javax.swing.JMenuItem AddMember;
    private javax.swing.JMenuItem HistoryTransaksi;
    private javax.swing.JMenuItem HomeButton;
    private javax.swing.JMenuItem JualBarang;
    private javax.swing.JMenuItem Laporan;
    private javax.swing.JMenuItem ManajemenBarang;
    private javax.swing.JMenuItem Settings;
    private javax.swing.JMenuItem UpdateCustomer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
