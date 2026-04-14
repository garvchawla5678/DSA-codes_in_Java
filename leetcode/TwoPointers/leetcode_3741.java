package leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_3741 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 1, 1, 3 };
		System.out.println(minimumDistance(nums));
	}

	public static int minimumDistance(int[] nums) {
		int len = nums.length;
		int res = Integer.MAX_VALUE;

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int k = 0; k < len; k++) {
			if (!map.containsKey(nums[k]))
				map.put(nums[k], new ArrayList<>());

			map.get(nums[k]).add(k);
			if (map.get(nums[k]).size() < 3)
				continue;

			List<Integer> temp = map.get(nums[k]);

			int i = temp.get(temp.size() - 3);
			res = Math.min(res, 2 * (k - i));
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
