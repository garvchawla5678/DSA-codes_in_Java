package leetcode.DP_Pract;

public class leetcode_55_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return true;
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 0; i < n; i++) {
			if (!dp[i])
				continue;

			for (int jump = 1; jump <= nums[i]; jump++) {
				if (i + jump < n)
					dp[i + jump] = true;
			}
			if (dp[n - 1])
				return true;
		}

		return dp[n - 1];
	}
}
