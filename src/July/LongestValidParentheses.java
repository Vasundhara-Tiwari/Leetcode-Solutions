package July;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String str = "())";
        System.out.println(longestValidParentheses(str));
    }
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int ans=0;
        for(int i=0;i<s.length();i++){
            System.out.println(stack);
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(stack.size()>1){
                stack.pop();
                ans=Math.max(ans,i-stack.peek());
            }
            else{
                stack.pop();
                stack.push(i);
            }
        }
        return ans;
    }
}
