package leetcode.Partition_DP;

import java.util.Arrays;

public class MCM_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 1, 3, 4 };
		System.out.println(matrixMultiplication(arr));
	}

	public static int matrixMultiplication(int[] arr) {
		int n = arr.length;
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(arr, 1, n - 1, memo);
	}

	private static int solve(int[] arr, int i, int j, int[][] memo) {
		if (i >= j)
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		int cost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int tmp = (arr[i - 1] * arr[k] * arr[j]) + solve(arr, i, k, memo) + solve(arr, k + 1, j, memo);
			cost = Math.min(cost, tmp);
		}

		return memo[i][j] = cost;
	}
}
