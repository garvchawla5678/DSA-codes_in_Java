package leetcode.Graph;

public class leetcode_463_simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(islandPerimeter(grid));
	}

	public static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					perimeter += 4;

					if (i + 1 < m && grid[i + 1][j] == 1)
						perimeter--;
					if (j + 1 < n && grid[i][j + 1] == 1)
						perimeter--;
					if (i - 1 >= 0 && grid[i - 1][j] == 1)
						perimeter--;
					if (j - 1 >= 0 && grid[i][j - 1] == 1)
						perimeter--;
				}
			}
		}

		return perimeter;
	}
}
