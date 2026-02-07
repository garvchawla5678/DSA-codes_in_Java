package leetcode.Graph;

public class leetcode_695 {

	static int m;
	static int n;
	static int area;
	static int currArea;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		area = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					currArea = 0;
					dfs(grid, i, j);
					area = Math.max(area, currArea);
				}
			}
		}

		return area;
	}

	private static void dfs(int[][] grid, int i, int j) {
		grid[i][j] = -1;
		currArea += 1;

		int[] r = { -1, 1, 0, 0 };
		int[] c = { 0, 0, -1, 1 };
		for (int k = 0; k < 4; k++) {
			int newr = i + r[k];
			int newc = j + c[k];
			if (newr < 0 || newr >= m || newc < 0 || newc >= n) {
				continue;
			}
			if (grid[newr][newc] == 1) {
				dfs(grid, newr, newc);
			}
		}
	}
}
