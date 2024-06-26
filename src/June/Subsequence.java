package June;

public class Subsequence {
    public static void main(String[] args) {
        subsequences("abc", "");
    }
    public static void subsequences(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String part = str.substring(1);
        subsequences(part, ans+ch);
        subsequences(part, ans);
    }
}
