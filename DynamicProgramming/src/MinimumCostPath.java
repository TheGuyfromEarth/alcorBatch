import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinimumCostPath {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        minCostPath(matrix);
    }

    private static void minCostPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == matrix.length - 1 && j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j];
                } else if (i == matrix.length - 1) {
                    dp[i][j] = matrix[i][j] + dp[i][j + 1];
                } else if (j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
        // find the min cost paths
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, ""));

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();

            if ((currPair.row == matrix.length - 1 && currPair.col == matrix[0].length - 1)) {
                System.out.println(currPair.path);
            } else {
                if (currPair.row == matrix.length - 1) {
                    queue.add(new Pair(currPair.row, currPair.col + 1, currPair.path + "H"));
                } else if (currPair.col == matrix[0].length - 1) {
                    queue.add(new Pair(currPair.row + 1, currPair.col, currPair.path + "V"));
                } else {
                    if (dp[currPair.row + 1][currPair.col] < dp[currPair.row][currPair.col + 1]) {
                        queue.add(new Pair(currPair.row + 1, currPair.col, currPair.path + "V"));
                    } else if (dp[currPair.row + 1][currPair.col] > dp[currPair.row][currPair.col + 1]) {
                        queue.add(new Pair(currPair.row, currPair.col + 1, currPair.path + "H"));
                    } else {
                        queue.add(new Pair(currPair.row + 1, currPair.col, currPair.path + "V"));
                        queue.add(new Pair(currPair.row, currPair.col + 1, currPair.path + "H"));
                    }
                }
            }

        }
    }
}

class Pair {

    int row;
    int col;
    String path;

    public Pair(int row, int col, String path) {
        this.row = row;
        this.col = col;
        this.path = path;
    }
}
