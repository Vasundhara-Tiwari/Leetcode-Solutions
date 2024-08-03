package August;

public class InterleavingStrings {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
//        if(s1.length() + s2.length() != s3.length())
//            return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        System.out.println(checkInterleave(s1, s2, s3, 0, 0, dp));
    }
    public static boolean checkInterleave(String s1, String s2, String s3, int i, int j, boolean[][] dp) {
        if (i+j == s3.length()){
            return true;
        }
        if(dp[i][j] == false)
            return dp[i][j];
        if (i < s1.length() && s3.charAt(i+j) == s1.charAt(i)){
            boolean c = checkInterleave(s1, s2, s3, i+1, j, dp);
            if (c)
                return dp[i][j] = true;
        }
        if(j < s2.length() && s3.charAt(i+j) == s2.charAt(j)){
            boolean c = checkInterleave(s1, s2, s3, i, j+1, dp);
            if (c)
                return dp[i][j] = true;
        }
        return dp[i][j] = false;
    }
}
