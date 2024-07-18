package July;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[]  arr = {0,1,2,3,2,5};
        int k = 1;
        System.out.println(containsNearbyDuplicate(arr, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 1;
        int j = 0;
        if(nums.length == 1){
            return false;
        }
        while (i < nums.length){
            if(nums[i] == nums[j] && Math.abs(i-j) <= k){
                return true;
            } else if(Math.abs(i-j) >= k){
                j++;
            }
            i++;
        }
        return false;
    }
}
