package July;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] dp = new int[nums.length];
        System.out.println(maximumAmountTD(nums, 0, dp));
//        System.out.println(maximumAmountBU(nums, dp));
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
