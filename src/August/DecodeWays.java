package August;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        int[] dp = new int[s.length()];
        System.out.println(numDecodings(s, 0, dp));
    }

    private static int numDecodings(String s, int i, int[] dp) {
        if(i >= s.length()){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        if(dp[i] != 0){
            return dp[i];
        }
        int ways = numDecodings(s, i+1, dp);
        if(i + 1 < s.length() && Integer.parseInt(s.substring(i, i+2)) <= 26){
            ways += numDecodings(s, i+2, dp);
        }
        return dp[i] = ways;
    }
}
