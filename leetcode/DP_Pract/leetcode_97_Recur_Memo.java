package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_97_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1, s2, s3));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		int N = s3.length();
		if (m + n != N)
			return false;

		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(s1, s2, s3, 0, 0, m, n, memo);
	}

	private static boolean solve(String s1, String s2, String s3, int i, int j, int m, int n, int[][] memo) {
		if (i == m && j == n)
			return true;

		if (memo[i][j] != -1)
			return memo[i][j] == 0 ? true : false;

		boolean result = false;
		if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
			result = result || solve(s1, s2, s3, i + 1, j, m, n, memo);

		if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
			result = result || solve(s1, s2, s3, i, j + 1, m, n, memo);

		if (result == true)
			memo[i][j] = 0;
		else
			memo[i][j] = 1;

		return result;
	}
}
