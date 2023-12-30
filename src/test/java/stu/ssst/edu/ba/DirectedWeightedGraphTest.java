package stu.ssst.edu.ba;

import junit.framework.TestCase;
import java.util.List;
import java.util.Optional;

public class DirectedWeightedGraphTest extends TestCase {

    public void testAddEdge() {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        graph.addEdge("A", "B", 10, List.of(new Constraints("A", "B", "none", 0.0)));
        assertEquals("Unexpected edge weight",
                10, (int) graph.getNode("A").getNeighbour().get(graph.getNode("B")));
    }

}

