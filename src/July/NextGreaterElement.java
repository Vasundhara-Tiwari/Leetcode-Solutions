package July;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {11, 9, 13, 21, 3};
        printNextGreater(arr);
    }

    private static void printNextGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ele = -1;
        for(int i = arr.length-1; i > 0; i--){
            if(arr[i] > arr[i-1]){
                ele = arr[i];
                st.push(arr[i]);
            } else {
                st.push(ele);
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + ", " + st.peek());
            st.pop();
        }
    }
}
