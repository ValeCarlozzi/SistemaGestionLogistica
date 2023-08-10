package UI;

public class test {

	public static void main(String[] args) {
		
		
		/*
		//creo frame
		JFrame frame = new JFrame("testing attention please");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("ejemplix");
		
		//creo panel
		JPanel panelDeContenido = new JPanel();
		frame.setContentPane(panelDeContenido);
		
		//eleentos del panel
		JLabel etiqueta1 = new JLabel("Texto etiqueta");
		JTextField campoDeTexto = new JTextField(20);
		JButton boton = new JButton("Boton");
		
		//agrego los elementos
		panelDeContenido.add(etiqueta1);
		panelDeContenido.add(campoDeTexto);
		panelDeContenido.add(boton);
		
		//armo todo
		frame.pack();
		frame.setSize(800, 500);
		frame.setVisible(true);
		*/
		
		MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
		
        SucursalesWindow sucursales = new SucursalesWindow();
        sucursales.setVisible(true);
        
		
	}

}
