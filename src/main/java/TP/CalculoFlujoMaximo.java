package TP;

import org.jgrapht.Graph;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.builder.GraphTypeBuilder;


public class CalculoFlujoMaximo {
	
	Double flujoMaximo;
	
public CalculoFlujoMaximo(ArmadorGrafo armadorGrafo) throws Exception{
		
	
		Graph<Sucursal,Camino> grafo = buildEmptySimpleDiGraph();
		
		grafo =  armadorGrafo.getGrafo();
		
		// Calculate Maximum Flow
        EdmondsKarpMFImpl<Sucursal, Camino> ek = new EdmondsKarpMFImpl<Sucursal,Camino>(grafo);
        
        //encontrar source y sink
        Sucursal sourceVertex = null;
        Sucursal sinkVertex = null;
        
        for (Sucursal sucursal : grafo.vertexSet()) {
            if (grafo.outDegreeOf(sucursal) == 0) {
            	
            	if(sinkVertex != null) {
            		throw new Exception(); 
            	}
            	sinkVertex = sucursal;
            }

            if (grafo.inDegreeOf(sucursal) == 0) {
            	
            	if(sourceVertex != null) {
            		throw new Exception(); 
            	}
            	
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