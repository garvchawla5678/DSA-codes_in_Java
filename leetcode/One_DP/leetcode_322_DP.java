package leetcode.One_DP;

public class leetcode_322_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 1, 2, 5 };
		int amount = 100;
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;

//		int[][] dp = new int[coins.length + 1][amount + 1];
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[i].length; j++) {
//				if (i == 0 || j == 0) {
//					dp[i][j] = (j == 0) ? 0 : 1_000_000_007;
//				}
//			}
//		}
//
//		for (int i = 1; i < dp.length; i++) {
//			for (int j = 1; j < dp[1].length; j++) {
//				if (coins[i - 1] > j) {
//					dp[i][j] = 0 + dp[i - 1][j];
//				} else {
//					dp[i][j] = Math.min(0 + dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
//				}
//			}
//		}
//
//		int res = dp[coins.length][amount];
//		return res == Integer.MAX_VALUE ? -1 : res;

		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i < amount + 1; i++)
			dp[i] = 1_000_000_007;

		for (int amt = 1; amt <= amount; amt++) {
			for (int coin : coins) {
				if (coin <= amt) {
					dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
				}
			}
		}

		return dp[amount] == 1_000_000_007 ? -1 : dp[amount];
	}
}
