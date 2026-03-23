package leetcode.Partition_DP;

import java.util.Arrays;

public class Boolean_Parenthesis_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "T|T&F^T";
		System.out.println(countWays(s));
	}

	public static int countWays(String s) {
		char[] wrd = s.toCharArray();
		int n = wrd.length;
		int[][][] memo = new int[n + 1][n + 1][2];
		for (int[][] row : memo) {
			for (int[] col : row)
				Arrays.fill(col, -1);
		}

		return solve(wrd, 0, n - 1, 1, n, memo);
	}

	private static int solve(char[] wrd, int i, int j, int isTrue, int n, int[][][] memo) {
		if (i > j)
			return 0;
		if (memo[i][j][isTrue] != -1)
			return memo[i][j][isTrue];

		if (i == j) {
			if (isTrue == 1)
				return wrd[i] == 'T' ? 1 : 0;
			else
				return wrd[i] == 'F' ? 1 : 0;
		}

		int ways = 0;
		for (int idx = i + 1; idx <= j - 1; idx += 2) {
			int leftTrueWays = solve(wrd, i, idx - 1, 1, n, memo);
			int leftFalseWays = solve(wrd, i, idx - 1, 0, n, memo);
			int rightTrueWays = solve(wrd, idx + 1, j, 1, n, memo);
			int rightFalseWays = solve(wrd, idx + 1, j, 0, n, memo);

			if (wrd[idx] == '&') {
				if (isTrue == 1)
					ways += leftTrueWays * rightTrueWays;
				else
					ways += (leftFalseWays * rightFalseWays) + (leftFalseWays * rightTrueWays)
							+ (leftTrueWays * rightFalseWays);
			} else if (wrd[idx] == '|') {
				if (isTrue == 1)
					ways += (leftTrueWays * rightTrueWays) + (leftTrueWays * rightFalseWays)
							+ (leftFalseWays * rightTrueWays);
				else
					ways += leftFalseWays * rightFalseWays;
			} else {
				if (isTrue == 1)
					ways += (leftFalseWays * rightTrueWays) + (leftTrueWays * rightFalseWays);
				else
					ways += (leftFalseWays * rightFalseWays) + (leftTrueWays * rightTrueWays);
			}
		}

		return memo[i][j][isTrue] = ways;
	}
}
