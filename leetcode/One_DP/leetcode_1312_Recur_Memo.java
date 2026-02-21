package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_1312_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mbadm";
		System.out.println(minInsertions(s));
	}

	public static int minInsertions(String s) {
		int n = s.length();
		int[][] memo = new int[n][n];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(s, 0, s.length() - 1, memo);
	}

	private static int solve(String s, int i, int j, int[][] memo) {
		if (i >= j)
			return 0;

		if (memo[i][j] != -1)
			return memo[i][j];

		if (s.charAt(i) == s.charAt(j))
			return memo[i][j] = 0 + solve(s, i + 1, j - 1, memo);
		else {
			return memo[i][j] = 1 + Math.min(solve(s, i + 1, j, memo), solve(s, i, j - 1, memo));
		}
	}
}
