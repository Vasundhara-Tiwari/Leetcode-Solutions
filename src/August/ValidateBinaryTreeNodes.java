package August;

import java.util.*;

public class ValidateBinaryTreeNodes {
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        int n = 4;
        int[] left = {1,-1,3,-1};
        int[] right = {2,-1,-1,-1};
        System.out.println(validateBinaryTreeNodes(n, left, right));
    }
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ll.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++) {
            if(leftChild[i] != -1) {
                ll.get(i).add(leftChild[i]);
            }
            if(rightChild[i] != -1) {
                ll.get(i).add(rightChild[i]);
            }
        }
        int root = findRootNode(n, leftChild, rightChild);
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited.add(root);
        for (int j = 0; j < n; j++){
            while (!q.isEmpty()){
                int node = q.poll();
                for (int i: ll.get(node)) {
                    if(visited.contains(i)) return false;
                    q.add(i);
                    visited.add(i);
                }
            }
        }
        return true;
    }
    public static int findRootNode(int n, int[] leftChild, int[] rightChild){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(leftChild[i]);
            set.add(rightChild[i]);
        }
        for (int i = 0; i < n; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
