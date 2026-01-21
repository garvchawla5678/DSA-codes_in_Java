package leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class leetcode_958_bfs {
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
	        boolean past = false;   // past me NULL dekha hai??
	        Queue<TreeNode> qu = new LinkedList<>();
	        qu.add(root);
	        while(!qu.isEmpty()) {
	            TreeNode curr = qu.poll();
	            if(curr == null) past = true;
	            else {
	                if(past) return false;
	                else {
	                    qu.add(curr.left);
	                    qu.add(curr.right);
	                }
	            }
	        }
	        return true;
	    }
	}
}
