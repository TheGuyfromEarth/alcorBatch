// Dijkstra's Algorithm (Weighted Graph -> Min Shortest Path in terms of weights)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class WtdGraph {

    ArrayList<WtdPair>[] adj;

    public WtdGraph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination, int weight) {
        adj[source].add(new WtdPair(destination, weight));
        adj[destination].add(new WtdPair(source, weight));
    }
}

class WtdPair implements Comparable<WtdPair> {

    int vertex;
    int weight;

    public WtdPair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(WtdPair otherPair) {
        return this.weight - otherPair.weight;
    }
}


public class Dijkstra {

    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();
        WtdGraph graph = new WtdGraph(numVertices);

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            int weight = scan.nextInt();
            graph.connectEdge(source, destination, weight);
        }

        dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[numVertices];

        MinShortestPath(0,graph);

        System.out.println(Arrays.toString(dist));

    }

    private static void MinShortestPath(int source, WtdGraph graph) {

        PriorityQueue<WtdPair> pq = new PriorityQueue<>();

        WtdPair sourcePair = new WtdPair(source, 0);
        pq.add(sourcePair);
        dist[sourcePair.vertex] = 0;

        while (!pq.isEmpty()) {
            WtdPair currPair = pq.poll();

            if (visited[currPair.vertex])
                continue;

            visited[currPair.vertex] = true;
            dist[currPair.vertex] = currPair.weight;

            for (WtdPair neighbour : graph.adj[currPair.vertex]) {
                if (!visited[neighbour.vertex]) {
                    if (dist[neighbour.vertex] > currPair.weight + neighbour.weight)
                        pq.add(new WtdPair(neighbour.vertex, currPair.weight + neighbour.weight));
                }
            }

        }


    }

}
