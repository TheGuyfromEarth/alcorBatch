import com.sun.source.tree.MemberSelectTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class MSTGraph {

    ArrayList<MSTPair>[] adj;


    public MSTGraph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void connectEdge(int source, int destination, int weight) {
        adj[source].add(new MSTPair(source,destination,weight));
        adj[destination].add(new MSTPair(destination,source,weight));

    }
}

class MSTPair implements Comparable<MSTPair> {
    int source;
    int destination;
    int weight;

    public MSTPair(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }


    @Override
    public int compareTo(MSTPair mstPair) {
        return this.weight - mstPair.weight;
    }
}


public class DisjointUnionSet {

    static int[] parent;
    static int[] size;
    static  MSTPair[] edgeArray;

    //   main method for Kruskal's Algorithm to create MST
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();



        MSTGraph graph = new MSTGraph(numVertices);

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        edgeArray = new MSTPair[numEdges];

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            int weight = scan.nextInt();
            edgeArray[i] = new MSTPair(source,destination,weight);
            graph.connectEdge(source, destination, weight);
        }


    }

    private static void kruskals(MSTGraph graph){

        for(int i=0;i<graph.adj.length;i++){
            make(i);
        }
        // sort the edgeArray
        Arrays.sort(edgeArray);
    }

    // main method for Disjoint Union Set to find number of connected components
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the no of vertices: ");
//        int numVertices = scan.nextInt();
//
//        parent = new int[numVertices];
//        size = new int[numVertices];
//
//        for (int i = 0; i < numVertices; i++) {
//            make(i);
//        }
//
//        System.out.println("Enter the number of edges: ");
//        int numEdges = scan.nextInt();
//
//        for (int j = 0; j < numEdges; j++) {
//            int source = scan.nextInt();
//            int dest = scan.nextInt();
//            union(source, dest);
//        }
//
//        int numConnectedComps = 0;
//        for (int i = 0; i < numVertices; i++) {
//            if (parent[i] == i)
//                numConnectedComps++;
//        }
//        System.out.println(numConnectedComps);
//    }

    private static void make(int node) {
        parent[node] = node;
        size[node] = 1;
    }

    // return the root parent for any given node
    private static int find(int node) {
        if (parent[node] == node)
            return node;
        // Path Compression Technique
        return parent[node] = find(parent[node]);
    }

    private static void union(int nodeA, int nodeB) {
        int parentA = find(nodeA);
        int parentB = find(nodeB);

        if (parentA != parentB) {
            // nodeA and nodeB are part of different components
            if (size[parentA] > size[parentB]) {
                parent[parentB] = parentA;
                size[parentA] += size[parentB];
            } else {
                parent[parentA] = parentB;
                size[parentB] += size[parentA];
            }
        }


    }
}

// Amortized Time Complexity (Path Compression and Size Optimization) = O(a(n))
// where a(n) is called as reverse Ackerman Function

// Highest Value observed for a(n) is approx equal to 4 until n <= 10^600


