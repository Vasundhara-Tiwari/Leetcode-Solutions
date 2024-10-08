package January.Jan9;

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {4,2,3};
        System.out.println(checkPossibility(nums));
    }
    public static boolean checkPossibility(int[] nums) {
        int modified = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (modified++ > 0) return false;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else nums[i] = nums[i - 1];
            }
        }
        return true;
    }
}
