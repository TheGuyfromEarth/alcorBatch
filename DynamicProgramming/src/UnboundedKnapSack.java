public class UnboundedKnapSack {

    public static void main(String[] args) {

        int[] weights = {2, 3, 1, 6, 4};
        int[] value = {15, 20, 10, 35, 12};

        int capacity = 6;
        System.out.println(maxValue(weights, value, capacity));
    }

    private static int maxValue(int[] weights, int[] value, int capacity) {

        int[] dp = new int[capacity + 1];
        dp[0] = 0;

        for (int col = 1; col < dp.length; col++) {
            int max = 0;
            for (int wtIndex = 0; wtIndex < weights.length; wtIndex++) {

                if (weights[wtIndex] <= col) {
                    int remWt = col - weights[wtIndex];
                    int remWtVal = dp[remWt];
                    if (remWtVal + value[wtIndex] > max)
                        max = remWtVal + value[wtIndex];
                }

            }
            dp[col] = max;
        }
        return dp[capacity];
    }
}