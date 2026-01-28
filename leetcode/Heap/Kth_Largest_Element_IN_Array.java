package leetcode.Heap;

import java.util.PriorityQueue;

public class Kth_Largest_Element_IN_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}
	public static int findKthLargest(int[] nums, int k) {
		// 1st approach
		// It's T.c : O(nlog(n))
//		Arrays.sort(nums);
//        int n = nums.length;
//        return nums[n - k];
		
		// It's T.c : O(nlog(k))
		int n = nums.length;
        PriorityQueue<Integer> qu = new PriorityQueue<>(); // min heap
        for(int i = 0; i < k; i++) {
            qu.add(nums[i]);
        }
        for(int i = k; i < n; i++) {
        	if(qu.peek() > nums[i]) continue;
        	qu.poll();
        	qu.add(nums[i]);
        }
        return qu.poll();
    }

}
