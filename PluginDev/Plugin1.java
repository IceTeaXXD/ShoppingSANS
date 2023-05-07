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

public class Plugin1 extends BasePlugin {
    private String windowname = "Bar and Line Chart";
    private JTextField data1;
    private JTextField data2;
    private JTextField data3;
    private JTextField data4;
    private JButton viewButton;
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

        viewButton = new JButton("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        add(viewButton, BorderLayout.SOUTH);

    }

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {

        int s1 = 10;
        int s2 = 20;
        int s3 = 15;
        int s4 = 20;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(s1, "Value", "Data 1");
        dataset.setValue(s2, "Value", "Data 2");
        dataset.setValue(s3, "Value", "Data 3");
        dataset.setValue(s4, "Value", "Data 4");

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

    @Override
    public void update(){
        System.out.println("PLUGIN 1 TO BE UPDATED IMPLEMENTED");
    }
}
