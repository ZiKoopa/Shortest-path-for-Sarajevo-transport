package stu.ssst.edu.ba;

import junit.framework.TestCase;

public class NodeTest extends TestCase {

    public void testAddNeighbourRoadClosed() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Constraints roadClosedConstraint =
                new Constraints("A", "B", "medics helicopter", 1.0);

        nodeA.addNeighbour(nodeB, 10, roadClosedConstraint);

        assertTrue(nodeA.getNeighbour().isEmpty());
    }

    public void testAddNeighbourRoadNotClosed() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Constraints roadNotClosedConstraint = new Constraints("A", "B", "none", 0.0);

        nodeA.addNeighbour(nodeB, 10, roadNotClosedConstraint);

        assertTrue(nodeA.getNeighbour().containsKey(nodeB));
        assertEquals(10, nodeA.getNeighbour().get(nodeB).intValue());
    }

    public void testAddDuplicateNeighbour() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Constraints roadNotClosedConstraint =
                new Constraints("A", "B", "none", 0.0);

        nodeA.addNeighbour(nodeB, 10, roadNotClosedConstraint);
        nodeA.addNeighbour(nodeB, 15, roadNotClosedConstraint);

        assertTrue(nodeA.getNeighbour().containsKey(nodeB));

        assertEquals(10, nodeA.getNeighbour().get(nodeB).intValue());
    }
}

