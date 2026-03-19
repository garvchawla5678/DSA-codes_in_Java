package leetcode.DP_Pract;

public class leetcode_309_Bottom_Up {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 1)
			return 0;

		// Time: O(n^2) Space: O(n)
//		int[] dp = new int[n];
//		dp[0] = 0;
//		dp[1] = Math.max(prices[1] - prices[0], 0);
//
//		for (int i = 2; i < n; i++) { // sell
//			dp[i] = dp[i - 1];
//			for (int j = 0; j <= i - 1; j++) { // buy
//				int prev_profit = j >= 2 ? dp[j - 2] : 0;
//
//				dp[i] = Math.max(dp[i], prices[i] - prices[j] + prev_profit);
//			}
//		}
//
//		return dp[n - 1];

		// Time: O(n) Space: O(n)
		// 0 -> buy state
		// 1 -> sell state
		// 2 -> cooldown state
//		int[][] dp = new int[n + 1][3];
//		for (int i = n - 1; i >= 0; i--) {
//			dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
//			dp[i][1] = Math.max(prices[i] + dp[i + 1][2], dp[i + 1][1]);
//			dp[i][2] = dp[i + 1][0];
//		}
//
//		return dp[0][0];

		// Time: O(n) Space: O(1)
		int[] prev = new int[3];
		for (int i = n - 1; i >= 0; i--) {
			int[] curr = new int[3];

			curr[0] = Math.max(-prices[i] + prev[1], prev[0]);
			curr[1] = Math.max(prices[i] + prev[2], prev[1]);
			curr[2] = prev[0];

			prev = curr.clone();
		}

		return prev[0];
	}
}
