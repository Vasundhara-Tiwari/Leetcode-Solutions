package July;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while (!st.isEmpty() && heights[i] < heights[st.peek()]){
                int h = heights[st.pop()];
                int r = i;
                if(st.isEmpty()){
                    area = Math.max(area, h*r);
                } else{
                    int l = st.peek();
                    area = Math.max(area, h*(r-l-1));
                }
            }
            st.push(i);
        }
        int r = heights.length;
        while (!st.isEmpty()){
            int h = heights[st.pop()];
            if(st.isEmpty()){
                area = Math.max(area, h*r);
            } else{
                int l = st.peek();
                area = Math.max(area, h*(r-l-1));
            }
        }
        return area;
    }
}
