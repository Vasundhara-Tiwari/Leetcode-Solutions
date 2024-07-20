package July;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] dp = new int[nums.length];
//        System.out.println(maximumAmountTD(nums, 0, dp));
        System.out.println(maximumAmountBU(nums, dp));
    }

    private static int maximumAmountBU(int[] nums, int[] dp) {
        if (nums.length == 1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int rob = nums[i] + dp[i-2];
            int dontRob = dp[i-1];
            dp[i] = Math.max(rob, dontRob);
        }
        return dp[nums.length-1];
    }

    private static int maximumAmountTD(int[] nums, int index, int[] dp) {
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] != 0){
            return dp[index];
        }
        int rob = nums[index] + maximumAmountTD(nums, index+2, dp);
        int dontRob = maximumAmountTD(nums, index+1, dp);
        return dp[index] = Math.max(rob, dontRob);
    }


}
