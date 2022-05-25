import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final WeightedGraph<Vertex> weightedGraph;
    private final Set<Vertex> unsetNode;
    private final Map<Vertex, Double> distances;

    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);

        this.weightedGraph = graph;
        unsetNode = new HashSet<>();
        distances = new HashMap<>();
        dijkstraConstructor();
    }


    private double getDistance(Vertex node, Vertex target) {
        for (Edge<Vertex> edge : weightedGraph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }
        return 0;
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex min = null;

        for (Vertex vertex : vertices) {
            if (min == null)
                min = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(min))
                    min = vertex;
            }
        }

        return min;
    }

    private double getShortestDistance(Vertex dest) {
        Double d = distances.get(dest);

        return (d == null ? Double.MAX_VALUE : d);
    }

    public void dijkstraConstructor() {
        distances.put(source, 0D);
        unsetNode.add(source);

        while (unsetNode.size() > 0) {
            Vertex node = getVertexWithMinimumWeight(unsetNode);
            marked.add(node);
            unsetNode.remove(node);

            for (Vertex target : weightedGraph.adjacencyList(node)) {
                if (getShortestDistance(target) > getShortestDistance(node)
                        + getDistance(node, target)) {
                    distances.put(target, getShortestDistance(node)
                            + getDistance(node, target));
                    edgeTo.put(target, node);
                    unsetNode.add(target);
                }
            }
        }
    }
}