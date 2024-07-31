package practice;

import java.util.*;

public class KruskalAlgo {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    class EdgePair{
        int v1;
        int v2;
        int cost;

        public EdgePair(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "EdgePair{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", cost=" + cost +
                    '}';
        }
    }

    public KruskalAlgo(int v) {
        this.map = new HashMap<>();
        for (int i = 1; i <= v; i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public List<EdgePair> getAllEdge() {
        List<EdgePair> ll = new ArrayList<>();
        for (int e1 : map.keySet()) {
            for (int e2 : map.get(e1).keySet()) {
                int cost = map.get(e1).get(e2);
                ll.add(new EdgePair(e1, e2, cost));
            }
        }
        return ll;
    }

    public void kruskal(){
        DSU dsu = new DSU();
        List<EdgePair> ll = getAllEdge();
        Collections.sort(ll, new Comparator<EdgePair>() {
            @Override
            public int compare(EdgePair o1, EdgePair o2) {
                return o1.cost - o2.cost;
            }
        });
        for (int i: map.keySet()){
            dsu.createSet(i);
        }
        int sum  = 0;
        for (EdgePair e: ll){
            int r1 = dsu.find(e.v1);
            int r2 = dsu.find(e.v2);
            if (r1 == r2){}
            else{
                sum += e.cost;
                dsu.union(e.v1, e.v2);
                System.out.println(e);
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        KruskalAlgo g = new KruskalAlgo(7);
        g.addEdge(1, 4, 6);
        g.addEdge(1, 2, 10);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 5);
        g.addEdge(4, 5, 1);
        g.addEdge(5, 6, 4);
        g.addEdge(7, 5, 2);
        g.addEdge(6, 7, 3);
        g.kruskal();
    }
}
