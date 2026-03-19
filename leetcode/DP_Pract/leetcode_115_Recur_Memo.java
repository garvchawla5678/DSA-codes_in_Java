package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_115_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct(s, t));
	}

	public static int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(s, t, 0, 0, m, n, memo);
	}

	private static int solve(String s, String t, int i, int j, int m, int n, int[][] memo) {
		if (j == n)
			return 1;
		if (memo[i][j] != -1)
			return memo[i][j];

		int ways = 0;
		if (i < m && j < n && s.charAt(i) == t.charAt(j)) {
			int take = solve(s, t, i + 1, j + 1, m, n, memo);
			int skip = solve(s, t, i + 1, j, m, n, memo);
			ways += take + skip;
		} else if (i < m && j < n)
			ways += solve(s, t, i + 1, j, m, n, memo);

		return memo[i][j] = ways;
	}
}
