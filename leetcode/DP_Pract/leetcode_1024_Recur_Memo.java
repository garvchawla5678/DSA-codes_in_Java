package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_1024_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] clips = { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 }, { 1, 3 }, { 4, 7 },
				{ 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 } };
		int time = 9;
		System.out.println(videoStitching(clips, time));
	}

	public static int videoStitching(int[][] clips, int time) {
		Arrays.sort(clips, (a, b) -> a[0] - b[0]);
		for (int[] row : clips)
			System.out.print(Arrays.toString(row) + " ");
		System.out.println();

		int[][] memo = new int[101][101];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		int n = clips.length;
		int ans = 1_000_000_007;
		for (int i = 0; i < n; i++) {
			if (clips[i][0] == 0)
				ans = Math.min(ans, 1 + solve(clips, time, i + 1, i, n, memo));
			else
				break;
		}

		return ans == 1_000_000_007 ? -1 : ans;
	}

	private static int solve(int[][] clips, int time, int i, int prev, int n, int[][] memo) {
		if (clips[prev][1] >= time)
			return 0;

		if (i >= n)
			return 1_000_000_007;

		if (memo[i][prev] != -1)
			return memo[i][prev];

		int clipTaken = 1_000_000_007;
		if (clips[i][0] <= clips[prev][1])
			clipTaken = 1 + solve(clips, time, i + 1, i, n, memo);

		int clipNotTaken = solve(clips, time, i + 1, prev, n, memo);

		return memo[i][prev] = Math.min(clipNotTaken, clipTaken);
	}
}
