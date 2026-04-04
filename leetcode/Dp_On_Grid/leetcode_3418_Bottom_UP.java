package leetcode.Dp_On_Grid;

import java.util.Arrays;

public class leetcode_3418_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] coins = { { 0, 1, -1 }, { 1, -2, 3 }, { 2, -3, 4 } };
		System.out.println(maximumAmount(coins));
	}

	public static int maximumAmount(int[][] coins) {
		int m = coins.length;
		int n = coins[0].length;
		int[][][] dp = new int[m + 1][n + 1][3];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				Arrays.fill(dp[i][j], -1_000_000_007);
			}
		}
		dp[m][n - 1][0] = dp[m][n - 1][1] = dp[m][n - 1][2] = 0;
		dp[m - 1][n][0] = dp[m - 1][n][1] = dp[m - 1][n][2] = 0;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (coins[i][j] >= 0) {
					dp[i][j][0] = coins[i][j] + Math.max(dp[i + 1][j][0], dp[i][j + 1][0]);
					dp[i][j][1] = coins[i][j] + Math.max(dp[i + 1][j][1], dp[i][j + 1][1]);
					dp[i][j][2] = coins[i][j] + Math.max(dp[i + 1][j][2], dp[i][j + 1][2]);
				} else {
					dp[i][j][0] = coins[i][j] + Math.max(dp[i + 1][j][0], dp[i][j + 1][0]);
					dp[i][j][1] = Math.max(coins[i][j] + Math.max(dp[i + 1][j][1], dp[i][j + 1][1]),
							Math.max(dp[i + 1][j][0], dp[i][j + 1][0]));
					dp[i][j][2] = Math.max(coins[i][j] + Math.max(dp[i + 1][j][2], dp[i][j + 1][2]),
							Math.max(dp[i + 1][j][1], dp[i][j + 1][1]));
				}
			}
		}

		return dp[0][0][2];
	}
}
