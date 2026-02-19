package leetcode.One_DP;

public class leetcode_322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 1, 2, 5 };
		int amount = 100;
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;

		int[] memo = new int[amount + 1];
		int ans = solve(coins, amount, memo);
		return ans == 1_000_000_007 ? -1 : ans;
	}

	private static int solve(int[] coins, int amount, int[] memo) {
		if (amount <= 0) {
			return amount == 0 ? 0 : -1;
		}
		if (memo[amount] != 0)
			return memo[amount];

		int minCost = 1_000_000_007;
		for (int coin : coins) {
			int res = solve(coins, amount - coin, memo);
			if (res >= 0) {
				minCost = Math.min(minCost, 1 + res);
			}
		}

		return memo[amount] = minCost;
	}
}
