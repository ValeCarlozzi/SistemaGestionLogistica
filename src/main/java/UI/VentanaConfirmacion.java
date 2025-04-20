package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaConfirmacion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaConfirmacion(String texto, String nombreVentana){
		
		crearVentana(texto, nombreVentana);

		JButton aceptar = new JButton("Aceptar");
		buttonConfig(aceptar);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(15, 15, 15, 15);
		this.getContentPane().add(aceptar, gbc);

		aceptar.addActionListener(e -> {
			this.dispose();
		});

		
	}
	
	private void crearVentana(String texto, String nombreVentana) {

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(nombreVentana);
		this.setSize(500, 500); // Set your preferred size
		this.setLocationRelativeTo(null); // Center the frame on the screen

		Background backgroundPanel = new Background("Background.jpg");
		this.setContentPane(backgroundPanel);
		ImageIcon customIcon = new ImageIcon("LogoApp.png");
	    this.setIconImage(customIcon.getImage());
	        
		JLabel aviso = new JLabel(texto);
		aviso.setForeground(Color.WHITE);
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setVerticalAlignment(SwingConstants.CENTER);
		aviso.setFont(new Font("Antipasto", Font.PLAIN, 20));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 10, 10, 10);
		backgroundPanel.add(aviso, gbc);

		this.setVisible(true);

	}

	private void buttonConfig(JButton button1) {
		button1.setOpaque(false);
		button1.setFont(new Font("Code Light", Font.PLAIN, 13));
		button1.setForeground(Color.WHITE);
		button1.setBackground(new Color(0, 0, 0, 70));
		button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		button1.setPreferredSize(new Dimension(180, 50));
		button1.setFocusable(false);

		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setOpaque(true);
				button1.setBackground(new Color(60, 80, 91, 255));
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
