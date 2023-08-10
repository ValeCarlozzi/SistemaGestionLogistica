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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import TP.Camino;
import TP.GestorCaminos;
import TP.TipoEstadoSucursal;


public class AltaCamino extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AltaCamino(MenuPrincipal main){
	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Alta Camino");
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
	    
	    JLabel idLabel = new JLabel("ID del camino:");
	    idLabel.setForeground(Color.WHITE);
	    gbc.gridx = 0; 
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.BOTH; 
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
	    gbc.gridy = 1;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(id,gbc);
	    
	    JCheckBox estado = new JCheckBox("Operativa");
	    estado.setSelected(true); // Set the initial state (checked or unchecked)
	    estado.setEnabled(true); // Set if the checkbox is enabled or disabled (true = enabled, false = disabled)
	    estado.setForeground(Color.WHITE);
	    estado.setOpaque(false);
	    gbc.gridy = 2;
	    gbc.insets = new Insets(10, 10, 10, 10);
	    panel.add(estado,gbc);
	    
	    JLabel origenLabel = new JLabel("ID de sucursal de origen:");
	    origenLabel.setForeground(Color.WHITE);
	    gbc.gridy = 3;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(origenLabel,gbc);
	    
	    JFormattedTextField idOrigen = new JFormattedTextField(formatter);
	    preferredSize = new Dimension(idOrigen.getPreferredSize().width, 30); 
	    idOrigen.setPreferredSize(preferredSize);
	    idOrigen.setForeground(Color.WHITE);
	    idOrigen.setOpaque(false);
	    idOrigen.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 4;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(idOrigen,gbc);
	    
	    JLabel destinoLabel = new JLabel("ID de sucursal de destino:");
	    destinoLabel.setForeground(Color.WHITE);
	    gbc.gridy = 5;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(destinoLabel,gbc);
	    
	    JFormattedTextField idDestino = new JFormattedTextField(formatter);
	    preferredSize = new Dimension(idDestino.getPreferredSize().width, 30); 
	    idDestino.setPreferredSize(preferredSize);
	    idDestino.setForeground(Color.WHITE);
	    idDestino.setOpaque(false);
	    idDestino.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 6;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(idDestino,gbc);
	    
	    JLabel tiempoTransitoLabel = new JLabel("Tiempo de transito:");
	    tiempoTransitoLabel.setForeground(Color.WHITE);
	    gbc.gridy = 7;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(tiempoTransitoLabel,gbc);
	    
	    JFormattedTextField tiempoTransito = new JFormattedTextField(formatter);
	    preferredSize = new Dimension(tiempoTransito.getPreferredSize().width, 30); 
	    tiempoTransito.setPreferredSize(preferredSize);
	    tiempoTransito.setForeground(Color.WHITE);
	    tiempoTransito.setOpaque(false);
	    tiempoTransito.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 8;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(tiempoTransito,gbc);
	    
	    JLabel capMaximaLabel = new JLabel("Capacidad maxima de carga:");
	    capMaximaLabel.setForeground(Color.WHITE);
	    gbc.gridy = 9;
	    gbc.insets = new Insets(10, 10, 0, 10);
	    panel.add(capMaximaLabel,gbc);
	    
	    JFormattedTextField integerInput = new JFormattedTextField(formatter);
	    preferredSize = new Dimension(integerInput.getPreferredSize().width, 30); 
	    integerInput.setPreferredSize(preferredSize);
	    integerInput.setForeground(Color.WHITE);
	    integerInput.setOpaque(false);
	    integerInput.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); 
	    gbc.gridy = 10;
	    gbc.insets = new Insets(1, 10, 10, 10);
	    panel.add(integerInput,gbc);
	    
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

			try {
				id.commitEdit();
				idOrigen.commitEdit();
				idDestino.commitEdit();
				tiempoTransito.commitEdit();
				integerInput.commitEdit();
			} catch (ParseException e1) {

			}

			Boolean est = null;
			Integer idVal = null;
			Integer origenVal = null;
			Integer destinoVal = null;
			Integer tiempoVal = null;
			Integer capVal = null;

			est = estado.isSelected();
			idVal = (Integer) id.getValue();
			origenVal = (Integer) idOrigen.getValue();
			destinoVal = (Integer) idDestino.getValue();
			tiempoVal = (Integer) tiempoTransito.getValue();
			capVal = (Integer) integerInput.getValue();

			if (idVal == null || origenVal == null || destinoVal == null || tiempoVal == null || capVal == null) {
				new VentanasError("No se permiten valores nulos");
			} else {
				try {
					
					new GestorCaminos().altaCamino(idVal, origenVal, destinoVal, capVal, est, tiempoVal);

					TipoEstadoSucursal estad;
					
					if(est) {
						estad = TipoEstadoSucursal.OPERATIVA;
					}
					else {
						estad = TipoEstadoSucursal.NO_OPERATIVA;
					}

					Camino cam = new Camino(idVal, origenVal,destinoVal,capVal,estad,tiempoVal);
					
					ArrayList<Camino> listaNueva = main.getListaCamino();
					listaNueva.add(cam);
					main.setContentPane(main.caminosScreen(listaNueva));
					main.revalidate();
					this.dispose();
					
				} catch (Exception e2) {
					new VentanasError(e2.getMessage());
				}
				
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
