package leetcode.Heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class leetcode_373_opti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		int k = 3;
		leetcode_373 cl = new leetcode_373();
		System.out.println(cl.kSmallestPairs(nums1, nums2, k));
	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		int m = nums1.length;
		int n = nums2.length;

		pq.add(new int[] { nums1[0] + nums2[0], 0, 0 });

		Set<String> visited = new HashSet<>();
		visited.add("0,0");

		while (k > 0 && !pq.isEmpty()) {
			List<Integer> ans1 = new ArrayList<>();
			int[] temp = pq.poll();
			ans1.add(nums1[temp[1]]);
			ans1.add(nums2[temp[2]]);
			ans.add(ans1);
			int idx1 = temp[1] + 1;
			int idx2 = temp[2] + 1;
			if (idx1 < m && !visited.contains(idx1 + "," + temp[2]))
				pq.add(new int[] { nums1[idx1] + nums2[temp[2]], idx1, temp[2] });
			visited.add(idx1 + "," + temp[2]);
			if (idx2 < n && !visited.contains(temp[1] + "," + idx2))
				pq.add(new int[] { nums1[temp[1]] + nums2[idx2], temp[1], idx2 });
			visited.add(temp[1] + "," + idx2);
			k--;
		}

		return ans;
	}
}
