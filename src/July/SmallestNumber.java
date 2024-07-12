package July;

import java.util.Arrays;
import java.util.Stack;

public class SmallestNumber {
    public static void main(String[] args) {
        String str = "IIIDIDDD";
        int[] ans = new int[str.length()+1];
        int count = 1;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= str.length(); i++){
            if(str.length() == i || str.charAt(i) == 'I'){
                ans[i] = count;
                count++;
                while (!st.isEmpty()){
                    ans[st.pop()] = count;
                    count++;
                }
            }
            else{
                st.push(i);
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
