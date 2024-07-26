package July;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheCity {
    class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private void dijkstras(ArrayList<ArrayList<Pair>> adj, int dist[], int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()) {
            int par = pq.peek().node;
            int wt = pq.peek().weight;
            pq.remove();

            for(Pair child : adj.get(par)) {
                int childNode = child.node;
                int childWt = child.weight;

                if(wt + childWt < dist[childNode]) {
                    dist[childNode] = wt + childWt;
                    pq.add(new Pair(childNode, dist[childNode]));
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < n; i++) dist[i][i] = 0;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int row[] : edges) {
            int u = row[0];
            int v = row[1];
            int wt = row[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        for(int citySource = 0; citySource < n; citySource++) {
            dijkstras(adj, dist[citySource], citySource);
        }

        int cntCity = n;
        int cityNo = -1;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int child : dist[i]) {
                if(child <= distanceThreshold) cnt++;
            }
            if(cnt <= cntCity) {
                cntCity = cnt;
                cityNo = i;
            }
        }
        return cityNo;

    }
}
