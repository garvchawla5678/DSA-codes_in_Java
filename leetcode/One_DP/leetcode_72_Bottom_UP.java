package leetcode.One_DP;

public class leetcode_72_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(minDistance(word1, word2));
	}

	public static int minDistance(String word1, String word2) {
		char[] wrd1 = word1.toCharArray();
		char[] wrd2 = word2.toCharArray();
		int m = wrd1.length;
		int n = wrd2.length;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++)
			dp[i][0] = i;

		for (int i = 1; i <= n; i++)
			dp[0][i] = i;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (wrd1[i - 1] != wrd2[j - 1]) {
					int insert = dp[i][j - 1];
					int delete = dp[i - 1][j];
					int replace = dp[i - 1][j - 1];

					dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
				} else {
					dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}

		return dp[m][n];
	}
}
