import java.util.LinkedList;
import java.util.Queue;

public class KnapSack01 {

    public static void main(String[] args) {

        int[] weights = {2, 5, 3, 1, 6};
        int[] value = {25, 18, 5, 10, 40};

        int capacity = 6;
        maxValue(weights, value, capacity);
    }

    private static void maxValue(int[] weights, int[] value, int capacity) {

        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (j >= weights[i - 1]) {
                    int wtVal = value[i - 1];
                    int remWt = j - weights[i - 1];
                    int remWtVal = dp[i - 1][remWt];
                    if (wtVal + remWtVal > dp[i - 1][j])
                        dp[i][j] = wtVal + remWtVal;
                    else
                        dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[weights.length][capacity]);

        // print the combination of weights

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(dp.length - 1, capacity, ""));

        while (!queue.isEmpty()) {

            Pair currPair = queue.poll();

            if (currPair.row == 0 || currPair.col == 0) {
                System.out.println(currPair.path);
            } else {
                int exclude = dp[currPair.row - 1][currPair.col];
                if (currPair.col >= weights[currPair.row - 1]) {
                    int remWt = currPair.col - weights[currPair.row - 1];
                    int include = value[currPair.row - 1] + dp[currPair.row - 1][remWt];

                    if(include>=exclude)
                        queue.add(new Pair(currPair.row-1,remWt,currPair.path+weights[currPair.row-1]+" "));
                }

                if(dp[currPair.row][currPair.col] == exclude)
                    queue.add(new Pair(currPair.row-1,currPair.col, currPair.path));
            }
        }
    }
}
