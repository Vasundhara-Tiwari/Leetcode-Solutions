package July;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumSumPair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        while (pq.size() > 1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            pq.add(num2+num1);
            sum += num2+num1;
        }
        System.out.println(sum);
    }
}
