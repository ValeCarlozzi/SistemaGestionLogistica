package UI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import TP.Camino;
import TP.Producto;
import TP.Sucursal;

public class ListaItem extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	ListaItem(Object ob){
		
		if(ob.getClass() == Sucursal.class) {
			Sucursal sucursal = (Sucursal) ob;
			ListaItemSucursal(sucursal);
		}
		else if(ob.getClass() == Camino.class) {
			Camino camino = (Camino) ob;
			ListaItemCamino(camino);
		}
		else if(ob.getClass() == Producto.class) {
			Producto producto = (Producto) ob;
			ListaItemProducto(producto);
		}
	
		
		
		
	}
	*/
	
	ListaItem(Object ob, MenuPrincipal main){
	
		if(ob.getClass() == Sucursal.class) {
			Sucursal sucursal = (Sucursal) ob;
			ListaItemSucursal(sucursal, main);
		}
		else if(ob.getClass() == Camino.class) {
			Camino camino = (Camino) ob;
			ListaItemCamino(camino, main);
		}
		else if(ob.getClass() == Producto.class) {
			Producto producto = (Producto) ob;
			ListaItemProducto(producto, main);
		}
		
	}

/*	
private void ListaItemProducto(Producto producto){
		
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//boton gestionar
		JButton gestionar = new JButton("GESTIONAR");
        buttonConfig(gestionar);

		
		//botones para gestionar
        JButton editar = new JButton("EDITAR");
        JButton baja= new JButton("BAJA");
        
        buttonConfig(editar);
        buttonConfig(baja);
      
        
        //labels de informacion del producto
        JLabel nombre = new JLabel(producto.getNombre());
        nombre.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        nombre.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        nombre.setFont(new Font("Antipasto", Font.PLAIN, 15));
        nombre.setForeground(Color.WHITE);
        nombre.setPreferredSize(new Dimension(120, 30));
        Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        nombre.setBorder(compoundBorder);
        
        //TODO hover para leer todo?
        JLabel descripcion = new JLabel(producto.descripcion());
        descripcion.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        descripcion.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        descripcion.setFont(new Font("Antipasto", Font.PLAIN, 15));
        descripcion.setForeground(Color.WHITE);
        descripcion.setPreferredSize(new Dimension(270, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        descripcion.setBorder(compoundBorder);
        
        JLabel precioUnitario = new JLabel(producto.getPrecioUnitario().toString());
        precioUnitario.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        precioUnitario.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        precioUnitario.setFont(new Font("Antipasto", Font.PLAIN, 15));
        precioUnitario.setForeground(Color.WHITE);
        precioUnitario.setPreferredSize(new Dimension(80, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 2, 14, 2);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        precioUnitario.setBorder(compoundBorder);
        
        JLabel peso = new JLabel(producto.getPeso().toString());
        peso.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        peso.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        peso.setFont(new Font("Antipasto", Font.PLAIN, 15));
        peso.setForeground(Color.WHITE);
        peso.setPreferredSize(new Dimension(80, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 2, 14, 2);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        peso.setBorder(compoundBorder);
        
       
        Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, editar.getPreferredSize().height);
        editar.setMaximumSize(maxComponentSize);
        baja.setMaximumSize(maxComponentSize);
        gestionar.setMaximumSize(maxComponentSize);
        
        
        this.add(Box.createHorizontalStrut(5));  
        this.add(nombre);
        this.add(descripcion); 
        this.add(precioUnitario);
        this.add(peso);
        this.add(Box.createHorizontalStrut(15)); 
        this.add(gestionar);
        this.add(Box.createHorizontalStrut(10)); 
        
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBackground(new Color(47,55,60,255));
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        
        popupMenu.add(editar);
        popupMenu.add(baja);
        
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Editar(producto);
            }
        });
        
        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Baja(producto);
            }
        });
        
        gestionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the popup menu when the button is clicked
                popupMenu.show(gestionar, 0, gestionar.getHeight());
            }
        });
		
		
		
	}
	*/
	
	/*
private void ListaItemCamino(Camino camino){
		
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//boton gestionar
		JButton gestionar = new JButton("GESTIONAR");
        buttonConfig(gestionar);

		
		//botones para gestionar
        JButton editar = new JButton("EDITAR");
        JButton baja= new JButton("BAJA");
        
        buttonConfig(editar);
        buttonConfig(baja);
      
        
        //labels de informacion de la sucursal
        JLabel id = new JLabel(camino.getID().toString());
        id.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        id.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        id.setFont(new Font("Antipasto", Font.PLAIN, 15));
        id.setForeground(Color.WHITE);
        id.setPreferredSize(new Dimension(75, 30));
        Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        id.setBorder(compoundBorder);
        
        JLabel id_Origen = new JLabel(camino.getOrigen().toString());
        id_Origen.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        id_Origen.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        id_Origen.setFont(new Font("Antipasto", Font.PLAIN, 15));
        id_Origen.setForeground(Color.WHITE);
        id_Origen.setPreferredSize(new Dimension(75, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        id_Origen.setBorder(compoundBorder);
        
        JLabel id_Destino = new JLabel(camino.getDestino().toString());
        id_Destino.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        id_Destino.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        id_Destino.setFont(new Font("Antipasto", Font.PLAIN, 15));
        id_Destino.setForeground(Color.WHITE);
        id_Destino.setPreferredSize(new Dimension(75, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        id_Destino.setBorder(compoundBorder);
        
        JLabel tiempoTransito = new JLabel(camino.getTiempoTransito().toString());
        tiempoTransito.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        tiempoTransito.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        tiempoTransito.setFont(new Font("Antipasto", Font.PLAIN, 15));
        tiempoTransito.setForeground(Color.WHITE);
        tiempoTransito.setPreferredSize(new Dimension(80, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 5, 14, 5);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        tiempoTransito.setBorder(compoundBorder);
        
        JLabel capMaxima = new JLabel(camino.getCapMaxima().toString());
        capMaxima.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        capMaxima.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        capMaxima.setFont(new Font("Antipasto", Font.PLAIN, 15));
        capMaxima.setForeground(Color.WHITE);
        capMaxima.setPreferredSize(new Dimension(90, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 5, 14, 5);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        capMaxima.setBorder(compoundBorder);
        
        JLabel estado = new JLabel(camino.estadoToString());
        estado.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        estado.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        estado.setFont(new Font("Antipasto", Font.PLAIN, 15));
        estado.setForeground(Color.WHITE);
        estado.setPreferredSize(new Dimension(140, 30));
        if(camino.estadoToString() == "Operativo") {
        	existingBorder = BorderFactory.createLineBorder((new Color(30,255,130,255)), 1);
        }
        else {
        	existingBorder = BorderFactory.createLineBorder((Color.RED), 1);
        }
        emptyBorder = BorderFactory.createEmptyBorder(14, 15, 14, 15);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        estado.setBorder(compoundBorder);
        
       
        Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, editar.getPreferredSize().height);
        editar.setMaximumSize(maxComponentSize);
        baja.setMaximumSize(maxComponentSize);
        gestionar.setMaximumSize(maxComponentSize);
        
        
        this.add(Box.createHorizontalStrut(5));  
        this.add(id);
        this.add(id_Origen); 
        this.add(id_Destino);
        this.add(tiempoTransito);
        this.add(capMaxima);
        this.add(estado);
        this.add(Box.createHorizontalStrut(15)); 
        this.add(gestionar);
        this.add(Box.createHorizontalStrut(10)); 
        
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBackground(new Color(47,55,60,255));
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        
        popupMenu.add(editar);
        popupMenu.add(baja);
        
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Editar(camino);
            }
        });
        
        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Baja(camino);
            }
        });
        
        gestionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the popup menu when the button is clicked
                popupMenu.show(gestionar, 0, gestionar.getHeight());
            }
        });
        
	
	
}
*/

