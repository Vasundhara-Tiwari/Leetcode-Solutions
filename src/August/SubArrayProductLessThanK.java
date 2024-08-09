package August;

public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        System.out.println(numSubArrayProductLessThanK(nums, k));
    }
    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = i; j < nums.length; j++){
                if(product*nums[j] < k){
                    product *= nums[j];
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
