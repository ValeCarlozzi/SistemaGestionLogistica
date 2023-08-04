package TP;

import org.jgrapht.Graph;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.builder.GraphTypeBuilder;

public class CalculoFlujoMaximo {

	//TODO chequear de alguna forma cuando no se puede calcular el flujo maximo
	
	Double flujoMaximo;
	
public CalculoFlujoMaximo(){
		
		//Graph<Sucursal,Camino> grafo =  (new GraphBuilder()).getGrafo();
	
		Graph<Sucursal,Camino> grafo = buildEmptySimpleDiGraph();
		
		grafo =  (new ArmadorGrafo()).getGrafo();
		
		// Calculate Maximum Flow
        EdmondsKarpMFImpl<Sucursal, Camino> ek = new EdmondsKarpMFImpl<Sucursal,Camino>(grafo);
        
        //encontrar source y sink
        Sucursal sourceVertex = new Sucursal();
        Sucursal sinkVertex = new Sucursal();
        
        for (Sucursal sucursal : grafo.vertexSet()) {
            if (grafo.outDegreeOf(sucursal) == 0) {
                // The vertex has no outgoing edges (sink)
                sinkVertex = sucursal;
            }

            if (grafo.inDegreeOf(sucursal) == 0) {
                // The vertex has no incoming edges (source)
                sourceVertex = sucursal;
            }
        }
        

        double maximumFlowValue = ek.calculateMaximumFlow(sourceVertex, sinkVertex);

        flujoMaximo = maximumFlowValue;
		
	}
	
	public Double getFlujoMaximo(){
		return flujoMaximo;
	}

	private static Graph<Sucursal, Camino> buildEmptySimpleDiGraph()
	{
	    return GraphTypeBuilder
	    	.<Sucursal, Camino> directed().allowingMultipleEdges(false)
	        .allowingSelfLoops(false).edgeClass(Camino.class).weighted(true).buildGraph();
	}

}