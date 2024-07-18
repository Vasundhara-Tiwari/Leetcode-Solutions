package July;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String s) {
        int i = 0;
        int j = 0;
        if(isPalindrome(s)){
            return s;
        }
        String ans = "";
        String current = "";
        while(i < s.length()){
            current += s.charAt(i);
            if(isPalindrome(current)){
                ans = ans.length() > current.length() ? ans : current;
                j++;
            }
            i++;
        }
        return ans;
    }
    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
