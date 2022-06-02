// You will be given a graph, where vertex represent the nth person and persons are connected
// using the edges in the graph. If given that at t=1, person 1 is already infected.
// How many persons will be infected at t=n? Given that all neighbours of a person
// get infected together.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PersonGraph {

    ArrayList<Integer>[] adj;
    static int count = 0;

    public PersonGraph(int numVertices) {
        adj = new ArrayList[numVertices + 1];
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

}

public class InfectionSpread {
    static PersonGraph personGraph = new PersonGraph(7);

    public static void main(String[] args) {
        int sourcePerson = 1;
        int time = 4;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            personGraph.connectEdge(source, destination);
        }
        System.out.println(bfs(sourcePerson,time));
    }


    private static int bfs(int sourcePerson, int time){

        int[] level = new int[personGraph.adj.length+1];

        Queue<Integer> pairQueue = new LinkedList<>();

        pairQueue.add(sourcePerson);

        level[sourcePerson] = 1;
        int count = 1;

        while(!pairQueue.isEmpty()){

            int currPersonDetails = pairQueue.poll();

            if(level[currPersonDetails] == time)
                return count;


            for(int neighbour : personGraph.adj[currPersonDetails]){
                if(level[neighbour] == 0){
                    pairQueue.add(neighbour);
                    level[neighbour] = level[currPersonDetails]+1;
                    count++;
                }
            }

        }
    return count;

    }
}


