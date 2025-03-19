package practice;

public class MinOperationsToMakeBinaryArrayOne {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len-2; i++){
            if(nums[i] == 1 && nums[i+1] == nums[i] && nums[i+2] == nums[i]){
                i += 2;
            }
            else if(nums[i] == 0){
                nums[i] = 1;
                if(nums[i+1] == 0) {
                    nums[i+1] = 1;
                }
                else{
                    nums[i+1] = 0;
                }
                if(nums[i+2] == 0){
                    nums[i+2] = 1;
                }
                else{
                    nums[i+2] = 0;
                }
                count++;
            }
        }
        for(int ele: nums){
            if(ele == 0){
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0,0};
        MinOperationsToMakeBinaryArrayOne m = new MinOperationsToMakeBinaryArrayOne();
        System.out.println(m.minOperations(arr));
    }
}
