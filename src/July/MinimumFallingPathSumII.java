package July;

import java.util.Arrays;

public class MinimumFallingPathSumII {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] a: dp){
            Arrays.fill(a, -9999999);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, minimumFallingPathSum(grid, 0, i, dp));
        }
        System.out.println(ans);
    }

    public static int minimumFallingPathSum(int[][] matrix, int cr, int cc, int[][] dp ) {
        if (cr == matrix.length-1){
            return matrix[cr][cc];
        }
        if (dp[cr][cc] != -9999999) {
            return dp[cr][cc];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            if(i == cc){
                continue;
            }
            min = Math.min(min, minimumFallingPathSum(matrix, cr+1, i, dp));
        }
        return dp[cr][cc] = min + matrix[cr][cc];
    }
}
