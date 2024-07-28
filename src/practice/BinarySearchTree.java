package practice;

public class BinarySearchTree {
    class Node{
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node createTree(int[] in){
        return createTree(in, 0, in.length-1);
    }

    public Node createTree(int[] arr, int si, int ei){
        if(si > ei){
            return null;
        }
        int mid = (si + ei) / 2;
        Node nn = new Node();
        nn.val = arr[mid];
        nn.left = createTree(arr, si, mid-1);
        nn.right = createTree(arr, mid+1, ei);
        return nn;
    }
}
