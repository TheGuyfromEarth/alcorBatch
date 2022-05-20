// Given an array with numbers, find out whether there exists a subset using which we can achieve the
// given target.

// Ex: arr = {2,3,5} => {},{2},{3},{5},{2,3},{3.5},{2,5},{2,3,5}
// target = 9 => res - false
// target = 8 => res - true

public class NSubset {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5};
        int target = 10;
        System.out.println(hasSubset(arr, target));
    }

    private static boolean hasSubset(int[] arr, int target) {

        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    // Not considering the current element
                    if (dp[i - 1][j])
                        dp[i][j] = dp[i - 1][j];
                    else {
                        // We are considering the current element as well
                        if (j >= arr[i - 1]) {
                            int rem = j - arr[i - 1];
//                        if(dp[i-1][rem])
                            dp[i][j] = dp[i - 1][rem];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
