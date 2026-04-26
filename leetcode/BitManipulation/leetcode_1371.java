package leetcode.BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1371 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcodeisgreat";
		System.out.println(findTheLongestSubstring(s));
	}

	public static int findTheLongestSubstring(String s) {
		Map<Integer, Integer> map = new HashMap<>();
		char[] arr = s.toCharArray();
		map.put(0, -1);
		int result = 0;
		int bit = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				int shift = arr[i] - 'a';
				bit ^= (1 << shift);
			}

			if (map.containsKey(bit)) {
				result = Math.max(result, i - map.get(bit));
			} else {
				map.put(bit, i);
			}
		}

		return result;
	}
}
