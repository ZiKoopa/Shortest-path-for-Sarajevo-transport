package stu.ssst.edu.ba;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private final String name;
    private final Map<Node, Integer> neighbour;

    public Node(String name) {
        this.name = name;
        this.neighbour = new HashMap<>();
    }

    public void addNeighbour(Node neighbour1, int time, Constraints constraint) {
        if (!constraint.isRoadClosed()) {
            int timeTravel = time;

            if (!neighbour.containsKey(neighbour1)) {
                neighbour.put(neighbour1, timeTravel);
            }
        }
    }

    public Map<Node, Integer> getNeighbour() {
        return neighbour;
    }

    @Override
    public String toString() {
        return name;
    }
}