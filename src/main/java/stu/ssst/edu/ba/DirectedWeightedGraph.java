package stu.ssst.edu.ba;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedWeightedGraph {
    private final Map<String, Node> graph;

    public DirectedWeightedGraph() {
        this.graph = new HashMap<>();
    }

    public void addNode(String node) {
        graph.putIfAbsent(node, new Node(node));
    }

    public void addEdge(String source, String destination, int time, List<Constraints> constraints) {
        addNode(source);
        addNode(destination);
        Node sourceNode = graph.get(source);
        Node destinationNode = graph.get(destination);
        Constraints constraint = findConstraint(source, destination, constraints);
        sourceNode.addNeighbour(destinationNode, time, constraint);
    }

    Constraints findConstraint(String source, String destination, List<Constraints> constraints) {
        return constraints.stream()
                .filter(constraint -> constraint.getPlace1().equals(source) && constraint.getPlace2().equals(destination))
                .findFirst()
                .orElse(new Constraints(source, destination, "none", 0.0));
    }

    public Map<String, Node> getGraph() {
        return graph;
    }

    public Node getNode(String name) {
        return graph.get(name);
    }
}