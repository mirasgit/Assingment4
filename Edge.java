import java.util.Objects;

public class Edge<Vertex> {
    private final Vertex source;
    private final Vertex dest;
    private Double weight;

    public Edge(Vertex s, Vertex d, Double w) {
        this.source = s;
        this.dest = d;
        this.weight = w;
    }

    public Edge(Vertex s, Vertex d) {
        this.source = s;
        this.dest = d;
    }

    public Vertex getDest() {
        return dest;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;

        return Objects.equals(source, edge.source) &&
                Objects.equals(dest, edge.dest);
    }
}