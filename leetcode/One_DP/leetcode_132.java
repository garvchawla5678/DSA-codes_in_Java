package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_132 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		System.out.println(minCut(s));
	}

	// it will give TLE
	public static int minCut(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		boolean[][] dp = new boolean[n + 1][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				int j = i + len - 1;

				if (i == j)
					dp[i][j] = true;
				else if (i + 1 == j)
					dp[i][j] = (arr[i] == arr[j]);
				else {
					if (arr[i] == arr[j] && dp[i + 1][j - 1])
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
			}
		}

		return solve(arr, 0, n - 1, memo, dp);
	}

	private static int solve(char[] arr, int i, int j, int[][] memo, boolean[][] dp) {
		if (i >= j)
			return 0;

		if (memo[i][j] != -1)
			return memo[i][j];

		if (dp[i][j])
			return memo[i][j] = 0;

		int res = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int tmp = 1 + solve(arr, i, k, memo, dp) + solve(arr, k + 1, j, memo, dp);
			res = Math.min(res, tmp);
		}

		return memo[i][j] = res;
	}
}
