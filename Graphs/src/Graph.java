import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    ArrayList<Integer>[] adj;

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

    }
}

