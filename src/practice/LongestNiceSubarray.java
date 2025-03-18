package practice;

public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, res = 1, mask = 0;
        while (r < n) {
            while ((mask & nums[r]) != 0) {
                mask ^= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
            mask |= nums[r];
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,8,48,10};
        LongestNiceSubarray lns = new LongestNiceSubarray();
        System.out.println(lns.longestNiceSubarray(arr));
    }
}
