package practice;

public class MaximumValueOfOrderedTripletII {
    public static void main(String[] args) {
        int[] arr = {1,10,3,4,19};
        System.out.println(maximumTripletValue(arr));
    }
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        for(int i = 1; i < n; i++){
            lMax[i] = Math.max(lMax[i-1], nums[i-1]);
            rMax[n-i-1] = Math.max(rMax[n-i], nums[n-i]);
        }
        long result = 0;
        for(int j  = 1; j < n-1; j++){
            result = Math.max(result, (long)(lMax[j] - nums[j]) * rMax[j]);
        }
        return result;
    }
}
