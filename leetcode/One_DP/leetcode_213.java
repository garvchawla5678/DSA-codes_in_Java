package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 7, 9, 3, 1 };
		System.out.println(rob(nums));
	}

	// top to down approach
//	public static int rob(int[] nums) {
//		int n = nums.length;
//		if (n == 1)
//			return nums[0];
//
//		if (n == 2)
//			return Math.max(nums[0], nums[1]);
//
//		int[] memo = new int[101];
//		Arrays.fill(memo, -1);
//
//		int take_0th_idx = solve(nums, 0, n - 2, memo);
//
//		Arrays.fill(memo, -1);
//		int not_0th_idx = solve(nums, 1, n - 1, memo);
//
//		return (int) Math.max(take_0th_idx, not_0th_idx);
//
//	}
//
//	static int solve(int[] nums, int i, int n, int[] memo) {
//		if (i > n)
//			return 0;
//		if (memo[i] != -1)
//			return memo[i];
//
//		int steal = nums[i] + solve(nums, i + 2, n, memo);
//		int skip = solve(nums, i + 1, n, memo);
//
//		return memo[i] = (int) Math.max(steal, skip);
//	}

	// bottom-up approach
	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		if (n == 2)
			return Math.max(nums[0], nums[1]);

		int[] dp = new int[n + 1];

		// 1st case -> taking 0th house
		for (int i = 1; i <= n - 1; i++) {
			int steal = nums[i - 1] + (i >= 2 ? dp[i - 2] : 0);
			int skip = dp[i - 1];

			dp[i] = (int) Math.max(steal, skip);
		}

		int result1 = dp[n - 1];

		// 2nd case -> not taking 0th index
		Arrays.fill(dp, 0);
		for (int i = 2; i <= n; i++) {
			int steal = nums[i - 1] + dp[i - 2];
			int skip = dp[i - 1];

			dp[i] = (int) Math.max(steal, skip);
		}

		int result2 = dp[n];

		return (int) Math.max(result1, result2);
	}
}
