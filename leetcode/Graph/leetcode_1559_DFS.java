package leetcode.Graph;

public class leetcode_1559_DFS {
	static int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static int m;
	static int n;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { 'c', 'c', 'c', 'a' }, { 'c', 'd', 'c', 'c' }, { 'c', 'c', 'e', 'c' },
				{ 'f', 'c', 'c', 'c' } };
		System.out.println(containsCycle(grid));
	}

	public static boolean containsCycle(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					if (solve(grid, i, j, -1, -1, grid[i][j]))
						return true;
				}
			}
		}

		return false;
	}

	private static boolean solve(char[][] grid, int i, int j, int px, int py, char ch) {
		visited[i][j] = true;

		for (int[] dir : directions) {
			int nx = i + dir[0];
			int ny = j + dir[1];

			if (nx < 0 || nx >= m || ny < 0 || ny >= n)
				continue;

			if (grid[nx][ny] != ch)
				continue;

			// skip parent
			if (nx == px && ny == py)
				continue;

			// visited again => cycle
			if (visited[nx][ny])
				return true;

			if (solve(grid, nx, ny, i, j, ch))
				return true;
		}

		return false;
	}
}
