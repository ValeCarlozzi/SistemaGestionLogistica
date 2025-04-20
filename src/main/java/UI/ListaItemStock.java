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

import TP.Stock;

public class ListaItemStock extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ListaItemStock(Stock stock, StockWindow main){
		
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
        JLabel nombre = new JLabel(stock.getNombre());
        nombre.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        nombre.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        nombre.setFont(new Font("Antipasto", Font.PLAIN, 15));
        nombre.setForeground(Color.WHITE);
        nombre.setPreferredSize(new Dimension(120, 30));
        Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 3, 14, 3);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        nombre.setBorder(compoundBorder);
        
     
        
        JLabel cantStock = new JLabel(stock.getStockProducto().toString());
        cantStock.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        cantStock.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        cantStock.setFont(new Font("Antipasto", Font.PLAIN, 15));
        cantStock.setForeground(Color.WHITE);
        cantStock.setPreferredSize(new Dimension(80, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 2, 14, 2);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        cantStock.setBorder(compoundBorder);
        
        
       
        Dimension maxComponentSize = new Dimension(Integer.MAX_VALUE, editar.getPreferredSize().height);
        editar.setMaximumSize(maxComponentSize);
        baja.setMaximumSize(maxComponentSize);
        gestionar.setMaximumSize(maxComponentSize);
        
        
        this.add(Box.createHorizontalStrut(5));  
        this.add(nombre);
        this.add(Box.createHorizontalStrut(1));
        this.add(cantStock);
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
            	new Editar(stock,main);
            }
        });
        
        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Baja(stock,main);
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
