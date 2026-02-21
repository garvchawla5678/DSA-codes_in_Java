package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_516_Without_Using_LCS_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbab";
		System.out.println(longestPalindromeSubseq(s));
	}

	public static int longestPalindromeSubseq(String s) {
		char[] s1 = s.toCharArray();
		int n = s.length();
		int[][] dp = new int[n + 1][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				int j = i + len - 1;

				if (i == j)
					dp[i][j] = 1;
				else {
					if (s1[i] == s1[j])
						dp[i][j] = 2 + dp[i + 1][j - 1];
					else
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}

		for (int[] arr : dp)
			System.out.println(Arrays.toString(arr));
		return dp[0][n - 1];
	}
}
