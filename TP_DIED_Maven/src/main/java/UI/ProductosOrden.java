package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import TP.OrdenDeProvision;

public class ProductosOrden extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HashMap<String,Integer> listaProductos;

	
	ProductosOrden(OrdenDeProvision orden){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Productos Orden de Provision");
		this.setSize(300, 380); // Set your preferred size
		this.setLocationRelativeTo(null); // Center the frame on the screen
		ImageIcon customIcon = new ImageIcon("LogoApp.png");
	    this.setIconImage(customIcon.getImage());
		// background panel (extiende JPanel)
		Background backgroundPanel = new Background("Background.jpg");
		this.setContentPane(backgroundPanel);
		
		listaProductos = orden.getListaProductos();
		
		JButton volver = new JButton("volver");
		buttonConfigSucursales(volver);
		
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    ListaTab lista = new ListaTab(listaProductos);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weightx = 1; 
	    gbc.weighty = 1; 
	    gbc.fill = GridBagConstraints.BOTH;
	    backgroundPanel.add(lista, gbc);
		
	    
	    gbc.gridy = 1;
	    gbc.weighty = 0.1; 
	    backgroundPanel.add(volver, gbc);

		
		volver.addActionListener(e -> {
			this.dispose();
		});
		
		this.setVisible(true);

	}
	
	private void buttonConfigSucursales(JButton button1) {
		button1.setOpaque(false);
		button1.setFont(new Font("Code Light", Font.PLAIN, 30));
		button1.setForeground(Color.WHITE);
		button1.setBackground(new Color(0, 0, 0, 70));
		button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		button1.setPreferredSize(new Dimension(180, 50));
		button1.setFocusable(false);

		button1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setOpaque(true);
				button1.setBackground(new Color(60, 80, 91, 255));
				button1.setForeground(Color.WHITE);
				button1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
				// button1.setFont(new Font("Code Light", Font.PLAIN, 42));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button1.setOpaque(false);
				button1.setForeground(Color.WHITE);
				button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
				// button1.setFont(new Font("Code Light", Font.PLAIN, 40));
			}
		});
	}
	
}
