class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        graph.setEdge("Car", "Bus", 3);
        graph.setEdge("Car", "Train", 2);
        graph.setEdge("Bus", "Plane", 3);
        graph.setEdge("Bus", "Rocket", 6);
        graph.setEdge("Train", "Bus", 4);
        graph.setEdge("Train", "Rocket", 5);
        System.out.print("bfs: ");
        Search<String> breadthFirstSearch = new BreadthFirstSearch<>(graph, "Car");
        breadthFirstSearch.out("Rocket");
        System.out.print("dijkstra: ");
        Search<String> dijkstraSearch = new DijkstraSearch<>(graph, "Car");
        dijkstraSearch.out("Rocket");
    }
}