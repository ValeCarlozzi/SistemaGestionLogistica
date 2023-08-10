package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import TP.Camino;
import TP.GestorCaminos;
import TP.GestorProductos;
import TP.GestorStock;
import TP.GestorSucursales;
import TP.Producto;
import TP.Stock;
import TP.Sucursal;

public class Baja extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Baja(Sucursal sucursal, MenuPrincipal main){
		
		crearVentana();
		
		JButton aceptar = new JButton("Aceptar");
		buttonConfig(aceptar);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.anchor = GridBagConstraints.CENTER; 
	    gbc.insets = new Insets(15, 15, 15, 15); 
	    this.getContentPane().add(aceptar,gbc);
		
	    aceptar.addActionListener(e -> {
	    	try {
	    		new GestorSucursales().bajaSucursal(sucursal);
	    		
		    	   ArrayList<Sucursal> listaNueva = main.getListaSucursal();
		    	   
		    	   listaNueva.remove(listaNueva.indexOf(sucursal));
		    	   main.setContentPane(main.sucursalScreen(listaNueva));
		    	   main.revalidate();
			       this.dispose();
	    		
			} catch (Exception e2) {
				new VentanasError(e2.getMessage());
			}	
	    		this.dispose();
		    });
	    
	}
	
	Baja(Camino camino, MenuPrincipal main){
			
		crearVentana();
		
	   JButton aceptar = new JButton("Aceptar");
		buttonConfig(aceptar);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.anchor = GridBagConstraints.CENTER; 
	    gbc.insets = new Insets(15, 15, 15, 15); 
	    this.getContentPane().add(aceptar,gbc);
			
	    aceptar.addActionListener(e -> {
	    	try {
	    		new GestorCaminos().bajaCamino(camino);
	    		
		    	   ArrayList<Camino> listaNueva = main.getListaCamino();
		    	   
		    	   listaNueva.remove(listaNueva.indexOf(camino));
		    	   main.setContentPane(main.caminosScreen(listaNueva));
		    	   main.revalidate();
			       this.dispose();
	    		
			} catch (Exception e2) {
				new VentanasError(e2.getMessage());
			}	
	    		this.dispose();
		    });
	    
		}
	
	Baja(Producto producto, MenuPrincipal main){
		
		crearVentana();
		
	   JButton aceptar = new JButton("Aceptar");
		buttonConfig(aceptar);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.anchor = GridBagConstraints.CENTER; 
	    gbc.insets = new Insets(15, 15, 15, 15); 
	    this.getContentPane().add(aceptar,gbc);
	    
	    aceptar.addActionListener(e -> {
	    	try {
	    		new GestorProductos().bajaProducto(producto);
	    		
		    	   ArrayList<Producto> listaNueva = main.getListaProducto();
		    	   
		    	   listaNueva.remove(listaNueva.indexOf(producto));
		    	   main.setContentPane(main.productosScreen(listaNueva));
		    	   main.revalidate();
			       this.dispose();
	    		
			} catch (Exception e2) {
				new VentanasError(e2.getMessage());
			}	
	    		this.dispose();
		    });
	    
	}
	
	Baja(Stock stock, StockWindow main){
		
		crearVentana();
		
	   JButton aceptar = new JButton("Aceptar");
		buttonConfig(aceptar);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.anchor = GridBagConstraints.CENTER; 
	    gbc.insets = new Insets(15, 15, 15, 15); 
	    this.getContentPane().add(aceptar,gbc);
	    
	    aceptar.addActionListener(e -> {
	    	try {
	    		new GestorStock().bajaStock(stock);
	    		
		    	   ArrayList<Stock> listaNueva = main.getListaStock();
		    	   
		    	   listaNueva.remove(listaNueva.indexOf(stock));
		    	   main.setContentPane(main.buildStockWindow(listaNueva));
		    	   main.revalidate();
			       this.dispose();
	    		
			} catch (Exception e2) {
				new VentanasError(e2.getMessage());
			}	
		       this.dispose();
		    });
	    
	}
	
	private void crearVentana() {
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Baja");
	    this.setSize(500, 500); // Set your preferred size
	    this.setLocationRelativeTo(null); // Center the frame on the screen
	    ImageIcon customIcon = new ImageIcon("LogoApp.png");
        this.setIconImage(customIcon.getImage());
        
	    Background backgroundPanel = new Background("Background.jpg");
	    this.setContentPane(backgroundPanel);
		
	    JLabel aviso = new JLabel("¿Seguro que desea dar de baja este elemento?");
	    aviso.setForeground(Color.WHITE);
	    aviso.setHorizontalAlignment(SwingConstants.CENTER);
	    aviso.setVerticalAlignment(SwingConstants.CENTER);
	    aviso.setFont(new Font("Antipasto", Font.PLAIN, 20)); 
	
	    JButton volver = new JButton("Volver");
		buttonConfig(volver);

		GridBagConstraints gbc = new GridBagConstraints();
	    
	    gbc.gridx = 0; 
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.anchor = GridBagConstraints.CENTER; 
	    gbc.insets = new Insets(10, 10, 10, 10); 
	    backgroundPanel.add(aviso,gbc);
	    
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.insets = new Insets(15, 15, 15, 15); 
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
