package leetcode.Partition_DP;

import java.util.Arrays;

public class leetcode_312_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 5, 8 };
		System.out.println(maxCoins(nums));
	}

	public static int maxCoins(int[] nums) {
		int[] arr = new int[nums.length + 2];
		int n = arr.length;
		arr[0] = 1;
		arr[n - 1] = 1;
		for (int i = 1; i < n - 1; i++)
			arr[i] = nums[i - 1];
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(arr, 1, n - 2, memo);
	}

	private static int solve(int[] arr, int i, int j, int[][] memo) {
		if (i > j)
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		int cost = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			int tmp = arr[i - 1] * arr[k] * arr[j + 1] + solve(arr, i, k - 1, memo) + solve(arr, k + 1, j, memo);
			cost = Math.max(cost, tmp);
		}

		return memo[i][j] = cost;
	}
}
