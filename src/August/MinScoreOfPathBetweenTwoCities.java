package August;

import java.util.*;

public class MinScoreOfPathBetweenTwoCities {
    public static void main(String[] args) {
        MinScoreOfPathBetweenTwoCities m = new MinScoreOfPathBetweenTwoCities();
        int[][] roads = {{1,2,2}, {1,3,4}, {3,4,7}};
        int n = 4;
        initializeGraph(roads);
        for (int i = 0; i < roads.length; i++) {
            createGraph(roads[i][0], roads[i][1], roads[i][2]);
        }
        System.out.println(m.dijkstra(n));
    }
    static HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    class DijstraPair{
        int vertex;
        int cost;

        public DijstraPair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "DijstraPair{" +
                    "vertex=" + vertex +
                    ", cost=" + cost +
                    '}';
        }
    }
    private int dijkstra(int n) {
        PriorityQueue<DijstraPair> q = new PriorityQueue<>(new Comparator<DijstraPair>() {
            @Override
            public int compare(DijstraPair o1, DijstraPair o2) {
                return o1.cost - o2.cost;
            }
        });
        HashSet<Integer> visited = new HashSet<>();
        int cost = Integer.MAX_VALUE;
        q.add(new DijstraPair(1, cost));
        while (!q.isEmpty()){
            DijstraPair dp = q.poll();
            if(visited.contains(dp.vertex)){
                continue;
            }
            cost = Math.min(dp.cost, cost);
            visited.add(dp.vertex);
            for (int nbrs: map.get(dp.vertex).keySet()) {
                if(!visited.contains(nbrs)){
                    int price = map.get(dp.vertex).get(nbrs);
                    q.add(new DijstraPair(nbrs, Math.min(price, dp.cost)));
                }
            }
        }
        return cost;
    }
    private static void initializeGraph(int[][] roads) {
        for (int i = 0; i < roads.length; i++) {
            if(!map.containsKey(roads[i][0])){
                map.put(roads[i][0], new HashMap<>());
            }
            if(!map.containsKey(roads[i][1])){
                map.put(roads[i][1], new HashMap<>());
            }
        }
    }

    public static void createGraph(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
}
