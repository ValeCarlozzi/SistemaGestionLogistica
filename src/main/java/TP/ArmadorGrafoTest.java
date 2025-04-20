package TP;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.junit.jupiter.api.Test;

public class ArmadorGrafoTest {

	@Test
	void obtenerGrafoCorrecto() {
		
		ArrayList<Camino> listaCaminos = armarCaminos();
		
		ArrayList<Sucursal> listaSucursales = armarSucursales();
		
		Graph<Sucursal,Camino> grafoEsperado = armarGrafo(listaSucursales,listaCaminos);
		
		Graph<Sucursal,Camino> grafoResultado = new ArmadorGrafo(listaSucursales,listaCaminos).getGrafo();
	
        assertEquals(grafoEsperado.vertexSet(),grafoResultado.vertexSet());
       
        for(Camino camino : grafoEsperado.edgeSet()) {
        	
        	System.out.println(camino.getID()+ " | " + camino.getOrigen() + " | " + camino.getDestino() +" | " + camino.getCapMaxima() + " | " + camino.getTiempoTransito());
        	
        }
        
    	System.out.println("-------------");

        
        for(Camino camino : grafoResultado.edgeSet()) {
        	
        	System.out.println(camino.getID() + " | " + camino.getOrigen() + " | " + camino.getDestino() +" | " + camino.getCapMaxima() + " | " + camino.getTiempoTransito());
        	
        }
        
        // assertEquals(grafoEsperado.edgeSet(),grafoResultado.edgeSet());
	
        
	}

	private ArrayList<Sucursal> armarSucursales() {
				
				ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
		
				//creo sucursales
				Integer id;
				String nombre;
				String HorarioA;
				String HorarioC;
				TipoEstadoSucursal estado;
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
				sucursal = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
				
				id = 2;
				nombre = "segunda";
				HorarioA = "6";
				HorarioC = "18";
				estado = TipoEstadoSucursal.OPERATIVA;
				sucursal2 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
				
				id = 3;
				nombre = "tercera";
				HorarioA = "6";
				HorarioC = "18";
				estado = TipoEstadoSucursal.OPERATIVA;
				sucursal3 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
				
				id = 4;
				nombre = "cuarta";
				HorarioA = "6";
				HorarioC = "18";
				estado = TipoEstadoSucursal.OPERATIVA;
				sucursal4 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
				
				id = 5;
				nombre = "quinta";
				HorarioA = "6";
				HorarioC = "18";
				estado = TipoEstadoSucursal.OPERATIVA;
				sucursal5 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
				
				id = 6;
				nombre = "sexta";
				HorarioA = "6";
				HorarioC = "18";
				estado = TipoEstadoSucursal.OPERATIVA;
				sucursal6 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
				
				
				
				//agrego sucursal al graph
				sucursales.add(sucursal);
				sucursales.add(sucursal2);
				sucursales.add(sucursal3);
				sucursales.add(sucursal4);
				sucursales.add(sucursal5);
				sucursales.add(sucursal6);		
				
				return sucursales;
	}

	private ArrayList<Camino> armarCaminos() {
				
				ArrayList<Camino> caminos = new ArrayList<Camino>();
		
				//creo caminos
				Integer idC = 1;
				Integer origen = 1;
				Integer destino = 2;
				Integer capMaxima = 15;
				TipoEstadoSucursal estadoC = TipoEstadoSucursal.OPERATIVA;
				Integer tiempo = 5;
				Camino camino1 = new Camino(idC,origen,destino,capMaxima,estadoC,tiempo);
				
				idC = 2;
				origen = 1;
				destino = 3;
				capMaxima = 12;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 5;
				Camino camino2 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				idC = 3;
				origen = 2;
				destino = 4;
				capMaxima = 12;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 5;
				Camino camino3 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				idC = 4;
				origen = 2;
				destino = 5;
				capMaxima = 1;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 1;
				Camino camino4 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				idC = 5;
				origen = 2;
				destino = 3;
				capMaxima = 10;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 5;
				Camino camino5 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				idC = 6;
				origen = 3;
				destino = 5;
				capMaxima = 14;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 5;
				Camino camino6 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				idC = 7;
				origen = 5;
				destino = 4;
				capMaxima = 10;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 5;
				Camino camino7 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				idC = 8;
				origen = 4;
				destino = 6;
				capMaxima = 25;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 5;
				Camino camino8 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				idC = 9;
				origen = 5;
				destino = 6;
				capMaxima = 4;
				estadoC = TipoEstadoSucursal.OPERATIVA;
				tiempo = 5;
				Camino camino9 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
				
				//agrego caminos
				caminos.add(camino1);
				caminos.add(camino2);
				caminos.add(camino3);
				caminos.add(camino4);
				caminos.add(camino5);
				caminos.add(camino6);
				caminos.add(camino7);
				caminos.add(camino8);
				caminos.add(camino9);
				
				return caminos;
	}
	
