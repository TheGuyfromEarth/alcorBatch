// Given a source and a destination, find all paths from source to destination.

import java.util.ArrayList;
import java.util.HashSet;
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

//        System.out.println(hasPath(graph, 0, 4, visited));
        //        allPaths(graph,0,5,visited,"0");

        HashSet<Integer> visitedSet = new HashSet<>();
        hamiltonian(graph, 2, visitedSet, "2", 2);
    }

    private static boolean hasPath(PathGraph graph, int source, int destination, boolean[] visited) {
        // has path base condition
        if (source == destination)
            return true;

        visited[source] = true;

        for (int nbr : graph.adj[source]) {
            if (!visited[nbr]) {
                if (hasPath(graph, nbr, destination, visited))
                    return true;
            }
        }
        return false;
    }

    private static void allPaths(PathGraph graph, int source, int destination, boolean[] visited, String path) {
        // has path base condition
        if (source == destination) {
            System.out.println(path);
            return;
        }

        visited[source] = true;

        for (int nbr : graph.adj[source]) {
            if (!visited[nbr]) {
                allPaths(graph, nbr, destination, visited, path + "->" + nbr);
            }
        }
        visited[source] = false;
    }

    private static void hamiltonian(PathGraph graph, int source, HashSet<Integer> visitedSet, String path, int orgSrc) {
        // has path base condition

        if (visitedSet.size() == graph.adj.length - 1) {
            boolean isCycle = false;

            for (int nbr : graph.adj[source]) {
                if (nbr == orgSrc) {
                    isCycle = true;
                    break;
                }
            }

            if (isCycle)
                System.out.println("Hamiltonian Cycle: " + path);
            else
                System.out.println("Hamiltonian Path: " + path);
        }

        visitedSet.add(source);

        for (int nbr : graph.adj[source]) {
            if (!visitedSet.contains(nbr)) {
                hamiltonian(graph, nbr, visitedSet, path + "->" + nbr, orgSrc);
            }
        }
        visitedSet.remove(source);
    }


}
