package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import TP.ArmadorGrafo;
import TP.CalculoPageRank;
import TP.Camino;
import TP.ListaCaminos;
import TP.ListaSucursales;
import TP.Sucursal;

public class PanelPageRank extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JScrollPane scrollPane;

	
	PanelPageRank() throws Exception{
		
		 // Create the scrollable panel for the content
        JPanel scrollableContentPanel = new JPanel(new GridLayout(0, 3, 5, 5));
        scrollableContentPanel.setBackground(new Color(60,80,91,255)); // Set the background color
        scrollPane = new JScrollPane(scrollableContentPanel);

        Map<Sucursal, Double> sortedMapDescending = null;
        
        ArrayList<Camino> listaCaminos = (new ListaCaminos()).getLista();
		
		ArrayList<Sucursal> listaSucursales = (new ListaSucursales()).getLista();
        
        try {
           sortedMapDescending = (new CalculoPageRank(new ArmadorGrafo(listaSucursales,listaCaminos))).getPageRankMap();
		} catch (Exception e) {
			throw e;
		}
        
        for (Sucursal sucursal : sortedMapDescending.keySet()) {
        
        	JLabel label = new JLabel((sucursal.id().toString()));
            label.setForeground(Color.WHITE); // Set the text color
            label.setOpaque(false); // Make the background color visible
            label.setFont(new Font("Antipasto", Font.PLAIN, 14)); // Set the font
            label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // Add a border
            label.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
            label.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        	scrollableContentPanel.add(label);
        	
        	JLabel label2 = new JLabel(sucursal.getNombre());
        	label2.setForeground(Color.WHITE); // Set the text color
            label2.setOpaque(false); // Make the background color visible
            label2.setFont(new Font("Antipasto", Font.PLAIN, 14)); // Set the font
            label2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // Add a border
            label2.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
            label2.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        	scrollableContentPanel.add(label2);
        	
        	JLabel label3 = new JLabel(sortedMapDescending.get(sucursal).toString());
        	label3.setForeground(Color.WHITE); // Set the text color
            label3.setOpaque(false); // Make the background color visible
            label3.setFont(new Font("Antipasto", Font.PLAIN, 14)); // Set the font
            label3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // Add a border
            label3.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
            label3.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        	scrollableContentPanel.add(label3);
        	
        }
        
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportBorder(null);
		
		// Set a custom ScrollBarUI on the vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        verticalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setUI(new CustomScrollBarUI());
        horizontalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        horizontalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	//Custom ScrollBarUI class
	class CustomScrollBarUI extends BasicScrollBarUI {
	 // Override the necessary methods to customize the scrollbar appearance
	 @Override
	 protected void configureScrollBarColors() {
	     // Set custom colors for the scrollbar
	     this.thumbColor = (new Color(255,255,255,55));
	     this.thumbDarkShadowColor = (new Color(255,255,255,0));
	     this.thumbHighlightColor = (new Color(255,255,255,255));
	     this.thumbLightShadowColor = (new Color(255,255,255,0));
	     this.trackColor = (new Color(60,80,91,255));
	     this.trackHighlightColor = (new Color(255,255,255,0));
	 }

	 @Override
	 protected JButton createDecreaseButton(int orientation) {
	     return createZeroButton();
	 }

	 @Override
	 protected JButton createIncreaseButton(int orientation) {
	     return createZeroButton();
	 
	 }

	 private JButton createZeroButton() {
	     JButton button = new JButton();
	     Dimension zeroDim = new Dimension(0, 0);
	     button.setPreferredSize(zeroDim);
	     button.setMinimumSize(zeroDim);
	     button.setMaximumSize(zeroDim);
	     return button;
	 	}
	

	}
}
