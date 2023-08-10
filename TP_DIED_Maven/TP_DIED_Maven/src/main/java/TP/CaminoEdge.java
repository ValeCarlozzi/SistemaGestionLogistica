package TP;

import org.jgrapht.graph.DefaultWeightedEdge;

public class CaminoEdge extends DefaultWeightedEdge {
    private Camino camino;

    public CaminoEdge(Camino camino) {
        this.camino = camino;
    }

    public Camino getCamino() {
        return camino;
    }
    
    @Override
    public double getWeight() {
        return camino.getCapMaxima(); // Set the capacity as the weight of the edge
    }
}