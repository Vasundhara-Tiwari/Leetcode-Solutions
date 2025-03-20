package practice;

import java.util.Arrays;

class DisjointSet {
    private Integer[] roots;
    public Integer[] comps;
    DisjointSet(Integer n) {
        roots = new Integer[n];
        comps = new Integer[n];

        for (Integer i = 0; i < n; i++) {
            roots[i] = i;
            comps[i] = (1<<20)-1;
        }
    }
    public Integer findRoot(Integer u) {
        while (u != roots[u]) {
            roots[u] = findRoot(roots[u]);
            u = roots[u];
        }

        return u;
    }
    public void union(Integer u, Integer v, Integer w) {
        Integer rootU = findRoot(u), rootV = findRoot(v);
        if (rootU == rootV) {
            comps[rootU] &= w;
        }
        else {
            roots[rootV] = rootU;
            comps[rootU] &= (w & comps[rootV]);
        }
    }
}
public class MinCostWalkInWeightedGraph {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        for (int[] edge: edges) {
            ds.union(edge[0], edge[1], edge[2]);
        }

        int[] ans = new int[query.length];
        Arrays.fill(ans, -1);

        int i = 0;
        for (int[] q: query) {
            int u = q[0], v = q[1];
            if (ds.findRoot(u) == ds.findRoot(v)) {
                ans[i] = ds.comps[ds.findRoot(u)];
            }
            i += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinCostWalkInWeightedGraph mc = new MinCostWalkInWeightedGraph();
        int[][] edges = {{0,1,7}, {1,3,7}, {1,2,1}};
        int[][] query = {{0,3}, {3,4}};
        int n = 5;
        System.out.println(Arrays.toString(mc.minimumCost(n, edges, query)));
    }
}
