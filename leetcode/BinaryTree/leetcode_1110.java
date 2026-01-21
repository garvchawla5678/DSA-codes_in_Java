package leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leetcode_1110 {
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
	    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        List<TreeNode> ans = new ArrayList<>();
	        HashSet<Integer> map = new HashSet<>();
	        for(int i : to_delete) {
	            map.add(i);
	        }
	        delete(root, map, ans);

	        if(!map.contains(root.val)) {
	            ans.add(root);
	        }
	        return ans;
	    }
	    public TreeNode delete(TreeNode root, HashSet<Integer> map, List<TreeNode> ans) {
	        if(root == null) return null;

	        root.left = delete(root.left, map, ans);
	        root.right = delete(root.right, map, ans);

	        if(map.contains(root.val)) {
	            if(root.left != null) ans.add(root.left);

	            if(root.right != null) ans.add(root.right);

	            return null;
	        } else {
	            return root;
	        }
	    }
	}
}
