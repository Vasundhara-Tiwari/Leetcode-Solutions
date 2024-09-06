package September;

public class MaximumBinaryTree {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0, nums.length-1, nums);
    }
    public TreeNode construct(int low, int high, int[] nums){
        if(low > high){
            return null;
        }
        int max = -1, maxIndex = 0;
        for(int i = low; i <= high; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(low, maxIndex - 1, nums);
        node.right = construct(maxIndex + 1, high, nums);
        return node;
    }
}
