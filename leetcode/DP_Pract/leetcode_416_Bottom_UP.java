package leetcode.DP_Pract;

public class leetcode_416_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 5, 11, 5 };
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int num : nums)
			totalSum += num;

		if (totalSum % 2 != 0)
			return false;

		int sumToFind = totalSum / 2;
		// int n = nums.length;

//		boolean[][] dp = new boolean[n + 1][sumToFind + 1];
//		for (int i = 0; i <= n; i++)
//			dp[i][0] = true;
//
		//// for (int i = 0; i <= sumToFind; i++) dp[0][i] = false;
//
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= sumToFind; j++) {
//				boolean skip = dp[i - 1][j];
//
//				boolean take = false;
//				if (nums[i - 1] <= j)
//					take = dp[i - 1][j - nums[i - 1]];
//
//				dp[i][j] = skip || take;
//			}
//		}
//
//		return dp[n][sumToFind];

		boolean[] dp = new boolean[sumToFind + 1];
		dp[0] = true;

		for (int num : nums) {
			for (int j = sumToFind; j >= num; j--) {
				dp[j] = dp[j] || dp[j - num];
			}
		}

		return dp[sumToFind];
	}

}
