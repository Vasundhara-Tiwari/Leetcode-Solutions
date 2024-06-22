package June;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        for(int j = 0; j < k; j++){
            int item = nums[n-1];
            for(int i = n-2; i >= 0; i--){
                nums[i+1] = nums[i];
            }
            nums[0] = item;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
