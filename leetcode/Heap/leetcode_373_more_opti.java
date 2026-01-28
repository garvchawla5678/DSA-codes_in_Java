package leetcode.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_373_more_opti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		int k = 3;
		leetcode_373_more_opti cl = new leetcode_373_more_opti();
		System.out.println(cl.kSmallestPairs(nums1, nums2, k));
	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return ans;

		int m = nums1.length;
		int n = nums2.length;

		for (int i = 0; i < n && i < k; i++) {
			pq.add(new int[] { nums1[0] + nums2[i], 0, i });
		}

		while (k-- > 0 && !pq.isEmpty()) {
			int[] temp = pq.poll();
			ans.add(Arrays.asList(nums1[temp[1]], nums2[temp[2]]));
			if (temp[1] + 1 < m)
				pq.add(new int[] { nums1[temp[1] + 1] + nums2[temp[2]], temp[1] + 1, temp[2] });
		}

		return ans;
	}
}
