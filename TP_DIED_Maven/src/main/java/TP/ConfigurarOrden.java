package TP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import DB.ConexionDB;
import UI.VentanaCaminosOrden;
import UI.VentanasError;

public class ConfigurarOrden {

	public ConfigurarOrden(OrdenDeProvision orden){
		
		//primero consigo las sucursales que pueden enviar el pedido
		ArrayList<Integer> idSucursalesDisponibles = new ArrayList<Integer>();
				
		ArrayList<Stock> stockSucursales = null;
		
		try {
			stockSucursales = new ConexionDB().crearListaStock();
		} catch (Exception e) {
			new VentanasError(e.getMessage());
		}
		
		
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

				} else if (id != stock.getIdSucursal()) {

					//chequeo que la sublista (lista de stocks en UNA sucursal) contenga todos los productos de la orden y sus cantidades necesarias
					if (tieneStock(id, sublista, productosOrden)) {
						//si puede hacer el pedido se agrega el id a los id de sucursales disponibles para el pedido
						idSucursalesDisponibles.add(id);	
					}

					sublista = new HashMap<String, Integer>();

					id = stock.getIdSucursal();

					sublista.put(stock.getNombre(), stock.getStockProducto());
					
				} else {
					sublista.put(stock.getNombre(), stock.getStockProducto());
				}

			}
			else {
				if (tieneStock(id, sublista, productosOrden)) {
					idSucursalesDisponibles.add(id);
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
		
		//se crea una lista de las sucursales DISPONIBLES que pueden hacer el pedido
		for(Sucursal sucursal : sucursales) {
			if(idSucursalesDisponibles.contains(sucursal.id()) && sucursal.estadoToString() == "Operativa") {
				sucursalesDisponibles.add(sucursal);
			}
		}
		
		
		Sucursal sucursalDestino = null;
		
		//busco sucursal destino
		for(Sucursal suc : sucursales) {
			if(suc.id() == orden.getSucursalDestino()) {
				sucursalDestino = suc;
				break;
			}
		}
		
		if(sucursalDestino == null) {
			new VentanasError("La sucursal destino no existe");
			return;
		}
		else if(sucursalDestino.estadoToString() == "No Operativa") {
			new VentanasError("La sucursal no está operativa");
			return;
		}
		
		
		//----------------------------------
		
		//armo los caminos desde esas sucursales disponibles a la sucursal destino y con eso una lista de los recorridos posibles
		
		Graph<Sucursal,Camino> grafo = new ArmadorGrafo().getGrafo();

		DijkstraShortestPath<Sucursal,Camino> alg = new DijkstraShortestPath<Sucursal,Camino>(grafo);
			
		GraphPath<Sucursal,Camino> recorrido;
		
		ArrayList<Recorrido> recorridos= new ArrayList<Recorrido>();
		
		//cargo la lista de recorridos usando el algoritmo Dijkstra para el camino mas corto
		for(Sucursal suc : sucursalesDisponibles) {
			
			recorrido = alg.getPath(suc, sucursalDestino);

			if(recorrido == null) {
				
			}else if(!(recorrido.getEdgeList().isEmpty())) {
				recorridos.add(new Recorrido(suc,sucursalDestino,recorrido.getEdgeList(),calculoTiempo(recorrido.getEdgeList())));
			}
			
			

		}
		
		if(recorridos.isEmpty()) {
			new VentanasError("No se encontraron caminos");
			return;
		}
		
		new VentanaCaminosOrden(recorridos, orden);
		
	}
	
	private Integer calculoTiempo(List<Camino> lista) {
		
			Integer tiempo = 0;
			
			for(Camino camino : lista) {
				
				tiempo += camino.getTiempoTransito();
				
			}
		
		return tiempo;
		
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
