package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import TP.CalculoFlujoMaximo;

public class PageRank extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Double flujoMaximo = (new CalculoFlujoMaximo()).getFlujoMaximo();
	
	PageRank(){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("PageRank");
	    this.setSize(500, 500); // Set your preferred size
	    this.setLocationRelativeTo(null); // Center the frame on the screen
	    ImageIcon customIcon = new ImageIcon("LogoApp.png");
        this.setIconImage(customIcon.getImage());
	    Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");
	    this.setContentPane(backgroundPanel);
		
		JLabel texto = new JLabel("Lista de sucursales ordenada por PageRank");
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setVerticalAlignment(SwingConstants.CENTER);
        texto.setFont(new Font("Antipasto", Font.PLAIN, 20)); 
		
		JButton volver = new JButton("volver");
		buttonConfig(volver);
		
		GridBagConstraints gbc = new GridBagConstraints();
	    
	    gbc.gridx = 0; 
	    gbc.gridy = 0;
	    gbc.weightx = 1; // Allow the panel to take up extra horizontal space
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.anchor = GridBagConstraints.NORTH; 
	    gbc.insets = new Insets(10, 10, 10, 10); 
	    backgroundPanel.add(texto,gbc);
	    
	    
	    
	    gbc.insets = new Insets(0, 0, 0, 0); 
	    gbc.gridx = 0; 
	    gbc.gridy = 1; // Reset the Y position to the first row
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
	    gbc.anchor = GridBagConstraints.NORTH;
	    backgroundPanel.add(new PanelPageRank().getScrollPane(),gbc);
	    
	    
	    gbc.gridy = 5;
	    gbc.gridheight = 2;
	    gbc.weighty = 0.2; 
	    gbc.fill = GridBagConstraints.NONE; // Make the panel fill the available space
	    gbc.anchor = GridBagConstraints.CENTER;
	    backgroundPanel.add(volver,gbc);
	    
	    volver.addActionListener(e -> {
		       this.dispose();
		    });
	    
	    this.setVisible(true);
	
	}
	
	private void buttonConfig(JButton button1) {
		 button1.setOpaque(false);
	  button1.setFont(new Font("Code Light", Font.PLAIN, 13));
	  button1.setForeground(Color.WHITE);
	  button1.setBackground(new Color(0,0,0,70));
	  button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	  button1.setPreferredSize(new Dimension(180, 50));
	  button1.setFocusable(false);

	  button1.addMouseListener(new MouseAdapter() {
	      @Override
	      public void mouseEntered(MouseEvent e) {
	      	button1.setOpaque(true);
	          button1.setBackground(new Color(60,80,91,255));
	          button1.setForeground(Color.WHITE);
	          button1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
	          button1.setFont(new Font("Code Light", Font.PLAIN, 14));
	      	}

	      @Override
	      public void mouseExited(MouseEvent e) {
	      	button1.setOpaque(false);
	          button1.setForeground(Color.WHITE);
	          button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	          button1.setFont(new Font("Code Light", Font.PLAIN, 13));
	      	}
	  	});
	  
		}
	
	
}
