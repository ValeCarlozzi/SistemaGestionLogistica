package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import TP.Camino;
import TP.ListaCaminos;
import TP.ListaProductos;
import TP.ListaSucursales;
import TP.Producto;
import TP.Sucursal;


public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Sucursal> listaSucursal;
	ArrayList<Camino> listaCamino;
	ArrayList<Producto> listaProducto;
	
	public ArrayList<Sucursal> getListaSucursal() {
		return listaSucursal;
	}

	public void setListaSucursal(ArrayList<Sucursal> listaSucursal) {
		this.listaSucursal = listaSucursal;
	}

	public ArrayList<Camino> getListaCamino() {
		return listaCamino;
	}

	public void setListaCamino(ArrayList<Camino> listaCamino) {
		this.listaCamino = listaCamino;
	}

	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(ArrayList<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

MenuPrincipal(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gestión de Logística");
        this.setSize(1000, 720); // Set your preferred size
        this.setLocationRelativeTo(null); // Center the frame on the screen
     
        //cambio icono ventana
        ImageIcon customIcon = new ImageIcon("LogoApp.png");
        this.setIconImage(customIcon.getImage());
		
        this.setContentPane(menu());
        this.revalidate();
         
	}

 private Container menu() {
	 //background panel (extiende JPanel)
     Background backgroundPanel = new Background("Background.jpg");
    
     //Botones
     JButton sucursales = new JButton("Sucursales");
     JButton caminos = new JButton("Caminos");
     JButton productos = new JButton("Productos");
     JButton calculos = new JButton("Calculos");
     
     //se configuran los botones
     buttonConfig(sucursales);
     buttonConfig(caminos);
     buttonConfig(productos);
     buttonConfig(calculos);
     
     sucursales.addActionListener(e -> {
         // Switch to the other panel when the button is clicked.
    	listaSucursal = (new ListaSucursales()).getLista();
    	   listaSucursal = ordenarSucursal(listaSucursal,"id");
         this.setContentPane(sucursalScreen(listaSucursal));
         this.revalidate(); // This ensures the new panel is properly laid out.
     });
     
     caminos.addActionListener(e -> {
         // Switch to the other panel when the button is clicked.
    	 listaCamino = (new ListaCaminos()).getLista();
         this.setContentPane(caminosScreen(listaCamino));
         this.revalidate(); // This ensures the new panel is properly laid out.
     });
     
     productos.addActionListener(e -> {
         // Switch to the other panel when the button is clicked.
    	 listaProducto = (new ListaProductos()).getLista();
         this.setContentPane(productosScreen(listaProducto));
         this.revalidate(); // This ensures the new panel is properly laid out.
     });
     
     
     calculos.addActionListener(e -> {
         // Switch to the other panel when the button is clicked.
         this.setContentPane(calculosScreen());
         this.revalidate(); // This ensures the new panel is properly laid out.
     });
     
     //logo y label panel derecha
     ImageIcon logo = new ImageIcon("Titulo.png");
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
     backgroundPanel.add(sucursales, gbc);

     // Add Button 2
     gbc.gridy = 1; // Move to the next row (vertically centered)
     backgroundPanel.add(caminos, gbc);
     
     // Add Button 3
     gbc.gridy = 2; // Move to the next row (vertically centered)
     backgroundPanel.add(productos, gbc);
     
     /*
     // Add Button 4
     gbc.gridy = 3; // Move to the next row (vertically centered)
     backgroundPanel.add(stock, gbc);
     */
     
     // Add Button 5
     gbc.gridy = 4; // Move to the next row (vertically centered)
     backgroundPanel.add(calculos, gbc);
     

     // Add the label on the right side
     gbc.insets = new Insets(0, 0, 0, 0); 
     gbc.gridx = 1; // Move to the right column
     gbc.gridy = 0; // Reset the Y position to the first row
     gbc.gridheight = 5; // Span two rows to take the full height of the panel
     gbc.weightx = 0.35; // Allow the panel to take up extra horizontal space
     gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
     backgroundPanel.add(panel, gbc);	
     
     return backgroundPanel;
}

private Container calculosScreen() {
	//background panel (extiende JPanel)
	Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");
	
	JButton flujoMaximo = new JButton("Flujo Máximo");
	JButton pageRank = new JButton("PageRank sucursales");
	JButton volver = new JButton("volver");
	buttonConfig(flujoMaximo);
    buttonConfig(pageRank);
    buttonConfigSucursales(volver);
	
    GridBagConstraints gbc = new GridBagConstraints();
    
    gbc.insets = new Insets(30, 30, 15, 30); 
    gbc.gridx = 0; 
    gbc.gridy = 0; // Reset the Y position to the first row
    gbc.weightx = 1; // Allow the panel to take up extra horizontal space
    gbc.weighty = 1; 
    gbc.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
    backgroundPanel.add(flujoMaximo, gbc);
    
    gbc.insets = new Insets(15, 30, 15, 30); 
    gbc.gridy = 1;
    backgroundPanel.add(pageRank, gbc);
	
    gbc.insets = new Insets(15, 30, 30, 30); 
    gbc.gridy = 2;
    gbc.weighty = 0.1;
    gbc.fill = GridBagConstraints.VERTICAL;
    gbc.anchor = GridBagConstraints.EAST;
    backgroundPanel.add(volver, gbc);
    
    flujoMaximo.addActionListener(e -> {

        try {
        	new FlujoMaximo();
		} catch (Exception e2) {
			new VentanasError("No es posible calcular el flujo maximo con este grafo");
		}
    	
    });
    
    pageRank.addActionListener(e -> {
        
		try {
			new PageRank();
		} catch (Exception e2) {
			new VentanasError("No es posible calcular el PageRank con este grafo");
		}

    });
    
    volver.addActionListener(e -> {
        // Switch to the other panel when the button is clicked.
        this.setContentPane(menu());
        this.revalidate(); // This ensures the new panel is properly laid out.
    });
    
    
	return backgroundPanel;
}

Container productosScreen( ArrayList<Producto> listaProducto) {
	//background panel (extiende JPanel)
    Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");

		
    //------------PANEL DERECHA-------------------
    
    //creo panel Derecha
    JPanel panelDerecha = new JPanel(new GridBagLayout());
    panelDerecha.setBackground(new Color(0,0,0,70));

    //Botones panel derecha
    JButton alta = new JButton("Alta");
    JButton busqueda = new JButton("Busqueda");
    JButton volver = new JButton("Volver");

    //se configuran los botones
    buttonConfigSucursales(alta);
    buttonConfigSucursales(busqueda);
    buttonConfigSucursales(volver);
    
    
    
    // Create GridBagConstraints to specify the layout constraints for each button
    GridBagConstraints gbc = new GridBagConstraints();
    
    //agrego panel derecha
    gbc.insets = new Insets(0, 0, 0, 0); 
    gbc.gridx = 1; 
    gbc.gridy = 0; // Reset the Y position to the first row
    gbc.weightx = 0.08; // Allow the panel to take up extra horizontal space
    gbc.weighty = 1; 
    gbc.gridheight = 3;
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
    
    //------------FIN PANEL DERECHA-------------------
		
    //------------PANEL IZQUIERDA---------------------
	
    GridBagConstraints gbcIzq = new GridBagConstraints();

    JPanel top = new JPanel();
    top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
    top.setBackground(new Color(60,80,91,255));
    
    JButton nombre = new JButton("nombre");
    JButton precio = new JButton("precio");
    JButton peso = new JButton("peso");
    
    buttonConfigSucursales(nombre);
    buttonConfigSucursales(precio);
    buttonConfigSucursales(peso);
    
    Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);
    nombre.setMaximumSize(maxComponentSize);
    precio.setMaximumSize(maxComponentSize);
    peso.setMaximumSize(maxComponentSize);
    
    top.add(nombre);
    this.add(Box.createHorizontalStrut(15));
    top.add(precio);
    this.add(Box.createHorizontalStrut(15));
    top.add(peso);
  
    gbcIzq.insets = new Insets(0, 0, 0, 0); 
    gbcIzq.gridx = 0; 
    gbcIzq.gridy = 0;
    gbcIzq.weightx = 1;
    gbcIzq.weighty = 0.03;
    gbcIzq.anchor = GridBagConstraints.NORTH;
    gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
    backgroundPanel.add(top, gbcIzq);
    
    JPanel guia = new JPanel();
    guia.setLayout(new BoxLayout(guia, BoxLayout.X_AXIS));
    guia.setBackground(new Color(60,80,91,255));
    
    JLabel nombreProd = new JLabel ("NOMBRE");
    nombreProd.setForeground(Color.WHITE);
    nombreProd.setHorizontalAlignment(SwingConstants.CENTER);
    nombreProd.setVerticalAlignment(SwingConstants.CENTER);
    nombreProd.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel descripcionProd = new JLabel ("DESCRIPCION");
    descripcionProd.setForeground(Color.WHITE);
    descripcionProd.setHorizontalAlignment(SwingConstants.CENTER);
    descripcionProd.setVerticalAlignment(SwingConstants.CENTER);
    descripcionProd.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel precioProd = new JLabel ("PRECIO");
    precioProd.setForeground(Color.WHITE);
    precioProd.setHorizontalAlignment(SwingConstants.CENTER);
    precioProd.setVerticalAlignment(SwingConstants.CENTER);
    precioProd.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel pesoProd = new JLabel ("PESO");
    pesoProd.setForeground(Color.WHITE);
    pesoProd.setHorizontalAlignment(SwingConstants.CENTER);
    pesoProd.setVerticalAlignment(SwingConstants.CENTER);
    pesoProd.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel botonGestionar = new JLabel ("GESTIONAR");
    botonGestionar.setForeground(Color.WHITE);
    botonGestionar.setHorizontalAlignment(SwingConstants.CENTER);
    botonGestionar.setVerticalAlignment(SwingConstants.CENTER);
    botonGestionar.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    
    
    maxComponentSize = new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);
    nombreProd.setMaximumSize(maxComponentSize);
    descripcionProd.setMaximumSize(maxComponentSize);
    precioProd.setMaximumSize(maxComponentSize);
    pesoProd.setMaximumSize(maxComponentSize);
    botonGestionar.setMaximumSize(maxComponentSize);
  
    
    guia.add(nombreProd);
    this.add(Box.createHorizontalStrut(15));
    guia.add(descripcionProd);
    this.add(Box.createHorizontalStrut(15));
    guia.add(precioProd);
    this.add(Box.createHorizontalStrut(15));
    guia.add(pesoProd);
    this.add(Box.createHorizontalStrut(15));
    guia.add(botonGestionar);
  
  
    gbcIzq.insets = new Insets(10, 0, 0, 0); 
    gbcIzq.gridx = 0; 
    gbcIzq.gridy = 1;
    gbcIzq.weightx = 1;
    gbcIzq.weighty = 0.03;
    gbcIzq.anchor = GridBagConstraints.NORTH;
    gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
    backgroundPanel.add(guia, gbcIzq);
    
    ListaTab panelIzquierda = new ListaTab(listaProducto,this);
         
    gbcIzq.insets = new Insets(0, 0, 0, 0); 
    gbcIzq.gridx = 0; 
    gbcIzq.gridy = 2; // Reset the Y position to the first row
    gbcIzq.weightx = 1; // Allow the panel to take up extra horizontal space
    gbcIzq.weighty = 1;
    gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
    gbcIzq.anchor = GridBagConstraints.NORTH;
    backgroundPanel.add(panelIzquierda, gbcIzq);
    

    //------------FIN PANEL IZQUIERDA-----------------
    
    nombre.addActionListener(e -> {
    	ArrayList <Producto> nueva = ordenarProducto(this.getListaProducto(),"nombre");
      	 this.setListaProducto(nueva);
      	 this.setContentPane(productosScreen(nueva));
      	 this.revalidate();
    });
    
    precio.addActionListener(e -> {
    	ArrayList <Producto> nueva = ordenarProducto(this.getListaProducto(),"precio");
     	 this.setListaProducto(nueva);
     	 this.setContentPane(productosScreen(nueva));
     	 this.revalidate();
    });
    
    peso.addActionListener(e -> {
    	ArrayList <Producto> nueva = ordenarProducto(this.getListaProducto(),"peso");
     	 this.setListaProducto(nueva);
     	 this.setContentPane(productosScreen(nueva));
     	 this.revalidate();
    });
    
    volver.addActionListener(e -> {
        // Switch to the other panel when the button is clicked.
        this.setContentPane(menu());
        this.revalidate(); // This ensures the new panel is properly laid out.
    });
    
    alta.addActionListener(e -> {
        // Switch to the other panel when the button is clicked.
        new AltaProducto(this);
    });
    
    busqueda.addActionListener(e -> {
        // Switch to the other panel when the button is clicked.
        new BusquedaProducto(this);
    });
    
	 
	return backgroundPanel;
}

