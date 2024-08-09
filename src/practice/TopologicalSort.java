package practice;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    TopologicalSort(int v){
        map = new HashMap<>();
        for (int i = 0; i <= v; i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2){
        map.get(v1).put(v2, 0);
    }

    public int[] indegree(){
        int[] arr = new int[map.size()];
        for (int i : map.keySet()) {
            for (int j: map.get(i).keySet()) {
                arr[j]++;
            }
        }
        return arr;
    }

    public void sort(){
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = indegree();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            int ans = q.poll();
            res.add(ans);
            for (int i : map.get(ans).keySet()){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort(7);
        ts.addEdge(1, 0);
        ts.addEdge(1, 2);
        ts.addEdge(1, 4);
        ts.addEdge(3, 2);
        ts.addEdge(4, 3);
        ts.addEdge(4, 5);
        ts.addEdge(5, 7);
        ts.addEdge(6, 3);
        ts.addEdge(6, 7);
        ts.sort();
    }
}
