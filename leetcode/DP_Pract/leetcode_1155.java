package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_1155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int k = 6;
		int target = 7;
		System.out.println(numRollsToTarget(n, k, target));
	}

	public static int numRollsToTarget(int n, int k, int target) {
		int[][] memo = new int[n + 1][target + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(n, k, target, memo);
	}

	private static int solve(int n, int k, int target, int[][] memo) {
		if (n == 0 && target == 0)
			return 1;

		if (n < 0 || target < 0)
			return 0;

		if (memo[n][target] != -1)
			return memo[n][target];

		int ways = 0;
		int mod = 1_000_000_007;

		for (int face = 1; face <= k; face++) {
			ways = (ways + solve(n - 1, k, target - face, memo)) % mod;
		}

		return memo[n][target] = ways;
	}
}
