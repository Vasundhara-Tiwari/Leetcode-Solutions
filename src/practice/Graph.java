package practice;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Graph(int vertex) {
        map = new HashMap<>();
        for (int i = 1; i <= vertex; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public boolean containsVertex(int v){
        return map.containsKey(v);
    }

    public boolean containsEdge(int v1, int v2){
        return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
    }

    public int noOfEdge(){
        int sum = 0;
        for (Integer i: map.keySet()) {
            sum += map.get(i).size();
        }
        return sum/2;
    }

    public void removeEdge(int v1, int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removeVertex(int v){
        for (Integer i: map.get(v).keySet()){
            map.get(i).remove(v);
        }
        map.remove(v);
    }

    public boolean hasPath(int source, int destination, HashSet<Integer> visited){
        if (source == destination){
            return true;
        }
        visited.add(source);
        for (Integer neighbour: map.get(source).keySet()) {
            if(!visited.contains(neighbour)){
                return hasPath(neighbour, destination, visited);
            }
        }
        return false;
    }

    public void printAllPath(int source, int destination, HashSet<Integer> visited, String ans){
        if (source == destination){
            System.out.println(ans+destination);
            return;
        }
        visited.add(source);
        for (Integer neighbour: map.get(source).keySet()) {
            if(!visited.contains(neighbour)){
                printAllPath(neighbour, destination, visited, ans+source+"-->");
            }
        }
        visited.remove(source);
    }
}