/*
private void ListaItemSucursal(Sucursal sucursal){
		
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//boton gestionar
		JButton gestionar = new JButton("GESTIONAR");
        buttonConfig(gestionar);

		
		//botones para gestionar
        JButton editar = new JButton("EDITAR");
        JButton baja= new JButton("BAJA");
        JButton stock= new JButton("STOCK");
        JButton ord= new JButton("Ord. Provisión");
        buttonConfig(editar);
        buttonConfig(baja);
        buttonConfig(stock);
        buttonConfig(ord);
        
        //labels de informacion de la sucursal
        JLabel nombre = new JLabel(sucursal.getNombre());
        nombre.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        nombre.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        nombre.setFont(new Font("Antipasto", Font.PLAIN, 15));
        nombre.setForeground(Color.WHITE);
        nombre.setPreferredSize(new Dimension(170, 30));
        Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 45, 14, 45);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        nombre.setBorder(compoundBorder);
        
        JLabel id = new JLabel(sucursal.id().toString());
        id.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        id.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        id.setFont(new Font("Antipasto", Font.PLAIN, 15));
        id.setForeground(Color.WHITE);
        id.setPreferredSize(new Dimension(100, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        id.setBorder(compoundBorder);
        
        
        JLabel estado = new JLabel(sucursal.estadoToString());
        estado.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        estado.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        estado.setFont(new Font("Antipasto", Font.PLAIN, 15));
        estado.setForeground(Color.WHITE);
        estado.setPreferredSize(new Dimension(140, 30));
        if(sucursal.estadoToString() == "Operativa") {
        	existingBorder = BorderFactory.createLineBorder((new Color(30,255,130,255)), 1);
        }
        else {
        	existingBorder = BorderFactory.createLineBorder((Color.RED), 1);
        }
        emptyBorder = BorderFactory.createEmptyBorder(14, 20, 14, 20);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        estado.setBorder(compoundBorder);
        
        JLabel apertura = new JLabel(sucursal.getHorarioApertura());
        apertura.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        apertura.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        apertura.setFont(new Font("Antipasto", Font.PLAIN, 15));
        apertura.setForeground(Color.WHITE);
        apertura.setPreferredSize(new Dimension(60, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        apertura.setBorder(compoundBorder);
        
        JLabel cierre = new JLabel(sucursal.getHorarioCierre());
        cierre.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        cierre.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        cierre.setFont(new Font("Antipasto", Font.PLAIN, 15));
        cierre.setForeground(Color.WHITE);
        cierre.setPreferredSize(new Dimension(60, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        cierre.setBorder(compoundBorder);

        Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, editar.getPreferredSize().height);
        editar.setMaximumSize(maxComponentSize);
        baja.setMaximumSize(maxComponentSize);
        stock.setMaximumSize(maxComponentSize);
        ord.setMaximumSize(maxComponentSize);
        gestionar.setMaximumSize(maxComponentSize);
        
        
        this.add(Box.createHorizontalStrut(5));  
        this.add(id);
        this.add(nombre); 
        this.add(estado);
        this.add(apertura);
        this.add(cierre);
        this.add(Box.createHorizontalStrut(15)); 
        this.add(gestionar);
        this.add(Box.createHorizontalStrut(10)); 
        
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBackground(new Color(47,55,60,255));
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        
        popupMenu.add(editar);
        popupMenu.add(baja);
        popupMenu.add(stock);
        popupMenu.add(ord);
        
        
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Editar(sucursal);
            }
        });
        
        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Baja(sucursal);
            }
        });
        
        stock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new StockWindow(sucursal);
            }
        });
        
        ord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new OrdenesProvisionWindow(sucursal);
            }
        });
               
        gestionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the popup menu when the button is clicked
                popupMenu.show(gestionar, 0, gestionar.getHeight());
            }
        });
        
	}
*/

