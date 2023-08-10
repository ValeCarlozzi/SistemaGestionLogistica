package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SucursalesWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO rercibir parametros para size y posicion para mantener size y posicion de ventana anterior
	SucursalesWindow(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sucursales");
        this.setSize(1000, 720); // Set your preferred size
        this.setLocationRelativeTo(null); // Center the frame on the screen
		
		
        //background panel (extiende JPanel)
        Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");
        this.setContentPane(backgroundPanel);
		
        //------------PANEL DERECHA-------------------
        
        //creo panel Derecha
        JPanel panelDerecha = new JPanel(new GridBagLayout());
        panelDerecha.setBackground(new Color(0,0,0,70));

        //Botones panel derecha
        JButton alta = new JButton("Alta");
        JButton busqueda = new JButton("Busqueda");

        //se configuran los botones
        buttonConfig(alta);
        buttonConfig(busqueda);
        
        // Create GridBagConstraints to specify the layout constraints for each button
        GridBagConstraints gbc = new GridBagConstraints();
        
        //agrego panel derecha
        gbc.insets = new Insets(0, 0, 0, 0); 
        gbc.gridx = 1; 
        gbc.gridy = 0; // Reset the Y position to the first row
        gbc.weightx = 0.4; // Allow the panel to take up extra horizontal space
        gbc.weighty = 1; 
        gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
        backgroundPanel.add(panelDerecha, gbc);
        
        // Add Alta
        gbc.gridx = 0; // X position in the grid (left side)
        gbc.gridy = 0; // Y position in the grid
        gbc.insets = new Insets(7, 10, 7, 10); // Add some padding around the button
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        panelDerecha.add(alta, gbc);
		
        // Add Busqueda
        gbc.gridy = 1; 
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        panelDerecha.add(busqueda, gbc);
        
        //------------FIN PANEL DERECHA-------------------
		
        //------------PANEL IZQUIERDA---------------------
		
        ListaTab panelIzquierda = new ListaTab();
        
        GridBagConstraints gbcIzq = new GridBagConstraints();
        
        gbcIzq.insets = new Insets(0, 0, 0, 0); 
        gbcIzq.gridx = 0; 
        gbcIzq.gridy = 0; // Reset the Y position to the first row
        gbcIzq.weightx = 1; // Allow the panel to take up extra horizontal space
        gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
        backgroundPanel.add(panelIzquierda, gbcIzq);
        
        
        //------------FIN PANEL IZQUIERDA-----------------

        
        this.setVisible(true);

		
		
	}
	
	private void buttonConfig(JButton button1) {
		 button1.setOpaque(false);
	     button1.setFont(new Font("Code Light", Font.PLAIN, 40));
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
