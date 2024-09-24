package September;

import java.util.Map;
import java.util.HashMap;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String, Integer> map = new HashMap<>();
        for(int num: arr1){
            String numS = Integer.toString(num);
            String prefix = "";
            for(char ch: numS.toCharArray()){
                prefix += ch;
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        int maxLength = 0;
        for(int num: arr2){
            String numS = Integer.toString(num);
            String prefix = "";
            for(char ch: numS.toCharArray()){
                prefix += ch;
                if(map.containsKey(prefix)){
                    maxLength = Math.max(maxLength, prefix.length());
                }
            }
        }
        return maxLength;
    }
}