private void ListaItemSucursal(Sucursal sucursal, MenuPrincipal main){
	
	this.setOpaque(false);
	this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	//boton gestionar
	JButton gestionar = new JButton("GESTIONAR");
    buttonConfig(gestionar);

	
	//botones para gestionar
    JButton editar = new JButton("EDITAR");
    JButton baja= new JButton("BAJA");
    JButton stock= new JButton("STOCK");
    JButton ord= new JButton("Ord. Provisión");
    buttonConfig(editar);
    buttonConfig(baja);
    buttonConfig(stock);
    buttonConfig(ord);
    
    //labels de informacion de la sucursal
    JLabel nombre = new JLabel(sucursal.getNombre());
    nombre.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    nombre.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    nombre.setFont(new Font("Antipasto", Font.PLAIN, 15));
    nombre.setForeground(Color.WHITE);
    nombre.setPreferredSize(new Dimension(170, 30));
    Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    Border emptyBorder = BorderFactory.createEmptyBorder(14, 45, 14, 45);
    Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    nombre.setBorder(compoundBorder);
    
    JLabel id = new JLabel(sucursal.id().toString());
    id.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    id.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    id.setFont(new Font("Antipasto", Font.PLAIN, 15));
    id.setForeground(Color.WHITE);
    id.setPreferredSize(new Dimension(100, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    id.setBorder(compoundBorder);
    
    
    JLabel estado = new JLabel(sucursal.estadoToString());
    estado.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    estado.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    estado.setFont(new Font("Antipasto", Font.PLAIN, 15));
    estado.setForeground(Color.WHITE);
    estado.setPreferredSize(new Dimension(140, 30));
    if(sucursal.estadoToString() == "Operativa") {
    	existingBorder = BorderFactory.createLineBorder((new Color(30,255,130,255)), 1);
    }
    else {
    	existingBorder = BorderFactory.createLineBorder((Color.RED), 1);
    }
    emptyBorder = BorderFactory.createEmptyBorder(14, 20, 14, 20);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    estado.setBorder(compoundBorder);
    
    JLabel apertura = new JLabel(sucursal.getHorarioApertura());
    apertura.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    apertura.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    apertura.setFont(new Font("Antipasto", Font.PLAIN, 15));
    apertura.setForeground(Color.WHITE);
    apertura.setPreferredSize(new Dimension(60, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    apertura.setBorder(compoundBorder);
    
    JLabel cierre = new JLabel(sucursal.getHorarioCierre());
    cierre.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    cierre.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    cierre.setFont(new Font("Antipasto", Font.PLAIN, 15));
    cierre.setForeground(Color.WHITE);
    cierre.setPreferredSize(new Dimension(60, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    cierre.setBorder(compoundBorder);

    Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, editar.getPreferredSize().height);
    editar.setMaximumSize(maxComponentSize);
    baja.setMaximumSize(maxComponentSize);
    stock.setMaximumSize(maxComponentSize);
    ord.setMaximumSize(maxComponentSize);
    gestionar.setMaximumSize(maxComponentSize);
    
    
    this.add(Box.createHorizontalStrut(5));  
    this.add(id);
    this.add(nombre); 
    this.add(estado);
    this.add(apertura);
    this.add(cierre);
    this.add(Box.createHorizontalStrut(15)); 
    this.add(gestionar);
    this.add(Box.createHorizontalStrut(10)); 
    
    JPopupMenu popupMenu = new JPopupMenu();
    popupMenu.setBackground(new Color(47,55,60,255));
    popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

    
    popupMenu.add(editar);
    popupMenu.add(baja);
    popupMenu.add(stock);
    popupMenu.add(ord);
    
    
    editar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Editar(sucursal, main);
        }
    });
    
    baja.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Baja(sucursal, main);
        }
    });
    
    stock.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new StockWindow(sucursal).buildStockWindow();
        }
    });
    
    ord.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new OrdenesProvisionWindow(sucursal);
        }
    });
           
    gestionar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Display the popup menu when the button is clicked
            popupMenu.show(gestionar, 0, gestionar.getHeight());
        }
    });
    
}

