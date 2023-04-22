package com.shoppingsans.JualBarang;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ImageRenderer extends JLabel implements TableCellRenderer {
    
    public ImageRenderer() {
        setOpaque(true);
    }
    
    @Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    // Get the path to the image from the data in the table
    String path = (String)value;
    
    // Create a new ImageIcon from the image at the path
    ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
    
    // Set the icon on this label
    setIcon(imageIcon);
    
    // Set the size of the label to match the size of the icon
    setSize(imageIcon.getImage().getWidth(null), imageIcon.getImage().getHeight(null));
    
    // Return this label as the renderer for the cell
    return this;
}

    
}