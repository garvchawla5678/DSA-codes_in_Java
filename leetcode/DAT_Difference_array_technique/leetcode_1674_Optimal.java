package leetcode.DAT_Difference_array_technique;

import java.util.Arrays;

public class leetcode_1674_Optimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2, 1 };
		int limit = 2;
		System.out.println(minMoves(nums, limit));
	}

	public static int minMoves(int[] nums, int limit) {
		int[] diff = new int[2 * limit + 2];
		int n = nums.length;

		for (int i = 0; i < n / 2; i++) {
			int a = nums[i];
			int b = nums[n - 1 - i];

			diff[2] += 2;
			diff[2 * limit + 1] -= 2;

			int minVal = Math.min(a, b) + 1;
			int maxVal = Math.max(a, b) + limit;

			diff[minVal] += -1;
			diff[maxVal + 1] -= (-1);

			diff[a + b] += -1;
			diff[a + b + 1] -= -1;
		}

		int result = diff[2];
		System.out.println(Arrays.toString(diff));
		for (int i = 3; i < 2 * limit + 1; i++) {
			diff[i] += diff[i - 1];
			result = Math.min(result, diff[i]);
		}
		System.out.println(Arrays.toString(diff));

		return result;
	}
}
