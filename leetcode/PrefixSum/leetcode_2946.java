package leetcode.PrefixSum;

import java.util.Arrays;

public class leetcode_2946 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 3;
		System.out.println(areSimilar(grid, k));
	}

	public static boolean areSimilar(int[][] mat, int k) {
		int n = mat.length;
		int m = mat[0].length;
		k = k % m;
		if (k == 0)
			return true;

		int[][] tmp = new int[n][m];

		shift(mat, n, m, k, tmp);

		return Arrays.deepEquals(mat, tmp);
	}

	private static void shift(int[][] grid, int n, int m, int k, int[][] ans) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i % 2 == 0) {
					ans[i][(j + k) % m] = grid[i][j];
				} else {
					ans[i][(j - k + m) % m] = grid[i][j];
				}
			}
		}

	}
}
