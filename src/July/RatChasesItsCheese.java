package July;

import java.util.Arrays;
import java.util.Scanner;

public class RatChasesItsCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
            }
        }
        int[][] ans = new  int[n][m];
        mazePath(maze, 0, 0, ans);
    }
    public static void mazePath(char[][] maze, int cr, int cc, int[][] ans ){
        if(cr == maze.length-1 && cc == maze[0].length-1){
            ans[cr][cc] = 1;
            display(ans);
            return;
        }
        if (cr < 0 || cc < 0 || cr >= maze.length || cc >= maze[0].length || maze[cr][cc] == 'X') {
            return;
        }
        maze[cr][cc] = 'X';
        ans[cr][cc] = 1;
        mazePath(maze, cr-1, cc, ans); // up
        mazePath(maze, cr, cc-1, ans); // left
        mazePath(maze, cr+1, cc, ans); // down
        mazePath(maze, cr, cc+1, ans); // right
        maze[cr][cc] = 'O';
        ans[cr][cc] = 0;
    }

    private static void display(int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
