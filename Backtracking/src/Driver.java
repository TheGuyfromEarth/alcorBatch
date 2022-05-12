public class Driver {

    public static void main(String[] args) {

        int[][] board = new int[5][5];
//        NQueens nQueens = new NQueens();
//        nQueens.solveNQueens(board,0);

        KnightsTour knightsTour = new KnightsTour();
        knightsTour.knightsTour(board,2,4,1);
        System.out.println(!KnightsTour.flag ? "No solution exists":"");
    }
}
