import java.util.*;
import java.util.List;

public class UtilityClass {

    static final int N = 4;
    private static final int ROWS = N;
    private static final int COLUMNS = N;
    static List<int[][]> list1 = new ArrayList<>();


    public static void solveNQueen(int a[][], int row, int col )  {

        if (col >= N) {
            // If all queens have been placed, add a copy of the current board configuration to the result list
            int[][] copy = Arrays.copyOf(a, a.length);
            synchronized (CanvasUi.configurations) {
                CanvasUi.configurations.add(copy);
            }
            //System.out.println("config:");
            for (int[][] configuration : CanvasUi.configurations) {
                System.out.println(Arrays.deepToString(configuration));
            }
            //CanvasUiGPT.configurations.remove(1);
            return;
        }

        for (int i = row; i < N; i++) {
            //if it is safe to place the queen at position i,col -> place it
            if (isSafe(a, i, col)) {
                a[i][col] = 1;
                // Recursively call the function to place the remaining queens
               solveNQueen(a, 0, col + 1);
                // Backtrack and remove the queen from position i,col
                a[i][col] = 0;
            }
        }
            return ;
    }

    static boolean isSafe(int[][] board, int row, int col) {
        // Check if any queens in the same row
        for (int i = 0; i < COLUMNS; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check if any queens in the same column
        for (int i = 0; i < ROWS; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check if any queens on the diagonal going from bottom left to top right
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check if any queens on the diagonal going from top left to bottom right
        for (int i = row, j = col; i < ROWS && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // If no queens found in the same row, column, or diagonals, it is safe to place a queen at (row, col)
        return true;
    }

}
