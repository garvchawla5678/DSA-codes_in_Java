package leetcode.HashMap;

import java.util.HashMap;

public class leetcode_128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(nums));
	}

	public static int longestConsecutive(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - 1)) {
				map.put(nums[i], false);
			} else {
				map.put(nums[i], true);
			}
			if (map.containsKey(nums[i] + 1)) {
				map.put(nums[i] + 1, false);
			}
		}
		int ans = 0;
		int count;
		for (int i : map.keySet()) {
			if (map.get(i)) {
				count = 1;
				while (map.containsKey(i + 1)) {
					count++;
					i++;
				}
				ans = Math.max(ans, count);
			}
		}
		return ans;
	}
}
