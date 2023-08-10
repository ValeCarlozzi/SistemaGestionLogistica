package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import TP.GestorOrdenes;
import TP.ListaProductos;
import TP.OrdenDeProvision;
import TP.Producto;
import TP.Sucursal;

public class NuevaOrdenProvision extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HashMap<String,Integer> listaProductos;
	
	int contadorPr = 0;
	
	NuevaOrdenProvision(OrdenesProvisionWindow main, Sucursal sucursal){
		
		listaProductos = new HashMap<String,Integer>();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Nueva Orden de Provisión");
	    this.setSize(500, 600); // Set your preferred size
	    this.setLocationRelativeTo(null); // senter the frame on the screen
	    ImageIcon customIcon = new ImageIcon("LogoApp.png");
        this.setIconImage(customIcon.getImage());
		
	    //background panel (extiende JPanel)
	    Background backgroundPanel = new Background("Background.jpg");
	    this.setContentPane(backgroundPanel);
	    
	    
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    JLabel titulo = new JLabel("Nueva orden de provisión");
	    titulo.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
	    titulo.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
	    titulo.setFont(new Font("Antipasto", Font.BOLD, 20));
	    titulo.setForeground(Color.WHITE);
	    titulo.setPreferredSize(new Dimension(170, 30));
        Border existingBorder = BorderFactory.createLineBorder(new Color(0,0,0,0), 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 45, 14, 45);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        titulo.setBorder(compoundBorder);
	    
        //agrego titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weighty = 0.05;
	    gbc.insets = new Insets(10, 10, 2, 10);
	    backgroundPanel.add(titulo,gbc);
	    
	    JPanel input = new JPanel(new GridBagLayout());
	    input.setOpaque(false);
	    Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        input.setBorder(border);
        
        
	    
        JLabel cantProductos = new JLabel("Cantidad de productos en la orden: " + contadorPr);
	    cantProductos.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
	    cantProductos.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
	    cantProductos.setFont(new Font("Antipasto", Font.PLAIN, 15));
	    cantProductos.setForeground(Color.WHITE);
	    cantProductos.setPreferredSize(new Dimension(170, 30));
        existingBorder = BorderFactory.createLineBorder(new Color(0,0,0,0), 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 45, 14, 45);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        cantProductos.setBorder(compoundBorder);
	    		
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
	    gbc.weighty = 0.1;
	    gbc.insets = new Insets(2, 2, 2, 2);
	    backgroundPanel.add(cantProductos,gbc);
        
	    //-----------INPUT PANEL-----------
	    
	  
	    
	    GridBagConstraints gbcInside = new GridBagConstraints();

	    
	    
	    JLabel nombreLabel = new JLabel("Nombre del producto:");
	    nombreLabel.setForeground(Color.WHITE);
	    gbcInside.gridy = 0;
	    gbcInside.weighty = 0.1;
	    gbcInside.insets = new Insets(10, 10, 10, 10); 
	    gbcInside.anchor = GridBagConstraints.CENTER;
	    gbcInside.fill = GridBagConstraints.BOTH;
	    input.add(nombreLabel,gbcInside);
	    
	    JTextField nombre = new JFormattedTextField();
	    
	    nombre.setBorder(emptyBorder);
	    Dimension preferredSize = new Dimension(150, 30); 
	    nombre.setPreferredSize(preferredSize);
	    nombre.setForeground(Color.WHITE);
	    nombre.setCaretColor(Color.WHITE);
	    nombre.setOpaque(false);
	    nombre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    
	    gbcInside.gridy = 1;
	    gbcInside.insets = new Insets(1, -50, 5, -50);
	    input.add(nombre,gbcInside);
	    
	    JLabel cantidadLabel = new JLabel("Cantidad del producto:");
	    cantidadLabel.setForeground(Color.WHITE);
	    gbcInside.gridy = 2;
	    gbcInside.weighty = 0.1;
	    gbcInside.insets = new Insets(5, 10, 10, 10); 
	    gbcInside.anchor = GridBagConstraints.CENTER;
	    gbcInside.fill = GridBagConstraints.BOTH;
	    input.add(cantidadLabel,gbcInside);
	    
	    JFormattedTextField cantidad = new JFormattedTextField();
	    cantidad.setBorder(emptyBorder);
	    preferredSize = new Dimension(150, 30); 
	    cantidad.setPreferredSize(preferredSize);
	    cantidad.setForeground(Color.WHITE);
	    cantidad.setCaretColor(Color.WHITE);
	    cantidad.setOpaque(false);
	    cantidad.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    
	    gbcInside.gridy = 3;
	    gbcInside.insets = new Insets(1, -50, 15, -50);
	    input.add(cantidad,gbcInside);
	    
	    JButton agregar = new JButton("Agregar Producto");
	    buttonConfig(agregar);
	    gbcInside.weighty = 0.1;
	    gbcInside.gridy = 4;
	    gbcInside.insets = new Insets(5, -50, 15, -50);
	    input.add(agregar,gbcInside);

        gbc.gridy = 2;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(2, 2, 10, 2);

	    backgroundPanel.add(input,gbc);
	    
	    //-----------FIN INPUT PANEL-----------

	    
	    
	    
	    JLabel horasLabel = new JLabel("Horas máximo de espera:");
	    horasLabel.setForeground(Color.WHITE);
	    horasLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    horasLabel.setVerticalAlignment(SwingConstants.CENTER);
	    gbc.weighty = 0.1;
	    gbc.gridwidth = 2;
	    gbc.gridy = 3;
	    gbc.insets = new Insets(5, 5, 10, 5); 
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.BOTH;
	    backgroundPanel.add(horasLabel,gbc);
	    
	    JFormattedTextField horas = new JFormattedTextField();
	    
	    horas.setBorder(emptyBorder);
	    preferredSize = new Dimension(150, 30); 
	    horas.setPreferredSize(preferredSize);
	    horas.setForeground(Color.WHITE);
	    horas.setCaretColor(Color.WHITE);
	    horas.setOpaque(false);
	    horas.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    
	    gbc.insets = new Insets(2, 2, 10, 2); 
	    gbc.gridy = 4;
	    backgroundPanel.add(horas,gbc);
	    
	    JButton cancelar = new JButton("cancelar");
	    buttonConfig(cancelar);
	    JButton confirmar = new JButton("Confirmar Orden");
	    buttonConfig(confirmar);
	    
	    gbc.gridwidth = 1;
        gbc.gridy = 5;
	    gbc.weighty = 0.05;
	    gbc.insets = new Insets(10,2,15,6);
	    backgroundPanel.add(cancelar,gbc);
	    
	    gbc.gridx = 1;
	    gbc.insets = new Insets(10,6,15,2);
	    backgroundPanel.add(confirmar,gbc);

	    ArrayList<Producto> productos = new ListaProductos().getLista();
	    
		agregar.addActionListener(e -> {
			try {
				cantidad.commitEdit();
			} catch (ParseException e1) {

			}
			
			Integer cant = null;
			cant = parseTextField(cantidad.getText());
			
			if(cant < 0) {
				new VentanasError("Cantidad erronea");
				return;
			}
			else if(listaProductos.keySet().contains(nombre.getText())) {
				new VentanasError("Producto ya ingresado");
				return;
			}
			else if(nombre.getText().isEmpty() || cant == null) {
				new VentanasError("Valores nulos");
				return;
			}
			boolean existe = false;
	        for (Producto producto : productos) {
	            if (producto.getNombre().equals(nombre.getText())) {
	            	existe = true;
	                break; // Exit the loop once a match is found
	            }
	        }

	        if (!existe) {
	            new VentanasError("No existe el producto ingresado");
	            return;
	        } else {
	            
				listaProductos.put(nombre.getText(),cant);
				sumaContadorPr();
				nombre.setText("");
				cantidad.setText("");
				cantProductos.setText("Cantidad de productos en la orden: " + contadorPr);
			}

		});
		
	    
		cancelar.addActionListener(e -> {
			this.dispose();
		});
		
		
		confirmar.addActionListener(e -> {
			
			if(listaProductos.isEmpty()) {
				new VentanasError("No se agregaron productos");
				return;
			}
			
			try {
				horas.commitEdit();
			} catch (ParseException e1) {

			}

			Integer hor = null;
			hor = parseTextField(horas.getText());
			
			if(hor >= 0) {
				try {
					
					GestorOrdenes gestor = new GestorOrdenes();
					
					gestor.altaOrden(sucursal,listaProductos,hor);
					
					OrdenDeProvision ordenNueva = gestor.generarOrden(sucursal,listaProductos,hor);
					
					ArrayList<OrdenDeProvision> listaNueva = main.getListaOrdenes();
					listaNueva.add(ordenNueva);
					
					main.setListaOrdenes(listaNueva);
					main.setContentPane(main.panelBuilder(listaNueva, sucursal));
					main.revalidate();
					this.dispose();
					
				} catch (Exception e2) {
					new VentanasError(e2.getMessage());
				}
			}
			else {
				new VentanasError("Horas erroneas");
			}
			
			
			
		});
		
	   
	    this.setVisible(true);

	}
	
	private void sumaContadorPr() {
		contadorPr++;
		return;
	}
	
	private Integer parseTextField(String text) {
        if (text.isEmpty()) {
        	return (-1);
        } else {
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                // Handle invalid input (non-integer) if needed
            	return (-1);
            }
        }
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
