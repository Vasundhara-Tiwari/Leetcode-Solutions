package June;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    static List<String> al = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generate(n, 0, 0, "");
        System.out.println(al);
    }
    public static void generate(int n, int open, int close, String ans){
        if(open >= n && close >= n){
            al.add(ans);
            return;
        }
        if(open > n) {
            return;
        }
        generate(n, open+1, close, ans+"(");
        if(open > close){
            generate(n, open, close+1, ans+")");
        }
    }
}
