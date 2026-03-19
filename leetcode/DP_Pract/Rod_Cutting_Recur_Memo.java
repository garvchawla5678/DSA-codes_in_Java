package leetcode.DP_Pract;

import java.util.Arrays;

public class Rod_Cutting_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(cutRod(prices));
	}

	public static int cutRod(int[] price) {
		int n = price.length;
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(price, 0, 1, memo);
	}

	private static int solve(int[] price, int length, int idx, int[][] memo) {
		if (length == price.length || idx > price.length) {
			return 0;
		}
		if (memo[idx][length] != -1)
			return memo[idx][length];

		int skip = solve(price, length, idx + 1, memo);
		int take = Integer.MIN_VALUE;
		if (length + idx <= price.length)
			take = price[idx - 1] + solve(price, length + idx, idx, memo);

		return memo[idx][length] = Math.max(skip, take);
	}
}
