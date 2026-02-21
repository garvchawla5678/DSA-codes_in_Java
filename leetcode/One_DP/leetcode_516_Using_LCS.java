package leetcode.One_DP;

public class leetcode_516_Using_LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbab";
		System.out.println(longestPalindromeSubseq(s));
	}

	public static int longestPalindromeSubseq(String s) {
		StringBuilder ss = new StringBuilder(s);
		String s2 = ss.reverse().toString();
		char[] ss1 = s.toCharArray();
		char[] ss2 = s2.toCharArray();
		int n = s.length();

		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (ss1[i - 1] == ss2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n][n];

	}

//	private static int solve(String s1, String s2, int i, int j, int[][] memo) {
//		if (i < 0 || j < 0)
//			return 0;
//
//		if (memo[i][j] != -1)
//			return memo[i][j];
//
//		if (s1.charAt(i) == s2.charAt(j)) {
//			return memo[i][j] = 1 + solve(s1, s2, i - 1, j - 1, memo);
//		} else {
//			return memo[i][j] = Math.max(solve(s1, s2, i - 1, j, memo), solve(s1, s2, i, j - 1, memo));
//		}
//
//	}
}
