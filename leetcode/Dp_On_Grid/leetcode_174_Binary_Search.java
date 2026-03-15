package leetcode.Dp_On_Grid;

public class leetcode_174_Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(dungeon));
	}

	public static int calculateMinimumHP(int[][] dungeon) {
		int min = 1;
		int max = 1_000_000;
		int m = dungeon.length;
		int n = dungeon[0].length;

		int result = 0;
		while (min <= max) {
			int mid = min + (max - min) / 2;

			if (canSurvive(dungeon, 0, 0, mid, m, n)) {
				result = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return result;
	}

	private static boolean canSurvive(int[][] dungeon, int i, int j, int hp, int m, int n) {
		hp += dungeon[i][j];
		if (hp <= 0)
			return false;

		if (i == m - 1 && j == n - 1)
			return true;

		boolean right = false;
		if (j + 1 < n)
			right = canSurvive(dungeon, i, j + 1, hp, m, n);

		boolean down = false;
		if (i + 1 < m)
			down = canSurvive(dungeon, i + 1, j, hp, m, n);

		return right || down;
	}
}
