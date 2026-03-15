package leetcode.Dp_On_Grid;

import java.util.Arrays;

public class leetocde_174_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(dungeon));
	}

	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] memo = new int[m][n];
		for (int[] row : memo)
			Arrays.fill(row, -1_000_000_007);

		return solve(dungeon, 0, 0, m, n, memo);
	}

	private static int solve(int[][] dungeon, int i, int j, int m, int n, int[][] memo) {
		if (i >= m || j >= n)
			return Integer.MAX_VALUE;

		if (memo[i][j] != -1_000_000_007)
			return memo[i][j];

		if (i == m - 1 && j == n - 1) {
			if (dungeon[i][j] <= 0)
				return Math.abs(dungeon[i][j]) + 1;

			return 1;
		}

		int right = solve(dungeon, i, j + 1, m, n, memo);
		int down = solve(dungeon, i + 1, j, m, n, memo);

		int result = Math.min(right, down) - dungeon[i][j];

		return memo[i][j] = result <= 0 ? 1 : result;
	}
}
