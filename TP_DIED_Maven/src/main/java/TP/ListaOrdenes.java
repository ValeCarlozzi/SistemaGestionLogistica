package TP;


import java.util.ArrayList;
import java.util.stream.Collectors;

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
	
	public ArrayList<OrdenDeProvision> getListaOrdenesPendientes() {
		
		ArrayList<OrdenDeProvision> listaPendientes = (ArrayList<OrdenDeProvision>) lista.stream()
															.filter(e -> e.getEstadoString() == "PENDIENTE")
															.collect(Collectors.toList());
		
		return listaPendientes;
	}
	
}
