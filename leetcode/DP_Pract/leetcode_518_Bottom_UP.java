package leetcode.DP_Pract;

public class leetcode_518_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 5;
		int[] coins = { 1, 2, 5 };
		System.out.println(change(amount, coins));
	}

	public static int change(int amount, int[] coins) {
		int n = coins.length;
//		int[][] dp = new int[n + 1][amount + 1];
//
//		for (int i = 0; i <= n; i++)
//			dp[i][0] = 1;
//
//		for (int i = 1; i <= n; i++) {
//			for (int amt = 0; amt <= amount; amt++) {
//				int skip = dp[i - 1][amt];
//
//				int take = 0;
//				if (amt - coins[i - 1] >= 0)
//					take = dp[i][amt - coins[i - 1]];
//
//				dp[i][amt] = take + skip;
//			}
//		}
//
//		return dp[n][amount];

		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int amt = coins[i]; amt <= amount; amt++) {
				int skip = dp[amt];

				int take = dp[amt - coins[i]];

				dp[amt] = take + skip;
			}
		}

		return dp[amount];
	}
}
