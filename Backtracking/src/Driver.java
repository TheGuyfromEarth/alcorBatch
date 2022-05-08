public class Driver {

    public static void main(String[] args) {

        int[][] board = new int[2][2];
        NQueens nQueens = new NQueens();
        if(nQueens.solveNQueens(board,0)) {
            System.out.println("Queens placed successfully");

            for(int i = 0; i< board.length; i++){
                for (int j = 0; j< board.length; j ++)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
        else
            System.out.println("Solution doesn't exist");
    }
}
