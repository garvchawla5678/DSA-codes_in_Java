package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_309_Recur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 1)
			return 0;
		int[][] memo = new int[n + 1][2];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(prices, 0, 0, n, memo);
	}

	private static int solve(int[] prices, int day, int buy, int length, int[][] memo) {
		if (day >= length)
			return 0;

		if (memo[day][buy] != -1)
			return memo[day][buy];

		int profit = 0;
		if (buy == 0) {
			int take = solve(prices, day + 1, 1, length, memo) - prices[day];
			int not_take = solve(prices, day + 1, 0, length, memo);
			profit = Math.max(profit, Math.max(take, not_take));
		} else {
			int sell = prices[day] + solve(prices, day + 2, 0, length, memo);
			int not_sell = solve(prices, day + 1, 1, length, memo);
			profit = Math.max(profit, Math.max(sell, not_sell));
		}

		return memo[day][buy] = profit;
	}
}
