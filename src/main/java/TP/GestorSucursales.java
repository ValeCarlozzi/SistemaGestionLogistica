package TP;

import DB.ConexionDB;

public class GestorSucursales {

	public void altaSucursal(Integer id, String nombre, Boolean estado, String apertura, String cierre) throws Exception {
 	
		
		TipoEstadoSucursal est;
		
		if(estado == true) {
			est = TipoEstadoSucursal.OPERATIVA;
		}
		else {
			est = TipoEstadoSucursal.NO_OPERATIVA;
		}
		
		Sucursal sucursal = new Sucursal(id,nombre,apertura,cierre,est);
		
		try {
			new ConexionDB().crearSucursal(sucursal);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void modificarSucursal(Integer id, String nombre, Boolean estado, String apertura, String cierre ) throws Exception {
		
		TipoEstadoSucursal est;
		
		if(estado) {
			est = TipoEstadoSucursal.OPERATIVA;
		}
		else {
			est = TipoEstadoSucursal.NO_OPERATIVA;
		}
		
		Sucursal sucursal = new Sucursal(id,nombre,apertura,cierre,est);
		try {
			new ConexionDB().modificarSucursal(sucursal);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void bajaSucursal(Sucursal sucursal) throws Exception {
		
		try {
			new ConexionDB().borrarSucursal(sucursal);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
