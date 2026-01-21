package leetcode.BinaryTree;

public class leetcode_958_dfs {
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
	    public boolean isCompleteTree(TreeNode root) {
	        int idx = 1;
	        int count = count(root);
	        return helper(root, 1, count);
	    }
	    public boolean helper(TreeNode root, int i, int count) {
	        if(root == null) return true;

	        if(i > count) return false;

	        return helper(root.left, 2*i, count) && helper(root.right, 2*i + 1, count);
	    }
	    public int count(TreeNode root) {
	        if(root == null) return 0;

	        return 1 + count(root.left) + count(root.right);
	    }
	}
}
