package stu.ssst.edu.ba;

import junit.framework.TestCase;

import java.util.List;

public class DjikstraTest extends TestCase {

    public void testShortestPath() {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        graph.addEdge("A", "B", 10,
                List.of(new Constraints("A", "B", "none", 0.0)));
        int shortestPath = Djikstra.ShortestPath(graph, "A", "B");
        assertEquals(10, shortestPath);
    }

    public void testShortestPathWithOneNode() {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        graph.addNode("A");
        int shortestPath = Djikstra.ShortestPath(graph, "A", "A");
        assertEquals(0, shortestPath);
    }

    public void testShortestPathWithLoop() {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        graph.addEdge("A", "A", 10,
                List.of(new Constraints("A", "A", "none", 0.0)));
        int shortestPath = Djikstra.ShortestPath(graph, "A", "A");
        assertEquals(0, shortestPath);
    }

    public void testShortestPathNoConnection() {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        int shortestPath = Djikstra.ShortestPath(graph, "A", "B");
        assertEquals(-1, shortestPath);
    }

}