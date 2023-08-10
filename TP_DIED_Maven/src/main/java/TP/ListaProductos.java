package TP;

import java.util.ArrayList;

import DB.ConexionDB;
import UI.VentanasError;

public class ListaProductos {

	ArrayList<Producto> lista = new ArrayList<Producto>();
	
	public ListaProductos(){

		try {
			lista = new ConexionDB().crearListadeProductos();
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}
		

		
		//instead
		/*
			//creo sucursales
			String nombre;
			String descripcion;
			Double precioUnitario;
			Double peso;
			
			Producto producto1;
			Producto producto2;
			Producto producto3;
			Producto producto4;
			Producto producto5;
			Producto producto6;
			
			nombre = "producto1";
			descripcion = "descripcion teeeeeeeeeeeeeeeeeeeeeeeeeeeest";
			precioUnitario = (double) 69000;
			peso = (double) 50;
			producto1 = new Producto(nombre, descripcion, precioUnitario, peso);
			
			nombre = "producto2";
			descripcion = "descripcion";
			precioUnitario = (double) 69;
			peso = (double) 1000;
			producto2 = new Producto(nombre, descripcion, precioUnitario, peso);

			nombre = "producto3";
			descripcion = "descripcion";
			precioUnitario = (double) 69;
			peso = (double) 50;
			producto3 = new Producto(nombre, descripcion, precioUnitario, peso);

			nombre = "producto4";
			descripcion = "descripcion";
			precioUnitario = (double) 69;
			peso = (double) 50;
			producto4 = new Producto(nombre, descripcion, precioUnitario, peso);
			
			nombre = "producto5";
			descripcion = "descripcion";
			precioUnitario = (double) 69;
			peso = (double) 50;
			producto5 = new Producto(nombre, descripcion, precioUnitario, peso);
			
			nombre = "producto6";
			descripcion = "descripcion";
			precioUnitario = (double) 69;
			peso = (double) 50;
			producto6 = new Producto(nombre, descripcion, precioUnitario, peso);
			
			
			lista.add(producto1);
			lista.add(producto2);
			lista.add(producto3);
			lista.add(producto4);
			lista.add(producto5);
			lista.add(producto6);
			*/
		}

		public ArrayList<Producto> getLista() {
			return lista;
		}

		public void setLista(ArrayList<Producto> lista) {
			this.lista = lista;
		}
	}
	
