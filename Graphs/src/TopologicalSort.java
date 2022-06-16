// Topological Sort is the permutation of the vertices of the graph such that for any
// given edge u->v, u is always before v.

// Topological Sort is always opposite to the order of work.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class TopologicalGraph {

    ArrayList<Integer>[] adj;

    public TopologicalGraph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination) {
        // For directed graph
        adj[source].add(destination);
    }
}

public class TopologicalSort {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();
        TopologicalGraph graph = new TopologicalGraph(numVertices);

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            graph.connectEdge(source, destination);
        }

        boolean[] visited = new boolean[numVertices];
        Stack<Integer> topologicalStack = new Stack<>();

        for (int i = 0; i < numVertices; i++) {
            if(!visited[i])
                topologicalSort(graph,i,visited, topologicalStack);
        }

        while(!topologicalStack.isEmpty())
            System.out.println(topologicalStack.pop());
    }

    private static void topologicalSort(TopologicalGraph graph,int vertex,boolean[] visited, Stack<Integer> stack){

        visited[vertex] = true;

        for(int nbr: graph.adj[vertex]){
            if(!visited[nbr])
                topologicalSort(graph,nbr,visited,stack);
        }
        stack.push(vertex);
    }

}
