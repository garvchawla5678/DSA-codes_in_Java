package leetcode.BST;

public class leetcode_1373 {
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
		    int sum = Integer.MIN_VALUE;
		    public int maxSumBST(TreeNode root) {
		        largest(root);
		        if(sum < 0) return 0;
		        return sum;
		    }
		    public int[] largest(TreeNode root) {
				if(root == null) {
					return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
				}
				int[] left = largest(root.left);
				int[] right = largest(root.right);
				if(left[1] < root.val && right[0] > root.val) {
				    int currSum = left[2] + right[2] + root.val;
				    sum = Math.max(sum, currSum);
				    return new int[] { Math.min(root.val, left[0]), Math.max(root.val, right[1]),  currSum };
				}
				return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
			}
		}
				
}
