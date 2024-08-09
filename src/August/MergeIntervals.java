package August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] res = merge(intervals);
        for (int[] arr: res) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int[] arr : intervals){
            pq.add(arr);
        }
        ArrayList<int[]> al = new ArrayList<>();
        al.add(pq.poll());
        int start = 0;
        int end = 1;
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int[] prev = al.get(al.size()-1);
            if(current[start] <= prev[end]){
                prev[end] = Math.max(current[end], prev[end]);
                prev[start] = Math.min(current[start], prev[start]);
            } else {
                al.add(current);
            }
        }
        return al.toArray(new int[al.size()][2]);
    }
}
