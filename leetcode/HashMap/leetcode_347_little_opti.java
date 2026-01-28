package leetcode.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class leetcode_347_little_opti {
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

	// t.c: O(Nlog(k))
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
		PriorityQueue<Pair> qu = new PriorityQueue<>((a, b) -> Integer.compare(a.frequency, b.frequency));
		int[] ans = new int[k];

		for (int j = 0; j < k; j++) {
			qu.add(prr[j]);
		}
		for (int j = k; j < prr.length; j++) {
			if (qu.peek().frequency > prr[j].frequency)
				continue;
			qu.poll();
			qu.add(prr[j]);
		}
		for (int j = 0; j < k; j++) {
			ans[j] = qu.poll().key;
		}
		return ans;
	}
}
