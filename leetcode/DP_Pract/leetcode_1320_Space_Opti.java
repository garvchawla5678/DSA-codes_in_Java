package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_1320_Space_Opti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "HAPPY";
		System.out.println(minimumDistance(word));
	}

	public static int minimumDistance(String word) {
		char[] wrd = word.toCharArray();
		int n = wrd.length;
		int[][] dp = new int[n + 1][27];
		for (int[] row : dp)
			Arrays.fill(row, 1_000_000_007);

		Arrays.fill(dp[0], 0);
		int prev = wrd[0] - 'A';

		for (int i = 1; i < n; i++) {
			int curr = wrd[i] - 'A';

			for (int fing = 0; fing < 27; fing++) {
				if (dp[i - 1][fing] >= 1_000_000_007)
					continue;

				dp[i][fing] = Math.min(dp[i][fing], dist(curr, prev) + dp[i - 1][fing]);
				dp[i][prev] = Math.min(dp[i][prev], dist(curr, fing) + dp[i - 1][prev]);
			}
			prev = curr;
		}
		for (int[] row : dp)
			System.out.println(Arrays.toString(row));

		return dp[0][26];

	}

	private static int dist(int a, int b) {
		if (a == 26 || b == 26)
			return 0;

		int r1 = a / 6, c1 = a % 6;
		int r2 = b / 6, c2 = b % 6;

		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
