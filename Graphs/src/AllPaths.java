// Given a source and a destination, find all paths from source to destination.

import java.util.ArrayList;
import java.util.Scanner;

class PathGraph {

    ArrayList<Integer>[] adj;

    public PathGraph(int numVertices) {
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

public class AllPaths {

    public static void main(String[] args) {

        PathGraph graph = new PathGraph(6);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            graph.connectEdge(source, destination);
        }

        boolean[] visited = new boolean[6];

        System.out.println(hasPath(graph,0,5,visited));

    }

    private static boolean hasPath(PathGraph graph, int source, int destination, boolean[] visited){
        // has path base condition
        if(source == destination)
            return true;

        visited[source] = true;

       for(int nbr : graph.adj[source]){
           if(!visited[nbr]){
               if(hasPath(graph,nbr,destination,visited))
                   return true;
           }
       }
        return false;
    }

}
