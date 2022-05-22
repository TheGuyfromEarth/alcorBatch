// Given a string, return the total no of palindromic substrings.

// Ex: I/P -> str = "abbc"
// O/P -> 5

// a    b   b   c
// ab   bb  bc
// abb  bbc
// abbc

// Total no of substrings = n*(n+1)/2

public class CountPalindromicSubstrings {

    public static void main(String[] args) {
        String str = "abbc";
        System.out.println(countPalindromicSubstrings(str));
    }

    private static int countPalindromicSubstrings(String str) {

        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;

        for (int gap = 0; gap < str.length(); gap++) { // N-1
            for (int i = 0, j = gap; j < str.length(); i++, j++) { //N

                // case for main diagonal (only one single character)
                if(gap == 0){
                    dp[i][j] = true;
                }
                // case for just upper left diagonal to the main diagonal (two characters only)
                else if(gap == 1){
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                }
                // case for other upper diagonals
                else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
                // If true, then increase count
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
}
