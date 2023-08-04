package UI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ListaItem extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ListaItem(){
		
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JButton sell = new JButton("SELL");
        JButton tax = new JButton("RETURN TAX");
        buttonConfig(sell);
        buttonConfig(tax);
        
        JLabel name = new JLabel("Item name");
        name.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        name.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        name.setFont(new Font("Antipasto", Font.PLAIN, 15));
        name.setForeground(Color.WHITE);
        
        JLabel emptySpace = new JLabel("  ");
        name.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        name.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        
        Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, sell.getPreferredSize().height);
        sell.setMaximumSize(maxComponentSize);
        tax.setMaximumSize(maxComponentSize);
        name.setMaximumSize(maxComponentSize);
        
        this.add(name);
        this.add(tax); 
        this.add(emptySpace);
        this.add(sell);
	}
	


private void buttonConfig(JButton button1) {
		button1.setOpaque(false);
	    button1.setFont(new Font("Antipasto", Font.PLAIN, 15));
	    button1.setForeground(Color.WHITE);
	    button1.setBackground(new Color(0,0,0,70));
	    button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    button1.setPreferredSize(new Dimension(180, 50));
	    button1.setFocusable(false);
	
	    button1.addMouseListener(new MouseAdapter() {
	       
	   	 @Override
	        public void mouseEntered(MouseEvent e) {
	        	 button1.setOpaque(true);
	            button1.setBackground(new Color(80,100,111,255));
	            button1.setForeground(Color.WHITE);
	            button1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
	            //button1.setFont(new Font("Code Light", Font.PLAIN, 42));
	        }
	        
	
	        @Override
	        public void mouseExited(MouseEvent e) {
	        	 button1.setOpaque(false);
	            button1.setForeground(Color.WHITE);
	            button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	            //button1.setFont(new Font("Code Light", Font.PLAIN, 40));
        	}
    	});
	}
}
