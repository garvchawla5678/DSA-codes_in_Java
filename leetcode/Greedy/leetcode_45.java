package leetcode.Greedy;

public class leetcode_45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;

		int jumps = 0, l = 0, r = 0;
		while (r < n - 1) {
			int farthest = 0;
			for (int j = l; j <= r; j++) {
				farthest = Math.max(farthest, j + nums[j]);
			}

			l = r + 1;
			r = farthest;
			jumps++;

		}
		return jumps;
	}
}
