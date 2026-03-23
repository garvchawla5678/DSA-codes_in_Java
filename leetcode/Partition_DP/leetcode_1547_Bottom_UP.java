package leetcode.Partition_DP;

import java.util.Arrays;

public class leetcode_1547_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] cuts = { 1, 3, 4, 5 };
		System.out.println(minCost(n, cuts));
	}

	public static int minCost(int n, int[] cuts) {
		Arrays.sort(cuts);
		int[] arr = new int[cuts.length + 2];
		int len = arr.length;
		arr[0] = 0;
		arr[len - 1] = n;
		for (int i = 1; i < len - 1; i++)
			arr[i] = cuts[i - 1];

		int[][] dp = new int[len + 1][len + 1];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				for (int k = i + 1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
							(arr[j] - arr[i]) + dp[i][k] + dp[k][j]);
				}
			}
		}

		return dp[0][len - 1];
	}
}
