package leetcode.DP_Pract;

public class leetcode_97_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1, s2, s3));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		int N = s3.length();
		if (m + n != N)
			return false;

//		boolean[][] dp = new boolean[m + 1][n + 1];
//		dp[0][0] = true;
//		for (int i = 1; i <= m; i++) {
//			dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
//		}
//
//		for (int j = 1; j <= n; j++) {
//			dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
//		}
//
//		for (int i = 1; i <= m; i++) {
//			for (int j = 1; j <= n; j++) {
//				if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
//					dp[i][j] = dp[i][j] || true;
//				if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
//					dp[i][j] = dp[i][j] || true;
//			}
//		}
//
//		return dp[m][n];

		// Space Optimized:
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
		}

		for (int i = 1; i <= m; i++) {
			dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);

			for (int j = 1; j <= n; j++) {
				boolean fromS1 = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j];
				boolean fromS2 = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1];
				dp[i] = fromS1 || fromS2;
			}
		}

		return dp[n];
	}
}
