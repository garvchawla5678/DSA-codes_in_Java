package leetcode.Dp_On_Grid;

public class leetcode_174_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(dungeon));
	}

	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					dp[i][j] = (dungeon[i][j] < 0 ? Math.abs(dungeon[i][j]) + 1 : 1);
				} else {
					int right = (j + 1 >= n) ? Integer.MAX_VALUE : dp[i][j + 1];
					int down = (i + 1 >= m) ? Integer.MAX_VALUE : dp[i + 1][j];

					int res = Math.min(down, right) - dungeon[i][j];
					dp[i][j] = (res <= 0) ? 1 : res;
				}
			}
		}

		return dp[0][0];
	}
}