Container caminosScreen(ArrayList<Camino> listaCamino) {
	//background panel (extiende JPanel)
    Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");

		
    //------------PANEL DERECHA-------------------
    
    //creo panel Derecha
    JPanel panelDerecha = new JPanel(new GridBagLayout());
    panelDerecha.setBackground(new Color(0,0,0,70));

    //Botones panel derecha
    JButton alta = new JButton("Alta");
    JButton busqueda = new JButton("Busqueda");
    JButton volver = new JButton("Volver");

    //se configuran los botones
    buttonConfigSucursales(alta);
    buttonConfigSucursales(busqueda);
    buttonConfigSucursales(volver);
    
    
    
    // Create GridBagConstraints to specify the layout constraints for each button
    GridBagConstraints gbc = new GridBagConstraints();
    
    //agrego panel derecha
    gbc.insets = new Insets(0, 0, 0, 0); 
    gbc.gridx = 1; 
    gbc.gridy = 0; // Reset the Y position to the first row
    gbc.weightx = 0.08; // Allow the panel to take up extra horizontal space
    gbc.weighty = 1; 
    gbc.gridheight = 3;
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
    
    //------------FIN PANEL DERECHA-------------------
		
    //------------PANEL IZQUIERDA---------------------
	
    GridBagConstraints gbcIzq = new GridBagConstraints();

    JPanel top = new JPanel();
    top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
    top.setBackground(new Color(60,80,91,255));
    
    JButton id = new JButton("ID");
    JButton capMaxima = new JButton("CAPACIDAD");
    JButton estado = new JButton("Estado");
    
    buttonConfigSucursales(id);
    buttonConfigSucursales(capMaxima);
    buttonConfigSucursales(estado);
    
    Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);
    id.setMaximumSize(maxComponentSize);
    capMaxima.setMaximumSize(maxComponentSize);
    estado.setMaximumSize(maxComponentSize);
    
    top.add(id);
    this.add(Box.createHorizontalStrut(15));
    top.add(capMaxima);
    this.add(Box.createHorizontalStrut(15));
    top.add(estado);
  
    gbcIzq.insets = new Insets(0, 0, 0, 0); 
    gbcIzq.gridx = 0; 
    gbcIzq.gridy = 0;
    gbcIzq.weightx = 1;
    gbcIzq.weighty = 0.01;
    gbcIzq.anchor = GridBagConstraints.NORTH;
    gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
    backgroundPanel.add(top, gbcIzq);
    
    
    JPanel guia = new JPanel();
    guia.setLayout(new BoxLayout(guia, BoxLayout.X_AXIS));
    guia.setBackground(new Color(60,80,91,255));
    
    JLabel idCamino = new JLabel ("ID");
    idCamino.setForeground(Color.WHITE);
    idCamino.setHorizontalAlignment(SwingConstants.CENTER);
    idCamino.setVerticalAlignment(SwingConstants.CENTER);
    idCamino.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    
    JLabel idOrigen = new JLabel ("ID ORIGEN");
    idOrigen.setForeground(Color.WHITE);
    idOrigen.setHorizontalAlignment(SwingConstants.CENTER);
    idOrigen.setVerticalAlignment(SwingConstants.CENTER);
    idOrigen.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel idDestino = new JLabel ("ID DESTINO");
    idDestino.setForeground(Color.WHITE);
    idDestino.setHorizontalAlignment(SwingConstants.CENTER);
    idDestino.setVerticalAlignment(SwingConstants.CENTER);
    idDestino.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel tiempoTransito = new JLabel ("TIEMPO");
    tiempoTransito.setForeground(Color.WHITE);
    tiempoTransito.setHorizontalAlignment(SwingConstants.CENTER);
    tiempoTransito.setVerticalAlignment(SwingConstants.CENTER);
    tiempoTransito.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel capacidadMaxima = new JLabel ("CAPACIDAD");
    capacidadMaxima.setForeground(Color.WHITE);
    capacidadMaxima.setHorizontalAlignment(SwingConstants.CENTER);
    capacidadMaxima.setVerticalAlignment(SwingConstants.CENTER);
    capacidadMaxima.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel estadoCamino = new JLabel ("ESTADO");
    estadoCamino.setForeground(Color.WHITE);
    estadoCamino.setHorizontalAlignment(SwingConstants.CENTER);
    estadoCamino.setVerticalAlignment(SwingConstants.CENTER);
    estadoCamino.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    JLabel botonGestionar = new JLabel ("GESTIONAR");
    botonGestionar.setForeground(Color.WHITE);
    botonGestionar.setHorizontalAlignment(SwingConstants.CENTER);
    botonGestionar.setVerticalAlignment(SwingConstants.CENTER);
    botonGestionar.setBorder(BorderFactory.createLineBorder(Color.white, 1));

    
    maxComponentSize = new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);
    idCamino.setMaximumSize(maxComponentSize);
    idOrigen.setMaximumSize(maxComponentSize);
    idDestino.setMaximumSize(maxComponentSize);
    tiempoTransito.setMaximumSize(maxComponentSize);
    capacidadMaxima.setMaximumSize(maxComponentSize);
    estadoCamino.setMaximumSize(maxComponentSize);
    botonGestionar.setMaximumSize(maxComponentSize);
    
    
    guia.add(idCamino);
    this.add(Box.createHorizontalStrut(15));
    guia.add(idOrigen);
    this.add(Box.createHorizontalStrut(15));
    guia.add(idDestino);
    this.add(Box.createHorizontalStrut(15));
    guia.add(tiempoTransito);
    this.add(Box.createHorizontalStrut(15));
    guia.add(capacidadMaxima);
    this.add(Box.createHorizontalStrut(15));
    guia.add(estadoCamino);
    this.add(Box.createHorizontalStrut(15));
    guia.add(botonGestionar);
    this.add(Box.createHorizontalStrut(15));

  
    gbcIzq.insets = new Insets(10, 0, 0, 0); 
    gbcIzq.gridx = 0; 
    gbcIzq.gridy = 1;
    gbcIzq.weightx = 1;
    gbcIzq.weighty = 0.03;
    gbcIzq.anchor = GridBagConstraints.NORTH;
    gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
    backgroundPanel.add(guia, gbcIzq);
    
    ListaTab panelIzquierda = new ListaTab(listaCamino,this);
         
    gbcIzq.insets = new Insets(0, 0, 0, 0); 
    gbcIzq.gridx = 0; 
    gbcIzq.gridy = 2; // Reset the Y position to the first row
    gbcIzq.weightx = 1; // Allow the panel to take up extra horizontal space
    gbcIzq.weighty = 0.8;
    gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
    gbcIzq.anchor = GridBagConstraints.NORTH;
    backgroundPanel.add(panelIzquierda, gbcIzq);
    

    //------------FIN PANEL IZQUIERDA-----------------
    
    //TODO
    id.addActionListener(e -> {
    	ArrayList <Camino> nueva = ordenarCamino(this.getListaCamino(),"id");
   	 this.setListaCamino(nueva);
   	 this.setContentPane(caminosScreen(nueva));
   	 this.revalidate();
    });
    
    capMaxima.addActionListener(e -> {
    	ArrayList <Camino> nueva = ordenarCamino(this.getListaCamino(),"capacidad");
   	 this.setListaCamino(nueva);
   	 this.setContentPane(caminosScreen(nueva));
   	 this.revalidate();
    });
    
    estado.addActionListener(e -> {
    	ArrayList <Camino> nueva = ordenarCamino(this.getListaCamino(),"estado");
   	 this.setListaCamino(nueva);
   	 this.setContentPane(caminosScreen(nueva));
   	 this.revalidate();
    });
    
    volver.addActionListener(e -> {
        // Switch to the other panel when the button is clicked.
        this.setContentPane(menu());
        this.revalidate(); // This ensures the new panel is properly laid out.
    });
    
    alta.addActionListener(e -> {
        // Switch to the other panel when the button is clicked.
        new AltaCamino(this);
    });
    
    busqueda.addActionListener(e -> {
        // Switch to the other panel when the button is clicked.
    	new BusquedaCamino(this);
    });
    
    
    
	 
	return backgroundPanel;
}

