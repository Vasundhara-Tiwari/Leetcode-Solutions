package August;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        System.out.println(editDistance(word1, word2, 0, 0, dp));
    }

    private static int editDistance(String word1, String word2, int i, int j, int[][] dp) {
        if(i == word1.length()){
            return word2.length() - j;
        }
        if(j == word2.length()){
            return word1.length() - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            ans = editDistance(word1, word2, i+1, j+1, dp);
        } else{
            int I = editDistance(word1, word2, i+1, j, dp);
            int D = editDistance(word1, word2, i, j+1, dp);
            int R = editDistance(word1, word2, i+1, j+1, dp);
            ans = Math.min(I, Math.min(D, R))+1;
        }
        return dp[i][j] = ans;
    }

}
