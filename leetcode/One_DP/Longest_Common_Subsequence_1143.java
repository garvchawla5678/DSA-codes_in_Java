package leetcode.One_DP;

import java.util.Arrays;

public class Longest_Common_Subsequence_1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(longestCommonSubsequence(text1, text2));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(text1, text2, 0, 0, memo);
	}

	private static int solve(String text1, String text2, int i, int j, int[][] memo) {
		if (i >= text1.length() || j >= text2.length())
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		if (text1.charAt(i) == text2.charAt(j))
			return memo[i][j] = 1 + solve(text1, text2, i + 1, j + 1, memo);
		else
			return memo[i][j] = Math.max(solve(text1, text2, i + 1, j, memo), solve(text1, text2, i, j + 1, memo));
	}
}
