package August;

import java.util.List;
import java.util.ArrayList;

public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(combinationSum3(k, n));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        find(k, n, 1, combinations, new ArrayList<>());
        return combinations;
    }
    public static void find(int size, int target, int index, List<List<Integer>> combinations, List<Integer> com) {
        if(com.size() > size){
            return;
        }
        if (com.size() == size && target == 0){
            combinations.add(new ArrayList<>(com));
            return;
        }
        for (int i = index; i <= 9; i++) {
            if(target >= i){
                com.add(i);
                find(size, target-i, i+1, combinations, com);
                com.remove(com.size()-1);
            }
        }
    }
}
