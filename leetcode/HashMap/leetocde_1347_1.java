package leetcode.HashMap;

import java.util.HashMap;

public class leetocde_1347_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		String t = "practice";
		System.out.println(minSteps(s, t));
	}

	public static int minSteps(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : ss) {
			if (!map.containsKey(ch))
				map.put(ch, 0);
			map.put(ch, map.get(ch) + 1);
		}

		int steps = 0;
		for (char ch : tt) {
			if (map.containsKey(ch) && map.get(ch) > 0) {
				map.put(ch, map.get(ch) - 1);
			} else {
				steps++;
			}
		}

		return steps;
	}
}
