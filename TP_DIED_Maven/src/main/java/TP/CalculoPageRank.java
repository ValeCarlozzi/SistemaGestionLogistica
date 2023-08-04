package TP;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.alg.scoring.PageRank;
import org.jgrapht.graph.builder.GraphTypeBuilder;

public class CalculoPageRank {

	Map<Sucursal, Double> sortedMapDescending;
	
	public CalculoPageRank(){
		
		Graph<Sucursal,Camino> grafo = buildEmptySimpleDiGraph();
		
		grafo =  (new ArmadorGrafo()).getGrafo();
		
		PageRank<Sucursal,Camino> pr = new PageRank<Sucursal,Camino>(grafo);
        
        Map<Sucursal,Double> valoresPR = pr.getScores();
        
        
        sortedMapDescending = valoresPR.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        
	}

	public Map<Sucursal, Double> getPageRankMap() {
		return sortedMapDescending;
	}
	
	private Graph<Sucursal, Camino> buildEmptySimpleDiGraph() {
		return GraphTypeBuilder
		    	.<Sucursal, Camino> directed().allowingMultipleEdges(false)
		        .allowingSelfLoops(false).edgeClass(Camino.class).weighted(true).buildGraph();
	}
	
	
}
