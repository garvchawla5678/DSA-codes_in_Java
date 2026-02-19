package leetcode.One_DP;

import java.util.ArrayList;
import java.util.List;

public class leetcode_300_Patience_Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 1;

		List<Integer> res = new ArrayList<>();
		for (int num : nums) {
			if (res.isEmpty() || res.getLast() < num) {
				res.add(num);
			} else {
				int idx = binarySearch(res, num);
				res.set(idx, num);
			}
		}

		return res.size();
	}

	private static int binarySearch(List<Integer> res, int num) {
		int l = 0;
		int r = res.size() - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (res.get(mid) == num) {
				return mid;
			} else if (res.get(mid) > num) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return l;
	}

}
