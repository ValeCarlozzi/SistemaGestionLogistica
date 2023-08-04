package UI;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class ListaPane extends JPanel {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ListaPane(){
		
		 this.setLayout(new GridBagLayout()); // Set an appropriate layout for overall needs
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0); 
        gbc.gridx = 0; 
        gbc.weightx = 1; // Allow the panel to take up extra horizontal space
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make the panel fill the available space
		
        for(int i = 0; i < 40; i++) {
        	
        	gbc.gridy = i;
        	this.add(new ListaItem(),gbc);
             
        	
        	
        }
		this.setBackground(new Color(60,80,91,255));

        
        
	}
	
}

