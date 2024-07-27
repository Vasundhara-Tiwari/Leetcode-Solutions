package July;

import java.util.Arrays;

public class VolumeOfLakes {
    public static void main(String[] args) {
        int[] lakes = {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
        int[] rightMax = new int[lakes.length];
        int[] leftMax = new int[lakes.length];
        leftMax[0] = lakes[0];
        for (int i = 1; i < lakes.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], lakes[i]);
        }
        rightMax[lakes.length-1] = lakes[lakes.length-1];
        for (int i = rightMax.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], lakes[i]);
        }
        int[] ans = new int[lakes.length];
        for (int i = 0; i < lakes.length; i++) {
            ans[i] = Math.min(rightMax[i], leftMax[i]) - lakes[i];
        }
        int sum = 0;
        for (int i = 0; i < ans.length; i++) {
            sum += ans[i];
        }
        System.out.println(sum);
    }
}
