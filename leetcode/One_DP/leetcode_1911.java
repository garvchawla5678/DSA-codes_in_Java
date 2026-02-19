package leetcode.One_DP;

public class leetcode_1911 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 6, 2, 1, 2, 4, 5 };
		System.out.println(maxAlternatingSum(nums));
	}

	public static long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		long[][] memo = new long[n + 1][2];
		return solve(nums, 0, n, 0, memo);
	}

	private static long solve(int[] nums, int i, int n, int nextOddorEven, long[][] memo) {
		if (i >= n) {
			return 0;
		}

		if (memo[i][nextOddorEven] != 0)
			return memo[i][nextOddorEven];

		// if we are skiping the nums[i]
		long skip = solve(nums, i + 1, n, nextOddorEven, memo);

		// if we are taking it
		long take = 0;
		if (nextOddorEven == 0) {
			take = nums[i] + solve(nums, i + 1, n, 1, memo);
		} else {
			take = solve(nums, i + 1, n, 0, memo) - nums[i];
		}

		return memo[i][nextOddorEven] = (long) Math.max(skip, take);
	}
}
