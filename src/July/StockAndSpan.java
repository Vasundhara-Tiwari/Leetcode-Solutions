package July;

import java.util.Stack;

public class StockAndSpan {
    // https://codeskiller.codingblocks.com/problems/502
    public static void main(String[] args) {
        int[] arr = {30, 35, 40, 38, 35};
        stockSpan(arr);
    }

    private static void stockSpan(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = i+1;
            } else {
                ans[i] = i - st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + ", " + ans[i]);
        }
    }
}
