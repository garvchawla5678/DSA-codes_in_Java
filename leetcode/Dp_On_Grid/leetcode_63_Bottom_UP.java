package leetcode.Dp_On_Grid;

public class leetcode_63_Bottom_UP {

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
		// Space Complexity: O(m * n)

//		int[][] dp = new int[m][n];
//
//		for (int i = 0; i < m; i++) {
//			if (obstacleGrid[i][0] == 1)
//				break;
//
//			dp[i][0] = 1;
//		}
//
//		for (int i = 0; i < n; i++) {
//			if (obstacleGrid[0][i] == 1)
//				break;
//
//			dp[0][i] = 1;
//		}
//
//		for (int i = 1; i < m; i++) {
//			for (int j = 1; j < n; j++) {
//				if (obstacleGrid[i][j] == 1)
//					dp[i][j] = 0;
//				else
//					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//			}
//		}
//
//		return dp[m - 1][n - 1];

		// Space Complexity: O(n)

		int[] dp = new int[n];
		dp[0] = 1;

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (obstacleGrid[r][c] == 1)
					dp[c] = 0;
				else {
					if (c > 0)
						dp[c] += dp[c - 1];
				}
			}
		}

		return dp[n - 1];
	}
}
