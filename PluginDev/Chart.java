import javax.swing.JFrame;

public class Chart {
    public static void main(String[] args) {
        // Create a new JFrame object
        JFrame frame = new JFrame("My Chart");

        // Create a new ChartPanelCustom object
        ChartPanelCustom chartPanelCustom = new ChartPanelCustom();

        // Add the ChartPanelCustom to the JFrame
        frame.setContentPane(chartPanelCustom);

        // Set the size of the JFrame
        frame.setSize(600, 400);

        // Set the JFrame to be visible
        frame.setVisible(true);
    }
}
