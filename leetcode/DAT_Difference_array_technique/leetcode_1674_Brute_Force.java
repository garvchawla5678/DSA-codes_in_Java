package leetcode.DAT_Difference_array_technique;

public class leetcode_1674_Brute_Force {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2, 1 };
		int limit = 2;
		System.out.println(minMoves(nums, limit));
	}

	public static int minMoves(int[] nums, int limit) {
		int result = Integer.MAX_VALUE;
		int n = nums.length;

		for (int sum = 2; sum <= 2 * limit; sum++) {
			int moves = 0;

			for (int i = 0; i < n / 2; i++) {
				int a = nums[i];
				int b = nums[n - 1 - i];

				if (a + b == sum)
					continue;

				int minVal = Math.min(a, b) + 1;
				int maxVal = Math.max(a, b) + limit;

				if (minVal <= sum && sum <= maxVal) {
					moves += 1;
				} else {
					moves += 2;
				}
			}
			result = Math.min(result, moves);
		}

		return result;
	}
}
