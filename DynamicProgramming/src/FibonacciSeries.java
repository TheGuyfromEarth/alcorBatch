public class FibonacciSeries {

    static int count = 0;

    public static void main(String[] args) {

        int n = 8;
        int[] dp = new int[n + 1];
        System.out.println(fibonacci(n, dp));

    }

    private static int fibonacci(int n, int[] dp) {

        // base condition
        if (n == 0 || n == 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        int fib1 = fibonacci(n - 1,dp);
        int fib2 = fibonacci(n - 2,dp);

        int fibn = fib1 + fib2;

        dp[n] = fibn;

        return fibn;
    }
}

// Memoization (top to bottom)
// Tabular Approach (bottom to top)
