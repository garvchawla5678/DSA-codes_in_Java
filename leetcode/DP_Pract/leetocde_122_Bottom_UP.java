package leetcode.DP_Pract;

public class leetocde_122_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
//		int[][] dp = new int[n + 1][2];
//
//		for (int i = n - 1; i >= 0; i--) {
//			dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1] - prices[i]);
//			dp[i][1] = Math.max(dp[i + 1][1], dp[i + 1][0] + prices[i]);
//		}
//
//		return dp[0][0];

		int[] prev = new int[2];
		for (int i = n - 1; i >= 0; i--) {
			int[] curr = new int[2];

			curr[0] = Math.max(prev[0], prev[1] - prices[i]);
			curr[1] = Math.max(prev[1], prev[0] + prices[i]);

			prev = curr;
		}

		return prev[0];
	}
}
