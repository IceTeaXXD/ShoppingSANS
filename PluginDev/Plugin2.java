import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.util.*;

import com.shoppingsans.Datastore.*;
import com.shoppingsans.JualBarang.*;

public class Plugin2 extends BasePlugin {

    private String windowname = "Pie Chart";
    private static final long serialVersionUID = 1L;

    public Plugin2() {
        initComponents();
    }

    private void initComponents() {
        panel = new JPanel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1268, 685));
        setLayout(new BorderLayout());

        panel.setBackground(new java.awt.Color(153, 153, 153));
        panel.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 198, 111));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pie Chart Insight");


        add(jLabel1, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        try {
                            DataStore ds = new DataStore();
                            System.out.println("Updating Pie Chart");
                            InventoryBarang ib = ds.getInventoryBarang();
                            ArrayList<Barang> inv = ib.getInventory();
                            Map <String, Integer> map = new HashMap<String, Integer>();
                            for (Barang b : inv){
                                String category = b.getKategori();
                                if (map.containsKey(category)){
                                    map.put(category, map.get(category) + 1);
                                } else {
                                    map.put(category, 1);
                                }
                            }
                            // update the pie chart
                            DefaultPieDataset pieDataset = new DefaultPieDataset();
                            for (String key : map.keySet()){
                                pieDataset.setValue(key, map.get(key));
                            }
                            JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, true);
                            PiePlot p = (PiePlot) chart.getPlot();
                            p.setSectionPaint("S1", Color.RED);
                            p.setSectionPaint("S2", Color.BLUE);
                            p.setSectionPaint("S3", Color.GREEN);
                            p.setSectionPaint("S4", Color.YELLOW);
                            p.setExplodePercent("S1", 0.10);
                            p.setExplodePercent("S2", 0.10);
                            p.setExplodePercent("S3", 0.10);
                            p.setExplodePercent("S4", 0.10);
                    
                            ChartPanel piePanel = new ChartPanel(chart);
                            panel.removeAll();
                            panel.add(piePanel, BorderLayout.CENTER);
                            panel.validate();
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
