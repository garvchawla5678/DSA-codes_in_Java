package leetcode.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_373 {
	class Pair {
		int sum;
		List<Integer> pair;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		int k = 3;
		leetcode_373 cl = new leetcode_373();
		System.out.println(cl.kSmallestPairs(nums1, nums2, k));
	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int sum = nums1[i] + nums2[j];
				if (k > 0) {
					Pair pp = new Pair();
					pp.sum = sum;
					pp.pair = new ArrayList<>();
					pp.pair.add(nums1[i]);
					pp.pair.add(nums2[j]);
					pq.add(pp);
					k--;
				} else if (pq.peek().sum > sum) {
					pq.poll();
					Pair pp = new Pair();
					pp.sum = sum;
					pp.pair = new ArrayList<>();
					pp.pair.add(nums1[i]);
					pp.pair.add(nums2[j]);
					pq.add(pp);
				} else {
					break;
				}
			}
		}

		while (!pq.isEmpty()) {
			ans.add(pq.poll().pair);
		}
		return ans;
	}
}
