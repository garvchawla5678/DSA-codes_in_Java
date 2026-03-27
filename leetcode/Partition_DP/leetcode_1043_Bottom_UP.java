package leetcode.Partition_DP;

public class leetcode_1043_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		System.out.println(maxSumAfterPartitioning(arr, k));
	}

	public static int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int max = 0;

			for (int j = i - 1; j >= Math.max(0, i - k); j--) {
				max = Math.max(max, arr[j]);
				int len = i - j;

				dp[i] = Math.max(dp[i], dp[j] + max * len);
			}
		}

		return dp[n];
	}
}
