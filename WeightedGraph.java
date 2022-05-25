import java.util.*;

public class WeightedGraph<Vertex> {
    private final Map<Vertex, List<Edge<Vertex>>> weightedGraph = new HashMap<>();
    private final boolean undir;

    public WeightedGraph(boolean dir) {
        this.undir = dir;
    }

    public void setEdge(Vertex s, Vertex d, double w) {
        if (isVertex(s))
            setVertex(s);
        if (isVertex(d))
            setVertex(d);
        if (isEdge(s, d) || s.equals(d))
            return;

        weightedGraph.get(s).add(new Edge<>(s, d, w));

        if (undir)
            weightedGraph.get(d).add(new Edge<>(d, s, w));
    }

    public void setVertex(Vertex v) {
        weightedGraph.put(v, new LinkedList<>());
    }

    public boolean isVertex(Vertex v) {
        return !weightedGraph.containsKey(v);
    }

    public boolean isEdge(Vertex s, Vertex d) {
        if (isVertex(s)) return false;

        return weightedGraph.get(s).contains(new Edge<>(s, d));
    }

    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        if (isVertex(v)) return null;

        return weightedGraph.get(v);
    }

    public Iterable<Vertex> adjacencyList(Vertex v) {
        if (isVertex(v)) return null;
        List<Vertex> vertexList = new LinkedList<>();

        for (Edge<Vertex> e : weightedGraph.get(v)) vertexList.add(e.getDest());
        return vertexList;
    }
}