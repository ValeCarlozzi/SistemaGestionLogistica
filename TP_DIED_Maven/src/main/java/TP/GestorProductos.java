package TP;

import DB.ConexionDB;

public class GestorProductos {

	public void altaProducto(String nombre, String descripcion, Double precioUnitario, Double peso) throws Exception {

		Producto producto = new Producto(nombre,descripcion,precioUnitario,peso);
		
		try {
			new ConexionDB().crearProducto(producto);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
public void modificarProducto(String nombre, String descripcion, Double precioUnitario, Double peso) throws Exception {
		
		Producto producto = new Producto(nombre,descripcion,precioUnitario,peso);
		
		try {
			new ConexionDB().modificarProducto(producto);

		} catch (Exception e) {
			throw e;
		}
		
}

public void bajaProducto(Producto producto) throws Exception {
	
	try {
		new ConexionDB().borrarProducto(producto);
	} catch (Exception e) {
		throw e;
	}
	
}
	
}