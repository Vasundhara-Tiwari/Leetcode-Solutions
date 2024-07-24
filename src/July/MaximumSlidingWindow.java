package July;

import java.util.*;
import java.util.HashMap;

public class MaximumSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int end = 0;
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> al = new ArrayList<>();
        while (end < nums.length){
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[end]) {
                dq.removeLast();
            }
            dq.addLast(end);
            if (dq.getFirst() == end - k) {
                dq.removeFirst();
            }
            if (end >= k - 1) {
                al.add(nums[dq.peek()]);
            }
            end++;
        }
        int[] ans = new int[al.size()];
        for(int i = 0; i < al.size(); i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}
