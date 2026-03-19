package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_494 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(findTargetSumWays(nums, target));
	}

	public static int findTargetSumWays(int[] nums, int target) {
//		HashMap<String, Integer> memo = new HashMap<>();
		int[][] memo = new int[nums.length + 1][2 * 1000 + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(nums, target, 0, 0, memo);
	}

	private static int solve(int[] nums, int target, int idx, int currSum, int[][] memo) {
		if (idx >= nums.length)
			return (currSum == target) ? 1 : 0;

//		String key = idx + "," + currSum;
//
//		if (memo.containsKey(key))
//			return memo.get(key);

		if (memo[idx][currSum + 1000] != -1)
			return memo[idx][currSum + 1000];

		int ways = 0;

		ways += solve(nums, target, idx + 1, currSum + nums[idx], memo);

		ways += solve(nums, target, idx + 1, currSum - nums[idx], memo);

		return memo[idx][currSum + 1000] = ways;
	}
}
