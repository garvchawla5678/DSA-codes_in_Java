package leetcode.Dp_On_Grid;

public class leetcode_64_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		if (m == 1 && n == 1)
			return grid[0][0];

//		int[][] dp = new int[m][n];
//		dp[0][0] = grid[0][0];
//
//		for (int i = 1; i < m; i++)
//			dp[i][0] = grid[i][0] + dp[i - 1][0];
//
//		for (int i = 1; i < n; i++)
//			dp[0][i] = grid[0][i] + dp[0][i - 1];
//
//		for (int i = 1; i < m; i++) {
//			for (int j = 1; j < n; j++) {
//				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
//			}
//		}
//
//		return dp[m - 1][n - 1];

		int[] dp = new int[n];
		dp[0] = grid[0][0];

		for (int j = 1; j < n; j++)
			dp[j] = grid[0][j] + dp[j - 1];

		for (int i = 1; i < m; i++) {
			dp[0] += grid[i][0];
			for (int j = 1; j < n; j++) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
			}
		}

		return dp[n - 1];
	}
}
