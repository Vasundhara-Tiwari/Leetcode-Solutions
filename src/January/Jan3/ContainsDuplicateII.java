package January.Jan3;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(arr, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            if(nums[start] == nums[end] && Math.abs(start-end) <= k){
                return true;
            }
            else if(start == end-1){
                end--;
                start = 0;
            }
            else{
                start++;
            }
        }
        return false;
    }
}
