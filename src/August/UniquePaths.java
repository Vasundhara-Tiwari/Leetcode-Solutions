package August;

public class UniquePaths {
    public static void main(String[] args) {
        int r = 3;
        int c = 7;
        int[][] dp = new int[r][c];
        System.out.println(uniquePath(0, 0, r, c, dp));
    }

    private static int uniquePath(int cr, int cc, int er, int ec, int[][] dp) {
        if(cr == er-1 && cc == ec-1){
            return 1;
        }
        if(cr >= er || cc >= ec){
            return 0;
        }
        if(dp[cr][cc] != 0){
            return dp[cr][cc];
        }
        int right = uniquePath(cr, cc+1, er, ec, dp);
        int down = uniquePath(cr+1, cc, er, ec, dp);
        return dp[cr][cc] = right + down;
    }
}
