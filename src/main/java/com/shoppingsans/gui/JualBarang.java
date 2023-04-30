package com.shoppingsans.gui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.shoppingsans.JualBarang.ImageRenderer;

public class JualBarang extends javax.swing.JPanel {

    /**
     * Creates new form JualBarang
     */
    public JualBarang() {
        initComponents();
        
        // Create data for the table
        Object[][] data = {
            {1, "JR", 15000, "images/jason.png"},
            {1, "Mahentot", 5000, "images/mahentot.png"},
            {1, "Mahentot", 10000, "images/mahentot2.png"},
            {1, "Pasangannya VHA", 3000, "images/v.png"}
        };
        

        // Create column names for the table
        String[] columnNames = {"Qty", "Nama Barang", "Harga", "Image"};

        // Create a new instance of JTable
        JTable table = new JTable(data, columnNames);
        
        table.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
        // make size of 100x100
        table.setRowHeight(100);

        // Create a new instance of JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Set the bounds of the scroll pane and add it to the panel
        scrollPane.setBounds(10, 50, 480, 480);
        this.add(scrollPane);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 43, 74));

        jLabel1.setBackground(new java.awt.Color(45, 43, 74));
        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 198, 111));
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
                .addGap(0, 669, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}