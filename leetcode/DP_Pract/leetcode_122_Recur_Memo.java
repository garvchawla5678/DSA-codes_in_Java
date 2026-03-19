package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_122_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] memo = new int[n + 1][2];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(prices, 0, 0, prices.length, memo);
	}

	private static int solve(int[] prices, int idx, int buy, int length, int[][] memo) {
		if (idx >= length)
			return 0;

		if (memo[idx][buy] != -1)
			return memo[idx][buy];

		int profit = 0;
		if (buy == 0) {
			int take = -prices[idx] + solve(prices, idx + 1, 1, length, memo);
			int not_take = solve(prices, idx + 1, 0, length, memo);
			profit = Math.max(profit, Math.max(not_take, take));
		} else {
			int sell = prices[idx] + solve(prices, idx + 1, 0, length, memo);
			int not_sell = solve(prices, idx + 1, 1, length, memo);
			profit = Math.max(profit, Math.max(sell, not_sell));
		}

		return memo[idx][buy] = profit;
	}
}
