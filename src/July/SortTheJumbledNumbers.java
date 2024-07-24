package July;

import java.util.*;
import java.util.HashMap;

public class SortTheJumbledNumbers {
    public static void main(String[] args) {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer,Integer> idx = new HashMap<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0;i<10;i++){
            idx.put(i,mapping[i]);
        }
        for(int i=0;i<nums.length;i++){
            int x = transformByMapping(nums[i],idx);
            if(!map.containsKey(x)){
                map.put(x,new ArrayList<>());
            }
            map.get(x).add(nums[i]);
        }
        int[] ans = new int[nums.length];
        int i =0;
        for(int val : map.keySet()){
            for(int j : map.get(val)){
                ans[i]=j;
                i++;
            }
        }
        return ans;
    }
    public static int transformByMapping(int n, HashMap<Integer, Integer> idx){
        String ans="";
        String t = Integer.toString(n);
        for(int i=0;i<t.length();i++){
            ans += idx.get(t.charAt(i)-'0');
        }
        return Integer.parseInt(ans);
    }
}
