package leetcode.DP_Pract;

public class leetcode_494_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(findTargetSumWays(nums, target));
	}

	public static int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;
		int totalSum = 0;
		for (int num : nums)
			totalSum += num;

		int sumToFind = (totalSum + target) / 2;
		if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0)
			return 0;

//		int[][] dp = new int[n + 1][sumToFind + 1];
//		dp[0][0] = 1;
//
//		for (int i = 1; i <= n; i++) {
//			for (int j = 0; j <= sumToFind; j++) {
//				if (j >= nums[i - 1])
//					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
//				else
//					dp[i][j] = dp[i - 1][j];
//			}
//		}
//
//		return dp[n][sumToFind];
		int[] dp = new int[sumToFind + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int j = sumToFind; j >= num; j--) {
				dp[j] = dp[j] + dp[j - num];
			}
		}

		return dp[sumToFind];
	}
}
