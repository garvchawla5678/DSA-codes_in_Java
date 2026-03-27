package leetcode.PrefixSum;

import java.util.HashSet;

public class leetcode_3548 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 2, 4 }, { 2, 3, 5 } };
		System.out.println(canPartitionGrid(grid));
	}

	public static boolean canPartitionGrid(int[][] grid) {
		long totalSum = 0;
		for (int[] row : grid) {
			for (int ele : row)
				totalSum += ele;
		}
		int n = grid.length;
		int m = grid[0].length;

		// Horizontal cuts
		if (checkHorizontal(grid, n, m, totalSum))
			return true;
		reverse(grid, n, m);
		if (checkHorizontal(grid, n, m, totalSum))
			return true;
		reverse(grid, n, m); // original grid

		// Vertical cuts
		int[][] transposeGrid = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				transposeGrid[j][i] = grid[i][j];
			}
		}

		if (checkHorizontal(transposeGrid, m, n, totalSum))
			return true;
		reverse(transposeGrid, m, n);
		if (checkHorizontal(transposeGrid, m, n, totalSum))
			return true;

		return false;
	}

	private static void reverse(int[][] grid, int n, int m) {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				int nx = n - i - 1;
				int temp = grid[i][j];
				grid[i][j] = grid[nx][j];
				grid[nx][j] = temp;
			}
		}
	}

	private static boolean checkHorizontal(int[][] grid, int n, int m, long totalSum) {
		HashSet<Long> set = new HashSet<>();
		long top = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				top += grid[i][j];
				set.add((long) grid[i][j]);
			}

			long bottom = totalSum - top;
			long diff = top - bottom;

			if (diff == 0)
				return true;
			if (grid[0][0] == diff)
				return true;
			if (grid[0][m - 1] == diff)
				return true;
			if (grid[i][0] == diff)
				return true;
			if (i > 0 && m > 1 && set.contains(diff))
				return true;
		}

		return false;
	}
}
