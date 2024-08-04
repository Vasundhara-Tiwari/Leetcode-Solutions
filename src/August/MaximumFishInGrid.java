package August;

public class MaximumFishInGrid {
    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0}, {4,0,0,3}, {1,0,0,4}, {0,3,2,0}};
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] > 0){
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        val += dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
        return val;
    }
}
