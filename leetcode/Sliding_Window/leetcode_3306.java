package leetcode.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class leetcode_3306 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "iieaouqiieaouqq";
		int k = 1;
		System.out.println(countOfSubstrings(s, k));
	}

	public static long countOfSubstrings(String word, int k) {
		char[] wrd = word.toCharArray();
		int n = wrd.length;
		long res = 0;
		Map<Character, Integer> mp = new HashMap<>();
		int[] pre = new int[n];
		int lastSeen = n;

		for (int i = n - 1; i >= 0; i--) {
			pre[i] = lastSeen;
			char ch = wrd[i];
			if (ch != 'a' && ch != 'e' && ch != 'o' && ch != 'i' && ch != 'u')
				lastSeen = i;
		}

		int i = 0, j = 0;
		int cons = 0;

		while (j < n) {
			char ch = wrd[j];
			if (isVowel(ch)) {
				mp.put(ch, mp.getOrDefault(ch, 0) + 1);
			} else {
				cons++;
			}

			while (cons > k) {
				char ch1 = wrd[i];
				if (isVowel(ch1)) {
					mp.put(ch1, mp.get(ch1) - 1);
					if (mp.get(ch1) == 0)
						mp.remove(ch1);
				} else {
					cons--;
				}
				i++;
			}

			while (mp.size() == 5 && cons == k) {
				int idx = pre[j];
				res += idx - j;

				char ch1 = wrd[i];

				if (isVowel(ch1)) {
					mp.put(ch1, mp.get(ch1) - 1);
					if (mp.get(ch1) == 0)
						mp.remove(ch1);
				} else {
					cons--;
				}

				i++;
			}

			j++;
		}

		return res;
	}

	private static boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u')
			return true;

		return false;
	}
}
