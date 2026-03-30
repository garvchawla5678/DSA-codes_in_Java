package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_2573_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] lcp = { { 4, 0, 2, 0 }, { 0, 3, 0, 1 }, { 2, 0, 2, 0 }, { 0, 1, 0, 1 } };
		System.out.println(findTheString(lcp));
	}

	public static String findTheString(int[][] lcp) {
		int n = lcp.length;
		char[] word = new char[n];
		Arrays.fill(word, '$');

		for (int i = 0; i < n; i++) {
			boolean[] forbidden = new boolean[26];

			for (int j = 0; j < i; j++) {
				if (lcp[i][j] != 0) {
					word[i] = word[j];
					break;
				} else {
					forbidden[word[j] - 'a'] = true;
				}
			}

			if (word[i] == '$') {
				for (int idx = 0; idx < 26; idx++) {
					if (!forbidden[idx]) {
						word[i] = (char) (idx + 'a');
						break;
					}
				}
			}

			if (word[i] == '$')
				return "";

		}

		int[][] check = checkLcp(word, n);
		if (Arrays.deepEquals(check, lcp))
			return new String(word);

		return "";

	}

	private static int[][] checkLcp(char[] word, int n) {
		int[][] lcp = new int[n][n];

		// filling n - 1 column
		for (int i = 0; i < n; i++) {
			if (word[i] == word[n - 1]) {
				lcp[i][n - 1] = 1;
			} else {
				lcp[i][n - 1] = 0;
			}
		}

		// filling n - 1 row
		for (int i = 0; i < n; i++) {
			if (word[i] == word[n - 1]) {
				lcp[n - 1][i] = 1;
			} else {
				lcp[n - 1][i] = 0;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (word[i] == word[j]) {
					lcp[i][j] = 1 + lcp[i + 1][j + 1];
				} else {
					lcp[i][j] = 0;
				}
			}
		}

		return lcp;
	}
}