Container sucursalScreen(ArrayList<Sucursal> listaSucursal) {
	 
	
	//background panel (extiende JPanel)
     Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");

		
     //------------PANEL DERECHA-------------------
     
     //creo panel Derecha
     JPanel panelDerecha = new JPanel(new GridBagLayout());
     panelDerecha.setBackground(new Color(0,0,0,70));

     //Botones panel derecha
     JButton alta = new JButton("Alta");
     JButton busqueda = new JButton("Busqueda");
     JButton volver = new JButton("Volver");

     //se configuran los botones
     buttonConfigSucursales(alta);
     buttonConfigSucursales(busqueda);
     buttonConfigSucursales(volver);
    
     
     
     // Create GridBagConstraints to specify the layout constraints for each button
     GridBagConstraints gbc = new GridBagConstraints();
     
     //agrego panel derecha
     gbc.insets = new Insets(0, 0, 0, 0); 
     gbc.gridx = 1; 
     gbc.gridy = 0; // Reset the Y position to the first row
     gbc.weightx = 0.05; // Allow the panel to take up extra horizontal space
     gbc.weighty = 1; 
     gbc.gridheight = 3;
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
     
     //------------FIN PANEL DERECHA-------------------
		
     //------------PANEL IZQUIERDA---------------------
	
     GridBagConstraints gbcIzq = new GridBagConstraints();
     
     //TOP
     JPanel top = new JPanel();
     top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
     top.setBackground(new Color(60,80,91,255));
     
     JButton id = new JButton("ID");
     JButton nombre = new JButton("Nombre");
     JButton estado = new JButton("Estado");
     
     buttonConfigSucursales(id);
     buttonConfigSucursales(nombre);
     buttonConfigSucursales(estado);
     
     Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);
     id.setMaximumSize(maxComponentSize);
     nombre.setMaximumSize(maxComponentSize);
     estado.setMaximumSize(maxComponentSize);
     
     top.add(id);
     this.add(Box.createHorizontalStrut(15));
     top.add(nombre);
     this.add(Box.createHorizontalStrut(15));
     top.add(estado);
   
     gbcIzq.insets = new Insets(0, 0, 0, 0); 
     gbcIzq.gridx = 0; 
     gbcIzq.gridy = 0;
     gbcIzq.weightx = 1;
     gbcIzq.weighty = 0.01;
     gbcIzq.anchor = GridBagConstraints.NORTH;
     gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
     backgroundPanel.add(top, gbcIzq);
     
     JPanel guia = new JPanel();
     guia.setLayout(new BoxLayout(guia, BoxLayout.X_AXIS));
     guia.setBackground(new Color(60,80,91,255));
     
     JLabel idSuc = new JLabel ("ID");
     idSuc.setForeground(Color.WHITE);
     idSuc.setHorizontalAlignment(SwingConstants.CENTER);
     idSuc.setVerticalAlignment(SwingConstants.CENTER);
     idSuc.setBorder(BorderFactory.createLineBorder(Color.white, 1));
     JLabel nombreSuc = new JLabel ("NOMBRE");
     nombreSuc.setForeground(Color.WHITE);
     nombreSuc.setHorizontalAlignment(SwingConstants.CENTER);
     nombreSuc.setVerticalAlignment(SwingConstants.CENTER);
     nombreSuc.setBorder(BorderFactory.createLineBorder(Color.white, 1));
     JLabel estadoSuc = new JLabel ("ESTADO");
     estadoSuc.setForeground(Color.WHITE);
     estadoSuc.setHorizontalAlignment(SwingConstants.CENTER);
     estadoSuc.setVerticalAlignment(SwingConstants.CENTER);
     estadoSuc.setBorder(BorderFactory.createLineBorder(Color.white, 1));
     JLabel aperturaSuc = new JLabel ("APERTURA");
     aperturaSuc.setForeground(Color.WHITE);
     aperturaSuc.setHorizontalAlignment(SwingConstants.CENTER);
     aperturaSuc.setVerticalAlignment(SwingConstants.CENTER);
     aperturaSuc.setBorder(BorderFactory.createLineBorder(Color.white, 1));
     JLabel cierreSuc = new JLabel ("CIERRE");
     cierreSuc.setForeground(Color.WHITE);
     cierreSuc.setHorizontalAlignment(SwingConstants.CENTER);
     cierreSuc.setVerticalAlignment(SwingConstants.CENTER);
     cierreSuc.setBorder(BorderFactory.createLineBorder(Color.white, 1));
     JLabel botonGestionar = new JLabel ("GESTIONAR");
     botonGestionar.setForeground(Color.WHITE);
     botonGestionar.setHorizontalAlignment(SwingConstants.CENTER);
     botonGestionar.setVerticalAlignment(SwingConstants.CENTER);
     botonGestionar.setBorder(BorderFactory.createLineBorder(Color.white, 1));
     
     
     maxComponentSize = new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);
     idSuc.setMaximumSize(maxComponentSize);
     nombreSuc.setMaximumSize(maxComponentSize);
     estadoSuc.setMaximumSize(maxComponentSize);
     aperturaSuc.setMaximumSize(maxComponentSize);
     cierreSuc.setMaximumSize(maxComponentSize);
     botonGestionar.setMaximumSize(maxComponentSize);
   
     
     guia.add(idSuc);
     this.add(Box.createHorizontalStrut(15));
     guia.add(nombreSuc);
     this.add(Box.createHorizontalStrut(15));
     guia.add(estadoSuc);
     this.add(Box.createHorizontalStrut(15));
     guia.add(aperturaSuc);
     this.add(Box.createHorizontalStrut(15));
     guia.add(cierreSuc);
     this.add(Box.createHorizontalStrut(15));
     guia.add(botonGestionar);
   
   
     gbcIzq.insets = new Insets(10, 0, 0, 0); 
     gbcIzq.gridx = 0; 
     gbcIzq.gridy = 1;
     gbcIzq.weightx = 1;
     gbcIzq.weighty = 0.03;
     gbcIzq.anchor = GridBagConstraints.NORTH;
     gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
     backgroundPanel.add(guia, gbcIzq);
     
     //LISTA
     
     ListaTab panelIzquierda = new ListaTab(listaSucursal,this);
          
     gbcIzq.insets = new Insets(0, 0, 0, 0); 
     gbcIzq.gridx = 0; 
     gbcIzq.gridy = 2; // Reset the Y position to the first row
     gbcIzq.weightx = 1; // Allow the panel to take up extra horizontal space
     gbcIzq.weighty = 1;
     gbcIzq.fill = GridBagConstraints.BOTH; // Make the panel fill the available space
     gbcIzq.anchor = GridBagConstraints.NORTH;
     backgroundPanel.add(panelIzquierda, gbcIzq);
     
     

     //------------FIN PANEL IZQUIERDA-----------------
     
     //TODO
     id.addActionListener(e -> {
    	 ArrayList <Sucursal> nueva = ordenarSucursal(this.getListaSucursal(),"id");
    	 this.setListaSucursal(nueva);
    	 this.setContentPane(sucursalScreen(nueva));
    	 this.revalidate();
     });
     
     nombre.addActionListener(e -> {
    	 ArrayList <Sucursal> nueva = ordenarSucursal(this.getListaSucursal(),"nombre");
    	 this.setListaSucursal(nueva);
    	 this.setContentPane(sucursalScreen(nueva));
    	 this.revalidate();
     });
     
     estado.addActionListener(e -> {
    	 ArrayList <Sucursal> nueva = ordenarSucursal(this.getListaSucursal(),"estado");
    	 this.setListaSucursal(nueva);
    	 this.setContentPane(sucursalScreen(nueva));
    	 this.revalidate();

     });
     
     volver.addActionListener(e -> {
         this.setContentPane(menu());
         this.revalidate(); // This ensures the new panel is properly laid out.
     });
     
     alta.addActionListener(e -> {
         
    	new AltaSucursales(this);
    	this.revalidate();
   	 	this.repaint();
    	
     });
     
     busqueda.addActionListener(e -> {
         new BusquedaSucursal(this);
     });
     

	return backgroundPanel;
}

 private void buttonConfigSucursales(JButton button1) {
	 button1.setOpaque(false);
     button1.setFont(new Font("Code Light", Font.PLAIN, 30));
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
 
 private ArrayList<Sucursal> ordenarSucursal(ArrayList<Sucursal> lista, String tipo) {
	 
	 Comparator<Sucursal> comparator = null;
	 
		switch (tipo) {

		case "id":

			comparator = (obj1, obj2) -> {
				// Comparison logic here
				// Return a negative value if obj1 is less than obj2
				// Return 0 if obj1 is equal to obj2
				// Return a positive value if obj1 is greater than obj2

				return obj1.id() - obj2.id();

			};

			break;

		case "nombre":

			comparator = (obj1, obj2) -> {

				return obj1.getNombre().compareTo(obj2.getNombre());

			};

			break;

		case "estado":

			comparator = (obj1, obj2) -> {

				if (obj1.estadoToString() == "Operativa" && obj2.estadoToString() != "Operativa") {
					return (-1);
				}
				if (obj1.estadoToString() == obj2.estadoToString()) {
					return 0;
				} else {
					return (1);
				}

			};

			break;
		}
	 
	 lista =  (ArrayList<Sucursal>) lista.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	
		return lista;
 }

 private ArrayList<Camino> ordenarCamino(ArrayList<Camino> lista, String tipo) {
	 
	 Comparator<Camino> comparator = null;
	 
	 
		switch (tipo) {

		case "id":

			comparator = (obj1, obj2) -> {
				// Comparison logic here
				// Return a negative value if obj1 is less than obj2
				// Return 0 if obj1 is equal to obj2
				// Return a positive value if obj1 is greater than obj2

				return obj1.getID() - obj2.getID();

			};

			break;

		case "capacidad":

			comparator = (obj1, obj2) -> {

				return obj2.getCapMaxima()-obj1.getCapMaxima();

			};

			break;

		case "estado":

			comparator = (obj1, obj2) -> {

				if (obj1.estadoToString() == "Operativo" && obj2.estadoToString() != "Operativo") {
					return (-1);
				}
				if (obj1.estadoToString() == obj2.estadoToString()) {
					return 0;
				} else {
					return (1);
				}

			};

			break;
		}
	 
	 lista =  (ArrayList<Camino>) lista.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	
		return lista;
 }
 
private ArrayList<Producto> ordenarProducto(ArrayList<Producto> lista, String tipo) {
	 
	 Comparator<Producto> comparator = null;
	 
	 
		switch (tipo) {

		case "nombre":

			comparator = (obj1, obj2) -> {
				
				return obj1.getNombre().compareTo(obj2.getNombre());

			};

			break;

		case "precio":

			comparator = (obj1, obj2) -> {

				if(obj1.getPrecioUnitario()-obj2.getPrecioUnitario() > 0) {
					return 1;
				}
				if (obj1.getPrecioUnitario()-obj2.getPrecioUnitario() < 0) {
					return (-1);
				}
				else return 0;
				
			};

			break;

		case "peso":

			comparator = (obj1, obj2) -> {

				if(obj1.getPeso()-obj2.getPeso() > 0) {
					return 1;
				}
				if (obj1.getPeso()-obj2.getPeso() < 0) {
					return (-1);
				}
				else return 0;
				


			};

			break;
		}
	 
	 lista =  (ArrayList<Producto>) lista.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	
		return lista;
 }
 
}
