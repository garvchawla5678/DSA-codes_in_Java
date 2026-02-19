package leetcode.One_DP;

public class leetcode_300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 1;

		int[][] memo = new int[n][n + 1];
		return solve(nums, 0, n, -1, memo);
	}

	private static int solve(int[] nums, int i, int n, int prevIdx, int[][] memo) {
		if (i >= n) {
			return 0;
		}
		if (memo[i][prevIdx + 1] != 0)
			return memo[i][prevIdx + 1];

		int skip = solve(nums, i + 1, n, prevIdx, memo);

		int take = 0;
		if (prevIdx == -1 || nums[i] > nums[prevIdx])
			take = 1 + solve(nums, i + 1, n, i, memo);

		return memo[i][prevIdx + 1] = (int) Math.max(take, skip);
	}
}
