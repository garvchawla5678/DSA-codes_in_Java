package leetcode.Greedy;

import java.util.HashMap;
import java.util.Map;

public class leetcode_3020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 4, 1, 2, 2 };
		System.out.println(maximumLength(nums));
	}

	public static int maximumLength(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		freq.put(1, 0);

		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}

		int len = 1;
		if ((freq.get(1) & 1) == 1)
			len = Math.max(len, freq.get(1));
		else if (freq.get(1) != 0)
			len = Math.max(len, freq.get(1) - 1);

		for (int i : freq.keySet()) {
			if (len >= 9)
				break;

			int base = (int) Math.sqrt(i);
			if (base * base == i && freq.getOrDefault(base, 0) > 1)
				continue;

			if (i == 1 || freq.get(i) == null || freq.get(i) <= 1)
				continue;

			long x = i;
			int tempLen = 0;
			while (freq.get((int) x) >= 2) {
				tempLen++;
				x = x * x;

				if (x > Integer.MAX_VALUE)
					break;

				if (freq.get((int) x) == null)
					break;
			}

			if (freq.get((int) x) != null) {
				len = Math.max(len, 2 * tempLen + 1);
				continue;
			}

			len = Math.max(len, 2 * tempLen - 1);
		}

		return len;
	}
}
