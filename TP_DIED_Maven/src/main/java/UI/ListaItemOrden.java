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
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import TP.ConfigurarOrden;
import TP.OrdenDeProvision;

public class ListaItemOrden extends JPanel{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ListaItemOrden(OrdenDeProvision orden, OrdenesProvisionWindow main){
		
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        //labels de informacion del producto
        JLabel fecha = new JLabel(orden.getFechaOrden().toString());
        fecha.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        fecha.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        fecha.setFont(new Font("Antipasto", Font.PLAIN, 15));
        fecha.setForeground(Color.WHITE);
        fecha.setPreferredSize(new Dimension(120, 30));
        Border existingBorder = BorderFactory.createLineBorder(new Color(0,0,0,0), 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        fecha.setBorder(compoundBorder);
        
        JLabel space = new JLabel("|");
        space.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        space.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        space.setFont(new Font("Antipasto", Font.PLAIN, 15));
        space.setForeground(Color.WHITE);
        space.setPreferredSize(new Dimension(120, 30));
        existingBorder = BorderFactory.createLineBorder(new Color(0,0,0,0), 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        space.setBorder(compoundBorder);
     
        
        JLabel tiempo = new JLabel("Horas maximas para recepcion: " + orden.getHorasMaximo().toString());
        tiempo.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        tiempo.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        tiempo.setFont(new Font("Antipasto", Font.PLAIN, 15));
        tiempo.setForeground(Color.WHITE);
        tiempo.setPreferredSize(new Dimension(80, 30));
        existingBorder = BorderFactory.createLineBorder(new Color(0,0,0,0), 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        tiempo.setBorder(compoundBorder);
        
        JButton productos = new JButton("Productos");
        buttonConfig(productos);
        JButton configurar = new JButton("Configurar");
        buttonConfig(configurar);
   
        
        this.add(Box.createHorizontalStrut(5));  
        this.add(fecha);
        this.add(space);
        this.add(Box.createHorizontalStrut(5));
        this.add(tiempo);
        this.add(Box.createHorizontalStrut(15)); 
        this.add(productos);
        this.add(Box.createHorizontalStrut(15)); 
        this.add(configurar);
        this.add(Box.createHorizontalStrut(5)); 
        
        
        productos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ProductosOrden(orden);
            }
        });
        
        configurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ConfigurarOrden(orden);
            }
        });
        
    
		
		
	}
	
	
	private void buttonConfig(JButton button1) {
	    button1.setFont(new Font("Antipasto", Font.PLAIN, 15));
	    button1.setForeground(Color.WHITE);
	    button1.setBackground(new Color(60,80,91,255));
	    Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
	    Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
	    Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        button1.setBorder(compoundBorder);
	    button1.setPreferredSize(new Dimension(180, 50));
	    button1.setFocusable(false);

	    button1.addMouseListener(new MouseAdapter() {
	       
	   	 @Override
	        public void mouseEntered(MouseEvent e) {
	        	 button1.setOpaque(true);
	            button1.setBackground(new Color(80,100,111,255));
	            button1.setForeground(Color.WHITE);
	            Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 3);
	            Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
	            Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
	            button1.setBorder(compoundBorder);
	            //button1.setFont(new Font("Code Light", Font.PLAIN, 42));
	        }
	        

	        @Override
	        public void mouseExited(MouseEvent e) {
	    	    button1.setBackground(new Color(60,80,91,255));
	            button1.setForeground(Color.WHITE);
	            button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	            Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
	            Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
	            Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
	            button1.setBorder(compoundBorder);
	            //button1.setFont(new Font("Code Light", Font.PLAIN, 40));
	    	}
		});
	}
	
}
