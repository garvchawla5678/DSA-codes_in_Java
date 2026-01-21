package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    public class Node {
        int val;
        Node left;
        Node right;
    }
    private Node root;

    public BinaryTree() {
        root = CreateBinaryTree();
    }

    Scanner sc = new Scanner(System.in);
    private Node CreateBinaryTree() {
        Node nn = new Node();
        nn.val = sc.nextInt();
        boolean hlc = sc.nextBoolean();
        if (hlc) {
            nn.left = CreateBinaryTree();
        }
        boolean hrc = sc.nextBoolean();
        if (hrc) {
            nn.right = CreateBinaryTree();
        }
        return nn;
    }
    public void display() {
        display(root);
    }

    private void display(Node root) {
        if (root == null) return;
        String s = "<--" + root.val + "-->";
        if(root.left != null) {
            s = root.left.val + s;
        } else {
            s = "." + s;
        }

        if(root.right != null) {
            s = s + root.right.val;
        } else {
            s = s + ".";
        }
        System.out.println(s);
        display(root.left);
        display(root.right);
    }

    public boolean seacrh(int val) {
        return search(root, val);
    }

    private boolean search(Node root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return search(root.left, val) || search(root.right, val);
    }

    public int height() {
        return height(root);
    }
    private int height(Node root) {
        if (root == null) return -1;

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = max(root.left);
        int right = max(root.right);
        return Math.max(root.val, Math.max(left, right));
    }
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.val + " ");
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
        }
        System.out.println();
    }
}
