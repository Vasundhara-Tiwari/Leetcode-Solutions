package August;

import java.util.ArrayList;
import java.util.Collections;

public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }
    public static int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int curSum = nums[i];
            al.add(curSum);
            for(int j = i+1; j < n; j++){
                curSum += nums[j];
                al.add(curSum);
            }
        }
        Collections.sort(al);
        int sum = 0;
        for(int i = left-1; i < right; i++){
            sum = (sum + al.get(i)) % 1000000007;
        }
        return sum;
    }
}
