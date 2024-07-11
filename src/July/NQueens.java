package July;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        nQueens(n, new boolean[n][n], 0);
    }
    public static void nQueens(int n, boolean[][] board, int row){
        if(n == 0){
            display(board);
            System.out.println();
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = true;
                nQueens(n-1, board, row+1);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int r = row; r >= 0 ; r--) {
            if(board[r][col] == true){
                return false;
            }
        }
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if(board[r][c] == true){
                return false;
            }
        }
        for(int r = row, c = col; r >= 0 && c < board[0].length; r--, c++){
            if(board[r][c] == true){
                return false;
            }
        }
        return true;
    }


    private static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
