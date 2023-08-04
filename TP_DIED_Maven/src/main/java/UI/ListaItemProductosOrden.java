package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class ListaItemProductosOrden extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ListaItemProductosOrden(String producto, Integer cant){
		

		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel prod = new JLabel(producto);
		prod.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
		prod.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
		prod.setFont(new Font("Antipasto", Font.PLAIN, 20));
		prod.setForeground(Color.WHITE);
		prod.setPreferredSize(new Dimension(100, 40));
        Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 12, 14, 12);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        prod.setBorder(compoundBorder);
        
        JLabel cantidad = new JLabel("Cantidad: " + cant);
        cantidad.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        cantidad.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        cantidad.setFont(new Font("Antipasto", Font.PLAIN, 20));
        cantidad.setForeground(Color.WHITE);
        cantidad.setPreferredSize(new Dimension(100, 40));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 12, 14, 12);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        cantidad.setBorder(compoundBorder);
        
		
		this.add(Box.createHorizontalStrut(5));  
        this.add(prod);
        this.add(cantidad);
        this.add(Box.createHorizontalStrut(5)); 
     
		
	}
	
	
	
}
