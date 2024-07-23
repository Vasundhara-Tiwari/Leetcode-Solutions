package July;

import java.util.Arrays;

public class MinimumOperationsToMakeASubsequence {
    public static void main(String[] args) {
        int[] target = {5,1,4,3};
        int[] arr = {9,4,2,3,4};
        int[][] dp = new int[arr.length][target.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int len = longestCommonSubsequence(target, arr, 0, 0, dp);
        System.out.println(len);
    }

    private static int longestCommonSubsequence(int[] target, int[] arr, int i, int j, int[][] dp) {
            if(target.length == j || arr.length == i){
                return 0;
            }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
            if(arr[i] == target[j]){
                dp[i][j] = 1 + longestCommonSubsequence(target, arr, i+1, j+1, dp);
            } else{
                int f = longestCommonSubsequence(target, arr, i+1, j, dp);
                int l = longestCommonSubsequence(target, arr, i, j+1, dp);
                dp[i][j] = Math.max(f, l);
            }
            return dp[i][j];
    }
}
