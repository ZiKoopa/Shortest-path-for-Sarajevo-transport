package stu.ssst.edu.ba;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        fillPlaces();
        List<Constraints> constraints = readConstraints();

        DirectedWeightedGraph graph0 = createGraph("src/main/java/stu/ssst/edu/ba/simple.txt", constraints);
        DirectedWeightedGraph graph1 = createGraph("src/main/java/stu/ssst/edu/ba/ten_places.txt", constraints);
        DirectedWeightedGraph graph2 = createGraph("src/main/java/stu/ssst/edu/ba/five_places.txt", constraints);
        DirectedWeightedGraph graph3 = createGraph("src/main/java/stu/ssst/edu/ba/complex.txt", constraints);
        DirectedWeightedGraph graph4 = createGraph("src/main/java/stu/ssst/edu/ba/all_places_a.txt", constraints);
        DirectedWeightedGraph graph5 = createGraph("src/main/java/stu/ssst/edu/ba/all_places_b.txt", constraints);

        WriteOptimalTravelTime(graph0, "simple");
        WriteOptimalTravelTime(graph1, "ten_places");
        WriteOptimalTravelTime(graph2, "five_places");
        WriteOptimalTravelTime(graph3, "complex");
        WriteOptimalTravelTime(graph4, "all_places_a");
        WriteOptimalTravelTime(graph5, "all_places_b");

    }


    private static void WriteOptimalTravelTime(DirectedWeightedGraph graph, String filename) {
        try (FileWriter writer = new FileWriter("src/main/java/stu/ssst/edu/ba/OptimalTimeFor" + filename + ".txt")) {
            for (String sourceNodeShortcode : graph.getGraph().keySet()) {
                String sourceNodeInfo = Places.getPlaceInfo(sourceNodeShortcode);
                if (!"Unknown".equals(sourceNodeInfo)) {
                    for (String destinationNodeShortcode : graph.getGraph().keySet()) {
                        if (!sourceNodeShortcode.equals(destinationNodeShortcode)) {
                            String destinationNodeInfo = Places.getPlaceInfo(destinationNodeShortcode);
                            if (!"Unknown".equals(destinationNodeInfo)) {
                                int time = Djikstra.ShortestPath(graph, sourceNodeShortcode, destinationNodeShortcode);
                                writer.write(sourceNodeInfo + " -> " + destinationNodeInfo + " : " + time + "\n");
                            }
                        }
                    }
                }
            }
            System.out.println("File written successfully: OptimalTimeFor" + filename + ".txt");
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }


    private static List<Constraints> readConstraints() {
        List<Constraints> constraints = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/java/stu/ssst/edu/ba/constraints.txt"));
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                String parts[] = scanner.nextLine().split(",");
                String place1 = parts[0];
                String place2 = parts[1];
                String constraint = parts[2];
                Double prob = Double.parseDouble(parts[3]);
                constraints.add(new Constraints(place1, place2, constraint, prob));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
        return constraints;
    }

    private static DirectedWeightedGraph createGraph(String filename, List<Constraints> constraints) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String parts[] = scanner.nextLine().split(" ");
                String source = parts[0];
                String destination = parts[1];
                int time = Integer.parseInt(parts[2]);
                graph.addEdge(source, destination, time, constraints);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
        return graph;
    }

    private static void fillPlaces() {
        try (Scanner scanner = new Scanner(new File("src/main/java/stu/ssst/edu/ba/places.txt"))) {
            while (scanner.hasNextLine()) {
                String parts[] = scanner.nextLine().split(",");
                String shortcode = parts[0];
                String name = parts[1];
                Places.addPlace(shortcode, name);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}