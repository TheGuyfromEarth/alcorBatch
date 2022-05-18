import java.util.Scanner;

public class GoldMine {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        System.out.println(maxGold(matrix));
    }

    private static int maxGold(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int col = matrix[0].length-1; col>=0; col--){
            for(int row = matrix.length-1; row>=0; row--){
                if(col == matrix[0].length - 1){
                    dp[row][col] = matrix[row][col];
                }
                else if(row == matrix.length - 1)
                {
                    dp[row][col] = matrix[row][col] + Math.max(dp[row][col+1],dp[row-1][col+1]);
                }
                else if(row == 0){
                    dp[row][col] = matrix[row][col] + Math.max(dp[row][col+1],dp[row+1][col+1]);
                }
                else{
                    dp[row][col] = matrix[row][col] + Math.max(dp[row][col+1],Math.max(dp[row-1][col+1],dp[row+1][col+1]));
                }

            }
        }

        int sum = 0;
        for(int k = 0; k<dp.length;k++){
            if(sum < dp[k][0])
            sum = dp[k][0];
        }
    return sum;
    }
}