package leetcode.BinaryTree;

public class leetcode_814_brute_force {
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
	class Solution {
	    public TreeNode pruneTree(TreeNode root) {
	        if(root == null) return null;

	        if(isValid(root.left)) root.left = null;
	        if(isValid(root.right)) root.right = null;
	        
	        pruneTree(root.left);
	        pruneTree(root.right);
	        
	        if(root.left == null && root.right == null && root.val == 0) return null;
	        
	        return root;
	    }
	    public boolean isValid(TreeNode root) {
	        if(root == null) return true;

	        boolean left = isValid(root.left);
	        boolean right = isValid(root.right);
	        boolean self = (root.val == 0) ? true : false;
	        return self && left && right;
	    }
	}
}
