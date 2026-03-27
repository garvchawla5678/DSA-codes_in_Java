package leetcode.Partition_DP;

import java.util.Arrays;

public class leetcode_1043_Front_Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		System.out.println(maxSumAfterPartitioning(arr, k));
	}

	public static int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);

		return solve(arr, k, 0, n, memo);
	}

	private static int solve(int[] arr, int k, int i, int n, int[] memo) {
		if (i == n)
			return 0;
		if (memo[i] != -1)
			return memo[i];

		int max = Integer.MIN_VALUE;
		int sum = Integer.MIN_VALUE;
		for (int j = i; j < Math.min(n, i + k); j++) {
			max = Math.max(max, arr[j]);
			int len = j - i + 1;
			sum = Math.max(sum, max * len + solve(arr, k, j + 1, n, memo));
		}

		return memo[i] = sum;
	}
}
