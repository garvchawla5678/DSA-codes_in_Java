package leetcode.Dp_On_Grid;

import java.util.Arrays;

public class leetcode_329_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(longestIncreasingPath(matrix));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = 0;
		int[][] memo = new int[m][n];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, solve(matrix, i, j, m, n, memo));
			}
		}

		return ans;
	}

	private static int solve(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
		if (memo[i][j] != -1)
			return memo[i][j];

		int path = 1;
		int[][] direc = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		for (int[] arr : direc) {
			int new_i = i + arr[0];
			int new_j = j + arr[1];

			if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n)
				continue;

			if (matrix[new_i][new_j] > matrix[i][j])
				path = Math.max(1 + solve(matrix, new_i, new_j, m, n, memo), path);

		}

		return memo[i][j] = path;
	}
}
