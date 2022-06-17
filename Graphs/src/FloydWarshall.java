import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class FWPair {
    int src;
    int dest;
    int wt;

    public FWPair(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}


class FWGraph {

    ArrayList<FWPair>[] adj;
    static int[][] dp;

    public FWGraph(int numVertices) {
        adj = new ArrayList[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        dp = new int[numVertices][numVertices];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
    }

    public void connectEdge(int source, int destination, int wt) {
        // For directed graph
        adj[source].add(new FWPair(source, destination, wt));
        adj[destination].add(new FWPair(destination, source, wt));
        dp[source][destination] = wt;
        dp[destination][source] = wt;
    }
}

public class FloydWarshall {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        int numVertices = scan.nextInt();
        FWGraph graph = new FWGraph(numVertices);

        System.out.println("Enter the number of edges: ");
        int numEdges = scan.nextInt();

        System.out.println("Enter source and destination for edge: ");

        for (int i = 0; i < numEdges; i++) {
            int source = scan.nextInt();
            int destination = scan.nextInt();
            int wt = scan.nextInt();
            graph.connectEdge(source, destination, wt);
        }

        int[][] dpArr = graph.dp;

        floydWarshall(dpArr, graph);

        // print the final dp array
        for (int i = 0; i < dpArr.length; i++) {
            for (int j = 0; j < dpArr[i].length; j++) {
                if (dpArr[i][j] == Integer.MAX_VALUE)
                    System.out.print("I ");
                else
                    System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floydWarshall(int[][] dp, FWGraph graph) {

        for (int k = 0; k < graph.adj.length; k++) {
            for (int i = 0; i < graph.adj.length; i++) {
                for (int j = 0; j < graph.adj.length; j++) {
                    if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }
}
