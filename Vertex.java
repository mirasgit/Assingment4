import java.util.*;

public class Vertex<V> {
    private final Map<Vertex<V>, Double> adjVertices;

    public Vertex(V data, Map<Vertex<V>, Double> adjacentVertices) {
        this.adjVertices = adjacentVertices;
    }

    public void addAdjVertices(Vertex<V> destination, double weight) {
        adjVertices.put(destination, weight);
    }

}