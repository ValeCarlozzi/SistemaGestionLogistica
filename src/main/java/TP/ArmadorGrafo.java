package TP;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.graph.builder.GraphTypeBuilder;

public class ArmadorGrafo {

	Graph<Sucursal,Camino> grafo = buildEmptySimpleDiGraph();
	ArrayList<Sucursal> listaSucursales;
	ArrayList<Camino> listaCaminos;
	
	public ArmadorGrafo(ArrayList<Sucursal> listaSucursales, ArrayList<Camino> listaCaminos){
		
		this.listaSucursales = listaSucursales;
		this.listaCaminos = listaCaminos;

		//agrego sucursales al graph
		for(Sucursal sucursal : listaSucursales) {
			if(sucursal.estadoToString() == "Operativa") {
				grafo.addVertex(sucursal);
			}
		}
				
		//agrego caminos y pesos al graph
		Sucursal sucursal1;
		Sucursal sucursal2;
		
		for(Camino camino : listaCaminos) {
			
			if(camino.estadoToString() == "Operativo") {
				
				sucursal1 = encontrarSucursal(camino.getOrigen());
				sucursal2 = encontrarSucursal(camino.getDestino());
			
				if(grafo.vertexSet().contains(sucursal1) && grafo.vertexSet().contains(sucursal2)) {
					grafo.addEdge(sucursal1,sucursal2,camino);
					grafo.setEdgeWeight(camino,camino.getCapMaxima());
				}
			}
		}	
	}
	
	private Sucursal encontrarSucursal(Integer id) {
		
		for(Sucursal sucursal : listaSucursales) {
			
			if(sucursal.id() == id) {
				return sucursal;
			}
			
		}
		return null;
	}

	public Graph<Sucursal,Camino> getGrafo(){
		return grafo;
	}
	
	private static Graph<Sucursal, Camino> buildEmptySimpleDiGraph()
    {
        return GraphTypeBuilder
        	.<Sucursal, Camino> directed().allowingMultipleEdges(false)
            .allowingSelfLoops(false).edgeClass(Camino.class).weighted(true).buildGraph();
    }
	
}
