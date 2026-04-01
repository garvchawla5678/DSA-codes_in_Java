package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_45_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 0, 1, 4 };
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);

		return solve(nums, 0, n - 1, memo);
	}

	private static int solve(int[] nums, int i, int j, int[] memo) {
		if (i >= j)
			return 0;
		if (nums[i] == 0)
			return 1_000_000_007;
		if (memo[i] != -1)
			return memo[i];

		int cost = Integer.MAX_VALUE;
		for (int jump = 1; jump <= nums[i]; jump++) {
			int tmp = 1 + solve(nums, i + jump, j, memo);
			cost = Math.min(cost, tmp);
		}

		return memo[i] = cost;
	}
}
