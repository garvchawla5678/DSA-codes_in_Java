package leetcode.One_DP;

public class leetcode_1312_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mbadm";
		System.out.println(minInsertions(s));
	}

	public static int minInsertions(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		int[][] dp = new int[n + 1][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				int j = i + len - 1;
				if (i == j)
					continue;

				if (arr[i] == arr[j])
					dp[i][j] = 0 + dp[i + 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
			}
		}

		return dp[0][n - 1];
	}
}
