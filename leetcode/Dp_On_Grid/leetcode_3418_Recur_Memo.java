package leetcode.Dp_On_Grid;

import java.util.Arrays;

public class leetcode_3418_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] coins = { { 0, 1, -1 }, { 1, -2, 3 }, { 2, -3, 4 } };
		System.out.println(maximumAmount(coins));
	}

	public static int maximumAmount(int[][] coins) {
		int m = coins.length;
		int n = coins[0].length;
		int[][][] memo = new int[m + 1][n + 1][3];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				Arrays.fill(memo[i][j], -1_000_000_007);
			}
		}

		return solve(coins, 0, 0, 2, m, n, memo);
	}

	private static int solve(int[][] coins, int i, int j, int neutralize, int m, int n, int[][][] memo) {
		if (i == m - 1 && j == n - 1) {
			if (coins[i][j] >= 0) {
				return coins[i][j];
			} else {
				if (neutralize > 0) {
					return 0;
				} else {
					return coins[i][j];
				}
			}
		}
		if (memo[i][j][neutralize] != -1_000_000_007) {
			return memo[i][j][neutralize];
		}

		int[][] directions = { { 0, 1 }, { 1, 0 } };
		int profit = Integer.MIN_VALUE;

		for (int[] row : directions) {
			int currProfit = 0;
			int new_x = i + row[0];
			int new_y = j + row[1];

			if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n)
				continue;

			if (coins[i][j] >= 0) {
				currProfit += coins[i][j] + solve(coins, new_x, new_y, neutralize, m, n, memo);
			} else {
				int skip = 0, take = 0;
				if (neutralize > 0) {
					skip += solve(coins, new_x, new_y, neutralize - 1, m, n, memo);
					take += coins[i][j] + solve(coins, new_x, new_y, neutralize, m, n, memo);

					currProfit += Math.max(skip, take);
				} else {
					currProfit += coins[i][j] + solve(coins, new_x, new_y, neutralize, m, n, memo);
				}
			}

			profit = Math.max(currProfit, profit);
		}

		return memo[i][j][neutralize] = profit;
	}
}
