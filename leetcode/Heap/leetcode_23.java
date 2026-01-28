package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_23 {
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }}

	class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
	    	ListNode dummy = new ListNode(0);
	        ListNode temp = dummy;
	        PriorityQueue<ListNode> qu = new PriorityQueue<>(new Comparator<ListNode>() {
	        	@Override
        		public int compare(ListNode o1, ListNode o2) {
        			return o1.val - o2.val;
        		}
	        });
	        // we can also write as : 
	        // PriorityQueue<ListNode> qu = new PriorityQueue<>((a, b) -> a.val - b.val);
	        for(ListNode curr : lists) {
	        	if(curr != null) qu.add(curr);
	        }
	        while(!qu.isEmpty()) {
	        	ListNode curr = qu.poll();
	        	if(curr.next != null) qu.add(curr.next);
	        	dummy.next = curr;
                dummy = dummy.next;
	        }
	        return temp.next;
	    }
	}
}
	  
