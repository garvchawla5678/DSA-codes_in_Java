package leetcode.DP_Pract;

public class leetcode_2573_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] lcp = { { 4, 0, 2, 0 }, { 0, 3, 0, 1 }, { 2, 0, 2, 0 }, { 0, 1, 0, 1 } };
		System.out.println(findTheString(lcp));
	}

	public static String findTheString(int[][] lcp) {
		int n = lcp.length;
		char[] word = new char[n];
		char current = 'a';

		for (int i = 0; i < n; i++) {
			if (word[i] == 0) {
				if (current > 'z') {
					return "";
				}
				word[i] = current;
				for (int j = i + 1; j < n; j++) {
					if (lcp[i][j] > 0) {
						word[j] = word[i];
					}
				}
				current++;
			}
		}

		if (checkLcp(word, n, lcp))
			return new String(word);

		return "";
	}

	private static boolean checkLcp(char[] word, int n, int[][] lcp) {

		// filling n - 1 column
		for (int i = 0; i < n; i++) {
			if (word[i] == word[n - 1]) {
				if (lcp[i][n - 1] != 1)
					return false;
			} else {
				if (lcp[i][n - 1] != 0)
					return false;
			}
		}

		// filling n - 1 row
		for (int i = 0; i < n; i++) {
			if (word[i] == word[n - 1]) {
				if (lcp[n - 1][i] != 1)
					return false;
			} else {
				if (lcp[n - 1][i] != 0)
					return false;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (word[i] == word[j]) {
					if (lcp[i][j] != 1 + lcp[i + 1][j + 1])
						return false;
				} else {
					if (lcp[i][j] != 0)
						return false;
				}
			}
		}

		return true;
	}
}
