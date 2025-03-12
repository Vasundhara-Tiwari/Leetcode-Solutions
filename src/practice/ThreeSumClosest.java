package practice;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int left = i + 1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(diff >= Math.abs(sum - target)){
                    diff = Math.abs(sum - target);
                    ans = sum;
                }
                if(sum > target){
                    right--;
                } else{
                    left++;
                }
            }
        }
        return ans;
    }
}
