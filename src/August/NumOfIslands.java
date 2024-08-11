package August;

public class NumOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    search(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    public static void search(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        search(i+1, j, grid);
        search(i-1, j, grid);
        search(i, j+1, grid);
        search(i, j-1, grid);
    }
}
