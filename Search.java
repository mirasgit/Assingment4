import java.util.*;

public class Search<Vertex> {
    protected final Vertex source;
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public void out(Vertex v) {
        if (!marked.contains(v)) return;

        LinkedList<Vertex> linkedList = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) linkedList.push(i);
        linkedList.push(source);

        System.out.println(linkedList);
    }
}