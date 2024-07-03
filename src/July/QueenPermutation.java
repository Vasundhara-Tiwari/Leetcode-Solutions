package July;

public class QueenPermutation {
    public static void main(String[] args) {
        int n = 4;
        boolean[] board = new boolean[n];
        int q = 2;
        queenPermutation(board, q, "", 0);
    }
    public static void queenPermutation(boolean[] board, int tq, String ans, int qpsf){
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < board.length; i++){
            if(!board[i]){
                board[i] = true;
                queenPermutation(board, tq, ans+" b"+i+"q"+qpsf, qpsf+1);
                board[i] = false;
            }
        }
    }
}
