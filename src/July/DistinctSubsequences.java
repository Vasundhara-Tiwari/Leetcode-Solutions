package July;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int[][] dp = new int[s.length()+1][t.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(distinctSubsequences(s, t, dp, 0, 0));
    }

    private static int distinctSubsequences(String s, String t, int[][] dp, int i, int j) {
        if(j == t.length()){
            return 1;
        }
        if (i == s.length()){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int pick = 0;
        if(s.charAt(i) == t.charAt(j)){
            pick = distinctSubsequences(s, t, dp, i+1, j+1);
        }
        int notPick = distinctSubsequences(s, t, dp, i+1, j);
        return dp[i][j] = pick + notPick;
    }
}
