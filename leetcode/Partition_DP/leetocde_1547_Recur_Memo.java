package leetcode.Partition_DP;

import java.util.Arrays;

public class leetocde_1547_Recur_Memo {

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

		int[][] memo = new int[len + 1][len + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(arr, 0, len - 1, memo);
	}

	private static int solve(int[] arr, int l, int r, int[][] memo) {
		if (r - l < 2)
			return 0;
		if (memo[l][r] != -1)
			return memo[l][r];

		int cost = Integer.MAX_VALUE;
		for (int k = l + 1; k <= r - 1; k++) {
			int temp = (arr[r] - arr[l]) + solve(arr, l, k, memo) + solve(arr, k, r, memo);
			cost = Math.min(cost, temp);
		}

		return memo[l][r] = cost;
	}
}
