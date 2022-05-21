public class KnapSack01 {

    public static void main(String[] args) {

        int[] weights = {2, 5, 3, 1, 6};
        int[] value = {25, 18, 5, 10, 20};

        int capacity = 6;
        System.out.println(maxValue(weights,value,capacity));
    }

    private static int maxValue(int[] weights, int[] value, int capacity) {

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
        return dp[weights.length][capacity];
    }
}
