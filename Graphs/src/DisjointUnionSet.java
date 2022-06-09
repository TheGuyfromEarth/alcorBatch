import java.util.HashMap;
import java.util.Scanner;

public class DisjointUnionSet {

    static int[] parent;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();

        parent = new int[numVertices];

        for(int i=0;i<numVertices;i++){
            make(i);
        }

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        for(int j=0;j<numEdges;j++){
            int source = scan.nextInt();
            int dest = scan.nextInt();
            union(source,dest);
        }
    }

    private static void make(int node){
        parent[node] = node;
    }

    private static int find(int node){
        if(parent[node] == node)
            return node;
        return find(parent[node]);
    }

    private static void union(int source, int destination){
        parent[source] = destination;
    }
}
