package leetcode.One_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_368_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		System.out.println(largestDivisibleSubset(nums));
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;

		int[] dp = new int[n];
		int[] prevIdx = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(prevIdx, -1);
		int maxIdx = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						prevIdx[i] = j;
					}
				}
			}
			if (dp[maxIdx] < dp[i])
				maxIdx = i;
		}

		while (maxIdx != -1) {
			ans.add(nums[maxIdx]);
			maxIdx = prevIdx[maxIdx];
		}

		return ans;
	}
}
