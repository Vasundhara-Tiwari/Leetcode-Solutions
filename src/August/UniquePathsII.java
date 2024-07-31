package August;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        System.out.println(uniquePath(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length, dp));
    }

    private static int uniquePath(int[][] grid, int cr, int cc, int er, int ec, int[][] dp) {
        if(cr == er-1 && cc == ec-1){
            return 1;
        }
        if(cr >= er || cc >= ec || grid[cr][cc] == 1){
            return 0;
        }
        if(dp[cr][cc] != 0){
            return dp[cr][cc];
        }
        int right = uniquePath(grid, cr, cc+1, er, ec, dp);
        int down = uniquePath(grid,cr+1, cc, er, ec, dp);
        return dp[cr][cc] = right + down;
    }
}
