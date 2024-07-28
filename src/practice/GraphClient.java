package practice;

import java.util.HashSet;

public class GraphClient {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1, 4, 6);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 5);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 6, 4);
        graph.addEdge(7, 5, 2);
        graph.addEdge(6, 7, 3);
        System.out.println(graph.hasPath(1, -1, new HashSet<>()));
        graph.printAllPath(1, 6, new HashSet<>(), "");
    }
}
