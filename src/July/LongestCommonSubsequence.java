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
        System.out.println(lcsTD(s1, s2, 0, 0, dp));
        System.out.println(lcsBU(s1, s2));
    }
    public static int lcsTD(String s1, String s2, int i, int j, int[][] dp){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+ lcsTD(s1, s2, i+1, j+1, dp);
        } else {
            int f = lcsTD(s1, s2, i+1, j, dp);
            int s = lcsTD(s1, s2, i, j+1, dp);
            return dp[i][j] = Math.max(f, s);
        }
        return dp[i][j];
    }
    public static int lcsBU(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1] ;
                } else {
                    int f = dp[i-1][j];
                    int s = dp[i][j-1];
                    dp[i][j] = Math.max(f, s);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
