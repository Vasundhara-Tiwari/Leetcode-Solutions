package July;

import java.util.HashSet;

public class FindLongestWord {
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) {
        String str = "abppplee";
        String[] arr = {"able", "ale", "apple", "bale", "kangaroo"};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        longestWord(str, set, "");
        System.out.println(res);
    }

    private static String longestWord(String str, HashSet<String> set, String ans) {
        if (set.contains(ans)){
            res = res.length() > ans.length() ? res : new StringBuilder(ans);
            return ans;
        }
        if(str.isEmpty()){
            return ans;
        }
        String pick = longestWord(str.substring(1), set, ans+str.charAt(0));
        String notPick = longestWord(str.substring(1), set, ans);
        return pick+notPick;
    }
}
