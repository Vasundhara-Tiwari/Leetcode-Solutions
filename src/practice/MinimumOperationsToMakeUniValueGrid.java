package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumOperationsToMakeUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();
        for (int[] row : grid) {
            for (int val : row) {
                values.add(val);
            }
        }

        for (int val : values) {
            if (Math.abs(val - values.get(0)) % x != 0) {
                return -1;
            }
        }

        Collections.sort(values);
        int median = values.get(values.size() / 2);
        int op = 0;
        for(int i = 0; i < values.size(); i++){
            op += Math.abs(values.get(i) - median) / x;
        }
        return op;
    }
}
