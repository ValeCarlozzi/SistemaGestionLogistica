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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import TP.ListaOrdenes;
import TP.OrdenDeProvision;
import TP.Sucursal;

public class OrdenesProvisionWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<OrdenDeProvision> listaOrdenes;
	
	Sucursal sucursal;
	
	OrdenesProvisionWindow(Sucursal s){
		
		this.listaOrdenes = new ListaOrdenes(s).getListaOrdenesPendientes();
		
		this.sucursal = s; 
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Ordenes de provision");
		this.setSize(700, 400); // Set your preferred size
		this.setLocationRelativeTo(null); // Center the frame on the screen
		ImageIcon customIcon = new ImageIcon("LogoApp.png");
		this.setIconImage(customIcon.getImage());
			
		this.setContentPane(panelBuilder(listaOrdenes, s));
		
		this.setVisible(true);
		
	}
	
	public JPanel panelBuilder(ArrayList<OrdenDeProvision> listaOrdenes, Sucursal sucursal) {
		
				// background panel (extiende JPanel)
				Background backgroundPanel = new Background("Background.jpg");
			
				// ------------PANEL ABAJO-------------------

				// creo panel abajo
				JPanel panelAbajo = new JPanel(new GridBagLayout());
				panelAbajo.setOpaque(false);

				// Botones panel derecha
				JButton nueva = new JButton("Nueva Orden");
				JButton volver = new JButton("Volver");

				// se configuran los botones
				buttonConfigSucursales(nueva);
				buttonConfigSucursales(volver);

				// Create GridBagConstraints to specify the layout constraints for each button
				GridBagConstraints gbc = new GridBagConstraints();

				// agrego panel de abajo
				gbc.insets = new Insets(0, 0, 0, 0);
				gbc.gridx = 0;
				gbc.gridy = 2; // Reset the Y position to the first row
				gbc.weightx = 1; // Allow the panel to take up extra horizontal space
				gbc.weighty = 0.1;
				gbc.gridwidth = 2;
				gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
				backgroundPanel.add(panelAbajo, gbc);

				// Add Volver
				gbc.gridx = 0; // X position in the grid (left side)
				gbc.gridy = 0; // Y position in the grid
				gbc.insets = new Insets(10, 10, 10, 10); // Add some padding around the button
				gbc.anchor = GridBagConstraints.CENTER;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1;
				gbc.gridwidth = 1;
				gbc.weighty = 1;
				gbc.gridheight = 1;
				panelAbajo.add(volver, gbc);

				// Add Nueva
				gbc.gridx = 1;
				panelAbajo.add(nueva, gbc);

				// ------------FIN PANEL ABAJO-------------------

				GridBagConstraints gbcA = new GridBagConstraints();

				JLabel titulo = new JLabel("Ordenes pendientes para la sucursal '" + sucursal.getNombre() + "' (ID: " + sucursal.id().toString() + ")");
				titulo.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
				titulo.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
				titulo.setFont(new Font("Antipasto", Font.PLAIN, 15));
				titulo.setForeground(Color.WHITE);
				titulo.setPreferredSize(new Dimension(170, 30));
		        Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		        Border emptyBorder = BorderFactory.createEmptyBorder(14, 45, 14, 45);
		        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
		        titulo.setBorder(compoundBorder);
				gbcA.gridx = 0;
				gbcA.gridy = 0; // Reset the Y position to the first row
				gbcA.weightx = 1; // Allow the panel to take up extra horizontal space
				gbcA.weighty = 0.1;
				gbcA.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
				gbcA.anchor = GridBagConstraints.CENTER;
				backgroundPanel.add(titulo, gbcA);
				
				// LISTA
				ListaTab panel = new ListaTab(listaOrdenes,this);

				gbcA.insets = new Insets(15, 10, 5, 10);
				gbcA.gridx = 0;
				gbcA.gridy = 1; // Reset the Y position to the first row
				gbcA.weightx = 1; // Allow the panel to take up extra horizontal space
				gbcA.weighty = 1;
				gbcA.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
				gbcA.anchor = GridBagConstraints.CENTER;
				backgroundPanel.add(panel, gbcA);

				volver.addActionListener(e -> {
					this.dispose();
				});
				
				nueva.addActionListener(e -> {
			        // Switch to the other panel when the button is clicked.
			        new NuevaOrdenProvision(this, sucursal);
			    });

				return backgroundPanel;
	}
	
	
	
	public ArrayList<OrdenDeProvision> getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(ArrayList<OrdenDeProvision> listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
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
