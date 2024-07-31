package July;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> ll = new ArrayList<>();
        generate(n, 0, 0, ll, "");
        System.out.println(ll);
    }
    public static List<String> generate(int n, int open, int close, List<String> result, String ans){
        if (open == n && close == n){
            result.add(ans);
        }
        if(open < n){
            generate(n, open+1, close, result, ans+"(");
        }
        if(open > close){
            generate(n, open, close+1, result, ans+")");
        }
        return result;
    }
}
