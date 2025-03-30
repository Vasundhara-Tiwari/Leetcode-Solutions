package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PutMarbelsInBags {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1) {
            return 0;
        }
        List<Integer> pairSum = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            pairSum.add(weights[i] + weights[i + 1]);
        }
        Collections.sort(pairSum);
        long min = 0, max = 0;
        for (int i = 0; i < k - 1; i++) {
            min += pairSum.get(i);
            max += pairSum.get(pairSum.size() - 1 - i);
        }
        return max - min;
    }
}
