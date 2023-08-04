package TP;


import java.util.ArrayList;

import DB.ConexionDB;
import UI.VentanasError;

public class ListaOrdenes {

	ArrayList<OrdenDeProvision> lista = new ArrayList<OrdenDeProvision>();
	
	public ListaOrdenes(Sucursal sucursal){
		
		try {
			lista = new ConexionDB().crearListaOrdenes(sucursal.id());
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}
		
	}
	
	public ArrayList<OrdenDeProvision> getLista() {
		return lista;
	}
	
}
