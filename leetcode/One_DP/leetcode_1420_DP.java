package leetcode.One_DP;

public class leetcode_1420_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int m = 3;
		int k = 1;
		System.out.println(numOfArrays(n, m, k));
	}

	public static int numOfArrays(int n, int m, int k) {
		long[][][] dp = new long[n + 1][m + 1][k + 1];
		int mod = 1_000_000_007;

		for (int i = 1; i <= m; i++) {
			dp[1][i][1] = 1;
		}

		for (int len = 1; len < n; len++) {
			for (int cost = 1; cost <= k; cost++) {

				long[] prefix = new long[m + 2];
				for (int prevMax = 1; prevMax <= m; prevMax++) {
					prefix[prevMax] = (prefix[prevMax - 1] + dp[len][prevMax][cost]) % mod;
				}

				for (int currMax = 1; currMax <= m; currMax++) {
					// case 1 -> when adding new no. still currMax < prevMax
					long noNewCost = dp[len][currMax][cost] * currMax;

					dp[len + 1][currMax][cost] = (dp[len + 1][currMax][cost] + noNewCost) % mod;

					// case 2 -> when adding new no. currMax > prevMax
					if (cost < k) {
						long newCost = prefix[currMax - 1];

						dp[len + 1][currMax][cost + 1] = (dp[len + 1][currMax][cost + 1] + newCost) % mod;
					}

				}
			}
		}

		long ans = 0;
		for (int max = 1; max <= m; max++) {
			ans += dp[n][max][k];
			ans %= mod;
		}

		return (int) ans;
	}
}
