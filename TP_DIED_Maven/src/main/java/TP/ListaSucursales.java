package TP;

import java.util.ArrayList;

import DB.ConexionDB;
import UI.VentanasError;


public class ListaSucursales {

	ArrayList<Sucursal> lista = new ArrayList<Sucursal>();
	
	public ListaSucursales() {

		try {
			lista = new ConexionDB().crearListadeSucursales();
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}

	}

	public ArrayList<Sucursal> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Sucursal> lista) {
		this.lista = lista;
	}
	
}
