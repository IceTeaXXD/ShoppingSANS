import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.*;
import com.shoppingsans.Datastore.*;
import com.shoppingsans.JualBarang.*;

public class Plugin1 extends BasePlugin {
    private String windowname = "Bar and Line Chart";
    private JTextField data1;
    private JTextField data2;
    private JTextField data3;
    private JTextField data4;
    private JPanel barPanel;
    private JPanel linePanel;

    public Plugin1() {
        initComponents();
    }

    public void initComponents() {

        setLayout(new BorderLayout());

        linePanel = new JPanel(new BorderLayout());
        linePanel.setBackground(new Color(153, 153, 153));
        add(linePanel, BorderLayout.CENTER);

        barPanel = new JPanel(new BorderLayout());
        barPanel.setBackground(new Color(153, 153, 153));
        add(barPanel, BorderLayout.EAST);

        JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 198, 111));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bar and Line Chart Insight");
        add(jLabel1, BorderLayout.NORTH);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        try {
                            DataStore ds = new DataStore();
                            System.out.println("Updating Bar and Line Chart");
                            InventoryBarang ib = ds.getInventoryBarang();
                            ArrayList<Barang> inv = ib.getInventory();
                            Map <String, Integer> map = new HashMap<String, Integer>();
                            for (Barang b : inv){
                                if (map.containsKey(b.getKategori())){
                                    map.put(b.getKategori(), map.get(b.getKategori()) + 1);
                                } else {
                                    map.put(b.getKategori(), 1);
                                }
                            }
                            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                            for (String key : map.keySet()){
                                dataset.setValue(map.get(key), "Value", key);
                            }
                            
                            // Bar Chart
                            JFreeChart chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false, false);
                            CategoryPlot catPlot = chart.getCategoryPlot();
                            catPlot.setRangeGridlinePaint(Color.BLACK);
                            
                            ChartPanel chartPanel = new ChartPanel(chart);
                            barPanel.removeAll();
                            barPanel.add(chartPanel, BorderLayout.CENTER);
                            barPanel.validate();
                            
                            // Line Chart
                            JFreeChart chart2 = ChartFactory.createLineChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false, false);
                            CategoryPlot catPlot2 = chart2.getCategoryPlot();
                            catPlot2.setRangeGridlinePaint(Color.BLACK);
                            
                            ChartPanel chartPanel2 = new ChartPanel(chart2);
                            linePanel.removeAll();
                            linePanel.add(chartPanel2, BorderLayout.CENTER);
                            linePanel.validate();
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
}
