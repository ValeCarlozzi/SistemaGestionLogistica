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

import DB.ConexionDB;
import TP.Camino;
import TP.OrdenDeProvision;
import TP.Recorrido;

public class ListaItemRecorrido extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ListaItemRecorrido(Recorrido recorrido, OrdenDeProvision orden, VentanaCaminosOrden main){
		
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//boton gestionar
		JButton elegir = new JButton("ELEGIR");
        buttonConfig(elegir);
      
        
        //labels de informacion del producto
        JLabel id = new JLabel("Origen: " + recorrido.getSucursalOrigen().id().toString());
        id.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        id.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        id.setFont(new Font("Antipasto", Font.PLAIN, 15));
        id.setForeground(Color.WHITE);
        id.setPreferredSize(new Dimension(120, 30));
        Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 15, 14, 15);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        id.setBorder(compoundBorder);
        
        
        JLabel recor = new JLabel("Caminos recorridos: ");
        recor.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        recor.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        recor.setFont(new Font("Antipasto", Font.PLAIN, 15));
        recor.setForeground(Color.WHITE);
        recor.setPreferredSize(new Dimension(120, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        recor.setBorder(compoundBorder);
        
        JLabel destino = new JLabel("Destino:" + recorrido.getSucursalDestino().id().toString());
        destino.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        destino.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        destino.setFont(new Font("Antipasto", Font.PLAIN, 15));
        destino.setForeground(Color.WHITE);
        destino.setPreferredSize(new Dimension(120, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        destino.setBorder(compoundBorder);
        
        JLabel camino = new JLabel();
        camino.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        camino.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        camino.setFont(new Font("Antipasto", Font.PLAIN, 15));
        camino.setForeground(Color.WHITE);
        camino.setPreferredSize(new Dimension(30, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        camino.setBorder(compoundBorder);
        
        JLabel tiempo = new JLabel("Tiempo: " + recorrido.getTiempo().toString() + "hs");
        tiempo.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        tiempo.setVerticalAlignment(SwingConstants.CENTER);   // Center text vertically
        tiempo.setFont(new Font("Antipasto", Font.PLAIN, 15));
        tiempo.setForeground(Color.WHITE);
        tiempo.setPreferredSize(new Dimension(80, 30));
        existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        emptyBorder = BorderFactory.createEmptyBorder(14, 10, 14, 10);
        compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        tiempo.setBorder(compoundBorder);
        
        this.add(Box.createHorizontalStrut(5));  
        this.add(id);
        this.add(Box.createHorizontalStrut(5));  
        this.add(recor);
        
        
        for(Camino caminoR : recorrido.getCaminos()) {
        	camino.setText(caminoR.getID().toString());
            this.add(camino); 	
        }
        this.add(Box.createHorizontalStrut(5));  
        this.add(destino);
        this.add(Box.createHorizontalStrut(5));  
        this.add(tiempo);
        this.add(Box.createHorizontalStrut(5));  
        this.add(elegir);
        this.add(Box.createHorizontalStrut(5));  

        elegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		new ConexionDB().setOrdenEnProceso(orden);
            		main.dispose();
            		} catch (Exception e2) {
					new VentanasError(e2.getMessage());
				}
            	
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
	    Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border emptyBorder = BorderFactory.createEmptyBorder(14, 30, 14, 30);
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
	    button1.setBorder(compoundBorder);
	    button1.addMouseListener(new MouseAdapter() {
	       
	   	 @Override
	        public void mouseEntered(MouseEvent e) {
	        	 button1.setOpaque(true);
	            button1.setBackground(new Color(80,100,111,255));
	            button1.setForeground(Color.WHITE);
	            button1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
	            Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
	            Border emptyBorder = BorderFactory.createEmptyBorder(14, 30, 14, 30);
	            Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
	    	    button1.setBorder(compoundBorder);
	            //button1.setFont(new Font("Code Light", Font.PLAIN, 42));
	        }
	        

	        @Override
	        public void mouseExited(MouseEvent e) {
	        	 button1.setOpaque(false);
	            button1.setForeground(Color.WHITE);
	            button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	            Border existingBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
	            Border emptyBorder = BorderFactory.createEmptyBorder(14, 30, 14, 30);
	            Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
	    	    button1.setBorder(compoundBorder);
	            //button1.setFont(new Font("Code Light", Font.PLAIN, 40));
	    	}
		});
	}
	
	
}
