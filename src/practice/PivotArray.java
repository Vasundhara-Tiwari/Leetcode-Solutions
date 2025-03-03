package practice;

public class PivotArray {
  public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                ans[start] = nums[i];
                start++;
            }
            if (nums[j] > pivot) {
                ans[end] = nums[j];
                end--;
            }
        }
        while (start <= end) {
            ans[start] = pivot;
            start++;
        }
        return ans;
    }
}
