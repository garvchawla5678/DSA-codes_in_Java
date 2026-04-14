package leetcode.Greedy;

public class leetcode_2366 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 7, 5, 6, 9 };
		System.out.println(minimumReplacement(nums));
	}

	public static long minimumReplacement(int[] nums) {
		int n = nums.length;

		long operations = 0;

		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] <= nums[i + 1])
				continue;

			long parts = nums[i] / nums[i + 1];
			if (nums[i] % nums[i + 1] != 0)
				parts++;

			operations += parts - 1;
			nums[i] = nums[i] / (int) parts;
		}

		return operations;
	}
}
