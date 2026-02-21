package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_647_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		System.out.println(countSubstrings(s));
	}

	public static int countSubstrings(String s) {
		int count = 0;
		int len = s.length();
		int[][] memo = new int[len + 1][len + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (isPalindrome(s, i, j, memo) == 1)
					count++;
			}
		}

		return count;
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
