package leetcode.DP_Pract;

public class Rod_Cutting_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(cutRod(prices));
	}

	public static int cutRod(int[] price) {
		int n = price.length;
//		int[][] dp = new int[n + 1][n + 1];
//
//		for (int i = 1; i <= n; i++) {
//			for (int len = 1; len <= n; len++) {
//				int skip = dp[i - 1][len];
//
//				int take = Integer.MIN_VALUE;
//				if (len - i >= 0)
//					take = price[i - 1] + dp[i][len - i];
//
//				dp[i][len] = Math.max(skip, take);
//			}
//		}
//
//		return dp[n][n];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int len = 1; len <= n; len++) {
				int skip = dp[len];

				int take = Integer.MIN_VALUE;
				if (len - i >= 0)
					take = price[i - 1] + dp[len - i];

				dp[len] = Math.max(skip, take);
			}
		}

		return dp[n];
	}
}
