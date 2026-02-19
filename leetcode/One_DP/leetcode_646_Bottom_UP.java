package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_646_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pairs = { { 1, 2 }, { 7, 8 }, { 3, 4 } };
		System.out.println(findLongestChain(pairs));
	}

	public static int findLongestChain(int[][] pairs) {
		int n = pairs.length;

		Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[j][1] < pairs[i][0]) {
					dp[i] = (int) Math.max(dp[i], dp[j] + 1);
					max = (int) Math.max(max, dp[i]);
				}
			}
		}

		return max;
	}
}
