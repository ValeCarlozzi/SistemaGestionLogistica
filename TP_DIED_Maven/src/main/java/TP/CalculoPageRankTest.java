package TP;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculoPageRankTest {

	@Test
	void obtenerPageRankCorrecto() {
		
        Map<Sucursal, Double> resultadoEsperado = new LinkedHashMap<Sucursal,Double>();

		
		Graph<Sucursal,Camino> grafo = armarGrafo(resultadoEsperado);
		
		ArmadorGrafo armadorMock = Mockito.mock(ArmadorGrafo.class);
        when(armadorMock.getGrafo()).thenReturn(grafo);
		
		
        Map<Sucursal, Double> resultado;
        
		try {
			resultado = new CalculoPageRank(armadorMock).getPageRankMap();
		} catch (Exception e) {
			resultado = null;	
		}
		
		for (Sucursal key : resultadoEsperado.keySet()) {
            double expectedValue = resultadoEsperado.get(key);
            double actualValue = resultado.get(key);
            
            assertTrue(areEqual(expectedValue, actualValue));
        }
		
		assertEquals(resultadoEsperado.keySet(),resultado.keySet()); 
		
	}
	
	
	
	
	private Graph<Sucursal,Camino> armarGrafo( Map<Sucursal, Double> resultado) {
		
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
		grafo.addVertex(sucursal);
		grafo.addVertex(sucursal2);
		grafo.addVertex(sucursal3);
		grafo.addVertex(sucursal4);
		grafo.addVertex(sucursal5);
		grafo.addVertex(sucursal6);
		
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
		
		//agrego caminos
		grafo.addEdge(sucursal, sucursal2, camino1);
		grafo.addEdge(sucursal, sucursal3, camino2);
		grafo.addEdge(sucursal2, sucursal4, camino3);
		grafo.addEdge(sucursal2, sucursal5, camino4);
		grafo.addEdge(sucursal2, sucursal3, camino5);
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
		
		resultado.put(sucursal, 0.06751152172832799d);
		resultado.put(sucursal2, 0.09937940243965035d);
		resultado.put(sucursal3, 0.12972592280763653d);
		resultado.put(sucursal4, 0.18145420470732648d);
		resultado.put(sucursal5, 0.22178325530917486d);
		resultado.put(sucursal6, 0.30014569300788385d);


		
		
		return grafo;
	}
	
    public static boolean areEqual(double a, double b) {
	    final double EPSILON = 0.05; // Define your desired epsilon value

        return Math.abs(a - b) < EPSILON;
    }
}
