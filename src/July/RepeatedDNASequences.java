package July;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        HashSet<String> set = new HashSet<>();
        int start = 0;
        int end = 9;
        List<String> al = new ArrayList<>();
        while (end < s.length()){
            if (!set.contains(s.substring(start, end+1))){
                set.add(s.substring(start, end+1));
            } else{
                if(!al.contains(s.substring(start, end+1))){
                    al.add(s.substring(start, end+1));
                }
            }
            set.add(s.substring(start, end+1));
            end++;
            start++;
        }
        System.out.println(al);
    }
}
