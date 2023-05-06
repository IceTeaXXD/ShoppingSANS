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

public class Plugin1 extends JPanel {

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

    private void initComponents() {

        barPanel = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        data2 = new JTextField();
        data3 = new JTextField();
        data1 = new JTextField();
        viewButton = new JButton();
        JLabel jLabel4 = new JLabel();
        data4 = new JTextField();
        linePanel = new JPanel();

        setLayout(new BorderLayout());

        barPanel.setBackground(new Color(153, 153, 153));
        barPanel.setLayout(new BorderLayout());

        jLabel1.setText("data_1");

        jLabel2.setText("data_2");

        jLabel3.setText("data_4");

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("data_3");

        linePanel.setBackground(new Color(153, 153, 153));
        linePanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(jLabel1);
        inputPanel.add(data1);
        inputPanel.add(jLabel2);
        inputPanel.add(data2);
        inputPanel.add(jLabel4);
        inputPanel.add(data3);
        inputPanel.add(jLabel3);
        inputPanel.add(data4);
        inputPanel.add(viewButton);

        add(barPanel, BorderLayout.WEST);
        add(linePanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int s1 = Integer.parseInt(data1.getText());
        int s2 = Integer.parseInt(data2.getText());
        int s3 = Integer.parseInt(data3.getText());
        int s4 = Integer.parseInt(data4.getText());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(s1, "", "Data 1");
        dataset.setValue(s2, "", "Data 2");
        dataset.setValue(s3, "", "Data 3");
        dataset.setValue(s4, "", "Data 4");

        // Bar Chart
        JFreeChart chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false,
                false);
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);

        ChartPanel chartPanel = new ChartPanel(chart);
        barPanel.removeAll();
        barPanel.add(chartPanel, BorderLayout.CENTER);
        barPanel.validate();

        // Line Chart
        JFreeChart chart2 = ChartFactory.createLineChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false,
                false);
        CategoryPlot catPlot2 = chart2.getCategoryPlot();
        catPlot2.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        linePanel.removeAll();
        linePanel.add(chartPanel2, BorderLayout.CENTER);
        linePanel.validate();
    }
}
