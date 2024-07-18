package July;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root, List<List<Integer>> al, int index) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode nn = q.remove();
            al.get(index).add(nn.val);
            if (nn.left != null){
                levelOrder(root.left, al, index+1);
            }
            if (nn.right != null){
                levelOrder(root.right, al, index+1);
            }
        }
        return al;
    }
}
