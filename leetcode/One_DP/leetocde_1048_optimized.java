package leetcode.One_DP;

import java.util.Arrays;
import java.util.HashMap;

public class leetocde_1048_optimized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
		System.out.println(longestStrChain(words));
	}

	public static int longestStrChain(String[] words) {
		int n = words.length;
		if (n == 1)
			return 1;

		Arrays.sort(words, (a, b) -> a.length() - b.length());
		HashMap<String, Integer> map = new HashMap<>();
		int res = 0;

		for (String word : words) {
			int length = 0;
			for (int i = 0; i < word.length(); i++) {
				String pred = word.substring(0, i) + word.substring(i + 1);
				length = (int) Math.max(map.getOrDefault(pred, 0) + 1, length);
			}

			map.put(word, length);
			res = (int) Math.max(res, length);
		}

		return res;
	}
}
