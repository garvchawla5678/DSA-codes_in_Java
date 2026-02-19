package leetcode.One_DP;

import java.util.TreeMap;

public class leetcode_2926_optimized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, -1, -3, 8 };
		System.out.println(maxBalancedSubsequenceSum(nums));
	}

	public static long maxBalancedSubsequenceSum(int[] nums) {
		int n = nums.length;

		long ans = Integer.MIN_VALUE;
		TreeMap<Integer, Long> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0)
				ans = Math.max(ans, nums[i]);
			else {
				int key = nums[i] - i;
				long sum = nums[i];

				// get best previous DP
				Integer prevKey = map.floorKey(key);
				if (prevKey != null) {
					sum += map.get(prevKey);
				}

				// update map with best value of for the key
				map.put(key, (long) Math.max(sum, map.getOrDefault(key, Long.MIN_VALUE)));

				// remove dominated entry
				Integer nextKey = map.higherKey(key);
				while (nextKey != null && map.get(nextKey) <= map.get(key)) {
					map.remove(nextKey);
					nextKey = map.higherKey(nextKey);
				}

				ans = (long) Math.max(sum, ans);
			}
		}

		return ans;
	}
}
