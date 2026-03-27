package leetcode.PrefixSum;

public class leetcode_3546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 4 }, { 2, 3 } };
		System.out.println(canPartitionGrid(grid));
	}

	public static boolean canPartitionGrid(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		long totalSum = 0;
		long[] row = new long[n];
		long[] col = new long[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				totalSum += grid[i][j];
				row[i] += grid[i][j];
				col[j] += grid[i][j];
			}
		}

		if (totalSum % 2 != 0)
			return false;

		long upper = 0;
		// horizontal check
		for (int i = 0; i < n - 1; i++) {
			upper += row[i];
			long lower = totalSum - upper;
			if (upper == lower)
				return true;
		}

		// vertical check
		upper = 0;
		for (int j = 0; j < m - 1; j++) {
			upper += col[j];
			long lower = totalSum - upper;
			if (upper == lower)
				return true;
		}

		return false;
	}
}
