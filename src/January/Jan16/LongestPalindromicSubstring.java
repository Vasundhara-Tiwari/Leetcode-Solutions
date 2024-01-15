package January.Jan16;

import java.util.ArrayList;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < s.length();  i++){
            for(int j = i+1; j <= s.length(); j++){
                String str = s.substring(i, j);
                if(isPalindrome(str)){
                    al.add(str);
                }
            }
        }
        String result = al.get(0);
        for(int i = 1; i < al.size(); i++){
            if(al.get(i).length() > result.length()){
                result = al.get(i);
            }
        }
        return result;
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
