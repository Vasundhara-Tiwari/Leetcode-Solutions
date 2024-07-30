package practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    class DijkstraPair{
        int v;
        String path;
        int cost;

        DijkstraPair(int v, String path, int cost){
            this.v = v;
            this.path = path;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "DijkstraPair{" +
                    "v=" + v +
                    ", path='" + path + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
    HashMap<Integer, HashMap<Integer, Integer>> map;

    DijkstraAlgorithm(int v){
        map = new HashMap<>();
        for (int i = 0; i <= v; i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public void Dijkstra(){
        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>() {
            @Override
            public int compare(DijkstraPair o1, DijkstraPair o2) {
                return o1.cost - o2.cost;
            }
        });
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new DijkstraPair(1, "1", 0));
        while (!pq.isEmpty()){
            DijkstraPair pair = pq.poll();
            if(visited.contains(pair.v)){
               continue;
            }
            System.out.println(pair);
            visited.add(pair.v);
            for(int nbrs: map.get(pair.v).keySet()){
                if(!visited.contains(nbrs)){
                    int cost = map.get(pair.v).get(nbrs);
                    pq.add(new DijkstraPair(nbrs, pair.path+nbrs, pair.cost+cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm da = new DijkstraAlgorithm(7);
        da.addEdge(1, 4, 8);
        da.addEdge(1, 2, 1);
        da.addEdge(2, 3, 2);
        da.addEdge(3, 4, 9);
        da.addEdge(4, 5, 5);
        da.addEdge(5, 6, 6);
        da.addEdge(7, 5, 4);
        da.addEdge(6, 7, 7);
        da.Dijkstra();
    }
}
