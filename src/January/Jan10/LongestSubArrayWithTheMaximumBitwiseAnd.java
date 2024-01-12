package January.Jan10;

public class LongestSubArrayWithTheMaximumBitwiseAnd {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,2,2};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
        int result = 0;
        int length = 0;
        int max = 0;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }
        for (int ele : nums) {
            if (ele == max) {
                result = Math.max(result, ++length);
            }
            else {
                length = 0;
            }
        }
        return result;
    }
}
