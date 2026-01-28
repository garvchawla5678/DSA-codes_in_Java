package leetcode.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class leetcode_451_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cccaaa";
		leetcode_451 cl = new leetcode_451();
		System.out.println(cl.frequencySort(s));
	}

	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		List<Character> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

		StringBuilder sb = new StringBuilder();
		for (char ch : list) {
			int freq = map.get(ch);
			while (freq-- > 0) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
