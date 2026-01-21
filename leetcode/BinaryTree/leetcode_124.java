package leetcode.BinaryTree;

public class leetcode_124 {
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

	        int neeche_hi_milgya = root.val + l + r; // 1

	        int ek_accha_hai = Math.max(l, r) + root.val; // 2

	        int root_hi_accha_bss = root.val;  // 3

	        maxSum = Math.max(maxSum, Math.max(Math.max(neeche_hi_milgya, ek_accha_hai), root_hi_accha_bss));

	        return Math.max(ek_accha_hai, root_hi_accha_bss);
	    }
	}
}
