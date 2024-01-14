package January.Jan14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfAPhoneNumber {
    static String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        letterCombinations(digits);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> al = new ArrayList<>();
        if(digits.equals("")){
            return al;
        }
        letterCombinationsPossible(digits,"", al);
        System.out.println(al);
        return al;
    }

    public static void letterCombinationsPossible(String digits, String ans, List<String> al){
        if(digits.length() == 0){
            al.add(ans);
            return;
        }
        char ch = digits.charAt(0);
        String press = letters[ch-'0'];
        for(int i = 0; i < press.length(); i++){
            letterCombinationsPossible(digits.substring(1), ans+press.charAt(i), al);
        }
    }
}
