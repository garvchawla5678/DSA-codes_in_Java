package leetcode.Partition_DP;

import java.util.Arrays;

public class leetcode_1043_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		System.out.println(maxSumAfterPartitioning(arr, k));
	}

	// it will give TLE
	public static int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(arr, k, 0, n - 1, n, memo);
	}

	private static int solve(int[] arr, int k, int i, int j, int n, int[][] memo) {
		if (i > j)
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		if (j - i + 1 <= k) {
			int max = -1;
			for (int it = i; it <= j; it++) {
				max = Math.max(max, arr[it]);
			}

			return max * (j - i + 1);
		}

		int sum = Integer.MIN_VALUE;
		for (int cut = i; cut < j; cut++) {
			int temp = 0;
			temp += solve(arr, k, i, cut, n, memo) + solve(arr, k, cut + 1, j, n, memo);
			sum = Math.max(sum, temp);
		}

		return memo[i][j] = sum;
	}
}
