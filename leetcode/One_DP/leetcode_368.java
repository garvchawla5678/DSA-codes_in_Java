package leetcode.One_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_368 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		System.out.println(largestDivisibleSubset(nums));
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		List<Integer> ans = new ArrayList<>();

		solve(nums, 0, -1, new ArrayList<>(), ans);
		return ans;
	}

	private static void solve(int[] nums, int idx, int prevIdx, List<Integer> temp, List<Integer> ans) {
		if (idx >= nums.length) {
			if (temp.size() > ans.size()) {
				ans.clear();
				ans.addAll(temp);
			}

			return;
		}

		solve(nums, idx + 1, prevIdx, temp, ans);

		if (prevIdx == -1 || (nums[idx] % nums[prevIdx]) == 0) {
			temp.add(nums[idx]);
			solve(nums, idx + 1, idx, temp, ans);
			temp.removeLast();
		}
	}
}
