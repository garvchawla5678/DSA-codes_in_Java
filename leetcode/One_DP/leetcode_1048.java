package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_1048 {

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
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int longest = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (isPredecessor(words[j], words[i])) {
					dp[i] = (int) Math.max(dp[i], dp[j] + 1);
					longest = (int) Math.max(dp[i], longest);
				}
			}
		}

		return longest;
	}

	private static boolean isPredecessor(String back, String forw) {
		if (forw.length() - back.length() != 1)
			return false;

		int i = 0;
		int j = 0;
		while (i < back.length() && j < forw.length()) {
			if (back.charAt(i) == forw.charAt(j))
				i++;
			j++;
		}

		return i == back.length();
	}
}
