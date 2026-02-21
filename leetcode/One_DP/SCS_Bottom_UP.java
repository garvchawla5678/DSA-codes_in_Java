package leetcode.One_DP;

public class SCS_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "geek";
		String str2 = "eke";
		System.out.println(minSuperSeq(str1, str2));
	}

	public static int minSuperSeq(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = i + j;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int i = m;
		int j = n;
		StringBuilder ans = new StringBuilder();
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				ans.append(s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] < dp[i][j - 1]) {
					ans.append(s1.charAt(i - 1));
					i--;
				} else {
					ans.append(s2.charAt(j - 1));
					j--;
				}
			}
		}

		while (i-- > 0)
			ans.append(s1.charAt(i));
		while (j-- > 0)
			ans.append(s2.charAt(j));

		System.out.println(ans.reverse().toString());
		return dp[m][n];
	}
}
