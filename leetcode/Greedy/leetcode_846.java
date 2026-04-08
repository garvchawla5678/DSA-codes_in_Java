package leetcode.Greedy;

import java.util.TreeMap;

public class leetcode_846 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int groupSize = 3;
		System.out.println(isNStraightHand(hand, groupSize));
	}

	public static boolean isNStraightHand(int[] hand, int groupSize) {
		int n = hand.length;

		if (n % groupSize != 0)
			return false;

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int num : hand) {
			if (!map.containsKey(num))
				map.put(num, 0);

			map.put(num, map.get(num) + 1);
		}

		while (!map.isEmpty()) {
			int num = map.firstKey();
			for (int i = 0; i < groupSize; i++) {
				if (!map.containsKey(num + i))
					return false;

				map.put(num + i, map.get(num + i) - 1);
				if (map.get(num + i) == 0)
					map.remove(num + i);
			}
		}

		return true;
	}
}