private void ListaItemCamino(Camino camino, MenuPrincipal main){
	
	this.setOpaque(false);
	this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	//boton gestionar
	JButton gestionar = new JButton("GESTIONAR");
    buttonConfig(gestionar);

	
	//botones para gestionar
    JButton editar = new JButton("EDITAR");
    JButton baja= new JButton("BAJA");
    
    buttonConfig(editar);
    buttonConfig(baja);
  
    
    //labels de informacion de la sucursal
    JLabel id = new JLabel(camino.getID().toString());
    id.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    id.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    id.setFont(new Font("Antipasto", Font.PLAIN, 15));
    id.setForeground(Color.WHITE);
    id.setPreferredSize(new Dimension(75, 30));
    Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
    Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    id.setBorder(compoundBorder);
    
    JLabel id_Origen = new JLabel(camino.getOrigen().toString());
    id_Origen.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    id_Origen.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    id_Origen.setFont(new Font("Antipasto", Font.PLAIN, 15));
    id_Origen.setForeground(Color.WHITE);
    id_Origen.setPreferredSize(new Dimension(75, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    id_Origen.setBorder(compoundBorder);
    
    JLabel id_Destino = new JLabel(camino.getDestino().toString());
    id_Destino.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    id_Destino.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    id_Destino.setFont(new Font("Antipasto", Font.PLAIN, 15));
    id_Destino.setForeground(Color.WHITE);
    id_Destino.setPreferredSize(new Dimension(75, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    id_Destino.setBorder(compoundBorder);
    
    JLabel tiempoTransito = new JLabel(camino.getTiempoTransito().toString());
    tiempoTransito.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    tiempoTransito.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    tiempoTransito.setFont(new Font("Antipasto", Font.PLAIN, 15));
    tiempoTransito.setForeground(Color.WHITE);
    tiempoTransito.setPreferredSize(new Dimension(80, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 5, 14, 5);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    tiempoTransito.setBorder(compoundBorder);
    
    JLabel capMaxima = new JLabel(camino.getCapMaxima().toString());
    capMaxima.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    capMaxima.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    capMaxima.setFont(new Font("Antipasto", Font.PLAIN, 15));
    capMaxima.setForeground(Color.WHITE);
    capMaxima.setPreferredSize(new Dimension(90, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 5, 14, 5);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    capMaxima.setBorder(compoundBorder);
    
    JLabel estado = new JLabel(camino.estadoToString());
    estado.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    estado.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    estado.setFont(new Font("Antipasto", Font.PLAIN, 15));
    estado.setForeground(Color.WHITE);
    estado.setPreferredSize(new Dimension(140, 30));
    if(camino.estadoToString() == "Operativo") {
    	existingBorder = BorderFactory.createLineBorder((new Color(30,255,130,255)), 1);
    }
    else {
    	existingBorder = BorderFactory.createLineBorder((Color.RED), 1);
    }
    emptyBorder = BorderFactory.createEmptyBorder(14, 15, 14, 15);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    estado.setBorder(compoundBorder);
    
   
    Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, editar.getPreferredSize().height);
    editar.setMaximumSize(maxComponentSize);
    baja.setMaximumSize(maxComponentSize);
    gestionar.setMaximumSize(maxComponentSize);
    
    
    this.add(Box.createHorizontalStrut(5));  
    this.add(id);
    this.add(id_Origen); 
    this.add(id_Destino);
    this.add(tiempoTransito);
    this.add(capMaxima);
    this.add(estado);
    this.add(Box.createHorizontalStrut(15)); 
    this.add(gestionar);
    this.add(Box.createHorizontalStrut(10)); 
    
    JPopupMenu popupMenu = new JPopupMenu();
    popupMenu.setBackground(new Color(47,55,60,255));
    popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

    
    popupMenu.add(editar);
    popupMenu.add(baja);
    
    editar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Editar(camino,main);
        }
    });
    
    baja.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Baja(camino, main);
        }
    });
    
    gestionar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Display the popup menu when the button is clicked
            popupMenu.show(gestionar, 0, gestionar.getHeight());
        }
    });
    


}

