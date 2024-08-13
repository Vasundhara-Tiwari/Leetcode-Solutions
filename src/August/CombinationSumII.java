package August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }
    public static void findCombinations(int[] arr, int target, int i, List<List<Integer>> combinations, List<Integer> com) {
        if (target == 0){
            combinations.add(new ArrayList<>(com));
        }
        for (int j = i; j < arr.length; j++) {
            if(j > i && arr[j] == arr[j-1]){
                continue;
            }
            if(target >= arr[j]){
                com.add(arr[j]);
                findCombinations(arr, target-arr[j], j+1, combinations, com);
                com.remove(com.size()-1);
            }
        }
    }
}
