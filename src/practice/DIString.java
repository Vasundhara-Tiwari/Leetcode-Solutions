package practice;

import java.util.Stack;

public class DIString {
    public String smallestNumber(String pattern) {
        int[] ans = new int[pattern.length()+1];
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= pattern.length(); i++){
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                ans[i] = count;
                count++;
                while (!stack.isEmpty()){
                    ans[stack.pop()] = count;
                    count++;
                }
            } else{
                stack.push(i);
            }
        }
        String out = "";
        for(int i = 0; i < ans.length; i++){
            out += ans[i];
        }
        return out;
    }

    public static void main(String[] args) {
        DIString ds = new DIString();
        System.out.println(ds.smallestNumber("IIIDIDDD"));
    }
}
