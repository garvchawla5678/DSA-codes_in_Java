package leetcode.One_DP;

public class Longest_Common_Subsequence_1143_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(longestCommonSubsequence(text1, text2));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuilder lcs = new StringBuilder();
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
				lcs.append(text1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1])
					i--;
				else
					j--;
			}
		}

		System.out.println(lcs.reverse().toString());
		return dp[m][n];
	}
}
