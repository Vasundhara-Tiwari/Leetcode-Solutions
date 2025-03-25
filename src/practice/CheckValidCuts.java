package practice;

import java.util.Arrays;
import java.util.Comparator;

public class CheckValidCuts {
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }
    private static boolean checkCuts(int[][] rectangles, int dim) {
        int gapCount = 0;
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[dim]));

        int furthestEnd = rectangles[0][dim + 2];

        for (int i = 1; i < rectangles.length; i++) {
            int[] rect = rectangles[i];

            if (furthestEnd <= rect[dim]) {
                gapCount++;
            }

            furthestEnd = Math.max(furthestEnd, rect[dim + 2]);
        }

        return gapCount >= 2;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,0,5,2}, {0,2,2,4}, {3,2,5,3}, {0,4,4,5}};
        int n = 5;
        System.out.println(checkValidCuts(n, rectangles));
    }
}
