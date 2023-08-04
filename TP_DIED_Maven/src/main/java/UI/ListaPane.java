package UI;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import TP.OrdenDeProvision;
import TP.Stock;


public class ListaPane extends JPanel {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	ListaPane(ArrayList<?> lista) {

		this.setLayout(new GridBagLayout()); // Set an appropriate layout for overall needs

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridx = 0;
		gbc.weightx = 1; // Allow the panel to take up extra horizontal space
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL; // Make the panel fill the available space

		int contador;

		contador = 0;

		for (Object item : lista) {
			gbc.gridy = contador;
			this.add(new ListaItem(item), gbc);
			contador++;
		}

		this.setBackground(new Color(60, 80, 91, 255));

	}
	*/
	
	ListaPane(ArrayList<?> lista, MenuPrincipal main) {

		this.setLayout(new GridBagLayout()); // Set an appropriate layout for overall needs

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridx = 0;
		gbc.weightx = 1; // Allow the panel to take up extra horizontal space
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL; // Make the panel fill the available space

		int contador;

		contador = 0;

		for (Object item : lista) {
			gbc.gridy = contador;
			this.add(new ListaItem(item,main), gbc);
			contador++;
		}

		this.setBackground(new Color(60, 80, 91, 255));

	}
	
	ListaPane(ArrayList<Stock> lista, StockWindow main) {

		this.setLayout(new GridBagLayout()); // Set an appropriate layout for overall needs

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridx = 0;
		gbc.weightx = 1; // Allow the panel to take up extra horizontal space
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL; // Make the panel fill the available space

		int contador;

		contador = 0;

		for (Stock item : lista) {
			gbc.gridy = contador;
			this.add(new ListaItemStock(item,main), gbc);
			contador++;
		}

		this.setBackground(new Color(60, 80, 91, 255));

	}

	ListaPane(ArrayList<OrdenDeProvision> listaOrdenes, OrdenesProvisionWindow main){
		
		this.setLayout(new GridBagLayout()); // Set an appropriate layout for overall needs
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0); 
        gbc.gridx = 0; 
        gbc.weightx = 1; // Allow the panel to take up extra horizontal space
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make the panel fill the available space
		
        int contador;
   
        	contador = 0;
        	gbc.fill = GridBagConstraints.BOTH;
        	 
        	 for(OrdenDeProvision orden : listaOrdenes) {
        		gbc.gridy = contador;
              	this.add(new ListaItemOrden(orden,main),gbc);	
              	contador++;
        	 }
        	
    	 this.setBackground(new Color(60,80,91,255));
    	 
	}
	
	ListaPane(HashMap<String,Integer> listaProductos){
		
		this.setLayout(new GridBagLayout()); // Set an appropriate layout for overall needs
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0); 
        gbc.gridx = 0; 
        gbc.weightx = 1; // Allow the panel to take up extra horizontal space
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make the panel fill the available space
		
        int contador;
		contador = 0;
    	gbc.fill = GridBagConstraints.BOTH;
		
		for(String producto : listaProductos.keySet()) {
			
			gbc.gridy = contador;
          	this.add(new ListaItemProductosOrden(producto,listaProductos.get(producto)),gbc);	
          	contador++;
			
		}
		
		this.setBackground(new Color(60,80,91,255));
	}
	
}

