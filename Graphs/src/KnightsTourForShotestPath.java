// Consider a chess board, in that chess board, there exists a knight at a given position and
// we need to reach the given destination using the shortest path.

// Ex: source - a1
// destination - h8
// output - 6


import java.util.ArrayList;

class Graphs {

    ArrayList<Integer>[] adj;
    static int count = 0;

    public Graphs(int numVertices) {
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

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class KnightsTourForShotestPath {

    public static void main(String[] args) {

        String source = "a1";
        String destination = "h8";
        int x = getX(source);
        int y = getY(source);
        Pair sourcePair = new Pair(x, y);
        x = getX(destination);
        y = getY(destination);
        Pair destPair = new Pair(x, y);
    }

    public static int getX(String str) {
        return str.charAt(0) - 'a';
    }

    public static int getY(String str) {
        // 0 based indexing
        return str.charAt(1) - '1';
    }
}
