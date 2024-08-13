package August;

import java.util.Arrays;

public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return findCombinations(nums, target, 0, dp);
    }
    public static int findCombinations(int[] arr, int target, int i, int[] dp) {
        if (target == 0){
            return 1;
        }
        if (target < 0)
            return 0;
        if(dp[target] != -1){
            return dp[target];
        }
        int curr = 0;
        for (int j = 0; j < arr.length; j++) {
            if(target >= arr[j]){
                curr += findCombinations(arr, target-arr[j], j, dp);
            }
        }
        return dp[target] = curr;
    }
}
