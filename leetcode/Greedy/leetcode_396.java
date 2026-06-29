package leetcode.Greedy;

public class leetcode_396 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 3, 2, 6 };
		System.out.println(maxRotateFunction(nums));
	}

	public static int maxRotateFunction(int[] nums) {
		int sum = 0;
		int F = 0;
		int n = nums.length;
		if (n == 1)
			return 0;

		int result = F;

		for (int i = 0; i < n; i++) {
			sum += nums[i];
			F += i * nums[i];
		}

		for (int k = 0; k <= n - 1; k++) {
			int new_F = F + sum - n * nums[n - 1 - k];
			result = Math.max(result, new_F);
			F = new_F;
		}

		return result;
	}
}
