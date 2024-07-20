package July;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(lcs(s1, s2, 0, 0, dp));
    }
    public static int lcs(String s1, String s2, int i, int j, int[][] dp){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+ lcs(s1, s2, i+1, j+1, dp);
        } else {
            int f = lcs(s1, s2, i+1, j, dp);
            int s = lcs(s1, s2, i, j+1, dp);
            return dp[i][j] = Math.max(f, s);
        }
        return dp[i][j];
    }
}
