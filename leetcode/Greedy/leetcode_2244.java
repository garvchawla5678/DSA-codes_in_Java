package leetcode.Greedy;

import java.util.HashMap;

public class leetcode_2244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tasks = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
		System.out.println(minimumRounds(tasks));
	}

	public static int minimumRounds(int[] tasks) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : tasks) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int rounds = 0;
		for (int num : map.keySet()) {
			int freq = map.get(num);

			if (freq == 0)
				continue;

			if (freq == 1)
				return -1;

			if (freq == 2) {
				map.put(num, 0);
				rounds++;
			} else if (freq >= 3) {
				int count = freq / 3;
				rounds += count;
				freq = freq - (3 * count);
				if (freq % 3 == 2) {
					rounds++;
					freq = freq - 2;
				}

				map.put(num, freq);
			}
		}

		return rounds;
	}
}
