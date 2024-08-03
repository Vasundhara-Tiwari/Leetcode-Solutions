package August;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int[][] dp = new int[triangle.size()][triangle.size()];
        System.out.println(minimumTotal(triangle, 0, 0, dp));
    }
    public static int minimumTotal(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        if (row == triangle.size()-1){
            return dp[row][col] = triangle.get(row).get(col);
        }
        if (dp[row][col] != 0){
            return dp[row][col];
        }
        int down = triangle.get(row).get(col) + minimumTotal(triangle, row+1, col, dp);
        int downPlusOne = triangle.get(row).get(col) + minimumTotal(triangle, row+1, col+1, dp);
        return dp[row][col] = Math.min(downPlusOne, down);
    }
}
