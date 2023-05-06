import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartPanelCustom extends JPanel {
    public ChartPanelCustom() {
        // Create a new DefaultCategoryDataset object
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Series 1", "Category 1");
        dataset.addValue(2.0, "Series 1", "Category 2");
        dataset.addValue(3.0, "Series 1", "Category 3");

        // Create a new JFreeChart object
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "Category", "Value", dataset, org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true, false);

        // Create a new ChartPanel object
        ChartPanel chartPanel = new ChartPanel(chart);

        // Add the ChartPanel to this JPanel
        this.add(chartPanel);
    }
}
