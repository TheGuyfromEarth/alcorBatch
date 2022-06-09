// MST (Prim's Algorithm)

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class GivenGraph {

    ArrayList<WeightedPair>[] adj;
    static int count = 0;

    public GivenGraph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination, int weight) {
        adj[source].add(new WeightedPair(destination, source, weight));
        adj[destination].add(new WeightedPair(source, destination, weight));
    }

}

class WeightedPair implements Comparable<WeightedPair> {

    int vertex;
    int weight;
    int parent;

    public WeightedPair(int vertex, int parent, int weight) {
        this.vertex = vertex;
        this.parent = parent;
        this.weight = weight;

    }

    @Override
    public int compareTo(WeightedPair otherPair) {
        return this.weight - otherPair.weight;
    }
}


public class PrimsAlgorithm {


    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();
        GivenGraph graph = new GivenGraph(numVertices);
        visited = new boolean[numVertices];
        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            int weight = scan.nextInt();
            graph.connectEdge(source, destination, weight);
        }

        System.out.println(prims(1, graph));
    }

    private static int prims(int source, GivenGraph graph) {

        PriorityQueue<WeightedPair> pq = new PriorityQueue<>();
        pq.add(new WeightedPair(source, -1, 0));
        int minWt = 0;

        while (!pq.isEmpty()) {
            WeightedPair currPair = pq.poll();

            if (visited[currPair.vertex])
                continue;

            visited[currPair.vertex] = true;
            if (currPair.parent != -1)
                System.out.println("From " + currPair.parent + " To " + currPair.vertex + " Having " + currPair.weight);

            minWt += currPair.weight;

            for (WeightedPair neighbour : graph.adj[currPair.vertex]) {
                if (!visited[neighbour.vertex]) {
                    pq.add(neighbour);
                }
            }

        }
        System.out.println();
        return minWt;
    }

}
