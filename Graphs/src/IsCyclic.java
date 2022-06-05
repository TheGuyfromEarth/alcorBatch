// Given a graph, return true if there exists a cycle in the graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MyGraph {

    ArrayList<Integer>[] adj;

    public MyGraph(int numVertices) {
        adj = new ArrayList[numVertices+1];
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }
}

public class IsCyclic {

    public static void main(String[] args) {
        MyGraph graph = new MyGraph(7);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            graph.connectEdge(source, destination);
        }

        System.out.println(isCyclic(5,graph));
    }

    private static boolean isCyclic(int source,MyGraph graph){

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.adj.length+1];
        queue.add(source);


        while(!queue.isEmpty()){

            int currVertex = queue.poll();

            // condition to check if the node is already visited, if it is visited, that
            // will be sufficient to conclude that a cycle exists
            if(visited[currVertex])
            {
                // write some code here
                return true;
            }
            visited[currVertex] = true;

            for(int neighbour :graph.adj[currVertex]){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                }
            }
        }

        return false;
    }

}
