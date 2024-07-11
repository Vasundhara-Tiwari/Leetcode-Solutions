package July;

import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        String word = scanner.next();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = search(board, i, j, word, 0);
                    if (ans) {
                        System.out.println(ans);
                    }
                }
            }
        }
        System.out.println(false);
    }

        public static boolean search ( char[][] board, int cr, int cc, String word,int index){
            if (index == word.length()) {
                return true;
            }
            if (cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length || word.charAt(index) != board[cr][cc]) {
                return false;
            }
            int[] r = {-1, 0, 1, 0};
            int[] c = {0, -1, 0, 1};
            board[cr][cc] = '*';
            boolean ans = false;
            for (int i = 0; i < c.length; i++) {
                ans = search(board, cr + r[i], cc + c[i], word, index + 1);
                if (ans) {
                    return true;
                }
            }
            board[cr][cc] = word.charAt(index);
            return ans;
        }
}

