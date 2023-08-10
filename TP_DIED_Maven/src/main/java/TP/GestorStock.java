package TP;

import DB.ConexionDB;

public class GestorStock  {

	public void altaStock(Integer idSucursal, String nombre, Integer cantidad) throws Exception {

		Stock stock = new Stock(idSucursal,nombre,cantidad);
		
		try {
			new ConexionDB().crearStock(stock);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
public void modificarStock(Integer idSucursal, String nombre, Integer cantidad) throws Exception {
		
		Stock stock= new Stock(idSucursal,nombre,cantidad);
		
		try {
			new ConexionDB().modificarStock(stock);

		} catch (Exception e) {
			throw e;
		}
		
}

public void bajaStock(Stock stock) throws Exception {
	
	try {
		new ConexionDB().borrarStock(stock);
	} catch (Exception e) {
		throw e;
	}
	
}
	
}
