package leetcode.Greedy;

import java.util.HashMap;

public class leetcode_2131 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "ab", "ty", "yt", "lc", "cl", "ab" };
		System.out.println(longestPalindrome(words));
	}

	public static int longestPalindrome(String[] words) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String wrd : words) {
			if (!map.containsKey(wrd))
				map.put(wrd, 0);

			map.put(wrd, map.get(wrd) + 1);
		}

		int result = 0;
		boolean hasCenteredAdded = false;

		for (String wrd : map.keySet()) {
			char[] ww = wrd.toCharArray();
			char temp = ww[0];
			ww[0] = ww[1];
			ww[1] = temp;
			String rev = new String(ww);

			if (map.containsKey(rev) && !wrd.equals(rev)) {
				int pairs = Math.min(map.get(rev), map.get(wrd));
				result += pairs * 4;
				map.put(rev, map.get(rev) - pairs);
				map.put(wrd, map.get(wrd) - pairs);

			} else if (map.containsKey(rev) && wrd.equals(rev)) {
				int count = map.get(rev);
				result += (count / 2) * 4;
				if (count % 2 == 1 && hasCenteredAdded == false) {
					result += 2;
					hasCenteredAdded = true;
					map.put(wrd, map.get(wrd) - 1);
				}
			}
		}

		return result;
	}
}
