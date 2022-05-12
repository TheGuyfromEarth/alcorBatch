public class KnightsTour {

    public static boolean flag = false;

    public void knightsTour(int[][] board, int row, int col, int move) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board.length - 1 || board[row][col] > 0) {
            return;
        }
        // base condition
        else if (move == board.length * board.length) {
            // to enter last value in board
            board[row][col] = move;
            printBoard(board);
            System.out.println();
            board[row][col] = 0;
            return;
        }

        board[row][col] = move;

        // recursive call
        knightsTour(board, row - 2, col + 1, move + 1);
        knightsTour(board, row - 1, col + 2, move + 1);
        knightsTour(board, row + 1, col + 2, move + 1);
        knightsTour(board, row + 2, col + 1, move + 1);
        knightsTour(board, row + 2, col - 1, move + 1);
        knightsTour(board, row + 1, col - 2, move + 1);
        knightsTour(board, row - 1, col - 2, move + 1);
        knightsTour(board, row - 2, col - 1, move + 1);

        // backtracking
        board[row][col] = 0;
    }

    private void printBoard(int[][] board) {
        flag = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
