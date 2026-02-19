package leetcode.One_DP;

import java.util.HashMap;

public class leetcode_2926_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, -1, -3, 8 };
		System.out.println(maxBalancedSubsequenceSum(nums));
	}

	// But still it will give TLE after memoization

	public static long maxBalancedSubsequenceSum(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = (int) Math.max(max, nums[i]);
		}

		if (max <= 0)
			return max;
		// using this much size array will give memory limit exceeded so we tried to use
		// HashMap
		// long[][] memo = new long[n][n + 1];
		HashMap<String, Long> map = new HashMap<>();

		return solve(nums, 0, -1, map);
	}

	private static long solve(int[] nums, int idx, int prevIdx, HashMap<String, Long> map) {
		if (idx >= nums.length) {
			return 0;
		}
		if (map.containsKey(prevIdx + "_" + idx))
			return map.get(prevIdx + "_" + idx);

		long skip = solve(nums, idx + 1, prevIdx, map);

		long take = 0;
		if (prevIdx == -1 || nums[idx] - idx >= nums[prevIdx] - prevIdx) {
			take = nums[idx] + solve(nums, idx + 1, idx, map);
		}

		map.put(prevIdx + "_" + idx, (long) Math.max(take, skip));
		return map.get(prevIdx + "_" + idx);
	}
}
