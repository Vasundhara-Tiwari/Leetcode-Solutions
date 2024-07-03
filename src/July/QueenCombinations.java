package July;

import static July.QueenPermutation.queenPermutation;

public class QueenCombinations {
    public static void main(String[] args) {
        int n = 4;
        boolean[] board = new boolean[n];
        int q = 2;
        combination(board, q, "", 0, 0);
    }
    public static void combination(boolean[] board, int tq, String ans, int qpsf, int index){
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }
        for(int i = index; i < board.length; i++){
            if(!board[i]){
                board[i] = true;
                combination(board, tq, ans+" b"+i+"q"+qpsf, qpsf+1, i+1);
                board[i] = false;
            }
        }
    }
}
