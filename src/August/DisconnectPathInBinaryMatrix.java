package August;

public class DisconnectPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1}, {1,0,0}, {1,1,1}};
        System.out.println(isPossibleToCutPath(grid));
    }
    public static boolean isPossibleToCutPath(int[][] grid) {
        if(!dfs(0, 0, grid)){
            return true;
        }
        grid[0][0] = 1;
        if (!dfs(0, 0, grid)) {
            return true;
        }
        return false;
    }
    public static boolean dfs(int cr, int cc, int[][] grid){
        if(cr >= grid.length || cc >= grid[0].length || grid[cr][cc] == 0){
            return false;
        }
        if(cr == grid.length-1 && cc == grid[0].length-1){
            return true;
        }
        grid[cr][cc] = 0;
        return dfs(cr, cc+1, grid) || dfs(cr+1, cc, grid);
    }}
