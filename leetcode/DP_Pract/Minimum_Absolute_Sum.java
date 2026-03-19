package leetcode.DP_Pract;

public class Minimum_Absolute_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 6, 11, 5 };
		System.out.println(minDifference(nums));
	}

	public static int minDifference(int[] nums) {
		int totalSum = 0;
		for (int num : nums)
			totalSum += num;

		boolean[] dp = new boolean[totalSum + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int j = totalSum; j >= num; j--) {
				dp[j] = dp[j] || dp[j - num];
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i <= totalSum / 2; i++) {
			if (dp[i])
				res = Math.min(res, Math.abs(2 * i - totalSum));
		}

		return res;
	}

}
