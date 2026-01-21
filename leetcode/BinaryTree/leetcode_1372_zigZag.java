package leetcode.BinaryTree;

public class leetcode_1372_zigZag {
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
	    // here true means -> go left
	    // here false means -> go right
	    int ans = 0;
	    public int longestZigZag(TreeNode root) {
	        solve(root, 0, true);
	        solve(root, 0, false);

	        return ans;
	    }
	    public void solve(TreeNode root, int steps, boolean flag) {
	        if(root == null) return;

	        ans = Math.max(steps, ans);
	        if(flag) {
	            solve(root.left, steps + 1, false);
	            solve(root.right, 1, true);
	        } else {
	            solve(root.right, steps + 1, true);
	            solve(root.left, 1, false);
	        }
	    }
	}
}
