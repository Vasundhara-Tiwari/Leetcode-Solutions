package August;

import java.util.HashSet;

public class MagicSquaresInGrid {
    public static void main(String[] args) {
        int[][] grid = {{3,2,9,2,7}, {6,1,8,4,2}, {7,5,3,2,7}, {2,9,4,9,6}, {4,3,8,2,5}};
        System.out.println(numMagicSquaresInside(grid));
    }
    public static int numMagicSquaresInside(int[][] grid) {
        int checkSum = 0;
        for(int i = 1; i < grid.length-1; i++){
            for(int j = 1; j < grid[i].length-1; j++){
                if(checkDistinct(i, j, grid)){
                    checkSum += calculateSum(i, j, grid);
                }
            }
        }
        return checkSum;
    }

    private static boolean checkDistinct(int i, int j, int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        for (int k = i-1; k < i+2; k++) {
            for (int l = j-1; l < j+2; l++) {
                if(!set.contains(grid[k][l]) && grid[k][l] >= 1 && grid[k][l] <= 9){
                    set.add(grid[k][l]);
                } else {
                    return false;
                }
            }
        }
        return set.size() == 9;
    }

    public static int calculateSum(int row, int col, int[][] grid){
        int result = 0;
        int r1 = grid[row-1][col-1] + grid[row-1][col] + grid[row-1][col+1];
        int r2 = grid[row][col-1] + grid[row][col] + grid[row][col+1];
        int r3 = grid[row+1][col-1] + grid[row+1][col] + grid[row+1][col+1];
        int c1 = grid[row-1][col-1] + grid[row][col-1] + grid[row+1][col-1];
        int c2 = grid[row-1][col] + grid[row][col] + grid[row+1][col];
        int c3 = grid[row-1][col+1] + grid[row][col+1] + grid[row+1][col+1];
        int d1 = grid[row-1][col-1] + grid[row][col] +  grid[row+1][col+1];
        int d2 = grid[row+1][col-1] + grid[row][col] +  grid[row-1][col+1];
        System.out.println(d1 + " " + d2 + " " + r1 + " " + r2 + " " + r3 + " " + c1 + " " + c2 + " " + c3);
        if(d1 == d2 && d2 == r1 && r1 == r2 && r2 == r3 && r3 == c1 && c1 == c2 && c2== c3){
            System.out.println(row + " " + col);
            return result+1;
        }
        return result;
    }
}
