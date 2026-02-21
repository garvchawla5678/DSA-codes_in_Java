package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_132_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		System.out.println(minCut(s));
	}

	public static int minCut(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);

		boolean[][] isPalin = new boolean[n + 1][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				int j = i + len - 1;

				if (i == j)
					isPalin[i][j] = true;
				else if (i + 1 == j)
					isPalin[i][j] = (arr[i] == arr[j]);
				else {
					if (arr[i] == arr[j] && isPalin[i + 1][j - 1])
						isPalin[i][j] = true;
					else
						isPalin[i][j] = false;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (isPalin[0][i])
				dp[i] = 0;
			else {
				for (int k = 0; k < i; k++) {
					if (isPalin[k + 1][i] && 1 + dp[k] < dp[i])
						dp[i] = 1 + dp[k];
				}
			}
		}

		return dp[n - 1];
	}
}
