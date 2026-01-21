package leetcode.BST;

class Node
{
  int data;
  Node left, right;

  public Node(int d)
  {
      data = d;
      left = right = null;
  }
}
// this solution is right but it might give TLE as it's T.C : O(n^2) as we are checking for each node whether it is Valid BST or not

public class leetcode_333 {
	static int largestBst(Node root) {
        if(root == null) return 0;

        int left = largestBst(root.left);
        int right = largestBst(root.right);
        if(isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)) return size(root);
        return Math.max(left, right);
        
    }
    static boolean isValid(Node root, long min, long max) {
        if(root == null) return true;
        
        if(root.data <= min || root.data >= max) return false;
        
        return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
    }
    static int size(Node root) {
        if(root == null) return 0;
        
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }
}
