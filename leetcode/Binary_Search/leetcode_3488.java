package leetcode.Binary_Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_3488 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 1, 4, 1, 3, 2 };
		int[] queries = { 0, 3, 5 };
		System.out.println(solveQueries(nums, queries));
	}

	public static List<Integer> solveQueries(int[] nums, int[] queries) {
		int n = nums.length;
		List<Integer> ans = new ArrayList<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<>());

			map.get(nums[i]).add(i);
		}

		for (int i : queries) {
			int target = nums[i];
			List<Integer> temp = map.get(target);
			if (temp.size() == 1) {
				ans.add(-1);
				continue;
			}

			int ans1 = 1_000_000_007;
			int size = temp.size();

			int idx = binarySearch(temp, i);

			int curr = temp.get(idx);

			// RIGHT
			int next = temp.get((idx + 1) % size);
			int right = Math.abs(next - curr);
			int circularRight = n - right;
			ans1 = Math.min(ans1, Math.min(right, circularRight));

			// LEFT
			int prev = temp.get((idx - 1 + size) % size);
			int left = Math.abs(curr - prev);
			int circularLeft = n - left;
			ans1 = Math.min(ans1, Math.min(left, circularLeft));

			ans.add(ans1);
		}

		return ans;
	}

	private static int binarySearch(List<Integer> ll, int i) {
		int l = 0;
		int r = ll.size() - 1;

		while (l <= r) {
			int mid = l + ((r - l) >> 1);

			if (ll.get(mid) == i)
				return mid;
			else if (ll.get(mid) > i)
				r = mid - 1;
			else
				l = mid + 1;
		}

		return l;
	}
}
