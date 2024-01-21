package January.Jan21;

import java.util.Scanner;

public class RatChasesItsCheese {
    static boolean val = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] maze = new char[n][m];
        for(int i = 0; i < n; i++){
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++){
                maze[i][j] = s.charAt(j);
            }
        }
        int[][] ans = new int[n][m];
        path(maze, 0, 0, ans);
        if(val == false){
            System.out.println("NO PATH FOUND");
        }
    }
    public static void path(char[][] maze, int cr, int cc, int[][] ans){
        if(cr == maze.length-1 && cc == maze[0].length-1 && maze[cr][cc] != 'X'){
            ans[cr][cc] = 1;
            display(ans);
            val = true;
            return;
        }
        if(cr >= maze.length || cc >= maze[0].length || cr < 0 || cc < 0 || maze[cr][cc] == 'X'){
            return;
        }
        maze[cr][cc] = 'X';
        ans[cr][cc] = 1;
        //upward
        path(maze, cr-1, cc, ans);
        //left
        path(maze, cr, cc-1, ans);
        //down
        path(maze, cr+1, cc, ans);
        //right
        path(maze, cr, cc+1, ans);
        maze[cr][cc] = 'O';
        ans[cr][cc] = 0;
    }
    public static void display(int[][] ans){
        for(int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
