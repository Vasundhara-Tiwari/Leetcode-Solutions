package practice;

import java.util.Map;
import java.util.HashMap;

public class DivideArrayIntoEqualPairs{
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int ele: nums){
            frequency.put(ele, frequency.getOrDefault(ele, 0) + 1);
        }
        for(int count: frequency.values()){
            if(count % 2 != 0){
                return false;
            }
        }
        return true;
    }
}
