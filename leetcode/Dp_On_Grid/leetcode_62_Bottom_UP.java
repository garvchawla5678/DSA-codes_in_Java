package leetcode.Dp_On_Grid;

public class leetcode_62_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 19;
		int n = 13;
		System.out.println(uniquePaths(m, n));
	}

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= n; i++)
			dp[0][i] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					continue;

				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}
}
