package leetcode.Dp_On_Grid;

public class leetcode_1594_Bottom_UP {

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
		Pair[][] dp = new Pair[m][n];

		dp[0][0] = new Pair(grid[0][0], grid[0][0]);
		for (int i = 1; i < m; i++)
			dp[i][0] = new Pair(grid[i][0] * dp[i - 1][0].max, grid[i][0] * dp[i - 1][0].min);

		for (int i = 1; i < n; i++)
			dp[0][i] = new Pair(grid[0][i] * dp[0][i - 1].max, grid[0][i] * dp[0][i - 1].min);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				long maxVal = Long.MIN_VALUE;
				long minVal = Long.MAX_VALUE;

				// down
				maxVal = Math.max(maxVal, Math.max(dp[i - 1][j].max * grid[i][j], dp[i - 1][j].min * grid[i][j]));
				minVal = Math.min(minVal, Math.min(dp[i - 1][j].max * grid[i][j], dp[i - 1][j].min * grid[i][j]));

				// right
				maxVal = Math.max(maxVal, Math.max(dp[i][j - 1].max * grid[i][j], dp[i][j - 1].min * grid[i][j]));
				minVal = Math.min(minVal, Math.min(dp[i][j - 1].max * grid[i][j], dp[i][j - 1].min * grid[i][j]));

				dp[i][j] = new Pair(maxVal, minVal);
			}
		}

		return dp[m - 1][n - 1].max < 0 ? -1 : (int) (dp[m - 1][n - 1].max % 1_000_000_007);
	}
}
