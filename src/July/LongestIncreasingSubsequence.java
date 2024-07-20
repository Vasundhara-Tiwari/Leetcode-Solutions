package July;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]){
                    int l = dp[j];
                    dp[i] = Math.max(l+1, dp[i]);
                }
            }
        }
        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
