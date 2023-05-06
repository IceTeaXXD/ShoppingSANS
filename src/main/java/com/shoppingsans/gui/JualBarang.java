package com.shoppingsans.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXBException;

import com.shoppingsans.Datastore.DataStore;
import com.shoppingsans.JualBarang.Barang;
import com.shoppingsans.JualBarang.ImageRenderer;
import com.shoppingsans.JualBarang.InventoryBarang;
import com.shoppingsans.User.Customer;
import com.shoppingsans.User.User;

public class JualBarang extends javax.swing.JPanel {

    /**
     * Creates new form JualBarang
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     */
    protected DataStore ds;
    protected ArrayList<Customer> users;
    private int selectedUser;
    public JualBarang() throws FileNotFoundException, ClassNotFoundException, JAXBException, IOException {
        initComponents();
        
        this.ds = new DataStore();
        
        ArrayList<Barang> barangList = ds.getInventoryBarang().getInventory();
        // // Create data for the table
        ImageIcon leftButtonIcon = createImage("images/mouse.jpg");
        data = new ArrayList<>();
        pembeli = new ArrayList<>();
        
        for (int i = 0; i < barangList.size(); i++) {
          Barang barang = barangList.get(i);
          ArrayList<Object> listToko = new ArrayList<>();
          ArrayList<Object> listPembeli = new ArrayList<>();
          // JButton button = new JButton("Buy", leftButtonIcon);
          listToko.add(barang.getIdBarang());
          listToko.add(barang.getStokBarang());
          listToko.add(barang.getNamaBarang());
          listToko.add(barang.getHargaBarang());
          listToko.add(barang.getHargaBeli());
          listToko.add(barang.getKategori());
          listToko.add("images/" + barang.getGambar());
          listToko.add(i);
          data.add(listToko);
          
          listPembeli.add(barang.getIdBarang());
          listPembeli.add(0);
          listPembeli.add(barang.getNamaBarang());
          listPembeli.add(barang.getHargaBarang());
          listPembeli.add(barang.getHargaBeli());
          listPembeli.add(barang.getKategori());
          listPembeli.add("images/" + barang.getGambar());
          listPembeli.add(i);
          pembeli.add(listPembeli);
        }
        
        // Create a new instance of JTable
        Object[][] convertedData = convertToArray(data);
        this.model = new DefaultTableModel(convertedData, columnNames);
        tableToko = createTable(convertedData,false);
        tablePembeli = createTable(convertToArray(pembeli), true);
      }
      
    public DefaultTableModel createTableModel(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        // add column names
        for (int i = 0; i < table.getColumnCount(); i++) {
            model.addColumn(table.getColumnName(i));
        }
        // add row data
        for (int i = 0; i < table.getRowCount(); i++) {
            Object[] row = new Object[table.getColumnCount()];
            for (int j = 0; j < table.getColumnCount(); j++) {
                row[j] = table.getValueAt(i, j);
            }
            model.addRow(row);
        }
        return model;
    }
    
