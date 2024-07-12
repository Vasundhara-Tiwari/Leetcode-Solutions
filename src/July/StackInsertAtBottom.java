package July;

import java.util.Stack;

public class StackInsertAtBottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);
        insertAtBottom(st, -7);
        System.out.println(st);
    }

    private static void insertAtBottom(Stack<Integer> st, int i) {
        if(st.empty()){
            st.push(i);
            return;
        }
        int ele = st.pop();
        insertAtBottom(st, i);
        st.push(ele);
    }
}
