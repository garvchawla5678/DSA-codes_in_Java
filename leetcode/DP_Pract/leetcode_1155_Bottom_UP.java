package leetcode.DP_Pract;

public class leetcode_1155_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int k = 6;
		int target = 7;
		System.out.println(numRollsToTarget(n, k, target));
	}

	public static int numRollsToTarget(int n, int k, int target) {
		int[][] dp = new int[n + 1][target + 1];

		dp[0][0] = 1;
		for (int dice = 1; dice <= n; dice++) {
			for (int targ = 1; targ <= target; targ++) {
				int ways = 0;
				for (int face = 0; face <= k; face++) {
					if (targ >= face)
						ways = (ways + dp[dice - 1][targ - face]) % 1_000_000_007;
				}

				dp[dice][targ] = ways;
			}
		}

		return dp[n][target];
	}
}
