package July;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        int[][] realOnes = new int[board.length][board[0].length];
        for (int cr = 0; cr < board.length; cr++) {
            for (int cc = 0; cc < board[0].length; cc++) {
                int liveNeighbours = gameOfLife(board, cr+1, cc)
                        + gameOfLife(board, cr+1, cc-1)
                        + gameOfLife(board, cr+1, cc+1)
                        + gameOfLife(board, cr-1, cc)
                        + gameOfLife(board, cr-1, cc-1)
                        + gameOfLife(board, cr-1, cc+1)
                        + gameOfLife(board, cr, cc-1)
                        + gameOfLife(board, cr, cc+1);
                if (board[cr][cc] == 1){
                    realOnes[cr][cc] = (liveNeighbours < 2 || liveNeighbours > 3) ? 0 : 1;
                } else{
                    realOnes[cr][cc] = (liveNeighbours == 3) ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            board[i] = realOnes[i].clone();
        }
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private static int gameOfLife(int[][] board, int cr, int cc) {
        if( cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length || board[cr][cc] == 0 ){ return 0; }                          // out of bound cases
        return 1;
    }
}
