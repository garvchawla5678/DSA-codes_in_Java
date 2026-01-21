package leetcode.BinaryTree;


public class leetcode_104 {
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
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root);
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left, right) + 1;
        
    }     
}

