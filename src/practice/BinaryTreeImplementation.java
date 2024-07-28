package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeImplementation {
    class Node {
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
    Scanner scanner = new Scanner(System.in);
    public Node createTree(){
        Node nn = new Node();
        int item = scanner.nextInt();
        nn.val = item;
        boolean hasLeft = scanner.nextBoolean();
        if(hasLeft){
            nn.left = createTree();
        }
        boolean hasRight = scanner.nextBoolean();
        if (hasRight){
            nn.right = createTree();
        }
        return nn;
    }

    public void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public int max(Node root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        int left = max(root.left);
        int right = max(root.right);
        return Math.max(root.val,Math.max(left, right));
    }

    public int min(Node root){
        if (root == null){
            return Integer.MAX_VALUE;
        }
        int left = min(root.left);
        int right = min(root.right);
        return Math.min(root.val,Math.min(left, right));
    }

    public int height(Node root){
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.val == key){
            return true;
        }
        boolean left = search(root.left, key);
        boolean right = search(root.right, key);
        return left || right;
    }

    public void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node nn = q.remove();
            System.out.print(nn.val+" ");
            if(nn.left != null){
                q.add(nn.left);
            }
            if(nn.right != null){
                q.add(nn.right);
            }
        }
    }
}
