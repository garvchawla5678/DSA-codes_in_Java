package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_931_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(matrix));
	}

	public static int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;

		int row = 0;
		int res = Integer.MAX_VALUE;
		int[][] memo = new int[n + 1][n + 1];
		for (int[] ro : memo)
			Arrays.fill(ro, 1_000_000_007);

		for (int col = 0; col < n; col++) {
			res = Math.min(res, solve(matrix, row, col, n, memo));
		}

		return res;
	}

	private static int solve(int[][] matrix, int row, int col, int n, int[][] memo) {
		if (row == n - 1)
			return matrix[row][col];

		if (memo[row][col] != 1_000_000_007)
			return memo[row][col];

		int sum = matrix[row][col];
		int res = Integer.MAX_VALUE;

		if (row + 1 < n && col - 1 >= 0)
			res = Math.min(sum + solve(matrix, row + 1, col - 1, n, memo), res);
		if (row + 1 < n)
			res = Math.min(sum + solve(matrix, row + 1, col, n, memo), res);
		if (row + 1 < n && col + 1 < n)
			res = Math.min(sum + solve(matrix, row + 1, col + 1, n, memo), res);

		return memo[row][col] = res;
	}
}
