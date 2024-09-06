package September;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {
        }
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        if(root ==  null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return right+1;
        }
        if(root.right == null){
            return left+1;
        }
        return Math.min(left,right) + 1;
    }
}
