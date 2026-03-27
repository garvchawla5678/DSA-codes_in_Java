package leetcode.PrefixSum;

import java.util.Arrays;

public class leetcode_2906 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 2 }, { 3, 4 } };
		int[][] ans = constructProductMatrix(grid);
		for (int[] row : ans)
			System.out.println(Arrays.toString(row));
	}

	public static int[][] constructProductMatrix(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int MOD = 12345;
		int[][] suf = new int[n][m];
		long suffix = 1;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				suf[i][j] = (int) suffix;
				suffix = (suffix * grid[i][j]) % MOD;
			}
		}

		long prefix = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				suf[i][j] = (int) (suf[i][j] * prefix) % MOD;
				prefix = (prefix * grid[i][j]) % MOD;
			}
		}

		return suf;
	}
}
