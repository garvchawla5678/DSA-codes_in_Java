package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_55_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		int n = nums.length;
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);

		return solve(nums, 0, n - 1, memo);
	}

	private static boolean solve(int[] nums, int i, int end, int[] memo) {
		if (i == end)
			return true;
		if (i > end)
			return false;
		if (nums[i] == 0)
			return false;

		if (memo[i] != -1)
			return memo[i] == 1 ? true : false;

		boolean ans = false;
		for (int jump = 1; jump <= nums[i]; jump++) {
			ans = ans || solve(nums, i + jump, end, memo);
		}

		memo[i] = (ans == true) ? 1 : 0;
		return ans;
	}
}
