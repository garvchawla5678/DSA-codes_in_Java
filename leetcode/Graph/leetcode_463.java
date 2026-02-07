package leetcode.Graph;

public class leetcode_463 {

	static int perimeter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(islandPerimeter(grid));
	}

	public static int islandPerimeter(int[][] grid) {
		perimeter = 0;
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, i, j, m, n);
					return perimeter;
				}
			}
		}

		return -1;
	}

	private static void dfs(int[][] grid, int i, int j, int m, int n) {
		grid[i][j] = -1;

		int[] r = { 0, 0, 1, -1 };
		int[] c = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k++) {
			int row = i + r[k];
			int col = j + c[k];
			if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
				perimeter += 1;
				continue;
			}

			if (grid[row][col] == 1)
				dfs(grid, row, col, m, n);
		}

	}
}
