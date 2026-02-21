package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_516_Without_Using_LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbab";
		System.out.println(longestPalindromeSubseq(s));
	}

	public static int longestPalindromeSubseq(String s) {
		char[] s1 = s.toCharArray();
		int n = s.length();
		int[][] memo = new int[n][n];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(s1, 0, n - 1, memo);

	}

	private static int solve(char[] s1, int i, int j, int[][] memo) {
		if (i > j)
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		if (s1[i] == s1[j]) {
			if (i != j)
				return memo[i][j] = 2 + solve(s1, i + 1, j - 1, memo);
			else
				return memo[i][j] = 1 + solve(s1, i + 1, j - 1, memo);
		} else {
			return memo[i][j] = Math.max(solve(s1, i + 1, j, memo), solve(s1, i, j - 1, memo));
		}
	}
}
