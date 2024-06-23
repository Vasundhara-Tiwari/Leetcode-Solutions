package June;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for(int i = 1; i < nums.length; i++){
            leftProduct[i] = nums[i-1] * leftProduct[i-1];
        }
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            rightProduct[i] = nums[i+1] * rightProduct[i+1];
        }
        for(int i = 0; i < nums.length; i++){
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}
