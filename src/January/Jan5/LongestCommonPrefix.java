package January.Jan5;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String result = "";
        String first = strs[0];
        String last = strs[strs.length-1];
        for(int i=0; i<first.length(); i++)
        {
            if(first.charAt(i)==last.charAt(i))
                result += first.charAt(i);
            else
                return result;
        }
        return result;
    }
}
