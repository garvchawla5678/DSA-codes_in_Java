package leetcode.One_DP;

public class leetcode_2926_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, -1, -3, 8 };
		System.out.println(maxBalancedSubsequenceSum(nums));
	}

	// It will also give TLE
	public static long maxBalancedSubsequenceSum(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = (int) Math.max(max, nums[i]);
		}

		if (max <= 0)
			return max;

		long ans = 0;
		long[] dp = new long[n];
		for (int i = 0; i < n; i++) {
			dp[i] = nums[i];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] - i >= nums[j] - j) {
					dp[i] = (long) Math.max(dp[i], dp[j] + nums[i]);
					ans = (long) Math.max(ans, dp[i]);
				}
			}
		}

		return ans > max ? ans : max;
	}
}
