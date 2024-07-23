package July;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s ="dvdf";
        ArrayList<Character> al = new ArrayList<>();
        int index = 0;
        int len = 0;
        while (index < s.length()){
            if(!al.contains(s.charAt(index))){
                al.add(s.charAt(index));
                len = Math.max(al.size(), len);
            } else {
                while (al.contains(s.charAt(index))){
                    al.remove(0);
                }
                al.add(s.charAt(index));
            }
            index++;
        }
        System.out.println(len);
    }
}
