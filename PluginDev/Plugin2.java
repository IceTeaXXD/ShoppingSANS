import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Plugin2 extends BasePlugin {

    private String windowname = "Pie Chart";
    private static final long serialVersionUID = 1L;

    public Plugin2() {
        initComponents();
    }

    private void initComponents() {
        panel = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1268, 685));
        setLayout(new BorderLayout());

        panel.setBackground(new java.awt.Color(153, 153, 153));
        panel.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 198, 111));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pie Chart Insight");

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        add(jLabel1, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(jButton1, BorderLayout.SOUTH);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int s1 = 10;
        int s2 = 20;
        int s3 = 25;
        int s4 = 15;

        // Create Pie Chart from the data
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("S1", new Integer(s1));
        pieDataset.setValue("S2", new Integer(s2));
        pieDataset.setValue("S3", new Integer(s3));
        pieDataset.setValue("S4", new Integer(s4));

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

    @Override
    public void update(){
        System.out.println("Updating Pie Chart");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
