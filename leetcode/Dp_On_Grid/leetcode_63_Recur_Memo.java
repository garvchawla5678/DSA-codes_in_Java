package leetcode.Dp_On_Grid;

import java.util.Arrays;

public class leetcode_63_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(uniquePathsWithObstacles(grid));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (obstacleGrid[m - 1][n - 1] == 1)
			return 0;

		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(obstacleGrid, m, n, 0, 0, memo);
	}

	private static int solve(int[][] grid, int m, int n, int i, int j, int[][] memo) {
		if (i == m - 1 && j == n - 1)
			return 1;

		if (grid[i][j] == 1)
			return 0;

		if (memo[i][j] != -1)
			return memo[i][j];

		int paths = 0;
		int[][] direc = { { 0, 1 }, { 1, 0 } };

		for (int[] arr : direc) {
			int new_i = i + arr[0];
			int new_j = j + arr[1];

			if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n)
				continue;

			paths += solve(grid, m, n, new_i, new_j, memo);
		}

		return memo[i][j] = paths;
	}
}
