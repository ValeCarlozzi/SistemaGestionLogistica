package TP;

import java.util.ArrayList;

import DB.ConexionDB;
import UI.VentanasError;

public class ListaStock {

	ArrayList<Stock> lista = new ArrayList<Stock>();

	
	public ListaStock(Sucursal sucursal) {
			
		try {
			lista = new ConexionDB().crearListaStockSucursal(sucursal);
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}
		
	}
	
	public ArrayList<Stock> getLista() {
		return lista;
	}
	
}
