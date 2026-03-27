package leetcode.One_DP;

public class leetcode_132_Front_Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		System.out.println(minCut(s));
	}

	public static int minCut(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
//		int[] memo = new int[n + 1];
//		Arrays.fill(memo, -1);

		boolean[][] dp = new boolean[n + 1][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				int j = i + len - 1;

				if (i == j)
					dp[i][j] = true;
				else if (i + 1 == j)
					dp[i][j] = (arr[i] == arr[j]);
				else {
					if (arr[i] == arr[j] && dp[i + 1][j - 1])
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
			}
		}

		int[] dp1 = new int[n + 1];

		for (int i = n - 1; i >= 0; i--) {
			int minCost = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
				int cost = 0;
				if (dp[i][j]) {
					cost = 1 + dp1[j + 1];
					minCost = Math.min(minCost, cost);
				}
			}
			dp1[i] = minCost;
		}

		return dp1[0] - 1;
	}

//	private static int solve(char[] arr, int i, int[] memo, boolean[][] dp, int n) {
//		if (i == n)
//			return 0;
//		if (memo[i] != -1)
//			return memo[i];
//
//		int minCost = Integer.MAX_VALUE;
//		for (int j = i; j < n; j++) {
//			if (dp[i][j]) {
//				int cost = 1 + solve(arr, j + 1, memo, dp, n);
//				minCost = Math.min(minCost, cost);
//			}
//		}
//
//		return memo[i] = minCost;
//	}
}
