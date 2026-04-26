package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_1320_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "KAORUKO";
		System.out.println(minimumDistance(word));
	}

	public static int minimumDistance(String word) {
		char[] wrd = word.toCharArray();
		int[][][] memo = new int[301][27][27];

		for (int[][] mat : memo) {
			for (int[] row : mat) {
				Arrays.fill(row, -1);
			}
		}

		return solve(wrd, 26, 26, 0, wrd.length, memo);
	}

	private static int solve(char[] word, int fing1, int fing2, int idx, int n, int[][][] memo) {
		if (idx == n)
			return 0;
		if (memo[idx][fing1][fing2] != -1)
			return memo[idx][fing1][fing2];

		if (fing1 == 26 && fing2 == 26) {
			return memo[idx][fing1][fing2] = solve(word, word[idx] - 'A', fing2, idx + 1, n, memo);
		}

		if (fing2 == 26) {
			int moveF2 = solve(word, fing1, word[idx] - 'A', idx + 1, n, memo);

			int moveF1 = dist(word[idx], fing1) + solve(word, word[idx] - 'A', fing2, idx + 1, n, memo);

			return memo[idx][fing1][fing2] = Math.min(moveF1, moveF2);
		}

		int moveF1 = dist(word[idx], fing1) + solve(word, word[idx] - 'A', fing2, idx + 1, n, memo);

		int moveF2 = dist(word[idx], fing2) + solve(word, fing1, word[idx] - 'A', idx + 1, n, memo);

		return memo[idx][fing1][fing2] = Math.min(moveF1, moveF2);
	}

	private static int dist(char wrd, int fing) {
		int pos = wrd - 'A';
		int r1 = pos / 6, c1 = pos % 6;
		int r2 = fing / 6, c2 = fing % 6;

		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
