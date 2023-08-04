package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import TP.ListaStock;
import TP.Stock;
import TP.Sucursal;

public class StockWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList <Stock> listaStock;
	Sucursal sucursal;
	
	public StockWindow(Sucursal sucursal) {
		this.sucursal = sucursal;
		listaStock = (new ListaStock(sucursal)).getLista();
		

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Stock Sucursal");
		this.setSize(700, 400); // Set your preferred size
		this.setLocationRelativeTo(null); // Center the frame on the screen

		// background panel (extiende JPanel)
		this.setContentPane(buildStockWindow());
		ImageIcon customIcon = new ImageIcon("LogoApp.png");
	    this.setIconImage(customIcon.getImage());
		
	    this.setVisible(true);
	    
	}
	
	public ArrayList<Stock> getListaStock() {
		return listaStock;
	}

	public void setListaStock(ArrayList<Stock> listaStock) {
		this.listaStock = listaStock;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public JPanel buildStockWindow(ArrayList<Stock> lista) {

		Background backgroundPanel = new Background("Background.jpg");

	    
		// ------------PANEL DERECHA-------------------

		// creo panel Derecha
		JPanel panelDerecha = new JPanel(new GridBagLayout());
		panelDerecha.setBackground(new Color(0, 0, 0, 70));

		// Botones panel derecha
		JButton alta = new JButton("Alta");
		JButton busqueda = new JButton("Busqueda");
		JButton volver = new JButton("Volver");

		// se configuran los botones
		buttonConfigSucursales(alta);
		buttonConfigSucursales(busqueda);
		buttonConfigSucursales(volver);

		// Create GridBagConstraints to specify the layout constraints for each button
		GridBagConstraints gbc = new GridBagConstraints();

		// agrego panel derecha
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 0; // Reset the Y position to the first row
		gbc.weightx = 0.05; // Allow the panel to take up extra horizontal space
		gbc.weighty = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
		backgroundPanel.add(panelDerecha, gbc);

		// Add Alta
		gbc.gridx = 0; // X position in the grid (left side)
		gbc.gridy = 0; // Y position in the grid
		gbc.insets = new Insets(7, 10, 7, 10); // Add some padding around the button
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 0.05;
		gbc.gridheight = 1;
		panelDerecha.add(alta, gbc);

		// Add Busqueda
		gbc.gridy = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		panelDerecha.add(busqueda, gbc);

		// Add Volver
		gbc.gridy = 3;
		gbc.weighty = 0.05;
		gbc.anchor = GridBagConstraints.SOUTH;
		panelDerecha.add(volver, gbc);

		// ------------FIN PANEL DERECHA-------------------

		GridBagConstraints gbcIzq = new GridBagConstraints();

		// LISTA
		ListaTab panelIzquierda = new ListaTab(lista,this);

		gbcIzq.insets = new Insets(0, 0, 0, 0);
		gbcIzq.gridx = 0;
		gbcIzq.gridy = 1; // Reset the Y position to the first row
		gbcIzq.weightx = 1; // Allow the panel to take up extra horizontal space
		gbcIzq.weighty = 1;
		gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
		gbcIzq.anchor = GridBagConstraints.NORTH;
		backgroundPanel.add(panelIzquierda, gbcIzq);

		volver.addActionListener(e -> {
			this.dispose();
		});
		
		alta.addActionListener(e -> {
	        // Switch to the other panel when the button is clicked.
	        new AltaStock(sucursal,this);
	    });
		
		busqueda.addActionListener(e -> {
	        // Switch to the other panel when the button is clicked.
	        new BusquedaStock(this);
	    });
		
			return backgroundPanel;
	}
	
	public JPanel buildStockWindow() {

		Background backgroundPanel = new Background("Background.jpg");
		
		// ------------PANEL DERECHA-------------------

		// creo panel Derecha
		JPanel panelDerecha = new JPanel(new GridBagLayout());
		panelDerecha.setBackground(new Color(0, 0, 0, 70));

		// Botones panel derecha
		JButton alta = new JButton("Alta");
		JButton busqueda = new JButton("Busqueda");
		JButton volver = new JButton("Volver");

		// se configuran los botones
		buttonConfigSucursales(alta);
		buttonConfigSucursales(busqueda);
		buttonConfigSucursales(volver);

		// Create GridBagConstraints to specify the layout constraints for each button
		GridBagConstraints gbc = new GridBagConstraints();

		// agrego panel derecha
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 0; // Reset the Y position to the first row
		gbc.weightx = 0.05; // Allow the panel to take up extra horizontal space
		gbc.weighty = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
		backgroundPanel.add(panelDerecha, gbc);

		// Add Alta
		gbc.gridx = 0; // X position in the grid (left side)
		gbc.gridy = 0; // Y position in the grid
		gbc.insets = new Insets(7, 10, 7, 10); // Add some padding around the button
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 0.05;
		gbc.gridheight = 1;
		panelDerecha.add(alta, gbc);

		// Add Busqueda
		gbc.gridy = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		panelDerecha.add(busqueda, gbc);

		// Add Volver
		gbc.gridy = 3;
		gbc.weighty = 0.05;
		gbc.anchor = GridBagConstraints.SOUTH;
		panelDerecha.add(volver, gbc);

		// ------------FIN PANEL DERECHA-------------------

		GridBagConstraints gbcIzq = new GridBagConstraints();

		// LISTA
		ListaTab panelIzquierda = new ListaTab(listaStock,this);

		gbcIzq.insets = new Insets(0, 0, 0, 0);
		gbcIzq.gridx = 0;
		gbcIzq.gridy = 1; // Reset the Y position to the first row
		gbcIzq.weightx = 1; // Allow the panel to take up extra horizontal space
		gbcIzq.weighty = 1;
		gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
		gbcIzq.anchor = GridBagConstraints.NORTH;
		backgroundPanel.add(panelIzquierda, gbcIzq);

		volver.addActionListener(e -> {
			this.dispose();
		});
		
		alta.addActionListener(e -> {
	        // Switch to the other panel when the button is clicked.
	        new AltaStock(sucursal,this);
	    });
		
		busqueda.addActionListener(e -> {
	        // Switch to the other panel when the button is clicked.
	        new BusquedaStock(this);
	    });

		return backgroundPanel;

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
