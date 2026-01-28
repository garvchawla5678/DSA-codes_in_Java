package leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_49_opti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));
	}

	// T.C: 0(m * n)
	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			int[] arr = new int[27];
			for (char ch : s.toCharArray()) {
				arr[ch - 'a']++;
			}

			StringBuilder ss = new StringBuilder();
			for (int i = 0; i < 27; i++) {
				while (arr[i]-- > 0) {
					ss.append(i + 'a');
				}
			}
			String key = ss.toString();
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(s);
		}

		return new ArrayList<>(map.values());
	}

}
