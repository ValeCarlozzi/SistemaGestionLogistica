package TP;

import java.util.ArrayList;

import DB.ConexionDB;
import UI.VentanasError;


public class ListaCaminos {
	
ArrayList<Camino> lista = new ArrayList<Camino>();
	
	public ListaCaminos(){
	
		try {
			lista = new ConexionDB().crearListadeCaminos();
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}
		
	
		
	//TODO PIDO A LA BASE DE DATOS
	
		/*
		//creo sucursales
		Integer id;
		Integer origen;
		Integer destino;
		Integer tiempoTransito;
		Integer capMaxima;
		TipoEstadoSucursal estado;
		Camino camino1;
		Camino camino2;
		Camino camino3;
		Camino camino4;
		Camino camino5;
		Camino camino6;
		Camino camino7;
		Camino camino8;
		Camino camino9;

		
		id = 1;
		origen = 1;
		destino = 2;
		tiempoTransito = 8;
		capMaxima = 15;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino1 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		
		id = 2;
		origen = 1;
		destino = 3;
		tiempoTransito = 8;
		capMaxima = 12;
		estado = TipoEstadoSucursal.NO_OPERATIVA;
		camino2 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		id = 3;
		origen = 2;
		destino = 4;
		tiempoTransito = 8;
		capMaxima = 12;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino3 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		id = 4;
		origen = 2;
		destino = 5;
		tiempoTransito = 8;
		capMaxima = 1;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino4 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		id = 5;
		origen = 2;
		destino = 3;
		tiempoTransito = 8;
		capMaxima = 10;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino5 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		id = 6;
		origen = 3;
		destino = 5;
		tiempoTransito = 8;
		capMaxima = 14;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino6 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		id = 7;
		origen = 5;
		destino = 4;
		tiempoTransito = 8;
		capMaxima = 10;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino7 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		id = 8;
		origen = 4;
		destino = 6;
		tiempoTransito = 8;
		capMaxima = 25;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino8 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		id = 9;
		origen = 5;
		destino = 6;
		tiempoTransito = 8;
		capMaxima = 4;
		estado = TipoEstadoSucursal.OPERATIVA;
		camino9 = new Camino(id, origen, destino, capMaxima, estado, tiempoTransito);
		
		lista.add(camino1);
		lista.add(camino2);
		lista.add(camino3);
		lista.add(camino4);
		lista.add(camino5);
		lista.add(camino6);
		lista.add(camino7);
		lista.add(camino8);
		lista.add(camino9);
		*/
	}

	public ArrayList<Camino> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Camino> lista) {
		this.lista = lista;
	}

}