	private Graph<Sucursal,Camino> armarGrafo(ArrayList<Sucursal> listaSucursales,ArrayList<Camino> listaCaminos) {
		
		//creo graph
		Graph<Sucursal,Camino> grafo =  GraphTypeBuilder
	        	.<Sucursal, Camino> directed().allowingMultipleEdges(false)
	            .allowingSelfLoops(false).edgeClass(Camino.class).weighted(true).buildGraph();
				
		//creo sucursales
		Integer id;
		String nombre;
		String HorarioA;
		String HorarioC;
		TipoEstadoSucursal estado;
		Sucursal sucursal;
		Sucursal sucursal21;
		Sucursal sucursal3;
		Sucursal sucursal4;
		Sucursal sucursal5;
		Sucursal sucursal6;
		
		id = 1;
		nombre = "primera";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		sucursal = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
		
		id = 2;
		nombre = "segunda";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		sucursal21 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
		
		id = 3;
		nombre = "tercera";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		sucursal3 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
		
		id = 4;
		nombre = "cuarta";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		sucursal4 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
		
		id = 5;
		nombre = "quinta";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		sucursal5 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);
		
		id = 6;
		nombre = "sexta";
		HorarioA = "6";
		HorarioC = "18";
		estado = TipoEstadoSucursal.OPERATIVA;
		sucursal6 = new Sucursal(id, nombre, HorarioA, HorarioC, estado);	
		
				
		//creo caminos
		Integer idC = 1;
		Integer origen = 1;
		Integer destino = 2;
		Integer capMaxima = 15;
		TipoEstadoSucursal estadoC = TipoEstadoSucursal.OPERATIVA;
		Integer tiempo = 5;
		Camino camino1 = new Camino(idC,origen,destino,capMaxima,estadoC,tiempo);
		
		idC = 2;
		origen = 1;
		destino = 3;
		capMaxima = 12;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino2 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 3;
		origen = 2;
		destino = 4;
		capMaxima = 12;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino3 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 4;
		origen = 2;
		destino = 5;
		capMaxima = 1;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 1;
		Camino camino4 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 5;
		origen = 2;
		destino = 3;
		capMaxima = 10;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino5 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 6;
		origen = 3;
		destino = 5;
		capMaxima = 14;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino6 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 7;
		origen = 5;
		destino = 4;
		capMaxima = 10;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino7 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 8;
		origen = 4;
		destino = 6;
		capMaxima = 25;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino8 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		idC = 9;
		origen = 5;
		destino = 6;
		capMaxima = 4;
		estadoC = TipoEstadoSucursal.OPERATIVA;
		tiempo = 5;
		Camino camino9 = new Camino(idC, origen, destino, capMaxima, estadoC, tiempo);
		
		/*
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
						
						sucursal1 = encontrarSucursal(camino.getOrigen(),listaSucursales);
						sucursal2 = encontrarSucursal(camino.getDestino(),listaSucursales);
					
						if(grafo.vertexSet().contains(sucursal1) && grafo.vertexSet().contains(sucursal2)) {
							grafo.addEdge(sucursal1,sucursal2,camino);
							grafo.setEdgeWeight(camino,camino.getCapMaxima());
						}
					}
				}
		*/
		
		grafo.addVertex(sucursal);
		grafo.addVertex(sucursal21);
		grafo.addVertex(sucursal3);
		grafo.addVertex(sucursal4);
		grafo.addVertex(sucursal5);
		grafo.addVertex(sucursal6);

		
		
		//agrego caminos
		grafo.addEdge(sucursal, sucursal21, camino1);
		grafo.addEdge(sucursal, sucursal3, camino2);
		grafo.addEdge(sucursal21, sucursal4, camino3);
		grafo.addEdge(sucursal21, sucursal5, camino4);
		grafo.addEdge(sucursal21, sucursal3, camino5);
		grafo.addEdge(sucursal3, sucursal5, camino6);
		grafo.addEdge(sucursal5, sucursal4, camino7);
		grafo.addEdge(sucursal4, sucursal6, camino8);
		grafo.addEdge(sucursal5, sucursal6, camino9);
		
		//agrego pesos
		grafo.setEdgeWeight(camino1, camino1.getCapMaxima());
		grafo.setEdgeWeight(camino2, camino2.getCapMaxima());
		grafo.setEdgeWeight(camino3, camino3.getCapMaxima());
		grafo.setEdgeWeight(camino4, camino4.getCapMaxima());
		grafo.setEdgeWeight(camino5, camino5.getCapMaxima());
		grafo.setEdgeWeight(camino6, camino6.getCapMaxima());
		grafo.setEdgeWeight(camino7, camino7.getCapMaxima());
		grafo.setEdgeWeight(camino8, camino8.getCapMaxima());
		grafo.setEdgeWeight(camino9, camino9.getCapMaxima());
		
		
		return grafo;
	}



}
