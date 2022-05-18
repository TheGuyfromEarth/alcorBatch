import java.util.Scanner;

public class MinimumCostPath {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        Scanner scan = new Scanner(System.in);

        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        System.out.println(minCostPath(matrix));
    }

    private static int minCostPath(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = dp.length-1; i>=0; i--){
            for(int j = dp[0].length -1 ; j>=0; j--){
                if(i == matrix.length-1 && j ==  matrix[0].length - 1){
                    dp[i][j] = matrix[i][j];
                }
                else if(i == matrix.length - 1){
                    dp[i][j] = matrix[i][j] + dp[i][j+1];
                }
                else if(j == matrix[0].length - 1){
                    dp[i][j] = matrix[i][j] + dp[i+1][j];
                }
                else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
