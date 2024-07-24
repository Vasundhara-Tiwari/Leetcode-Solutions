package July;

import java.util.ArrayList;
import java.util.Arrays;

public class NextGreaterElementLeetcode {
    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        System.out.println(map);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            System.out.println(map.get(nums1[i]));
            int j = map.get(nums1[i]);
            int firstMax = -1;
            for(; j < nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    firstMax = nums2[j];
                    break;
                }
            }
            ans.add(firstMax);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
