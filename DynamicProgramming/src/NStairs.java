// Given N stairs, then we need to find the total possible ways to reach from Nth Step to 0th Step.
// You can run One step, Two Steps or Three Steps at a time.

public class NStairs {

    public static void main(String[] args) {

        int N = 5;
        int[] dp = new int[N + 1];
//        System.out.println(numSteps(N, dp));
        System.out.println(countStepsUsingTabulation(N));
    }

    private static int numSteps(int N, int[] dp) {

        // base case
        if (N == 0)
            return 1;

        if (N < 0)
            return 0;

        if (dp[N] != 0)
            return dp[N];

        int x = numSteps(N - 1, dp);
        int y = numSteps(N - 2, dp);
        int z = numSteps(N - 3, dp);

        int totSteps = x + y + z;

        dp[N] = totSteps;

        return totSteps;
    }

    // N = 4
    // 1    1     2     4    7
    // 0    1     2     3    4
    private static int countStepsUsingTabulation(int N) {

        int[] dp = new int[N + 1]; // 5

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (i == 1)
                dp[i] = dp[i - 1];
            else if (i == 2)
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[N];
    }
}