private void ListaItemProducto(Producto producto, MenuPrincipal main){
	
	this.setOpaque(false);
	this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	//boton gestionar
	JButton gestionar = new JButton("GESTIONAR");
    buttonConfig(gestionar);

	
	//botones para gestionar
    JButton editar = new JButton("EDITAR");
    JButton baja= new JButton("BAJA");
    
    buttonConfig(editar);
    buttonConfig(baja);
  
    
    //labels de informacion del producto
    JLabel nombre = new JLabel(producto.getNombre());
    nombre.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    nombre.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    nombre.setFont(new Font("Antipasto", Font.PLAIN, 15));
    nombre.setForeground(Color.WHITE);
    nombre.setPreferredSize(new Dimension(120, 30));
    Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
    Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    nombre.setBorder(compoundBorder);
    
    //TODO hover para leer todo?
    JLabel descripcion = new JLabel(producto.descripcion());
    descripcion.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    descripcion.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    descripcion.setFont(new Font("Antipasto", Font.PLAIN, 15));
    descripcion.setForeground(Color.WHITE);
    descripcion.setPreferredSize(new Dimension(270, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    descripcion.setBorder(compoundBorder);
    
    JLabel precioUnitario = new JLabel(producto.getPrecioUnitario().toString());
    precioUnitario.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    precioUnitario.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    precioUnitario.setFont(new Font("Antipasto", Font.PLAIN, 15));
    precioUnitario.setForeground(Color.WHITE);
    precioUnitario.setPreferredSize(new Dimension(80, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 2, 14, 2);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    precioUnitario.setBorder(compoundBorder);
    
    JLabel peso = new JLabel(producto.getPeso().toString());
    peso.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
    peso.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
    peso.setFont(new Font("Antipasto", Font.PLAIN, 15));
    peso.setForeground(Color.WHITE);
    peso.setPreferredSize(new Dimension(80, 30));
    existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    emptyBorder = BorderFactory.createEmptyBorder(14, 2, 14, 2);
    compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
    peso.setBorder(compoundBorder);
    
   
    Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, editar.getPreferredSize().height);
    editar.setMaximumSize(maxComponentSize);
    baja.setMaximumSize(maxComponentSize);
    gestionar.setMaximumSize(maxComponentSize);
    
    
    this.add(Box.createHorizontalStrut(5));  
    this.add(nombre);
    this.add(descripcion); 
    this.add(precioUnitario);
    this.add(peso);
    this.add(Box.createHorizontalStrut(15)); 
    this.add(gestionar);
    this.add(Box.createHorizontalStrut(10)); 
    
    JPopupMenu popupMenu = new JPopupMenu();
    popupMenu.setBackground(new Color(47,55,60,255));
    popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

    
    popupMenu.add(editar);
    popupMenu.add(baja);
    
    editar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Editar(producto,main);
        }
    });
    
    baja.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Baja(producto, main);
        }
    });
    
    gestionar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Display the popup menu when the button is clicked
            popupMenu.show(gestionar, 0, gestionar.getHeight());
        }
    });
	
	
	
}

private void buttonConfig(JButton button1) {
		button1.setOpaque(false);
	    button1.setFont(new Font("Antipasto", Font.PLAIN, 15));
	    button1.setForeground(Color.WHITE);
	    button1.setBackground(new Color(0,0,0,70));
	    button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	    button1.setPreferredSize(new Dimension(180, 50));
	    button1.setFocusable(false);
	
	    button1.addMouseListener(new MouseAdapter() {
	       
	   	 @Override
	        public void mouseEntered(MouseEvent e) {
	        	 button1.setOpaque(true);
	            button1.setBackground(new Color(80,100,111,255));
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
