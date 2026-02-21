package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(minDistance(word1, word2));
	}

	public static int minDistance(String word1, String word2) {
		char[] wrd1 = word1.toCharArray();
		char[] wrd2 = word2.toCharArray();
		int m = wrd1.length;
		int n = wrd2.length;

		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(wrd1, wrd2, 0, 0, m, n, memo);
	}

	private static int solve(char[] wrd1, char[] wrd2, int i, int j, int m, int n, int[][] memo) {
		if (j == wrd2.length) {
			return wrd1.length - i;
		}

		if (i == wrd1.length) {
			return wrd2.length - j;
		}

		if (memo[i][j] != -1)
			return memo[i][j];

		int res = 1_000_000_007;

		if (wrd1[i] == wrd2[j])
			return memo[i][j] = solve(wrd1, wrd2, i + 1, j + 1, m, n, memo);
		else {
			int insert = solve(wrd1, wrd2, i, j + 1, m, n, memo);
			int delete = solve(wrd1, wrd2, i + 1, j, m, n, memo);
			int replace = solve(wrd1, wrd2, i + 1, j + 1, m, n, memo);

			res = 1 + Math.min(insert, Math.min(replace, delete));
		}

		return memo[i][j] = res;
	}
}
