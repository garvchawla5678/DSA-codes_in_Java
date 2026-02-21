package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_5_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
		int n = s.length();
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (isPalindrome(s, i, j, memo) == 1 && (end - start + 1) < (j - i + 1)) {
					start = i;
					end = j;
				}
			}
		}

		return s.substring(start, end + 1);
	}

	private static int isPalindrome(String s, int i, int j, int[][] memo) {
		if (i > j)
			return 1;
		if (memo[i][j] != -1)
			return memo[i][j];

		if (s.charAt(i) == s.charAt(j)) {
			return memo[i][j] = isPalindrome(s, i + 1, j - 1, memo);
		}

		return memo[i][j] = 0;
	}
}
