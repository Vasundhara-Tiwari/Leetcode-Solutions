package July;

import java.util.Arrays;

public class MinimumPathSum  {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(minimumPathSum(arr, dp, 0, 0));
    }

    private static int minimumPathSum(int[][] arr, int[][] dp, int cr, int cc) {
        if(cr == arr.length-1 && cc == arr[0].length-1){
            return dp[cr][cc] = arr[cr][cc];
        }
        if(cr > arr.length-1 || cc > arr[0].length-1){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc] != -1){
            return dp[cr][cc];
        }
        int right = minimumPathSum(arr, dp, cr, cc+1);
        int down = minimumPathSum(arr, dp, cr+1, cc);
        return dp[cr][cc] = Math.min(right, down) + arr[cr][cc];
    }
}
