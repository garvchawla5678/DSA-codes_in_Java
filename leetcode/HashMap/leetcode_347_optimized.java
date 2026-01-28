package leetcode.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_347_optimized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		leetcode_347 cl = new leetcode_347();
		System.out.println(Arrays.toString(cl.topKFrequent(nums, k)));
	}

	public int[] topKFrequent(int[] nums, int k) {
		int n = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Integer>[] bucket = new ArrayList[n + 1];
		for (int key : map.keySet()) {
			int frq = map.get(key);
			if (bucket[frq] == null)
				bucket[frq] = new ArrayList<>();
			bucket[frq].add(key);
		}

		int[] ans = new int[k];
		int j = 0;
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] == null)
				continue;
			for (int key : bucket[i]) {
				ans[j] = key;
				j++;
				if (j == k)
					return ans;
			}
		}
		return ans;
	}
}
