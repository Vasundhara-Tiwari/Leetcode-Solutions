package August;

public class CheckKnightTourConfiguration {
    public static void main(String[] args) {
        int[][] grid = {{0,11,16,5,20}, {17,4,19,10,15}, {12,1,8,21,6}, {3,18,23,14,9}, {24,13,2,7,22}};
        int count = 0;
        dfs(grid, 0, 0, count);
        for(int[] arr: grid){
            for(int ele: arr){
                if(ele != -1){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    private static void dfs(int[][] grid, int cr, int cc, int count) {
        if(cr < 0 || cc < 0 || cr >= grid[0].length || cc >= grid.length || grid[cr][cc] != count){
            return;
        }
        grid[cr][cc] = -1;
        dfs(grid, cr+1, cc+2, count+1);
        dfs(grid, cr+1, cc-2, count+1);
        dfs(grid, cr+2, cc+1, count+1);
        dfs(grid, cr-2, cc+1, count+1);
        dfs(grid, cr-1, cc+2, count+1);
        dfs(grid, cr-1, cc-2, count+1);
        dfs(grid, cr-2, cc-1, count+1);
        dfs(grid, cr+2, cc-1, count+1);
    }
}
