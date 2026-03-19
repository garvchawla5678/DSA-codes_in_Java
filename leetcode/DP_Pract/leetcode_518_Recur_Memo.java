package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_518_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 5;
		int[] coins = { 1, 2, 5 };
		System.out.println(change(amount, coins));
	}

	public static int change(int amount, int[] coins) {
		int n = coins.length;
		int[][] memo = new int[n + 1][amount + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(amount, coins, 0, n, memo);
	}

	private static int solve(int amount, int[] coins, int idx, int n, int[][] memo) {
		if (idx >= n) {
			return amount == 0 ? 1 : 0;
		}
		if (memo[idx][amount] != -1)
			return memo[idx][amount];

		int skip = solve(amount, coins, idx + 1, n, memo);
		int take = 0;
		if (amount - coins[idx] >= 0)
			take = solve(amount - coins[idx], coins, idx, n, memo);

		return memo[idx][amount] = skip + take;
	}
}
