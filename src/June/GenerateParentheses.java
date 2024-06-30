package June;

import java.util.Arrays;
import java.util.Scanner;

public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generate(n, 0, 0, "");
    }
    public static void generate(int n, int open, int close, String ans){
        if(open >= n && close >= n){
            System.out.println(ans);
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
