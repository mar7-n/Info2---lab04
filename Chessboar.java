import java.util.Arrays;

public class Chessboar {
    static final int N = 5;
    public static void main(String[] args) {
   //N x N chess board



        int[][] board = new int[N][N];

        for (int[] row : board) {
            Arrays.fill(row, 0);
        }

        solveNQueen(board,0,0);

        //newprintSolution(board);


    }

    // print the final solution matrix
    static void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                System.out.print(" " + board[i][j]
                        + " ");
            }
            System.out.println();
           // System.out.print(" \n" + "Result: "+ i);
        }
        System.out.print(" \n");
    }
    static void placeQueen(int board[][],int row, int column){
        board[row][column] = 1;
    }
    static boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;


        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
    // The function that solves the problem using backtracking
    public static void solveNQueen(int board[][], int col , int row)
    {
        if (col >= N) {
            printSolution(board);
            return;
        }

        for (int i = row; i <N; i++) {
            //if it is safe to place the queen at position i,col -> place it
            if (isSafe(board, i, col)) {
                //board[i][col] = 1;
                placeQueen(board,i,col);
                solveNQueen(board, col + 1,0);

                //backtrack if the above condition is false
                board[i][col] = 0;
            }
        }




    }


}
