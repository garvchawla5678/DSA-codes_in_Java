package leetcode.One_DP;

import java.util.Arrays;

public class SCS_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "geek";
		String str2 = "eke";
		System.out.println(minSuperSeq(str1, str2));
	}

	public static int minSuperSeq(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(s1, s2, 0, 0, memo);
	}

	private static int solve(String s1, String s2, int i, int j, int[][] memo) {
		if (i >= s1.length())
			return s2.length() - j;
		else if (j >= s2.length())
			return s1.length() - i;

		if (memo[i][j] != -1)
			return memo[i][j];

		if (s1.charAt(i) == s2.charAt(j)) {
			return memo[i][j] = 1 + solve(s1, s2, i + 1, j + 1, memo);
		} else {
			return memo[i][j] = 1 + Math.min(solve(s1, s2, i + 1, j, memo), solve(s1, s2, i, j + 1, memo));
		}
	}

}
