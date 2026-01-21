package leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102_bfs {
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
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        if(root == null) return new ArrayList<>();
	        List<List<Integer>> ans = new ArrayList<>();
	        helper(root, ans);
	        return ans;
	    }
	    public void helper(TreeNode root, List<List<Integer>> ans) {
	    	// 1st approach
//	        Queue<TreeNode> qu = new LinkedList<>();
//	        qu.add(root);
//	        while(!qu.isEmpty()) {
//	            List<Integer> ans1 = new ArrayList<>();
//	            List<TreeNode> currNode = new ArrayList<>();
//	            while(!qu.isEmpty()) {
//	                TreeNode curr = qu.poll();
//	                currNode.add(curr);
//	                ans1.add(curr.val);
//	            }
//	            ans.add(ans1);
//	            for(TreeNode curr : currNode) {
//	                if(curr.left != null) qu.add(curr.left);
//	                if(curr.right != null) qu.add(curr.right);
//	            }
//	        }
	    	
	    	// 2nd approach
	    	Queue<TreeNode> qu = new LinkedList<>();
	        qu.add(root);
	        while(!qu.isEmpty()) {
	            List<Integer> ans1 = new ArrayList<>();
	            int size = qu.size();
	            for(int i = 0; i < size; i++) {
	                TreeNode curr = qu.poll();
	                ans1.add(curr.val);
	                if(curr.left != null) qu.add(curr.left);
	                if(curr.right != null) qu.add(curr.right);
	            }
	            ans.add(ans1);        
	        }
	    }
	}
}
