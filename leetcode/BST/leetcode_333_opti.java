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

public class leetcode_333_opti {
	static int maxSize;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        maxSize = 0;
		largest(root);
		return maxSize;
	}
	static int[] largest(Node root) {
		if(root == null) {
			return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
		}
		int[] left = largest(root.left);
		int[] right = largest(root.right);
		if(left[1] < root.data && right[0] > root.data) {
		    int currSize = left[2] + right[2] + 1;
		    maxSize = Math.max(maxSize, currSize);
		    return new int[] { Math.min(root.data, left[0]), Math.max(root.data, right[1]),  currSize };
		}
		return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
	}
}
