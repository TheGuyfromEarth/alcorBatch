public class NQueens {

    // It tells whether the queen can be placed or not in the given coordinates of the cell
    public boolean isValid(int[][] board, int x, int y) {

        // Checking if queen exists in that particular col or not
        for (int row = 0; row < x; row++) {
            if (board[row][y] == 1)
                return false;
        }

        int row = x;
        int col = y;

        // Checking if queen exists in upper left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 1)
                return false;
            row--;
            col--;
        }

        row = x;
        col = y;

        // Checking if queen exists in upper right diagonal
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 1)
                return false;
            row--;
            col++;
        }

        return true;
    }

    public void solveNQueens(int[][] board, int row) {
        // Base Condition
        if (row == board.length) {
            printBoard(board);
            System.out.println();
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                // So, since isValid returned true, hence queen can be placed here
                board[row][col] = 1;
                // Making a recursive call
                solveNQueens(board, row + 1);
                // We need to do back track if recursive call doesn't return true
                board[row][col] = 0; // set value back to zero
            }
        }
    }

    private void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}