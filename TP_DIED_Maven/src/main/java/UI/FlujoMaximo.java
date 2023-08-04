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

public class FlujoMaximo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Double flujoMaximo = (new CalculoFlujoMaximo()).getFlujoMaximo();
	
	FlujoMaximo(){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Flujo Maximo");
	    this.setSize(500, 500); // Set your preferred size
	    this.setLocationRelativeTo(null); // Center the frame on the screen
	    ImageIcon customIcon = new ImageIcon("LogoApp.png");
        this.setIconImage(customIcon.getImage());
	    
	    Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");
	    this.setContentPane(backgroundPanel);
		
		JLabel texto = new JLabel("Flujo Maximo en KG: ");
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setVerticalAlignment(SwingConstants.CENTER);
        texto.setFont(new Font("Antipasto", Font.PLAIN, 20)); 
		
		JLabel flujo = new JLabel(flujoMaximo.toString());
		flujo.setForeground(Color.WHITE);
		flujo.setHorizontalAlignment(SwingConstants.CENTER);
        flujo.setVerticalAlignment(SwingConstants.CENTER);
        flujo.setFont(new Font("Antipasto", Font.PLAIN, 40)); 
		
		JButton volver = new JButton("volver");
		buttonConfig(volver);
		
		GridBagConstraints gbc = new GridBagConstraints();
	    
	    gbc.gridx = 0; 
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.anchor = GridBagConstraints.CENTER; 
	    gbc.insets = new Insets(10, 10, 0, 10); 
	    backgroundPanel.add(texto,gbc);
	    
	    gbc.gridy = 1;
	    gbc.insets = new Insets(30, 30, 15, 30); 
	    backgroundPanel.add(flujo,gbc);
	    
	    gbc.gridy = 3;
	    gbc.gridheight = 2;
	    gbc.anchor = GridBagConstraints.SOUTH;
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