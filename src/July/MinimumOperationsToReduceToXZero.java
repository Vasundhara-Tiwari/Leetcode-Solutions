package July;

public class MinimumOperationsToReduceToXZero {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x = 5;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
        }
        int target = sum - x;
        if (target < 0){
            System.out.println(-1);
            return;
        }
        if (target == x){
            System.out.println(nums.length);
            return;
        }
        int left = 0, right = 0;
        int currentSum = 0;
        int minOperations = Integer.MAX_VALUE;
        while (right < nums.length){
            currentSum += nums[right];
            right++;
            while(currentSum > target){
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == target){
                minOperations = Math.min(minOperations, nums.length - (right- left));
            }
        }
        System.out.println(minOperations == Integer.MAX_VALUE ? -1 : minOperations);
    }
}
