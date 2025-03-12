package practice;

public class MaximumCount {
    public int maximumCount(int[] nums) {
        int countPos = 0, countNeg = 0;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > 0){
                countPos = nums.length - mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        start = 0;
        end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < 0){
                countNeg = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return Math.max(countPos, countNeg);
    }
}
