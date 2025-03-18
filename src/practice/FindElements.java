package practice;

import August.PathSumII.TreeNode;
import java.util.HashSet;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        dfs(root, 0);
    }
    
    void dfs(TreeNode current, int currVal){
        if(current == null){
            return;
        }
        set.add(currVal);
        dfs(current.left, currVal * 2 + 1);
        dfs(current.right, currVal * 2 + 2);
    }
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */