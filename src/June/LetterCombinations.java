package June;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinations {
    static String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits =  scanner.next();
        List<String> al = new ArrayList<>();
        if(digits.length() > 0){
            combinations(digits, "", al);
        }
    }

    private static void combinations(String digits, String ans, List<String> al) {
        if(digits.length() == 0){
            al.add(ans);
            return;
        }
        int ch = digits.charAt(0) - 48;
        String part = digits.substring(1);
        for(int i = 0; i < arr[ch].length(); i++){
            combinations(part, ans+arr[ch].charAt(i), al);
        }
    }

}
