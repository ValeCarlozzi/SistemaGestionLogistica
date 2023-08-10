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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

MenuPrincipal(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menú Principal");
        this.setSize(1000, 720); // Set your preferred size
        this.setLocationRelativeTo(null); // Center the frame on the screen
     
        //cambio icono ventana
        ImageIcon customIcon = new ImageIcon("C:/Users/valec/OneDrive/Desktop/UI_resources/LogoApp.png");
        this.setIconImage(customIcon.getImage());
		
        //background panel (extiende JPanel)
        Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");
        this.setContentPane(backgroundPanel);
       
        //Botones
        JButton button1 = new JButton("Sucursales");
        JButton button2 = new JButton("Caminos");
        JButton button3 = new JButton("Productos");
        JButton button4 = new JButton("Estados");
        JButton button5 = new JButton("Calculos");
        
        //se configuran los botones
        buttonConfig(button1);
        buttonConfig(button2);
        buttonConfig(button3);
        buttonConfig(button4);
        buttonConfig(button5);
        
        //logo y label panel derecha
        ImageIcon logo = new ImageIcon("C:/Users/valec/OneDrive/Desktop/UI_resources/Logo.png");
        JLabel Label = new JLabel(logo);
        
        //creo panel Derecha
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0,0,0,70));
        
        
        //gridBagConstraints para el logo adentro del panel derecha
        GridBagConstraints gbcPanel = new GridBagConstraints();
        gbcPanel.gridx = 0; // X position in the grid (left side)
        gbcPanel.gridy = 0; // Y position in the grid
        gbcPanel.anchor = GridBagConstraints.CENTER;
        gbcPanel.weightx = 1;
        gbcPanel.weighty = 1;   
        panel.add(Label,gbcPanel);

   
        // Create GridBagConstraints to specify the layout constraints for each component
        GridBagConstraints gbc = new GridBagConstraints();

        // Add Button 1
        gbc.gridx = 0; // X position in the grid (left side)
        gbc.gridy = 0; // Y position in the grid
        gbc.insets = new Insets(7, 10, 7, 10); // Add some padding around the button
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        backgroundPanel.add(button1, gbc);

        // Add Button 2
        gbc.gridy = 1; // Move to the next row (vertically centered)
        backgroundPanel.add(button2, gbc);
        
        // Add Button 3
        gbc.gridy = 2; // Move to the next row (vertically centered)
        backgroundPanel.add(button3, gbc);
        
        // Add Button 4
        gbc.gridy = 3; // Move to the next row (vertically centered)
        backgroundPanel.add(button4, gbc);
        
        // Add Button 5
        gbc.gridy = 4; // Move to the next row (vertically centered)
        backgroundPanel.add(button5, gbc);
        

        // Add the label on the right side
        gbc.insets = new Insets(0, 0, 0, 0); 
        gbc.gridx = 1; // Move to the right column
        gbc.gridy = 0; // Reset the Y position to the first row
        gbc.gridheight = 5; // Span two rows to take the full height of the panel
        gbc.weightx = 0.35; // Allow the panel to take up extra horizontal space
        gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
        backgroundPanel.add(panel, gbc);

     
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
             button1.setFont(new Font("Code Light", Font.PLAIN, 42));
         }

         @Override
         public void mouseExited(MouseEvent e) {
         	button1.setOpaque(false);
             button1.setForeground(Color.WHITE);
             button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
             button1.setFont(new Font("Code Light", Font.PLAIN, 40));
         }
     });
 }
 

	
}
