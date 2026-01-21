package leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

// leetcode 366 -> premium question
public class Find_Leaves_of_binary_tree {
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
		List<List<Integer>> ans = new ArrayList<>();
		
	    public List<List<Integer>> delNodes(TreeNode root) {
	        height(root);
	        return ans;
	    }
	    public int height(TreeNode root) {
	    	if(root == null) return 0;
	    	
	    	int left = height(root.left);
	    	int right = height(root.right);
	    	
	    	int currHeight = Math.max(left, right);
	    	
	    	if(ans.size() == currHeight) ans.add(new ArrayList<>());
	    	
	    	ans.get(currHeight).add(root.val);
	    	
	    	return currHeight + 1;
	    }
	    
	}
}
