package leetcode.Dp_On_Grid;

import java.util.Arrays;

public class leetcode_64_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(grid, 0, 0, m, n, memo);
	}

	private static int solve(int[][] grid, int i, int j, int m, int n, int[][] memo) {
		if (i == m - 1 && j == n - 1)
			return grid[i][j];

		if (memo[i][j] != -1)
			return memo[i][j];

		if (i == m - 1)
			return memo[i][j] = grid[i][j] + solve(grid, i, j + 1, m, n, memo);
		else if (j == n - 1)
			return memo[i][j] = grid[i][j] + solve(grid, i + 1, j, m, n, memo);
		else
			return memo[i][j] = grid[i][j]
					+ Math.min(solve(grid, i, j + 1, m, n, memo), solve(grid, i + 1, j, m, n, memo));
	}
}
