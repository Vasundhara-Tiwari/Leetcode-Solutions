package September;

public class SymmetricTree {
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
    public boolean isSymmetric(TreeNode root) {
        return isMirrorImage(root.left, root.right);
    }
    public boolean isMirrorImage(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        boolean lft = isMirrorImage(left.left, right.right);
        boolean rgt = isMirrorImage(left.right, right.left);
        return lft && rgt;
    }
}
