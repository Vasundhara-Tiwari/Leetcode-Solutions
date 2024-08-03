package practice;

import java.util.HashMap;

public class DSU {
    class Node{
        int v;
        Node parent;
        int rank;
    }
    HashMap<Integer, Node> map = new HashMap<>();

    public void createSet(int v){
        Node n = new Node();
        n.v = v;
        n.parent = n;
        n.rank =0;
        map.put(v, n);
    }

    public int find(int v){
        return find(map.get(v)).v;
    }

    private Node find(Node nn){
        if(nn.parent == nn){
            return nn;
        }
        Node ren = find(nn.parent);
        nn.parent = ren;
        return ren;
    }

    public void union(int v1, int v2){
        Node n1 = map.get(v1);
        Node n2 = map.get(v2);
        Node r1 = find(n1);
        Node r2 = find(n2);
        if (r1.rank == r2.rank){
            r1.parent = r2;
            r2.rank++;
        } else if (r1.rank > r2.rank){
            r2.parent = r1;
        } else{
            r1.parent = r2;
        }
    }
}
