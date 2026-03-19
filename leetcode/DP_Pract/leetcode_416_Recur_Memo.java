package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_416_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 5 };
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int num : nums)
			totalSum += num;

		if (totalSum % 2 != 0)
			return false;

		int sumToFind = totalSum / 2;
		int[][] memo = new int[nums.length + 1][sumToFind + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(nums, sumToFind, 0, nums.length, memo);
	}

	private static boolean solve(int[] nums, int sumToFind, int idx, int n, int[][] memo) {
		if (idx == n)
			return false;

		if (sumToFind < 0)
			return false;
		else if (sumToFind == 0)
			return true;

		if (memo[idx][sumToFind] != -1)
			return memo[idx][sumToFind] == 1 ? true : false;

		boolean skip = solve(nums, sumToFind, idx + 1, n, memo);
		boolean take = solve(nums, sumToFind - nums[idx], idx + 1, n, memo);

		boolean res = skip || take;

		memo[idx][sumToFind] = (res == true) ? 1 : 0;
		return res;
	}
}
