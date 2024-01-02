package January;

public class Jan2 {
    public static void main(String[] args) {
        int[] nums = {-4,-2,1,4,8};
        System.out.println(findClosestNumber(nums));
    }
    public static int findClosestNumber(int[] nums) {
        int diff = Math.abs(nums[0]);
        int num = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(Math.abs(nums[i]) < diff){
                diff = Math.abs(nums[i]);
                num = nums[i];
            }
            if(diff == Math.abs(nums[i]) && nums[i] > num){
                num = nums[i];
            }
        }
        return num;
    }
}
