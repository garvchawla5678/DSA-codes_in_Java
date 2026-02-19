package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_300_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 1;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int maxLIS = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = (int) Math.max(dp[i], dp[j] + 1);
					maxLIS = (int) Math.max(maxLIS, dp[i]);
				}
			}
		}

		return maxLIS;
	}
}
