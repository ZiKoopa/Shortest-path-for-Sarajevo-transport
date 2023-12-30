package stu.ssst.edu.ba;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Djikstra {
    public static int ShortestPath(DirectedWeightedGraph graph, String startNode, String endNode) {
        Map<String, Integer> distance = new HashMap<>();
        PriorityQueue<NodeDistance> minHeap = new PriorityQueue<>((a, b) -> a.getDistance() - b.getDistance());

        distance.put(startNode, 0);
        minHeap.offer(new NodeDistance(graph.getNode(startNode), 0));

        while (!minHeap.isEmpty()) {
            NodeDistance current = minHeap.poll();
            Node currentNode = current.getNode();
            int currentDistance = current.getDistance();

            if (currentNode.toString().equals(endNode)) {
                return currentDistance;
            }
            for (Map.Entry<Node, Integer> neighbourEntry : currentNode.getNeighbour().entrySet()) {
                Node neighbourNode = neighbourEntry.getKey();
                int newDistance = currentDistance + neighbourEntry.getValue();

                if (!distance.containsKey(neighbourNode.toString()) || newDistance <
                        distance.get(neighbourNode.toString())) {
                    distance.put(neighbourNode.toString(), newDistance);
                    minHeap.offer(new NodeDistance(neighbourNode, newDistance));
                }
            }
        }
        return -1;
    }
}