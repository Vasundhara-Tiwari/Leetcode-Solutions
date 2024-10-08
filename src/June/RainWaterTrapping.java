package June;

import java.util.Arrays;
import java.util.Map;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] buildings = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(buildings));
    }
    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        for(int i = height.length-2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int result = 0;
        for(int i = 0; i  < height.length; i++){
            result += Math.abs(height[i]-Math.min(leftMax[i], rightMax[i]));
        }
        return result;
    }
}
