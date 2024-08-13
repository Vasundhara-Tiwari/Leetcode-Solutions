package August;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        find(candidates, target, 0, combinations, new ArrayList<>());
        return combinations;
    }
    public static void find(int[] arr, int target, int i, List<List<Integer>> combinations, List<Integer> com){
        if(target == 0){
            combinations.add(new ArrayList<>(com));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            if(target >= arr[j]){
                com.add(arr[j]);
                find(arr, target-arr[j], j, combinations, com);
                com.remove(com.size()-1);
            }
        }
    }
}
