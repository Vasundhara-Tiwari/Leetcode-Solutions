package July;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println(q);
        reverseQueue(q);
        System.out.println(q);
    }

    private static void reverseQueue(Queue<Integer> q) {
        if(q.isEmpty()){
            return;
        }
        int item = q.remove();
        reverseQueue(q);
        q.add(item);
    }
}
