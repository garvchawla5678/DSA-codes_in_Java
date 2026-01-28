package leetcode.HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode_347 {
	class Pair {
		int key;
		int frequency;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		leetcode_347 cl = new leetcode_347();
		System.out.println(Arrays.toString(cl.topKFrequent(nums, k)));
	}

	// T.C : 0(NLOG(N))
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Pair[] prr = new Pair[map.keySet().size()];
		int i = 0;
		for (int key : map.keySet()) {
			prr[i] = new Pair();
			prr[i].key = key;
			prr[i].frequency = map.get(key);
			i++;
		}
		Arrays.sort(prr, (a, b) -> Integer.compare(b.frequency, a.frequency));
		int[] ans = new int[k];
		for (int j = 0; j < k; j++) {
			ans[j] = prr[j].key;
		}

		return ans;
	}
}
