// Write the program to find the value for Nth Catalan Number. Given that C0 = C1 = 1.

// Example: N = 4
// O/P -> C4 = C0C3 + C1C2 + C2C1 + C3C0

// Ex: N = 2
// O/P -> C2 = C0C1 + C1C0

// Ex: N = 2
// O/P -> C3 = C0C2 + C1C1 + C2C0

// N = 5
// O/P -> C5 = C0C4 + C1C3 + C2C2 + C3C1 + C4C0

public class CatalanNumbers {

    public static void main(String[] args) {

        int N = 5;
        System.out.println(catanNumber(N));
    }

    private static int catanNumber(int N) {
        int[] dp = new int[N + 1];

        dp[0] = dp[1] = 1;

        for (int j = 2; j <= N; j++) {
            for (int i = 0; i < j; i++) {

                dp[j] += dp[i] * dp[j - i - 1];
            }
        }
        return dp[N];
    }

}
