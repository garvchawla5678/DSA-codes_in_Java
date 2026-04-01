package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_45_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 0, 1, 4 };
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;

		int[] dp = new int[n];
		Arrays.fill(dp, 1_000_000_007);
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i)
					dp[i] = Math.min(dp[i], 1 + dp[j]);
			}
		}

		System.out.println(Arrays.toString(dp));
		return dp[n - 1];
	}
}
