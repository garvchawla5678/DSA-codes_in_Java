package leetcode.BinaryTree;

public class leetcode_124_little_bit_opti {
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
	    int maxSum;
	    public int maxPathSum(TreeNode root) {
	        maxSum = Integer.MIN_VALUE;
	        helper(root);
	        return maxSum;
	    }
	    public int helper(TreeNode root) {
	        if(root == null) return 0;

	        int l = helper(root.left);
	        int r = helper(root.right);
	        
	        l = Math.max(0,  l);
	        r = Math.max(0,  r);

	        maxSum = Math.max(maxSum, root.val + l + r);

	        return Math.max(l, r) + root.val;
	    }
	}
}
