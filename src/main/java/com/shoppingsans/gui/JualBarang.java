package com.shoppingsans.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.xml.bind.JAXBException;

import com.shoppingsans.Datastore.DataStore;
import com.shoppingsans.JualBarang.Barang;
import com.shoppingsans.JualBarang.ImageRenderer;
import com.shoppingsans.JualBarang.InventoryBarang;

public class JualBarang extends javax.swing.JPanel {

    /**
     * Creates new form JualBarang
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     */
    public JualBarang() throws FileNotFoundException, ClassNotFoundException, JAXBException, IOException {
        initComponents();
        
        DataStore ds = new DataStore();
        
        ArrayList<Barang> barangList = ds.getInventoryBarang().getInventory();
        // // Create data for the table
        ImageIcon leftButtonIcon = createImage("images/mouse.jpg");
        data = new Object[barangList.size()][7];
        for (int i = 0; i < barangList.size(); i++) {
            Barang barang = barangList.get(i);
            // JButton button = new JButton("Buy", leftButtonIcon);
            data[i][0] = barang.getStokBarang();
            data[i][1] = barang.getNamaBarang();
            data[i][2] = barang.getHargaBarang();
            data[i][3] = barang.getHargaBeli();
            data[i][4] = barang.getKategori();
            data[i][5] = "images/" + barang.getGambar();
            data[i][6] = i;
        }
        

        // Create a new instance of JTable
        table = new JTable(data, columnNames);
        
        table.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        // make size of 100x100
        table.setRowHeight(100);

        // Create a new instance of JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Set the bounds of the scroll pane and add it to the panel
        scrollPane.setBounds(10, 50, 480, 480);
        this.add(scrollPane);
    }
    private ImageIcon createImage(String string) {
        return new ImageIcon(string);
    }
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
          setOpaque(true);
        }
      
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
          if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
          } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
          }
          setText("Buy");
          return this;
        }
      }
      
      /**
       * @version 1.0 11/09/98
       */
      
      class ButtonEditor extends DefaultCellEditor implements TableCellEditor {
        protected JButton button;
      
        private String label;
      
        private boolean isPushed;
      
        public ButtonEditor(JCheckBox checkBox) {
          super(checkBox);
          button = new JButton();
          button.setOpaque(true);
          button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Integer newVal = Integer.valueOf(Integer.parseInt(data[Integer.parseInt(label)][0].toString())-1);
              if (newVal<0) {
                JOptionPane.showMessageDialog(button, "Barang sudah habis");
              }
              else {
                data[Integer.parseInt(label)][0] = (Integer.valueOf(Integer.parseInt(data[Integer.parseInt(label)][0].toString())-1)).toString();
                table.setValueAt(data[Integer.parseInt(label)][0], Integer.parseInt(label), 0);
              }
            }
          });
        }
      
        public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
          if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
          } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
          }
          label = (value == null) ? "" : value.toString();
          button.setText("Buy");
          isPushed = true;
          return button;
        }
      
        public Object getCellEditorValue() {
          if (isPushed) {
            
          }
          isPushed = false;
          return new String(label);
        }
      
        public boolean stopCellEditing() {
          isPushed = false;
          return super.stopCellEditing();
        }
      
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
    private JTable table;
    private Object[][] data;
    private final String[] columnNames = {"Qty", "Nama Barang", "Harga Barang","Harga Beli","Kategori", "Image","Buy"};
    // End of variables declaration//GEN-END:variables
}