    public JTable createTable(Object[][] data, boolean flag)
    {
      

      JTable retTable = new JTable(data, columnNames);
      retTable.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
      retTable.getColumnModel().getColumn(6).setPreferredWidth(100);

      retTable.setRowHeight(100);

      JScrollPane scrollPane = new JScrollPane(retTable);
      // Create a new instance of JScrollPane and add the table to it

      // Set the bounds of the scroll pane and add it to the panel
      if (flag)
      {
        scrollPane = new JScrollPane(retTable);
        retTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
        retTable.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
        scrollPane.setBounds(650, 200, 480, 480);        
      }
      else{ 
        scrollPane = new JScrollPane(retTable);
        retTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(1));
        retTable.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 1));
        scrollPane.setBounds(100, 100, 480, 480);
      }
      this.add(scrollPane);
        this.users = ds.getUsers().getCustomers();
        if (users.size() != 0)
        {
            //clear item in combobox
            jComboBox1.removeAllItems();
            for (int i = 0 ; i < users.size() ; i++)
            {
                jComboBox1.addItem(users.get(i).getId().toString());
            }
        }
        this.add(jComboBox1);
      return retTable;
    }

    private ImageIcon createImage(String string) {
        return new ImageIcon(string);
    }

    private Object[][] convertToArray(ArrayList<ArrayList<Object>> list) {
      Object[][] arr = new Object[list.size()][list.get(0).size() - 1];
      for (int i = 0; i < list.size(); i++) {
          ArrayList<Object> row = list.get(i);
          for (int j = 1; j < row.size(); j++) {
              arr[i][j - 1] = row.get(j);
              System.out.println(row.get(j));
          }
      }
      return arr;
  }
  
  
    class ButtonRenderer extends JButton implements TableCellRenderer {
        private int cat;

        public ButtonRenderer(int cat) {
          setOpaque(true);
          this.cat = cat;
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
          if (cat==1)
          setText("Buy");
          else
          setText("--");
          return this;
        }
    }
      
      /**
       * @version 1.0 11/09/98
       */
      
       class ButtonEditor extends DefaultCellEditor implements TableCellEditor {
        protected JButton button;
        private int category;
        private String label;
    
        private boolean isPushed;
      
        public ButtonEditor(JCheckBox checkBox, int category) {
          super(checkBox);
          this.category = category;
          button = new JButton();
          button.setOpaque(true);
          button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              if (category == 1) {
                Integer newStock = Integer.parseInt(data.get(Integer.parseInt(label)).get(0).toString()) - 1;
                if (newStock < 0) {
                    JOptionPane.showMessageDialog(button, "Barang sudah habis");
                } else {
                    data.get(Integer.parseInt(label)).set(0, newStock.toString());
                    pembeli.get(Integer.parseInt(label)).set(0, Integer.parseInt(pembeli.get(Integer.parseInt(label)).get(0).toString()) + 1);
                    tableToko.getModel().setValueAt(data.get(Integer.parseInt(label)).get(0), Integer.parseInt(label), 0);
                    // ini yang salah
                    tablePembeli.getModel().setValueAt(pembeli.get(Integer.parseInt(label)).get(0), Integer.parseInt(label), 0);
    
                    // if (newStock == 0) {
                    //     DefaultTableModel model = (DefaultTableModel) tablePembeli.getModel();
                    //     model.removeRow(Integer.parseInt(label));
                    // }
                }
              } else if (category == 2) {
                  // get data dengan indeks pertama = label

                  data.get(Integer.parseInt(label)).set(0, Integer.parseInt(data.get(Integer.parseInt(label)).get(0).toString()) + 1);
                  // pembeli.get(Integer.parseInt(label)).set(0, Integer.parseInt(pembeli.get(Integer.parseInt(label)).get(0).toString()) - 1);
                  // print all of qty in pembeli
                  System.out.println("PEMBELI ");
                  for (int i = 0; i < pembeli.size(); i++) {
                    System.out.println(pembeli.get(i).get(0));
                  }
                  System.out.println("====================");
                  tableToko.getModel().setValueAt(data.get(Integer.parseInt(label)).get(0), Integer.parseInt(label), 0);
                  tablePembeli.getModel().setValueAt(pembeli.get(Integer.parseInt(label)).get(0), Integer.parseInt(label), 0);
                  if (Integer.parseInt(pembeli.get(Integer.parseInt(label)).get(0).toString()) == 0) {
                    System.out.println("FHSDJHFDJKAHFJKDHFDJAHFJKDAHJKFDAJKHFDAJKFHDH");
                    DefaultTableModel model = createTableModel(tablePembeli);
                    System.out.println("label " + label);
                    model.removeRow(Integer.parseInt(label));
                    tablePembeli.setModel(model);
                    tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
                    // tablePembeli.getColumnModel().getColumn(6).setPreferredWidth(100);
                    tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
                    tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
                  }
                  for (int i = 0 ; i < tablePembeli.getRowCount() ; i++)
                  {
                    // print all of label in each row
                    System.out.println(tablePembeli.getModel().getValueAt(i, 6).toString());
                  }
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
          if (category==1)
          button.setText("Buy");
          else if (category==2)
          button.setText("--");
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
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(45, 43, 74));

        jLabel1.setBackground(new java.awt.Color(45, 43, 74));
        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 198, 111));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jual Barang");
        jLabel1.setToolTipText("");

        jButton2.setText("+");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 589, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private JTable tableToko;
    private JTable tablePembeli; 
    private ArrayList<ArrayList<Object>> data;
    private ArrayList<ArrayList<Object>> pembeli;
    private DefaultTableModel model;
    
    private final String[] columnNames = {"Qty", "Nama Barang", "Harga Barang","Harga Beli","Kategori", "Image","Buy"};
    // End of variables declaration//GEN-END:variables
}