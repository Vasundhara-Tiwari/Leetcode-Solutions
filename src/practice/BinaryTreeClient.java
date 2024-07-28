package practice;

public class BinaryTreeClient {
    public static void main(String[] args) {
        BinaryTreeImplementation bt = new BinaryTreeImplementation();
        BinaryTreeImplementation.Node root = bt.createTree();
        bt.preOrder(root);
        System.out.println();
        bt.postOrder(root);
        System.out.println();
        bt.inOrder(root);
        System.out.println();
        System.out.println(bt.max(root));
        System.out.println(bt.min(root));
        System.out.println(bt.height(root));
        System.out.println(bt.search(root, 50));
        bt.levelOrder(root);
    }
}
