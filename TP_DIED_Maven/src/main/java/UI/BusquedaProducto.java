package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import TP.Producto;

public class BusquedaProducto extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BusquedaProducto(MenuPrincipal main){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Busqueda Producto");
	    this.setSize(500, 500); // Set your preferred size
	    this.setLocationRelativeTo(null); // Center the frame on the screen
		
	    ImageIcon customIcon = new ImageIcon("LogoApp.png");
        this.setIconImage(customIcon.getImage());
		
	    //background panel (extiende JPanel)
	    Background backgroundPanel = new Background("Background.jpg");
	    this.setContentPane(backgroundPanel);
	    
	    
	    JPanel panel = new JPanel(new GridBagLayout());
	    panel.setOpaque(false);
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    JLabel nombreLabel = new JLabel("Nombre del producto:");
	    nombreLabel.setForeground(Color.WHITE);
	    gbc.gridx = 0; 
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.insets = new Insets(10, 10, 0, 10); 
	    panel.add(nombreLabel,gbc);
	    
	    NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);
	    
        JTextField nombre = new JTextField();
	    Dimension preferredSize = new Dimension(nombre.getPreferredSize().width, 30); 
	    nombre.setPreferredSize(preferredSize);
	    nombre.setForeground(Color.WHITE);
	    nombre.setOpaque(false);
	    nombre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 1;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(nombre,gbc);
	    
	    JLabel descripcionLabel = new JLabel("Descripcion del producto:");
	    descripcionLabel.setForeground(Color.WHITE);
	    gbc.gridy = 2;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(descripcionLabel,gbc);
	    
	    JTextField descripcion = new JTextField();
	    preferredSize = new Dimension(descripcion.getPreferredSize().width, 30); 
	    descripcion.setPreferredSize(preferredSize);
	    descripcion.setForeground(Color.WHITE);
	    descripcion.setOpaque(false);
	    descripcion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 3;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(descripcion,gbc);
	    
	    JLabel precioLabel = new JLabel("Precio unitario del producto:");
	    precioLabel.setForeground(Color.WHITE);
	    gbc.gridy = 4;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(precioLabel,gbc);
	    
	    JFormattedTextField precio = new JFormattedTextField();
	    preferredSize = new Dimension(precio.getPreferredSize().width, 30); 
	    precio.setPreferredSize(preferredSize);
	    precio.setForeground(Color.WHITE);
	    precio.setOpaque(false);
	    precio.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 5;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(precio,gbc);
	    
	    JLabel pesoLabel = new JLabel("Peso del producto:");
	    pesoLabel.setForeground(Color.WHITE);
	    gbc.gridy = 6;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(pesoLabel,gbc);
	    
	    JFormattedTextField peso = new JFormattedTextField();
	    preferredSize = new Dimension(precio.getPreferredSize().width, 30); 
	    peso.setPreferredSize(preferredSize);
	    peso.setForeground(Color.WHITE);
	    peso.setOpaque(false);
	    peso.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 7;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(peso,gbc);
	    
	    JButton cancelar = new JButton("Cancelar");
	    buttonConfig(cancelar);
	    gbc.gridy = 11;
	    gbc.gridwidth = 1;
	    gbc.insets = new Insets(10, 10, 10, 10);
	    panel.add(cancelar,gbc);
	    
	    JButton confirmar = new JButton("Confirmar");
	    buttonConfig(confirmar);
	    gbc.gridx = 1;
	    panel.add(confirmar,gbc);
	    
	    gbc.gridx = 0; 
	    gbc.gridy = 0;
	    gbc.gridwidth = 1;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.insets = new Insets(0, 0, 0, 0); 
	    backgroundPanel.add(panel,gbc);
	    
	    confirmar.addActionListener(e -> {
	 
			String nomb = null;
			String desc = null;
			Double prec = null;
			Double pes = null;
	    	
	    	try {
	    		precio.commitEdit();
	    		peso.commitEdit();
			} catch (ParseException e1) {

			}

	    	if(!(nombre.getText().isEmpty())) {
				nomb = nombre.getText();
			}
			if(!(descripcion.getText().isEmpty())) {
				desc = descripcion.getText();
			}
			prec = parseTextField(precio.getText());
			pes = parseTextField(peso.getText());;
			
			
			final String finalnomb = nomb;
			final String finaldesc = desc;
			final Double finalprec = prec;
			final Double finalpes = pes;
	
			
			Predicate<Producto> predicado = p -> {
				
					if( (finalnomb == null || finalnomb.equals(p.getNombre())) &&
						(finaldesc == null || finaldesc.equals(p.descripcion())) &&
						(finalprec == (-1.0) || finalprec.equals(p.getPrecioUnitario())) &&
						(finalpes == (-1.0) || finalpes.equals(p.getPeso()))) {
						return true;
					}
					else return false;
			
			};	
			
			try {
				ArrayList<Producto> listaNueva = (ArrayList<Producto>) main.getListaProducto().stream()	
						.filter(predicado)
						.collect(Collectors.toList());
				
				main.setContentPane(main.productosScreen(listaNueva));
				main.revalidate();
				this.dispose();

				
			} catch (Exception e2) {
				new VentanasError(e2.getMessage());
			}
	    	
	    });
	    
	    cancelar.addActionListener(e -> {
	       this.dispose();
	    });
	   
	    this.setVisible(true);
	    
	}
	
	private Double parseTextField(String text) {
        if (text.isEmpty()) {
        	return (-1.0);
        } else {
            try {
                return Double.parseDouble(text);
            } catch (NumberFormatException e) {
                // Handle invalid input (non-integer) if needed
            	return (-1.0);
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
