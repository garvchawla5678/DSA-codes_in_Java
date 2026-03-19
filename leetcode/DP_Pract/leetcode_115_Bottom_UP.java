package leetcode.DP_Pract;

public class leetcode_115_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct(s, t));
	}

	public static int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
					dp[i][j] += dp[i - 1][j];
				} else {
					dp[i][j] += dp[i - 1][j];
				}
			}
		}

		return dp[m][n];
	}
}
