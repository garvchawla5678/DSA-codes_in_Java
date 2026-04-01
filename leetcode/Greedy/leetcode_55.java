package leetcode.Greedy;

public class leetcode_55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return true;
		int maxReachabale = 0;
		for (int i = 0; i < n; i++) {
			if (i > maxReachabale)
				return false;

			maxReachabale = Math.max(maxReachabale, i + nums[i]);
		}

		return true;
	}
}
