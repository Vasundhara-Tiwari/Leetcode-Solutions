package July;

import java.util.*;
import java.util.HashMap;

public class FindLongestWord {
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) {
        String str = "abppplee";
        String[] arr = {"able", "ale", "apple", "bale", "kangaroo"};
//        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }
//        longestWord(str, set, "");
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), new ArrayList<>());
            }
            map.get(str.charAt(i)).add(i);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String currAns = "";
            for (int j = 0; j < arr[i].length(); j++) {
                if (map.containsKey(arr[i].charAt(j))){
                    currAns += arr[i].charAt(j);
                    ans = currAns.length() > ans.length() ? new StringBuilder(currAns) : ans;
                } else {
                    continue;
                }
            }
        }
        System.out.println(ans);
    }

//    private static String longestWord(String str, HashSet<String> set, String ans) {
//        if (set.contains(ans)){
//            res = res.length() > ans.length() ? res : new StringBuilder(ans);
//            return ans;
//        }
//        if(str.isEmpty()){
//            return ans;
//        }
//        String pick = longestWord(str.substring(1), set, ans+str.charAt(0));
//        String notPick = longestWord(str.substring(1), set, ans);
//        return pick+notPick;
//    }

}
