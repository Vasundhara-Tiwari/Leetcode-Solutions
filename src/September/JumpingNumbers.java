package September;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {
    public static void main(String[] args) {
        jumpingNums(20);
    }
    static void jumpingNums(int X) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            bfs(X, i, al);
        }
        Collections.sort(al);
        System.out.println(al);
    }
    static void bfs(int X, int num, ArrayList<Integer> al){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()){
            num = q.poll();
            if (num <= X) {
                al.add(num);
                int lastDigit = num % 10;
                if (lastDigit == 0) {
                    q.add((num * 10) + (lastDigit + 1));
                } else if (lastDigit == 9) {
                    q.add((num * 10) + (lastDigit - 1));
                } else {
                    q.add((num * 10) + (lastDigit + 1));
                    q.add((num * 10) + (lastDigit - 1));
                }
            }
        }
    }
}
