package TP;
//import org.jgrapht.alg.flow.MaximumFlowAlgorithmBase;
import org.jgrapht.graph.builder.GraphTypeBuilder;


import java.util.stream.Collectors;

import org.jgrapht.*;

import org.jgrapht.alg.flow.EdmondsKarpMFImpl;

import org.jgrapht.alg.scoring.PageRank;

import java.util.*;

public class App {

	public static void main(String[] args) {

		//creo graph
		Graph<Sucursal,CaminoEdge> grafo =  buildEmptySimpleDiGraph();
		
		//creo sucursales
		Integer id;
		String nombre;
		String HorarioA;
		String HorarioC;
		TipoEstadoSucursal estado;
		String direccion;
		Sucursal sucursal;
		Sucursal sucursal2;
		Sucursal sucursal3;
		Sucursal sucursal4;
		Sucursal sucursal5;
		Sucursal sucursal6;
		
		id = 1;
		nombre = "primera";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		direccion = "direccion1";
		sucursal = new Sucursal(id, nombre, HorarioA, HorarioC, estado, direccion);
		
		id = 2;
		nombre = "segunda";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		direccion = "direccion2";
		sucursal2 = new Sucursal(id, nombre, HorarioA, HorarioC, estado, direccion);
		
		id = 3;
		nombre = "tercera";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		direccion = "direccion3";
		sucursal3 = new Sucursal(id, nombre, HorarioA, HorarioC, estado, direccion);
		
		id = 4;
		nombre = "cuarta";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		direccion = "direccion4";
		sucursal4 = new Sucursal(id, nombre, HorarioA, HorarioC, estado, direccion);
		
		id = 5;
		nombre = "quinta";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		direccion = "direccion4";
		sucursal5 = new Sucursal(id, nombre, HorarioA, HorarioC, estado, direccion);
		
		id = 6;
		nombre = "sexta";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		direccion = "direccion4";
		sucursal6 = new Sucursal(id, nombre, HorarioA, HorarioC, estado, direccion);
		
		
		
		//agrego sucursal al graph
		grafo.addVertex(sucursal);
		grafo.addVertex(sucursal2);
		grafo.addVertex(sucursal3);
		grafo.addVertex(sucursal4);
		grafo.addVertex(sucursal5);
		grafo.addVertex(sucursal6);
		
		
		//imprimo nombre de la sucursales
		grafo.vertexSet().forEach(e -> System.out.println(e.getNombre()));
		
		//creo caminos
		Integer idC = 1;
		Integer origen = 1;
		Integer destino = 2;
		Integer capMaxima = 15;
		TipoEstadoSucursal estadoC = TipoEstadoSucursal.OPERATIVA;
		Integer tiempo = 5;
		Camino camino1 = new Camino(idC,origen,destino,capMaxima,estadoC,tiempo);
		
		idC = 2;
		origen = 2;
		destino = 3;
		capMaxima = 12;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino2 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 3;
		origen = 2;
		destino = 3;
		capMaxima = 12;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino3 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 4;
		origen = 2;
		destino = 3;
		capMaxima = 1;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino4 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 5;
		origen = 2;
		destino = 3;
		capMaxima = 10;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino5 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 6;
		origen = 2;
		destino = 3;
		capMaxima = 14;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino6 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 7;
		origen = 2;
		destino = 3;
		capMaxima = 10;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino7 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 8;
		origen = 2;
		destino = 3;
		capMaxima = 25;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino8 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 9;
		origen = 2;
		destino = 3;
		capMaxima = 4;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino9 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		//creo edges (wrappers)
		CaminoEdge edge1 = new CaminoEdge(camino1);
		CaminoEdge edge2 = new CaminoEdge(camino2);
		CaminoEdge edge3 = new CaminoEdge(camino3);
		CaminoEdge edge4 = new CaminoEdge(camino4);
		CaminoEdge edge5 = new CaminoEdge(camino5);
		CaminoEdge edge6 = new CaminoEdge(camino6);
		CaminoEdge edge7 = new CaminoEdge(camino7);
		CaminoEdge edge8 = new CaminoEdge(camino8);
		CaminoEdge edge9 = new CaminoEdge(camino9);
		
		
		//agrego caminos
		grafo.addEdge(sucursal, sucursal2, edge1);
		grafo.addEdge(sucursal, sucursal3, edge2);
		grafo.addEdge(sucursal2, sucursal4, edge3);
		grafo.addEdge(sucursal2, sucursal5, edge4);
		grafo.addEdge(sucursal2, sucursal3, edge5);
		grafo.addEdge(sucursal3, sucursal5, edge6);
		grafo.addEdge(sucursal5, sucursal4, edge7);
		grafo.addEdge(sucursal4, sucursal6, edge8);
		grafo.addEdge(sucursal5, sucursal6, edge9);
		
		//agrego pesos
		grafo.setEdgeWeight(edge1, edge1.getWeight());
		grafo.setEdgeWeight(edge2, edge2.getWeight());
		grafo.setEdgeWeight(edge3, edge3.getWeight());
		grafo.setEdgeWeight(edge4, edge4.getWeight());
		grafo.setEdgeWeight(edge5, edge5.getWeight());
		grafo.setEdgeWeight(edge6, edge6.getWeight());
		grafo.setEdgeWeight(edge7, edge7.getWeight());
		grafo.setEdgeWeight(edge8, edge8.getWeight());
		grafo.setEdgeWeight(edge9, edge9.getWeight());
		
		/*
		//itero con DFS
		DepthFirstIterator<Sucursal,Camino> iter = new DepthFirstIterator(grafo,sucursal);
		
		while (iter.hasNext()) {
            Sucursal vertex = iter.next();
            System.out.println("Visited: " + vertex.getNombre());
        }
        */
		
		//max flow
		// Calculate Maximum Flow
        EdmondsKarpMFImpl<Sucursal, CaminoEdge> ek = new EdmondsKarpMFImpl<Sucursal,CaminoEdge>(grafo);

        Sucursal sourceVertex = sucursal; // Set the source vertex (where the flow starts)
        Sucursal sinkVertex = sucursal6; // Set the sink vertex (where the flow ends)

        double maximumFlowValue = ek.calculateMaximumFlow(sourceVertex, sinkVertex);

        System.out.println("Maximum Flow Value: " + maximumFlowValue);
        
        //PageRank
        PageRank<Sucursal,CaminoEdge> pr = new PageRank<Sucursal,CaminoEdge>(grafo);
        
        Map<Sucursal,Double> valoresPR = pr.getScores();
        
        System.out.println("");
        System.out.println("PR VALUES:");
        
        //mostrar  valores sin ordenar
        /*
        for (Sucursal sucursales : valoresPR.keySet()) {
            System.out.println(sucursales.getNombre() + ": " + valoresPR.get(sucursales));
        }
        */
        
        /*
        List<Double> valores = valoresPR.values().stream()
        					.sorted()
        					.collect(Collectors.toList());
        
        for(Double valor : valores) {
        	System.out.println(valor);
        }
        */
        
        Map<Sucursal, Double> sortedMapDescending = valoresPR.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        
        for (Sucursal sucursales : sortedMapDescending.keySet()) {
            System.out.println(sucursales.getNombre() + ": " + sortedMapDescending.get(sucursales));
        }
		
	}
	
	private static Graph<Sucursal, CaminoEdge> buildEmptySimpleDiGraph()
    {
        return GraphTypeBuilder
        	.<Sucursal, CaminoEdge> directed().allowingMultipleEdges(false)
            .allowingSelfLoops(false).edgeClass(CaminoEdge.class).weighted(true).buildGraph();
    }
	

}
