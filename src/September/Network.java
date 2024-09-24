package September;
//
//import java.util.*;
//import javafx.util.Pair;
//
//public class Network {
//
////    Question:
////    A company called GoodCorp has a data network that can be visualized as a graph of nodes connected by cables where each node can transfer data to other nodes.
////    A malicious hacker company, MaliciousCorp has managed to hack and corrupt one of these nodes which stops the transfer of data going through it.
////
////            Part 1: Given this network and what node was corrupted, GoodCorp wants to know whether it is possible to transfer data between two nodes (a source and destination node).
////
////            1 - 2 - 3       8 - 10 - 12
////            |           |\      /
////            4 - 5 - 6 - 7-9 - 11
////
////    Source Node: 2
////    Destination Node: 9
////    Corrupted Node: 11
////    Output: TRUE
//
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        Network(int v){
//            for(int i = 1; i <= v; i++){
//                map.put(i, new ArrayList<>());
//            }
//        }
//
//        void addEdge(int v1, int v2){
//            map.get(v1).add(v2);
//            map.get(v2).add(v1);
//        }
//
//        void createNetwork(ArrayList<Pair<Integer, Integer>> edges, int vertices){
//            Network n = new Network(vertices);
//            for(Pair p: edges){
//                n.addEdge(p.get(0), p.get(1));
//            }
//        }
//
//        boolean checkPath(int src, int des, int currupt, ArrayList<Pair<Integer, Integer>> edges, int vertices){
//            createNetwork(edges, vertices);
//            Queue<Integer> q = new LinkedList<>();
//            HashSet<Integer> visited = new HashSet<>();
//            q.add(src);
//            while(!q.isEmpty()){
//                int v = q.poll();
//                if(visited.contains(v)){
//                    continue;
//                }
//                visited.add(v);
//                if(v == des){
//                    return true;
//                }
//                for(int nbrs: map.get(v)){
//                    if(visited.contains(nbrs) || nbrs == currupt){
//                        continue;
//                    } else {
//                        q.add(nbrs);
//                    }
//                }
//            }
//            return false;
//        }
////
////    Part 2: Now, GoodCorp wants to know the minimal cost or the distance between the source node and all other reachable (non-corrupted) nodes for record keeping,
////            which can be represented as a map of node to distance.
////
////    Example:
////            1 - 2 - 3       8 - 10 - 12
////            |           |\      /
////            4 - 5 - 6 - 7-9 - 11
////
////    Source Node: 2
////    Corrupted Node: 7
////
////            [N1: 1, N3: 1, N4: 1, N5: 2, N6: 3, N7: -1, N9: -1, N8: -1....]
//
//    HashMap<Integer, Integer> checkPath(int src, int currupt, ArrayList<Pair<Integer, Integer>> edges, int vertices){
//        createNetwork(edges, vertices);
//        HashMap<Integer, Integer> costs = new HashMap<>();
//        for(int i = 1; i <= v; i++){
//            costs.put(i, -1);
//        }
//        Queue<Integer> q = new LinkedList<>();
//        HashSet<Integer> visited = new HashSet<>();
//        q.add(src);
//        costs.put(src, 0);
//        while(!q.isEmpty()){
//            int v = q.poll();
//            if(visited.contains(v)){
//                continue;
//            }
//            visited.add(v);
//            for(int nbrs: map.get(v)){
//                if(visited.contains(nbrs) || nbrs == currupt){
//                    continue;
//                } else {
//                    costs.put(nbrs, costs.get(v)+1);
//                    q.add(nbrs);
//                }
//            }
//        }
//        return costs;
//    }
//
////    Part 3:
////    Now, the corrupted node has gained the ability to corrupt its neighbors.
////    Virality describes the maximum distance from the infected node that neighbors are also corrupted, so that data transferring through them is lost.
////
////1 - 2 - 3       8 - 10 - 12
////        |           |\      /
////        4 - 5 - 6 - 7-9 - 11
////
////    Push 8 -> [8] V - 2
////    Pop -> 8
////    Push 10,7 ->[10,7] V - 1
////    Pop -> 10 [7]
////    Push 12 [12, 7] V - 0
////
////
////
////    Source Node: 2
////    Corrupted Node : 10
////    Virality: 2
////
////    Corrupted Nodes - [10,8,12, 11, 7, 9]
//
//    HashMap<Integer, Integer> checkPath(int src, int currupt, ArrayList<Pair<Integer, Integer>> edges, int vertices, int virality){
//        createNetwork(edges, vertices);
//        HashMap<Integer, Integer> costs = new HashMap<>();
//        HashMap<Integer, Integer> curruptedNodes = new HashMap<>();
//        curruptedNodes = bfs(currupt, virality, curruptedNodes, costs);
//        costs = bfs(src, -1, curruptedNodes, costs);
//        return costs;
//    }
//
//    HashMap<Integer, Integer> bfs(int src, int virality, HashMap<Integer, Integer> curruptedNodes,  HashMap<Integer, Integer> costs){
//        Queue<Integer> q = new LinkedList<>();
//        HashSet<Integer> visited = new HashSet<>();
//        q.add(src);
//        costs.put(src, 0);
//        while(!q.isEmpty()){
//            int v = q.poll();
//            if(visited.contains(v)){
//                continue;
//            }
//            visited.add(v);
//            for(int nbrs: map.get(v)){
//                if(visited.contains(nbrs) || curruptedNodes.get(nbrs) == 0){
//                    continue;
//                } else {
//                    if(costs.get(v) < virality){
//                        curruptedNodes.put(nbrs, 0);
//                        costs.put(nbrs, costs.get(v)+1);
//                        q.add(nbrs);
//                    }
//                }
//            }
//        }
//        return costs;
//    }
//
//    }
