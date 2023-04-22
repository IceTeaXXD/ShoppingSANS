package com.shoppingsans.gui;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JualBarang extends javax.swing.JPanel {

    /**
     * Creates new form JualBarang
     */
    public JualBarang() {
        initComponents();
        
        // Create data for the table
        Object[][] data = {
            {1, "Gula", 15000},
            {1, "Garam", 5000},
            {1, "Kopi", 10000},
            {1, "Teh", 3000}
        };

        // Create column names for the table
        String[] columnNames = {"Qty", "Nama Barang", "Harga"};

        // Create a new instance of JTable
        JTable table = new JTable(data, columnNames);
        
        // Create a new instance of JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Set the bounds of the scroll pane and add it to the panel
        scrollPane.setBounds(10, 50, 480, 480);
        this.add(scrollPane);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jual Barang");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 686, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}