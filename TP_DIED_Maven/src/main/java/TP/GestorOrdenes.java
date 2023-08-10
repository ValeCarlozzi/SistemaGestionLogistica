package TP;

import java.time.LocalDate;
import java.sql.Date;
import java.util.HashMap;

import DB.ConexionDB;

public class GestorOrdenes {

	public void altaOrden(Sucursal sucursal, HashMap<String, Integer> listaProductos, Integer horas) throws Exception  {
		
		ConexionDB conexion = new ConexionDB();
		
		Date fecha = Date.valueOf(LocalDate.now());
		
		OrdenDeProvision orden = new OrdenDeProvision(fecha,sucursal.id(),horas);
		orden.setListaProductos(listaProductos);
	
		try {
			
			conexion.crearOrdenProvision(orden);
			
		} catch (Exception e) {
			throw e;
		}
		
	
		
		
		return;
	}
	
	public OrdenDeProvision generarOrden(Sucursal sucursal, HashMap<String, Integer> listaProductos, Integer horas) {
		
		Date fecha = Date.valueOf(LocalDate.now());
		
		OrdenDeProvision orden = new OrdenDeProvision(fecha,sucursal.id(),horas);
		orden.setListaProductos(listaProductos);
		
		return orden;
	}
	
}
