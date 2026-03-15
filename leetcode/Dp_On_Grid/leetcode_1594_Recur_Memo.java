package leetcode.Dp_On_Grid;

public class leetcode_1594_Recur_Memo {

	class Pair {
		long max;
		long min;

		Pair() {
			max = Long.MIN_VALUE;
			min = Long.MAX_VALUE;
		}

		Pair(long max, long min) {
			this.max = max;
			this.min = min;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };
		leetcode_1594_Recur_Memo cl = new leetcode_1594_Recur_Memo();
		System.out.println(cl.maxProductPath(grid));
	}

	public int maxProductPath(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Pair[][] memo = new Pair[m][n];

		Pair ans = solve(grid, 0, 0, m, n, memo);
		return (ans.max < 0 ? 0 : (int) (ans.max % 1_000_000_007));
	}

	private Pair solve(int[][] grid, int i, int j, int m, int n, Pair[][] memo) {

		if (i == m - 1 && j == n - 1) {
			return new Pair(grid[i][j], grid[i][j]);
		}

		if (memo[i][j] != null)
			return memo[i][j];

		// down
		long maxVal = Long.MIN_VALUE;
		long minVal = Long.MAX_VALUE;
		if (i + 1 < m) {
			Pair down = solve(grid, i + 1, j, m, n, memo);
			maxVal = Math.max(maxVal, Math.max(down.max * grid[i][j], down.min * grid[i][j]));
			minVal = Math.min(minVal, Math.min(down.max * grid[i][j], down.min * grid[i][j]));
		}

		// right
		if (j + 1 < n) {
			Pair right = solve(grid, i, j + 1, m, n, memo);
			maxVal = Math.max(maxVal, Math.max(right.max * grid[i][j], right.min * grid[i][j]));
			minVal = Math.min(minVal, Math.min(right.max * grid[i][j], right.min * grid[i][j]));
		}

		return memo[i][j] = new Pair(maxVal, minVal);
	}
}
