import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    ArrayList<Integer>[] adj;
    static int count = 0;

    public Graph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination) {
//        ArrayList<Integer> sourceList = adj[source];
//        sourceList.add(destination);
        adj[source].add(destination);
        adj[destination].add(source);
    }

    // recursive dfs function
    private void dfsUtil(int source, boolean[] visited) {
        visited[source] = true;
        count++;

        if (count < adj.length)
            System.out.print(source + "->");
        else
            System.out.println(source);

        for (int neighbor : adj[source]) {
            if (!visited[neighbor])
                dfsUtil(neighbor, visited);
        }
    }

    public void dfs(int source) {
        boolean[] visited = new boolean[adj.length];
        visited[source] = true;
        dfsUtil(source, visited);
    }

    public void bfs(int source) {
        boolean[] visited = new boolean[adj.length];
        int[] level = new int[adj.length];

        visited[source] = true;
        level[source] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currElement = queue.poll();

            System.out.println(currElement + "->");

            // printing all nodes at a given distance from source to destination
//            if(level[currElement] == 2)
//                System.out.println(currElement);

            for (int neighbour : adj[currElement]) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    level[neighbour] = level[currElement] + 1;
                }
            }
        }
        // finding shortest distance
//        System.out.println(level[5]);
    }

}

class Tester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();
        Graph graph = new Graph(numVertices);

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            graph.connectEdge(source, destination);
        }

        // DFS
//        System.out.println("Please enter source node for DFS: ");
//        int source = scan.nextInt();
//        graph.dfs(source);

        // Check if the path exists between any two nodes or not
//        System.out.println("Please enter destination node for DFS: ");
//        int destination = scan.nextInt();

        // BFS
        System.out.println("Please enter source node for BFS: ");
        int source = scan.nextInt();
        graph.bfs(source);

        // shortest distance from source for given destination
//        System.out.println("Please enter destination node for BFS: ");
//        int destination = scan.nextInt();

    }
}

