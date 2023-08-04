package UI;

import TP.OrdenDeProvision;
import TP.Stock;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class ListaTab extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	ListaTab(String tipo){
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        this.setBorder(border);

		JScrollPane scrollPane = new JScrollPane(new ListaPane(tipo));
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportBorder(null);
		
		// Set a custom ScrollBarUI on the vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        verticalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setUI(new CustomScrollBarUI());
        horizontalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        horizontalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
	
		this.add(scrollPane);
	}
	*/
	/*
	ListaTab(ArrayList<?> lista){
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        this.setBorder(border);

		JScrollPane scrollPane = new JScrollPane(new ListaPane(lista));
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportBorder(null);
		
		// Set a custom ScrollBarUI on the vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        verticalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setUI(new CustomScrollBarUI());
        horizontalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        horizontalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
	
		this.add(scrollPane);
	}
	*/
	
	ListaTab(ArrayList<?> lista, MenuPrincipal main){
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        this.setBorder(border);

		JScrollPane scrollPane = new JScrollPane(new ListaPane(lista, main));
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportBorder(null);
		
		// Set a custom ScrollBarUI on the vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        verticalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setUI(new CustomScrollBarUI());
        horizontalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        horizontalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
	
		this.add(scrollPane);
	}
	
	ListaTab(ArrayList<Stock> lista, StockWindow main){
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        this.setBorder(border);

		JScrollPane scrollPane = new JScrollPane(new ListaPane(lista, main));
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportBorder(null);
		
		// Set a custom ScrollBarUI on the vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        verticalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setUI(new CustomScrollBarUI());
        horizontalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        horizontalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
	
		this.add(scrollPane);
	}

	
	ListaTab(ArrayList<OrdenDeProvision> listaOrdenes, OrdenesProvisionWindow main){
		
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        this.setBorder(border);

		JScrollPane scrollPane = new JScrollPane(new ListaPane(listaOrdenes , main));
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportBorder(null);
		
		// Set a custom ScrollBarUI on the vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        verticalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setUI(new CustomScrollBarUI());
        horizontalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        horizontalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
	
		this.add(scrollPane);
		
	}
	
	ListaTab(HashMap<String,Integer> listaProductos){
		
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        this.setBorder(border);

		JScrollPane scrollPane = new JScrollPane(new ListaPane(listaProductos));
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportBorder(null);
		
		// Set a custom ScrollBarUI on the vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        verticalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
        
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setUI(new CustomScrollBarUI());
        horizontalScrollBar.setUnitIncrement(17); // Change the unit increment to 20 pixels
        horizontalScrollBar.setBlockIncrement(200); // Change the block increment to 200 pixels
	
		this.add(scrollPane);

		
	}

//Custom ScrollBarUI class
class CustomScrollBarUI extends BasicScrollBarUI {
 // Override the necessary methods to customize the scrollbar appearance
 @Override
 protected void configureScrollBarColors() {
     // Set custom colors for the scrollbar
     this.thumbColor = (new Color(255,255,255,55));
     this.thumbDarkShadowColor = (new Color(255,255,255,0));
     this.thumbHighlightColor = (new Color(255,255,255,255));
     this.thumbLightShadowColor = (new Color(255,255,255,0));
     this.trackColor = (new Color(60,80,91,255));
     this.trackHighlightColor = (new Color(255,255,255,0));
 }

 @Override
 protected JButton createDecreaseButton(int orientation) {
     return createZeroButton();
 }

 @Override
 protected JButton createIncreaseButton(int orientation) {
     return createZeroButton();
 
 }

 private JButton createZeroButton() {
     JButton button = new JButton();
     Dimension zeroDim = new Dimension(0, 0);
     button.setPreferredSize(zeroDim);
     button.setMinimumSize(zeroDim);
     button.setMaximumSize(zeroDim);
     return button;
 	}
 
}
 
 public void ordenar(String atributo, Integer id) {
	 //TODO
	 return;
 }
 
 public void ordenar(String atributo, String s ) {
	 //TODO
	 return;
 }

}
 
