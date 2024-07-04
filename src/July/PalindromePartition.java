package July;

import java.util.Scanner;

public class PalindromePartition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        palindromePartition(str, "");
    }

    private static void palindromePartition(String ques, String ans) {
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 1; i <= ques.length(); i++){
            String s = ques.substring(0, i);
            if(isPalindrome(s)){
                palindromePartition(ques.substring(i), ans+s+"|");
            }
        }
    }

    private static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while (i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
