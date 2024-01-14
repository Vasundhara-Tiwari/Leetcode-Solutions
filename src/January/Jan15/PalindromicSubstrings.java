package January.Jan15;

import java.util.ArrayList;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < s.length();  i++){
            for(int j = i+1; j <= s.length(); j++){
                String str = s.substring(i, j);
                if(isPalindrome(str)){
                    al.add(str);
                }
            }
        }
        return al.size();
    }
    static boolean isPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
