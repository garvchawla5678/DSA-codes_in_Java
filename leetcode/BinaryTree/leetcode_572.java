package leetcode.BinaryTree;

public class leetcode_572 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	    	  	this.val = val;
	    	  	this.left = left;
	    	  	this.right = right;
	      }
	}
	// It has T.C: O(n * m) where n is full tree size and m is subtree size
	class Solution {
	    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
	        return helper(root, subRoot);
	    }
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        if(p == null && q == null) return true;
	        else if(p == null) return false;
	        else if(q == null) return false;

	        boolean left = isSameTree(p.left, q.left);
	        boolean right = isSameTree(p.right, q.right);
	        return left && right && p.val == q.val;
	    }
	    public boolean helper(TreeNode p, TreeNode q) {
	        if(p == null) return false;

	        if(isSameTree(p, q)) return true;

	        return helper(p.left, q) || helper(p.right, q);
	    }
	}
}
