package August;

import java.util.*;

public class KthDistinctString {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i])+1);
        }
        System.out.println(map);
        List<String> al = new ArrayList<>();
        for (String key: map.keySet()) {
            if(map.get(key) == 1){
                al.add(key);
            }
        }
        if(k > al.size()){
            System.out.println("");
        }
        System.out.println(al.get(k-1));
    }
}
