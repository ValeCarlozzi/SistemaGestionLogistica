package TP;

import java.util.ArrayList;
import java.util.HashMap;

import DB.ConexionDB;
import UI.VentanasError;

public class ConfigurarOrden {

	public ConfigurarOrden(OrdenDeProvision orden){
		
		ArrayList<Integer> idSucursalesDisponibles = new ArrayList<Integer>();
				
		ArrayList<Stock> stockSucursales = null;
		
		try {
			stockSucursales = new ConexionDB().crearListaStock();
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}
		for(Stock s : stockSucursales) {
			System.out.println(s.getIdSucursal());
		}
		System.out.println("-----------------");
		
		
		HashMap <String, Integer> productosOrden = orden.getListaProductos();
		
		Integer id = null;
		HashMap<String,Integer> sublista = new HashMap<String,Integer>();
		
		Stock stock;
		
		for (int i = 0; i <= stockSucursales.size(); i++) {

			if (i != stockSucursales.size()) {
				stock = stockSucursales.get(i);

				if (id == null) {

					id = stock.getIdSucursal();
					sublista.put(stock.getNombre(), stock.getStockProducto());

					System.out.println("----sublista-----");
					System.out.println(id + " | " + stock.getNombre() + " | " + sublista.get(stock.getNombre()));

				} else if (id != stock.getIdSucursal()) {

					System.out.println("LLAMO CON " + id);
					if (tieneStock(id, sublista, productosOrden)) {
						idSucursalesDisponibles.add(id);
						System.out.println("AGREGO " + id);
					}

					sublista = new HashMap<String, Integer>();

					id = stock.getIdSucursal();

					sublista.put(stock.getNombre(), stock.getStockProducto());
					System.out.println("-----------------");
					System.out.println("----sublista-----");
					System.out.println(id + " | " + stock.getNombre() + " | " + sublista.get(stock.getNombre()));

				} else {
					sublista.put(stock.getNombre(), stock.getStockProducto());
					System.out.println(id + " | " + stock.getNombre() + " | " + sublista.get(stock.getNombre()));
				}

			}
			else {
				System.out.println("LLAMO CON " + id);
				if (tieneStock(id, sublista, productosOrden)) {
					idSucursalesDisponibles.add(id);
					System.out.println("AGREGO " + id);
				}
			}
			
			
			
		}
		
		
		
		ArrayList<Sucursal> sucursales = null;
		
		try {
			sucursales = new ConexionDB().crearListadeSucursales();
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}
		
		ArrayList<Sucursal> sucursalesDisponibles = new ArrayList<Sucursal>();
		
		for(Sucursal sucursal : sucursales) {
			if(idSucursalesDisponibles.contains(sucursal.id()) && sucursal.estadoToString() == "Operativa") {
				sucursalesDisponibles.add(sucursal);
			}
		}
		
		System.out.println("-               -");
		System.out.println("----resultado----");
		for(Sucursal id1 : sucursalesDisponibles) {
			System.out.println(id1.id());
		}
		
		
	}
	
	private boolean tieneStock(Integer id, HashMap<String, Integer> sublista, HashMap<String, Integer> listaProductos) {

		if (sublista.keySet().containsAll(listaProductos.keySet())) {

			for (String prod : listaProductos.keySet()) {

				if (listaProductos.get(prod) > sublista.get(prod)) {
					return false;
				}

			}
			
			return true;

		}
		else {
			return false;
		}
		
	}
	
}
