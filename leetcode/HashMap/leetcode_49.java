package leetcode.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));
	}

	// T.C: O(m * nlogn)
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			String org = new String(s);
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			s = new String(arr);
			if (!map.containsKey(s))
				map.put(s, new ArrayList<>());
			map.get(s).add(org);
		}
		for (String s : map.keySet()) {
			ans.add(map.get(s));
		}
		return ans;
	}
}
