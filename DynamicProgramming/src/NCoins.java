// Given an array of coins having different denominations, then we need to tell
// how many possible permutations/combinations exist to achieve the target. It is given that we have
// infinite supply of coins.

// Example -> arr = {2,3,5}
// target -> 5

// O/P permutation -> {   (3,2)
//            (2,3)
//            (5)
//            }

// O/P combinations -> {
//            (2,3)
//            (5)
//            }

// target -> 6
/* o/p -> { (2,2,2), (3,3)
}
 */

// target -> 7
/*o/p permutations -> { (2,2,3), (3,2,2),(2,3,2)
        (5,2),(2,5)
}
 */
/*o/p combinations -> { (2,2,3)
        (5,2)
}
 */

public class NCoins {

    public static void main(String[] args) {

        int[] coins = {2,3,5};
        int target = 7;
//        System.out.println(nCoins(coins,target));
        System.out.println(nCoinsPermutations(coins,target));
    }

    // To find n number of combinations for a given target and given denominations
    private static int nCoins(int[] coins, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {
               if(coins[i] <= j){
                   int rem = j - coins[i];
                   dp[j] += dp[rem];
               }
            }
        }
        return dp[target];
    }

    // To find n number of permutations for a given target and given denominations
    private static int nCoinsPermutations(int[] coins, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int col = 1; col<=target;col++){
            for(int coin:coins){
                if(coin <= col){
                    int remAmt = col - coin;
                    dp[col] += dp[remAmt];
                }
            }
        }
        return dp[target];
    }
}
