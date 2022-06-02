// Consider a chess board, in that chess board, there exists a knight at a given position and
// we need to reach the given destination using the shortest path.

// Ex: source - a1
// destination - h8
// output - 6


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
        String destination = "a2";
        int x = getX(source);
        int y = getY(source);
        Pair sourcePair = new Pair(x, y);
        x = getX(destination);
        y = getY(destination);
        Pair destPair = new Pair(x, y);
        int numJumps = bfs(sourcePair,destPair);
        if(numJumps==-1)
            System.out.println("No path exists");
        else
            System.out.println(numJumps);

    }

    // we are within the confines of the board
    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<=7 && y<=7;
    }

    private static int bfs(Pair sourcePair, Pair destPair){

        int[][] level = new int[8][8];
        for(int k=0;k<8;k++)
            Arrays.fill(level[k],-1);

        int[] moves = {-1,1,-2,2};

        Queue<Pair> queue = new LinkedList<>();

        queue.add(sourcePair);
        level[sourcePair.x][sourcePair.y] = 0;

        while(!queue.isEmpty()){

            Pair currPair = queue.poll();

            // creating knight's possible moves
            for(int i: moves){
                for(int j: moves){
                    if(Math.abs(i)!=Math.abs(j)) {
                        if(isValid(currPair.x+i, currPair.y+j) && level[currPair.x+i][currPair.y+j]==-1){
                            queue.add(new Pair(currPair.x+i, currPair.y+j));
                            level[currPair.x+i][currPair.y+j] =  level[currPair.x][currPair.y]+1;
                        }
                    }
                }
            }

            if(level[destPair.x][destPair.y]>-1){
                return level[destPair.x][destPair.y];
            }
        }
        return -1;
    }

    public static int getX(String str) {
        return str.charAt(0) - 'a';
    }

    public static int getY(String str) {
        // 0 based indexing
        return str.charAt(1) - '1';
    }
}
