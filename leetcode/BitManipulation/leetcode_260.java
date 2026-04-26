package leetcode.BitManipulation;

import java.util.Arrays;

public class leetcode_260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		System.out.println(Arrays.toString(singleNumber(nums)));
	}

	public static int[] singleNumber(int[] nums) {
		int total_xor = 0;
		for (int num : nums) {
			total_xor ^= num;
		}

		int mask = total_xor & (-total_xor);
		int groupA = 0;
		int groupB = 0;

		for (int num : nums) {
			if ((num & mask) == 0)
				groupA ^= num;
			else
				groupB ^= num;
		}

		return new int[] { groupA, groupB };
	}
}
