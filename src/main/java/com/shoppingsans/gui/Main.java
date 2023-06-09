/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shoppingsans.gui;

import com.shoppingsans.Datastore.DataStore;
import com.shoppingsans.Plugins.JarClassLoader;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew
 * @author Azmi
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     */
    public Main() throws FileNotFoundException, ClassNotFoundException, JAXBException, IOException {
        initComponents();
        Home h = new Home();
        addTab("Home", h);
        new Thread(){
            public void run(){
                while(true){
                    Calendar cal = new GregorianCalendar();
                    
                    /* Set AM PM to text */
                    String am_pm_text;
                    if(cal.get(Calendar.AM_PM) == 0){
                        am_pm_text = "AM";
                    }else{
                        am_pm_text = "PM";
                    }
                    
                    /* Parse to text */
                    String hour_string = String.format("%02d", cal.get(Calendar.HOUR));
                    String minute_string = String.format("%02d", cal.get(Calendar.MINUTE));
                    String second_string = String.format("%02d", cal.get(Calendar.SECOND));
                    
                    String time_text = hour_string + ":" + minute_string + ":" + second_string + " " + am_pm_text;                    
                    clock.setText(time_text);
                    
                    
                    
                    /* Set Tanggal */
                    String day;
                    switch (cal.get(Calendar.DAY_OF_WEEK)) {
                        case Calendar.SUNDAY: day = "Sunday"; break;
                        case Calendar.MONDAY: day = "Monday"; break;
                        case Calendar.TUESDAY: day = "Tuesday"; break;
                        case Calendar.WEDNESDAY: day = "Wednesday"; break;
                        case Calendar.THURSDAY: day = "Thursday"; break;
                        case Calendar.FRIDAY: day = "Friday"; break;
                        case Calendar.SATURDAY: day = "Saturday"; break;
                        default: day = ""; break;
                    }
                    
                    String tgl;
                    Integer __tanggal = cal.get(Calendar.DATE);
                    tgl = __tanggal.toString();
                    
                    String month;
                    switch(cal.get(Calendar.MONTH)){
                        case Calendar.JANUARY : month = "January"; break;
                        case Calendar.FEBRUARY : month = "February"; break;
                        case Calendar.MARCH : month = "March"; break;
                        case Calendar.APRIL : month = "April"; break;
                        case Calendar.MAY : month = "May"; break;
                        case Calendar.JUNE : month = "June"; break;
                        case Calendar.JULY : month = "July"; break;
                        case Calendar.AUGUST : month = "August"; break;
                        case Calendar.SEPTEMBER : month = "September"; break;
                        case Calendar.OCTOBER : month = "October"; break;
                        case Calendar.NOVEMBER : month = "November"; break;
                        case Calendar.DECEMBER : month = "December"; break;
                        default : month = ""; break;
                    }
                    
                    String year;
                    Integer __year = cal.get(Calendar.YEAR);
                    year = __year.toString();
                    
                    tanggal.setText(day + ", " + tgl + " " + month + " " + year);
                }
            }
        }.start();
        
        jPanel1.setVisible(false);
        jPanel3.setVisible(false);

        /* Search through if there exists */
        DataStore ds = new DataStore();
        
        for(int i = 0; i < ds.getConfig().getPlugins().getPath().size(); i++){
            try {
                JarClassLoader jcl = new JarClassLoader(ds.getConfig().getPlugins().getPath().get(i));
                File f = new File(ds.getConfig().getPlugins().getPath().get(i));
                String name = f.getName().substring(0, f.getName().lastIndexOf("."));
                Component obj = jcl.loadClassObject(name);
                addTab(obj);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
//        File pluginFolder = new File(ds.getConfig().getPath());
//        if (pluginFolder.exists()) {
//            File[] pluginFiles = pluginFolder.listFiles(new FilenameFilter() {
//                public boolean accept(File dir, String name) {
//                    return name.toLowerCase().endsWith(".jar");
//                }
//            });
//    
//            for (File pluginFile : pluginFiles) {
//                try {
//                    JarClassLoader jcl = new JarClassLoader(pluginFile.toPath().toString());
//                    System.out.println(pluginFile.getName());
//                    String name = pluginFile.getName().substring(0, pluginFile.getName().lastIndexOf("."));
//                    Component obj = jcl.loadClassObject(name);
//                    addTab(obj);
//                } catch (Exception ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }
    
    public final void addTab(String title, Component page){
        jTabbedPane1.addTab(title, page);
        jTabbedPane1.setTabComponentAt(jTabbedPane1.getTabCount()-1, new CloseButton(jTabbedPane1));
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount()-1);
    }

    public final void addTab(Component plugin) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Field windowname = plugin.getClass().getDeclaredField("windowname");
        windowname.setAccessible(true);
        String window = (String) windowname.get(plugin);        
        jTabbedPane1.addTab(window, plugin);
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount()-1);
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
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        tanggal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 36, 1190, 850));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/member_area.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 210, 50));

        jPanel1.setOpaque(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        jPanel2.setBackground(new java.awt.Color(45, 43, 74));
        jPanel2.setForeground(new java.awt.Color(45, 43, 74));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/addnew.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/updatecust.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/history.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 190, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/penjualan.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 210, 50));

        jPanel3.setBackground(new java.awt.Color(45, 43, 74));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(45, 43, 74));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/manajemen.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/laporan.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton7)
            .addComponent(jButton5)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 190, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/jualbarang.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton8ActionPerformed(evt);
                } catch (ClassNotFoundException | JAXBException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, 50));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/settings.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 210, 50));

        tanggal.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("DAY, TGL BULAN TAHUN");
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 830, -1, -1));

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/logo.png"))); // NOI18N
        jLabel1.setText("ShoppingSans");
        jLabel1.setName("logo"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 220, 80));
        jLabel1.addMouseListener(new MouseAdapter(){
            public void mouseClicked (MouseEvent evt){
                addTab("Home", new Home());
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/group.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 220, -1));

        clock.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        clock.setForeground(new java.awt.Color(255, 255, 255));
        clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clock.setText("HH:MM:SS AM");
        clock.setToolTipText("");
        getContentPane().add(clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 870, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoppingsans/img/bg.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1510, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jPanel1.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        // TODO add your handling code here:
        jPanel1.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            addTab("Add New Member", new AddMember());
        } catch (JAXBException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            addTab("History Transaksi", new HistoryTransaksi());
        } catch (JAXBException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jButton6MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jPanel3MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException, ClassNotFoundException, JAXBException, IOException {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        addTab("Jual Barang", new JualBarang());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            // TODO add your handling code here:
            addTab("Settings", new Settings());
        } catch (JAXBException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
        // TODO add your handling code here:
        //        addTab("Laporan", new Laporan());
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
        //        addTab("Manajemen Barang", new ManajemenBarang());
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            addTab("Update Customer", new UpdateCustomer());
        } catch (JAXBException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        addTab("Laporan", new Laporan());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            addTab("Manajemen Barang", new ManajemenBarang());
        } catch (JAXBException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
                try {
                    new Main().setVisible(true);
                } catch (ClassNotFoundException | JAXBException | IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
