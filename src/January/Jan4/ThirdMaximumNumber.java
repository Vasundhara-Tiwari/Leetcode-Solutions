package January.Jan4;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max || nums[i] == secondMax || nums[i] == thirdMax){
                continue;
            }
            if(nums[i] > max){
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            }
            else if (nums[i] > secondMax || secondMax == Integer.MIN_VALUE){
                thirdMax = secondMax;
                secondMax = nums[i];
            }
            else if(thirdMax == Integer.MIN_VALUE || nums[i] > thirdMax){
                thirdMax = nums[i];
            }
        }
        return thirdMax == Integer.MIN_VALUE ? max : thirdMax;
    }
}
