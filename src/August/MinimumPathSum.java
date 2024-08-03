package August;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4, 5, 6}};
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        System.out.println(minimumPathSum(grid, 0, 0, grid.length, grid[0].length, dp, grid[0][0]));
    }

    private static int minimumPathSum(int[][] grid, int cr, int cc, int er, int ec, int[][] dp, int sum) {
        if(cc == ec-1 && cr == er-1){
            return grid[cr][cc];
        }
        if (cc >= ec || cr >= er){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc] != -1){
            return dp[cr][cc];
        }
        int right = minimumPathSum(grid, cr+1, cc, er, ec, dp, sum+grid[cr][cc]);
        int down = minimumPathSum(grid, cr, cc+1, er, ec, dp, sum+grid[cr][cc]);
        return dp[cr][cc] = Math.min(right, down) + grid[cr][cc];
    }
}
