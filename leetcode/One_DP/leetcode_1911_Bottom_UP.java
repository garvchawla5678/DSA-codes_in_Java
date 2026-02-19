package leetcode.One_DP;

public class leetcode_1911_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 374, 126, 84, 237, 195, 139, 328, 353, 286, 113, 351, 167, 394, 398, 29, 118, 17, 162, 206, 138,
				34, 109, 291, 368, 162, 109, 336, 256, 203, 330, 235, 74, 136, 72, 127, 382, 288, 276, 135, 383, 300,
				220, 299, 205, 186, 113, 71, 261, 253, 47, 387, 25, 57, 79, 322, 82, 349, 217, 306, 33, 198, 196, 306,
				240, 271, 129, 284, 6, 349, 370, 59, 350, 275, 385, 137, 394, 329, 175, 58, 151, 223, 81, 233, 2, 370,
				369, 135, 257, 391, 92, 260, 55, 321, 153, 328, 260, 312, 102, 79, 192 };
		System.out.println(maxAlternatingSum(nums));
	}

//	public static long maxAlternatingSum(int[] nums) {
//		int n = nums.length;
//		if (n == 1)
//			return nums[0];
//
//		long[][] dp = new long[n + 1][2];
//		for (int i = 1; i <= n; i++) {
//			// even 0 -> even
//			dp[i][0] = (long) Math.max(dp[i - 1][1] - nums[i - 1], dp[i - 1][0]);
//
//			// odd 1 -> odd
//			dp[i][1] = (long) Math.max(dp[i - 1][0] + nums[i - 1], dp[i - 1][1]);
//		}
//
//		return (long) Math.max(dp[n][0], dp[n][1]);
//	}

	// O(1) space
	public static long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		long even = nums[0];
		long odd = 0;
		for (int i = 1; i < n; i++) {
			// even 0 -> even
			long newEven = (long) Math.max(odd + nums[i], even);

			// odd 1 -> odd
			odd = (long) Math.max(even - nums[i], odd);
			even = newEven;
		}

		return (long) Math.max(even, odd);
	}
}
