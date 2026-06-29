package leetcode.DP_Pract;

import java.util.Arrays;

public class Number_Of_ZigZag_Arrays {

	static final int MOD = 1_000_000_007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3, l = 1, r = 3;
		System.out.println(zigZagArrays(n, l, r));
	}

	public static int zigZagArrays(int n, int l, int r) {
		int m = r - l + 1;
		int[] dp = new int[m];
		Arrays.fill(dp, 1);

		for (int i = 2; i <= n; i++) {
			int sum = 0;
			if ((i & 1) == 0)
				for (int j = 0; j < m; j++) {
					int t = dp[j];
					dp[j] = sum;
					sum = (sum + t) % MOD;
				}
			else
				for (int j = m - 1; j >= 0; j--) {
					int t = dp[j];
					dp[j] = sum;
					sum = (sum + t) % MOD;
				}
		}

		int res = 0;
		for (int j = 0; j < m; j++)
			res = (res + dp[j]) % MOD;

		return (res << 1) % MOD;
	}
}
