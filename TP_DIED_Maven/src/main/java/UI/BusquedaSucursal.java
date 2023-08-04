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
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import TP.Sucursal;

public class BusquedaSucursal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BusquedaSucursal(MenuPrincipal main){
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Busqueda Sucursales");
	    this.setSize(500, 500); // Set your preferred size
	    this.setLocationRelativeTo(null); // Center the frame on the screen
	    ImageIcon customIcon = new ImageIcon("LogoApp.png");
        this.setIconImage(customIcon.getImage());
		
	    //background panel (extiende JPanel)
	    Background backgroundPanel = new Background("C:/Users/valec/OneDrive/Desktop/UI_resources/Background.jpg");
	    this.setContentPane(backgroundPanel);
	    

	    JPanel panel = new JPanel(new GridBagLayout());
	    panel.setOpaque(false);
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    JLabel aviso = new JLabel("DEJAR ESPACIO VACIO PARA IGNORAR EL CAMPO EN LA BUSQUEDA");
	    aviso.setForeground(Color.WHITE);
	    gbc.gridx = 0; 
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
	    gbc.insets = new Insets(5, 10, 10, 10); 
	    panel.add(aviso,gbc);
	    
	    JLabel idLabel = new JLabel("ID de la sucursal:");
	    idLabel.setForeground(Color.WHITE);
	    gbc.gridy = 1;
	    gbc.insets = new Insets(10, 10, 0, 10); 
	    panel.add(idLabel,gbc);
	    
	    NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
	    
	    JFormattedTextField id = new JFormattedTextField(formatter);
	    Dimension preferredSize = new Dimension(id.getPreferredSize().width, 30); 
	    id.setPreferredSize(preferredSize);
	    id.setForeground(Color.WHITE);
	    id.setOpaque(false);
	    id.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 2;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(id,gbc);
	    
	    JLabel nombreLabel = new JLabel("Nombre de la sucursal:");
	    nombreLabel.setForeground(Color.WHITE);
	    gbc.gridy = 3;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(nombreLabel,gbc);
	    
	    JFormattedTextField nombre = new JFormattedTextField();
	    preferredSize = new Dimension(nombre.getPreferredSize().width, 30); 
	    nombre.setPreferredSize(preferredSize);
	    nombre.setForeground(Color.WHITE);
	    nombre.setOpaque(false);
	    nombre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 4;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(nombre,gbc);
	    
	    JCheckBox estado = new JCheckBox("Operativa");
	    estado.setSelected(true); // Set the initial state (checked or unchecked)
	    estado.setEnabled(true); // Set if the checkbox is enabled or disabled (true = enabled, false = disabled)
	    estado.setForeground(Color.WHITE);
	    estado.setOpaque(false);
	    gbc.gridy = 5;
	    gbc.insets = new Insets(10, 10, 10, 10);
	    panel.add(estado,gbc);
	    
	    JLabel aperturaLabel = new JLabel("Horario de apertura:");
	    aperturaLabel.setForeground(Color.WHITE);
	    gbc.gridy = 6;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(aperturaLabel,gbc);
	    
	    JFormattedTextField apertura = new JFormattedTextField();
	    preferredSize = new Dimension(apertura.getPreferredSize().width, 30); 
	    apertura.setPreferredSize(preferredSize);
	    apertura.setForeground(Color.WHITE);
	    apertura.setOpaque(false);
	    apertura.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 7;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(apertura,gbc);
	    
	    JLabel cierreLabel = new JLabel("Horario de ciere:");
	    cierreLabel.setForeground(Color.WHITE);
	    gbc.gridy = 8;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(cierreLabel,gbc);
	    
	    JFormattedTextField cierre = new JFormattedTextField();
	    preferredSize = new Dimension(cierre.getPreferredSize().width, 30); 
	    cierre.setPreferredSize(preferredSize);
	    cierre.setForeground(Color.WHITE);
	    cierre.setOpaque(false);
	    cierre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 9;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(cierre,gbc);
	    
	    JButton cancelar = new JButton("Cancelar");
	    buttonConfig(cancelar);
	    gbc.gridy = 10;
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
	    	
	    	Integer intValue = null;
			String nomb = null;
			String ap = null;
			String cier = null;
			Boolean est = null;

			try {
				id.commitEdit();
				nombre.commitEdit();
				apertura.commitEdit();
				cierre.commitEdit();
			} catch (ParseException e1) {
			}
	
			try {
				
				intValue = (Integer) id.getValue();
				
				if(!(nombre.getText().isEmpty())) {
					nomb = nombre.getText();
				}
				if(!(apertura.getText().isEmpty())) {
					ap = apertura.getText();
				}
				if(!(cierre.getText().isEmpty())) {
					cier = cierre.getText();
				}
				
				est = estado.isSelected();

			} catch (Exception e2) {
				new VentanasError(e2.getMessage());
			}

			final Integer finalValue = intValue;
			final String finalnomb = nomb;
			final String finalap = ap;
			final String finalcier = cier;
			final String finalest;

			if(est) {
				finalest = "Operativa";
			}else {
				finalest = "No Operativa";
			}
			
	
			
			Predicate<Sucursal> predicado = s -> {
			
				if( (finalValue == null || finalValue == s.id()) &&
					(finalnomb == null || finalnomb.equals(s.getNombre())) &&
					(finalap == null || finalap.equals(s.getHorarioApertura())) &&
					(finalcier == null || finalcier.equals(s.getHorarioCierre())) &&
					(finalest == null || finalest == s.estadoToString())) {
					return true;
				}
				else return false;
			
			};		
			
			try {
					ArrayList<Sucursal> listaNueva = (ArrayList<Sucursal>) main.getListaSucursal().stream()	
							.filter(predicado)
							.collect(Collectors.toList());
					
					main.setContentPane(main.sucursalScreen(listaNueva));
					main.revalidate();
					this.dispose();

					
				} catch (Exception e3) {
					new VentanasError(e3.getMessage());
				}
	    	
	    });
	    
	    cancelar.addActionListener(e -> {
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
