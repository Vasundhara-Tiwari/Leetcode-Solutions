package July;

public class MaximumValueInBinaryTree {
    private class ListNode {
        int val;
        ListNode left;
        ListNode right;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    public int max(ListNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        return Math.max(node.val, Math.max(leftMax, rightMax));
    }
}
