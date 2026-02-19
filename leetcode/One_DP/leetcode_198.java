package leetcode.One_DP;

public class leetcode_198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 7, 9, 3, 1 };
		System.out.println(rob(nums));
	}

	// top to bottom approach
//	public static int rob(int[] nums) {
//		int[] memo = new int[101];
//		Arrays.fill(memo, -1);
//		return solve(nums, 0, nums.length, memo);
//	}
//
//	static int solve(int[] nums, int i, int n, int[] memo) {
//		if (i >= n)
//			return 0;
//
//		if (memo[i] != -1)
//			return memo[i];
//
//		int steal = nums[i] + solve(nums, i + 2, n, memo);
//		int skip = solve(nums, i + 1, n, memo);
//
//		return memo[i] = (int) Math.max(steal, skip);
//	}

	// bottom-up approach
	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		int[] dp = new int[n + 1]; // it represents the max money till ith house
		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 2; i <= n; i++) {
			int steal = nums[i - 1] + dp[i - 2];
			int skip = dp[i - 1];
			dp[i] = (int) Math.max(steal, skip);
		}

		return dp[n];
	}

	// constant space approach
//	public static int rob(int[] nums) {
//		int n = nums.length;
//		if (n == 1)
//			return nums[0];
//
//		int prevprev = 0;
//        int prev = nums[0];
//
//		for (int i = 2; i <= n; i++) {
//			int steal = nums[i - 1] + prevprev;
//			int skip = prev;
//			int temp = (int) Math.max(steal, skip);
//            prevprev = prev;
//            prev = temp;
//		}
//
//		return prev;
//	}
}
