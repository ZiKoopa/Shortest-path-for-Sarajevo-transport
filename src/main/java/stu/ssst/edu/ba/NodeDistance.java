package stu.ssst.edu.ba;

public class NodeDistance {
    private final Node node;
    private final int distance;

    public NodeDistance(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Node getNode() {
        return node;
    }
}