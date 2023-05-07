package com.shoppingsans.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

import com.shoppingsans.Bill.Bill;
import com.shoppingsans.Datastore.DataStore;
import com.shoppingsans.JualBarang.Barang;
import com.shoppingsans.JualBarang.ImageRenderer;
import com.shoppingsans.JualBarang.InventoryBarang;
import com.shoppingsans.User.Customer;
import com.shoppingsans.User.Member;
import com.shoppingsans.User.User;
import com.shoppingsans.User.VIP;

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
    private JTable tableToko;
    private JTable tablePembeli; 
    private ArrayList<ArrayList<Object>> data;
    private ArrayList<ArrayList<Object>> pembeli;
    private DefaultTableModel model;
    private Integer billIdx;
    private Object billedUserId;
    private HashMap<String, Integer> mapId;
    private boolean fixed = false;;
    
    private final String[] columnNames = {"Qty", "Nama Barang", "Harga Barang","Harga Beli","Kategori", "Image","Buy"};


    public JualBarang() throws FileNotFoundException, ClassNotFoundException, JAXBException, IOException {
        initComponents();
        
        this.ds = new DataStore();
        
        ArrayList<Barang> barangList = ds.getInventoryBarang().getInventory();
        // // Create data for the table
        ImageIcon leftButtonIcon = createImage("images/mouse.jpg");
        data = new ArrayList<>();
        pembeli = new ArrayList<>();
        mapId = new HashMap<>();
        
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
          listToko.add(barang.getIdBarang());
          data.add(listToko);
          
          listPembeli.add(barang.getIdBarang());
          listPembeli.add(0);
          listPembeli.add(barang.getNamaBarang());
          listPembeli.add(barang.getHargaBarang());
          listPembeli.add(barang.getHargaBeli());
          listPembeli.add(barang.getKategori());
          listPembeli.add("images/" + barang.getGambar());
          listPembeli.add(barang.getIdBarang());
          pembeli.add(listPembeli);
        }

        this.users = ds.getUsers().getCustomers();
        if (users.size() != 0)
        {
            //clear item in combobox
            jComboBox1.removeAllItems();
            for (int i = 0 ; i < users.size() ; i++)
            {
                if (users.get(i) instanceof Member)
                {
                  jComboBox1.addItem(((Member) users.get(i)).getNama());
                  if (billedUserId==null)
                  billedUserId = users.get(i).getId();
                  mapId.put(((Member) users.get(i)).getNama(), users.get(i).getId());
                }
                if (users.get(i) instanceof VIP)
                {
                  jComboBox1.addItem(((VIP) users.get(i)).getNama());
                  if (billedUserId==null)
                  billedUserId = users.get(i).getId();
                  mapId.put(((VIP) users.get(i)).getNama(), users.get(i).getId());
                }
            }
        }
        // System.out.println("Map id: " + mapId);
        this.add(jComboBox1);
        
        // Create a new instance of JTable
        Object[][] convertedData = convertToArray(data);
        this.model = new DefaultTableModel(convertedData, columnNames);
        tableToko = createTable(convertedData,false);
        
        // remove all rows of tablePembeli
        
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
              // System.out.println(row.get(j));
          }
      }
      return arr;
    }

    private void saveDataStore() {
      try {
        String og = ds.getConfig().getSaveas();
        ds.getConfig().setSaveas("xml");
        ds.saveAs();

        ds.getConfig().setSaveas("json");
        ds.saveAs();

        ds.getConfig().setSaveas("obj");
        ds.saveAs();

        ds.getConfig().setSaveas(og);

        ds = new DataStore();
      } catch (FileNotFoundException | JAXBException g) {
        // TODO Auto-generated catch block
        g.printStackTrace();
      } catch (ClassNotFoundException g) {
        // TODO Auto-generated catch block
        g.printStackTrace();
      } catch (IOException g) {
        // TODO Auto-generated catch block
        g.printStackTrace();
      }
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
              if (category == 1 && ds.getBills().getListBill().get(billIdx) != null) {
                // System.out.println("label:" + label);
                // search di dalam data dengan id yang sama
                int idx = 0;
                Integer newStock = 0;
                for (int i = 0 ; i < data.size() ; i++)
                {
                  if (data.get(i).get(0).toString().equals(label))
                  {
                    newStock = Integer.parseInt(data.get(i).get(1).toString()) - 1;
                    idx = i;
                    break;
                  }
                }
                // System.out.println("======> " + data.get(idx).get(1).toString());
                // Integer newStock = Integer.parseInt(data.get(Integer.parseInt(label)).get(1).toString()) - 1;
                if (newStock < 0) {
                  JOptionPane.showMessageDialog(button, "Barang sudah habis");
                } else {
                  data.get(idx).set(1, newStock.toString());
                  // System.out.println(" data yang diganti " + data.get(idx).get(1).toString());
                  pembeli.get(idx).set(1, Integer.parseInt(pembeli.get(idx).get(1).toString()) + 1);
                  // System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
                  int idxPembeli = -1;
                  // System.out.println(tablePembeli.getRowCount());
                
                  for (int i = 0 ; i< tablePembeli.getRowCount() ; i++)
                  {
                    // System.out.println(i +"aaaaaaaaa");
                    // System.out.println(tablePembeli.getModel().getValueAt(i, 0).toString());
                    if (tablePembeli.getModel().getValueAt(i, 6).toString().equals(label))
                    {
                      tablePembeli.getModel().setValueAt(pembeli.get(idx).get(1), i, 0);
                      // System.out.println("diganti " + pembeli.get(idx).get(1).toString());
                      idxPembeli = i;
                      break;
                    }
                  }

                  if (idxPembeli == -1)
                  {
                    // System.out.println("label:" + label);
                    DefaultTableModel model = createTableModel(tablePembeli);
                    model.addRow(pembeli.get(idx).subList(1, 8).toArray());
                    // model.setValueAt(Integer.valueOf(1).toString(), tablePembeli.getRowCount(), 0);
                    // System.out.println("-=-=-=-=-=-=--=--=-=-=-");
                    // System.out.println(model.getDataVector());
                    // System.out.println("-=-=-=-=-=-=--=--=-=-=-");
                    tablePembeli.setModel(model);
                    tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
                    tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
                    tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
                  }
                  // System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");

                  for (int i = 0 ; i< tableToko.getRowCount() ; i++)
                  {
                    if (tableToko.getModel().getValueAt(i, 6).toString().equals(label))
                    {
                      tableToko.getModel().setValueAt(data.get(idx).get(1), i, 0);
                      // System.out.println("diganti" + data.get(idx).get(1).toString());
                      break;
                    }
                  }

                  if (billIdx != null) 
                  {
                    ds.getBills().getListBill().get(billIdx).addBarang(pembeli.get(idx).get(2).toString(), 1, Integer.valueOf(pembeli.get(idx).get(3).toString()));
                    // System.out.println(ds.getBills().getListBill().get(billIdx).getMapPembelian());
                    // System.out.println(ds.getBills().getListBill().get(billIdx).getMapId());
                    jLabel2.setText(ds.getBills().getListBill().get(billIdx).getTotal().toString());
                  }
                  
                  
                    // tableToko.getModel().setValueAt(data.get(Integer.parseInt(label)).get(1), Integer.parseInt(label), 0);
                    // ini yang salah
                    // tablePembeli.getModel().setValueAt(pembeli.get(Integer.parseInt(label)).get(1), Integer.parseInt(label), 0);
                }
              } else if (category == 2) {
                  //get data dg indeks = label
                  int idx = 0;
                  for (int i = 0 ; i < data.size() ; i++)
                  {
                      if (data.get(i).get(0).toString().equals(label))
                      {
                        data.get(i).set(1, Integer.parseInt(data.get(i).get(1).toString()) + 1);
                        pembeli.get(i).set(1, Integer.parseInt(pembeli.get(i).get(1).toString()) - 1);
                        idx = i;
                        break;
                      }
                  }
                  // System.out.println("PEMBELI ");
                  // for (int i = 0; i < pembeli.size(); i++) {
                  //   System.out.println(pembeli.get(i).get(0));
                  // }
                  // System.out.println("====================");
                  // search data dg indeks = label di dalam tabel
                  int idxPembeli = -1; 
                  // for (int i = 0 ; i < tablePembeli.getRowCount() ; i++)
                  // {
                  //   System.out.println("888888888888888888888888888888888888888888888888888888888888888");
                  //   System.out.println(tablePembeli.getModel().getValueAt(i, 6).toString());
                  //   System.out.println("888888888888888888888888888888888888888888888888888888888888888");
                  // }
                  for (int i = 0 ; i< tablePembeli.getRowCount() ; i++)
                  {
                    if (tablePembeli.getModel().getValueAt(i, 6).toString().equals(label))
                    {
                      tablePembeli.getModel().setValueAt(pembeli.get(idx).get(1), i, 0);
                      idxPembeli = i;
                      break;
                    }
                  }
                  
                  
                  // System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
                  for (int i = 0 ; i< tableToko.getRowCount() ; i++)
                  {
                    if (tableToko.getModel().getValueAt(i, 6).toString().equals(label))
                    {
                      tableToko.getModel().setValueAt(data.get(idx).get(1), i, 0);
                      break;
                    }
                  }
                  if ((int) tablePembeli.getModel().getValueAt(idxPembeli, 0) == 0)
                  {
                    DefaultTableModel model = createTableModel(tablePembeli);
                    model.removeRow(idxPembeli);
                    tablePembeli.setModel(model);
                    tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
                    tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
                    tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
                  }
                  
                  ds.getBills().getListBill().get(billIdx).removeBarang(pembeli.get(idx).get(2).toString(), 1, Integer.valueOf(pembeli.get(idx).get(3).toString()));
                  jLabel2.setText(ds.getBills().getListBill().get(billIdx).getTotal().toString());
                  saveDataStore();
                  // if (Integer.parseInt(pembeli.get(idx).get(1).toString()) == 0) {
                  //   System.out.println(pembeli.get(idx).get(2));
                  //   DefaultTableModel model = createTableModel(tablePembeli);
                  //   System.out.println("label " + label);
                  //   model.removeRow(idx);
                  //   tablePembeli.setModel(model);
                  //   tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
                  //   tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
                  //   tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
                  // }
                  // System.out.println(tablePembeli.getRowCount());
                  // for (int i = 0 ; i < tablePembeli.getRowCount() ; i++)
                  // {
                  //   // print all of label in each row
                  //   System.out.println("bbbbbbbbbbbbbbbbbbbbbbb" + i);
                  //   System.out.println(tablePembeli.getModel().getValueAt(i, 6).toString());
                  //   System.out.println("cccccccccccccccccccc");
                  // }
              }
              ds.getBills().getListBill().get(billIdx).createEntryList();

              // System.out.println("BILL: " + ds.getBills().getListBill().get(billIdx));
              // System.out.println("MAP PEMBELIAN: " + ds.getBills().getListBill().get(billIdx).getMapPembelian());
              // System.out.println("PEMBELIAN: " + ds.getBills().getListBill().get(billIdx).getPembelian());
              // System.out.println(ds.getBills().getListBill().get(0).getMapPembelian());

              saveDataStore();

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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonPlus = new javax.swing.JButton();
        buttonSubmit = new javax.swing.JButton();
        buttonCreateBill = new javax.swing.JButton();

        setBackground(new java.awt.Color(45, 43, 74));

        jLabel1.setBackground(new java.awt.Color(45, 43, 74));
        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 198, 111));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jual Barang");
        jLabel1.setToolTipText("");
        
        jLabel2.setBackground(new java.awt.Color(45, 43, 74));
        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 198, 111));
        jLabel2.setText("0");
        jLabel2.setToolTipText("");
        
        jLabel3.setBackground(new java.awt.Color(45, 43, 74));
        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 198, 111));
        jLabel3.setText("");
        jLabel3.setToolTipText("");
        
        
        buttonPlus.setBackground(new java.awt.Color(242, 198, 111));
        buttonPlus.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        buttonPlus.setForeground(new java.awt.Color(255, 255, 255));
        buttonPlus.setText("+");
        buttonPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlusActionPerformed(evt);
            }
        });

        buttonSubmit.setBackground(new java.awt.Color(242, 198, 111));
        buttonSubmit.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        buttonSubmit.setForeground(new java.awt.Color(255, 255, 255));
        buttonSubmit.setText("Submit");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        buttonCreateBill.setBackground(new java.awt.Color(242, 198, 111));
        buttonCreateBill.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        buttonCreateBill.setForeground(new java.awt.Color(255, 255, 255));
        buttonCreateBill.setText("CreateBill");
        buttonCreateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateBillActionPerformed(evt);
            }
        });
                
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(659, 659, 659)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSubmit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCreateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCreateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 411, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSubmit))
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    protected void jButtonSubmitActionPerformed(ActionEvent evt) {
      
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      billedUserId = mapId.get(jComboBox1.getSelectedItem().toString());
      // if (jComboBox1.getSelectedItem()!=null && mapId.size()>0)
      // {
      //   if (bill != null)
      //   {
      //     System.out.println("-----------------");
      //     System.out.println(bill.getMapPembelian());
      //     System.out.println("-----------------");
      //     System.out.println(bill);
      //   }
      //   billedUserId = mapId.get(jComboBox1.getSelectedItem().toString());
      //   System.out.println("billedUserId " + billedUserId);
      //   // bill = new Bill(ds.getBills().getSize(), Integer.valueOf(billedUserId.toString()));
      //   for (int i = 0; i < ds.getBills().getListBill().size(); i++)
      //   {
      //     if (ds.getBills().getListBill().get(i).getIdUser().equals(billedUserId))
      //     {
      //       bill = ds.getBills().getListBill().get(i);
      //       System.out.println("Billlll: " + bill.getMapPembelian());
      //       break;
      //     }
      //   }
      //   // reset matrix ke 0
      //   for (int i = 0 ; i < pembeli.size() ; i++)
      //   {
      //     pembeli.get(i).set(1, 0);
      //   }
      //   // bikin dari bill ke matrix
      //   for (Map.Entry<String,Integer> entry : bill.getMapPembelian().entrySet())
      //   {
      //     for (int i = 0 ; i < pembeli.size() ; i++)
      //     {
      //       if (pembeli.get(i).get(2).equals(entry.getKey()))
      //       {
      //         pembeli.get(i).set(1, entry.getValue());
      //       }
      //     } 
      //   }
      //   for (int i = tablePembeli.getRowCount() - 1; i >= 0; i--) 
      //   {
      //     DefaultTableModel model = createTableModel(tablePembeli);
      //     model.removeRow(i);
      //     tablePembeli.setModel(model);
      //     tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
      //     tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
      //     tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
      //   }
      //   for (int i = 0 ; i < pembeli.size() ; i++)
      //   {
      //     if (pembeli.get(i).get(1).toString().equals("0"))
      //     {
      //       DefaultTableModel model = createTableModel(tablePembeli);
      //       model.addRow(pembeli.get(i).subList(1, 8).toArray());
      //       tablePembeli.setModel(model);
      //       tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
      //       tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
      //       tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
      //     }
      //   }
      // }
      
    }//GEN-LAST:event_jComboBox1ActionPerformed


    private void jButtonCreateBillActionPerformed(java.awt.event.ActionEvent evt) {
      // System.out.println("bill==null?"+(ds.getBills().getListBill().get(billIdx)==null));
      boolean flag = true;
      if (!fixed)
      {
          fixed = true;
          // System.out.println(jComboBox1.getSelectedItem().toString());
          // ds.getBills().getListBill().add(new Bill(ds.getBills().getSize(), Integer.valueOf(billedUserId.toString())));
          // billIdx = ds.getBills().getListBill().size()-1;
          billedUserId = mapId.get(jComboBox1.getSelectedItem().toString());
          // System.out.println("billedUserId " + billedUserId);
          // bill = new Bill(ds.getBills().getSize(), Integer.valueOf(billedUserId.toString()));
          for (int i = 0; i < ds.getBills().getListBill().size(); i++)
          {
            System.out.println("IDUSER:" + ds.getBills().getListBill().get(i).getIdUser());
            System.out.println("BILLEDUSER:" + billedUserId);
            if (ds.getBills().getListBill().get(i).getIdUser().equals(billedUserId))
            {
              billIdx = i;
              System.out.println("Billlll: " + ds.getBills().getListBill().get(billIdx).getMapPembelian());
              flag = false;
              break;
            }
          }
          if (billIdx==null)
          {
            ds.getBills().getListBill().add(new Bill(ds.getBills().getSize(), Integer.valueOf(billedUserId.toString())));
            billIdx = ds.getBills().getListBill().size()-1;
          }
          // reset matrix ke 0
          for (int i = 0 ; i < pembeli.size() ; i++)
          {
            pembeli.get(i).set(1, 0);
          }
          tablePembeli = createTable(convertToArray(pembeli), true);
          // bikin dari bill ke matrix
          for (Map.Entry<String,Integer> entry : ds.getBills().getListBill().get(billIdx).getMapPembelian().entrySet())
          {
            for (int i = 0 ; i < pembeli.size() ; i++)
            {
              if (pembeli.get(i).get(2).equals(entry.getKey()))
              {
                pembeli.get(i).set(1, entry.getValue());
              }
            } 
          }
          for (int i = tablePembeli.getRowCount() - 1; i >= 0; i--) 
          {
            DefaultTableModel model = createTableModel(tablePembeli);
            model.removeRow(i);
            tablePembeli.setModel(model);
            tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
            tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
            tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
          }
          for (int i = 0 ; i < pembeli.size() ; i++)
          {
            if (!pembeli.get(i).get(1).toString().equals("0"))
            {
              DefaultTableModel model = createTableModel(tablePembeli);
              model.addRow(pembeli.get(i).subList(1, 8).toArray());
              tablePembeli.setModel(model);
              tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
              tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
              tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
            }
          }

          /* Loop cari orangnya di datastore */
          String status = "Customer "; // 1 member, 2 vip
          for(int i = 0; i < ds.getUsers().getCustomers().size(); i++){
            if(ds.getUsers().getCustomers().get(i).getId().equals(Integer.valueOf(billedUserId.toString()))){
                if(ds.getUsers().getCustomers().get(i) instanceof Member){
                  status = "Member ";
                  break;
                }else if (ds.getUsers().getCustomers().get(i) instanceof VIP){
                  status = "VIP ";
                  break;
                }
            }
          }
          jLabel3.setText((status + jComboBox1.getSelectedItem().toString()));
          // System.out.println("FLag: " + flag);
          ds.getBills().createMapBill(ds.getInventoryBarang());
          ds.getBills().createEntryLists();
          // System.out.println("jsfhioajsfopsapa");
          // System.out.println(ds.getBills());
          // System.out.println(ds.getBills().getListBill().get(0).getMapPembelian());
          // System.out.println("jsfhioajsfopsapa");
          
          saveDataStore();
          // System.out.println("-sa-d---sads-");
       }
      //  else
      //  {
      //    // DataStore tempDs = ds;
      //    try {
           
      //      ds = new DataStore();
      //      ArrayList<Barang> barangList = ds.getInventoryBarang().getInventory();
      //  // // Create data for the table
      //      ImageIcon leftButtonIcon = createImage("images/mouse.jpg");
      //      data = new ArrayList<>();
      //      pembeli = new ArrayList<>();
           
      //      for (int i = 0; i < barangList.size(); i++) {
      //        Barang barang = barangList.get(i);
      //        ArrayList<Object> listToko = new ArrayList<>();
      //        ArrayList<Object> listPembeli = new ArrayList<>();
      //        // JButton button = new JButton("Buy", leftButtonIcon);
      //        listToko.add(barang.getIdBarang());
      //        listToko.add(barang.getStokBarang());
      //        listToko.add(barang.getNamaBarang());
      //        listToko.add(barang.getHargaBarang());
      //        listToko.add(barang.getHargaBeli());
      //        listToko.add(barang.getKategori());
      //        listToko.add("images/" + barang.getGambar());
      //        listToko.add(barang.getIdBarang());
      //        data.add(listToko);
             
      //        listPembeli.add(barang.getIdBarang());
      //        listPembeli.add(0);
      //        listPembeli.add(barang.getNamaBarang());
      //        listPembeli.add(barang.getHargaBarang());
      //        listPembeli.add(barang.getHargaBeli());
      //        listPembeli.add(barang.getKategori());
      //        listPembeli.add("images/" + barang.getGambar());
      //        listPembeli.add(barang.getIdBarang());
      //        pembeli.add(listPembeli);
      //      }
           
      //      System.out.println("ukuran data: " + data.size());
      //      // Create a new instance of JTable
 
      //      // Ganti jadi ubah tabel, bukan create table
      //      // Object[][] convertedData = convertToArray(data);
      //      // model = new DefaultTableModel(convertedData, columnNames);
      //      // tableToko = createTable(convertedData,false);
      //      DefaultTableModel model = createTableModel(tableToko);
      //      for (int i = 0; i < tableToko.getRowCount(); i++)
      //      {
      //        model.removeRow(0);
      //      }
      //      tableToko.setModel(model);
           
      //      System.out.println("ukuran table toko: " + tableToko.getRowCount());
 
      //      for (int i = 0; i < data.size(); i++)
      //      {
      //        model.addRow(data.get(i).subList(1, 8).toArray());
      //        tableToko.setModel(model);
      //        tableToko.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
      //        tableToko.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(1));
      //        tableToko.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 1));
      //      }
 
      //      bill = new Bill(ds.getBills().getSize(), Integer.valueOf(billedUserId.toString()));
      //      boolean flagg = true;
      //      for (int i = 0; i < ds.getBills().getListBill().size(); i++)
      //      {
      //        if (ds.getBills().getListBill().get(i).getIdUser().equals(billedUserId))
      //        {
      //          bill = ds.getBills().getListBill().get(i);
      //          System.out.println("billlsss:" + bill.getMapPembelian());
      //          flagg = false;
      //          break;
      //        }
      //      }
 
      //      String status = "Customer ";
      //      for(int i = 0; i < ds.getUsers().getCustomers().size(); i++){
      //        if(ds.getUsers().getCustomers().get(i).getId().equals(Integer.valueOf(billedUserId.toString()))){
      //            if(ds.getUsers().getCustomers().get(i) instanceof Member){
      //              status = "Member ";
      //              break;
      //            }else if (ds.getUsers().getCustomers().get(i) instanceof VIP){
      //              status = "VIP ";
      //              break;
      //            }
      //        }
      //      }
           
      //      jLabel3.setText((status + jComboBox1.getSelectedItem().toString()));
      //      if (flagg)
      //      {
      //        ds.getBills().addBill(bill);
      //        ds.getBills().createMapBill(ds.getInventoryBarang());
      //      }
      //      try {
      //        String og = ds.getConfig().getSaveas();
      //        ds.getConfig().setSaveas("xml");
      //        ds.saveAs();
     
      //        ds.getConfig().setSaveas("json");
      //        ds.saveAs();
     
      //        ds.getConfig().setSaveas("obj");
      //        ds.saveAs();
     
      //        ds.getConfig().setSaveas(og);
     
      //        ds = new DataStore();
      //      } catch (FileNotFoundException | JAXBException e) {
      //        // TODO Auto-generated catch block
      //        e.printStackTrace();
      //      } catch (ClassNotFoundException e) {
      //        // TODO Auto-generated catch block
      //        e.printStackTrace();
      //      } catch (IOException e) {
      //        // TODO Auto-generated catch block
      //        e.printStackTrace();
      //      }
      //      System.out.println("-sa-d---sads-");
           
      //      model = createTableModel(tablePembeli);
      //      for (int i = 0; i < tablePembeli.getRowCount(); i++)
      //      {
      //        model.removeRow(0);
      //      }
      //      tablePembeli.setModel(model);
      //      tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
      //      tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
      //      tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
      //      System.out.println("row pembeli:" + tablePembeli.getRowCount());
      //    } catch (ClassNotFoundException | JAXBException | IOException e) {
      //      // TODO Auto-generated catch block
      //      e.printStackTrace();
      //    }
       
      // }
       
    }

    private void jButtonPlusActionPerformed(java.awt.event.ActionEvent evt) {
      if (!fixed)
      {
        fixed = true;
        // System.out.println(ds.getUsers().getCustomers().get(ds.getUsers().getCustomers().size()-1).toString());
        Customer newCust = new Customer(ds.getUsers().getCustomers().size()==0 ? 1 : Integer.parseInt(ds.getUsers().getCustomers().get(ds.getUsers().getCustomers().size()-1).getId().toString())+1);
        ds.getUsers().getCustomers().add(newCust);
        
        System.out.println("-----------------------");
        saveDataStore();
        billedUserId = newCust.getId();
        ds.getBills().getListBill().add(new Bill(ds.getBills().getSize(), Integer.valueOf(billedUserId.toString())));
        billIdx = ds.getBills().getListBill().size()-1;
        // reset matrix ke 0
        for (int i = 0 ; i < pembeli.size() ; i++)
        {
          pembeli.get(i).set(1, 0);
        }
        tablePembeli = createTable(convertToArray(pembeli), true);
        // bikin dari bill ke matrix
        for (Map.Entry<String,Integer> entry : ds.getBills().getListBill().get(billIdx).getMapPembelian().entrySet())
        {
          for (int i = 0 ; i < pembeli.size() ; i++)
          {
            if (pembeli.get(i).get(2).equals(entry.getKey()))
            {
              pembeli.get(i).set(1, entry.getValue());
            }
          } 
        }
        
        jLabel3.setText("Customer " + newCust.getId().toString());
        ds.getBills().createMapBill(ds.getInventoryBarang());
        ds.getBills().createEntryLists();
        saveDataStore();
        for (int i = tablePembeli.getRowCount() - 1; i >= 0; i--) 
        {
          DefaultTableModel model = createTableModel(tablePembeli);
          model.removeRow(i);
          tablePembeli.setModel(model);
          tablePembeli.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
          tablePembeli.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(2));
          tablePembeli.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), 2));
        }
      }

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPlus;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JButton buttonCreateBill;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}