// Bipartite Graph:
// is a graph that once divided into two sets, it satisfies following props:
// Mutually Exclusive
// Exhaustive
// All edges should be across sets

// Acyclic Grpah is always Bipartite
// Cyclic Grpah:
// a) Having even vertices and edges will be bipartite
// b) Having odd vertices and edges will be non bipartite

import java.util.*;

class YourGraph {

    ArrayList<Integer>[] adj;
    static int count = 0;

    public YourGraph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }
}


public class IsGraphBipartite {
    static YourGraph graph;
    static int[] level;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();
        graph = new YourGraph(numVertices);

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            graph.connectEdge(source, destination);
        }
        level = new int[graph.adj.length];
        Arrays.fill(level, -1);

        boolean flag = true;

        for (int k = 0; k < graph.adj.length; k++) {
            if (level[k] == -1) {
                flag = isGraphBipartite(graph, k);
                if (!flag)
                    break;
            }
        }
        if (flag) {
            System.out.println("Bipartite Graph");
        } else
            System.out.println("Non Bipartite Graph");
    }

    private static boolean isGraphBipartite(YourGraph graph, int source) {

        Queue<Node> queue = new LinkedList<>();


        level[source] = 0;
        Node sourcePair = new Node(source, level[source]);
        queue.add(sourcePair);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            // cyclic case
            if (level[currNode.vertex] != -1 && currNode.vertex != source) {
                // write some code here
                // even cyclic case
                if (currNode.level == level[currNode.vertex])
                    return true;
                else
                    // odd cyclic case
                    return false;
            }

            level[currNode.vertex] = currNode.level;

            for (int neighbour : graph.adj[currNode.vertex]) {
                if (level[neighbour] == -1) {
                    queue.add(new Node(neighbour, currNode.level + 1));
                }
            }

        }

        return true;
    }

}

class Node {

    int vertex;
    int level;

    public Node(int vertex, int level) {
        this.vertex = vertex;
        this.level = level;
    }
}

