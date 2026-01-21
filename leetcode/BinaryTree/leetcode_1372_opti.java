package leetcode.BinaryTree;

public class leetcode_1372_opti {
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
	    int ans = 0;
	    public int longestZigZag(TreeNode root) {
	        solve(root, 0, 0);

	        return ans;
	    }
	    public void solve(TreeNode root, int left, int right) {
	        if(root == null) return;

	        ans = Math.max(ans, Math.max(left, right));

	        solve(root.left, right + 1, 0);
	        solve(root.right, 0, left + 1);
	    }
	}
}
