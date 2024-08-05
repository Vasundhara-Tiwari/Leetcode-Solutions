package August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> al = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return al;
        }
        targetSum-=root.val;
        curr.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum==0){
                al.add(new ArrayList<>(curr));
            }
        } else {
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        curr.remove(curr.size()-1);
        return al;
    }
}
