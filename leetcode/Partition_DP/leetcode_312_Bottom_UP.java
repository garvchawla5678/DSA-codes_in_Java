package leetcode.Partition_DP;

public class leetcode_312_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 5, 8 };
		System.out.println(maxCoins(nums));
	}

	public static int maxCoins(int[] nums) {
		int[] arr = new int[nums.length + 2];
		int n = arr.length;
		arr[0] = 1;
		arr[n - 1] = 1;
		for (int i = 1; i < n - 1; i++)
			arr[i] = nums[i - 1];

		int[][] dp = new int[n + 1][n + 1];
		for (int i = n - 2; i >= 1; i--) {
			for (int j = i; j < n - 1; j++) {
				int maxi = Integer.MIN_VALUE;
				for (int k = i; k <= j; k++) {
					int cost = arr[i - 1] * arr[k] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j];
					maxi = Math.max(maxi, cost);
				}
				dp[i][j] = maxi;
			}
		}

		return dp[1][n - 2];
	}
}
